package com.booking.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestOperations;

import com.booking.dto.NaverLoginUser;
import com.booking.dto.NaverLoginUserResult;
import com.booking.dto.User;
import com.booking.service.UserService;
import com.booking.util.NaverLoginStateUtil;

import net.minidev.json.JSONObject;

@Controller
@RequestMapping("/login")
@PropertySource("classpath:/auth.properties")
public class LoginController {
	@Value("${naver.login.client.id.query}")
	private String clientIdQuery;

	@Value("${naver.login.client.secret.query}")
	private String clientSecretQuery;

	@Value("${naver.login.oauth.authorize.url}")
	private String naverOauthAuthorizeUrl;

	@Value("${naver.login.oauth.token.url}")
	private String naverOauthTokenUrl;

	@Value("${naver.login.oauth.user.url}")
	private String naverOauthUserUrl;

	@Value("${naver.login.callback.url}")
	private String naverCallbackUrl;

	private RestOperations restOperations;
	private UserService userService;
	private NaverLoginStateUtil naverLoginStateUtil;

	@Autowired
	public LoginController(RestOperations restOperations, UserService userService, NaverLoginStateUtil naverLoginStateUtil) {
		this.restOperations = restOperations;
		this.userService = userService;
		this.naverLoginStateUtil = naverLoginStateUtil;
	}

	@GetMapping
	public void login(HttpServletResponse response, HttpSession session) {
		String state = naverLoginStateUtil.getState();
		session.setAttribute("state", state);
		String redirectUri = null;
		try {
			redirectUri = URLEncoder.encode(naverCallbackUrl, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		try {
			response.sendRedirect(naverOauthAuthorizeUrl +"?client_id="+ clientIdQuery + "&redirect_uri=" + redirectUri + "&state=" + state+"&response_type=code");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@GetMapping("/callback")
	public String callback(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "code", required = false) String code,
			@RequestParam(value = "state", required = false) String resultState, HttpSession session,
			HttpServletResponse response) {
		if (error != null) {
			return "redirect:/?error=true";

		} else if (!resultState.equals(session.getAttribute("state"))) {
			return "redirect:/?state-error=true";

		} else {
			setUserToSession(resultState, code, session, response);
			return "redirect:" + session.getAttribute("path");

		}
	}

	private void setUserToSession(String state, String code, HttpSession session, HttpServletResponse response) {
		JSONObject token = getNaverOauthToken(state, code);
		ResponseEntity<NaverLoginUserResult> result = getNaverOauthUserResult(token);
		if (result != null && result.getStatusCode() == HttpStatus.OK) {
			NaverLoginUser naverUser = result.getBody().getResponse();
			User checkingUser = userService.selectByEmail(naverUser.getEmail());

			if (checkingUser == null) {
				checkingUser = userService.create(naverUser.convertToUser());
			}

			switch (checkingUser.checkNaverUser(naverUser)) {
			case User.SAME:
				break;

			case User.NEED_UPDATE:
				checkingUser = userService.update(naverUser.convertToUser());
				break;

			}
			session.setAttribute("user", checkingUser);
		} else {
			try {
				response.sendRedirect("/");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private JSONObject getNaverOauthToken(String state, String code) {
		String url = naverOauthTokenUrl +"?client_id="+ clientIdQuery +"&client_secret="+ clientSecretQuery 
					+ "&state=" + state + "&code=" + code +"&grant_type=authorization_code";
		return restOperations.getForObject(url, JSONObject.class);
	}

	private ResponseEntity<NaverLoginUserResult> getNaverOauthUserResult(JSONObject token) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", token.get("token_type") + " " + token.get("access_token"));
		HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
		return restOperations.exchange(naverOauthUserUrl, HttpMethod.GET, entity, NaverLoginUserResult.class);
	}

}
