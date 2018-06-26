<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<div class="section_visual">
                    <div class="pagination">
                        <div class="bg_pagination"></div>
                        <div class="figure_pagination">
                            <span class="num">1</span>
                            <span class="num off">/ <span>${product.bannerImageIdList.size() }</span></span>
                        </div>
                    </div>
                    <div class="group_visual">
                        <div>
                            <div class="container_visual" style="width: 414px;">
                                <ul class="visual_img">
                                	<c:forEach var="banner" items="${product.bannerImageIdList }">
                                	<li class="item" style="width: 414px;"> <img alt="" class="img_thumb" src="/files/${banner }"> <span class="img_bg"></span>
                                        <div class="visual_txt">
                                            <div class="visual_txt_inn">
                                                <h2 class="visual_txt_tit"> <span>${product.name }</span> </h2>
                                                <p class="visual_txt_dsc"></p>
                                            </div>
                                        </div>
                                    </li>
                                	</c:forEach>
                                	<!-- 
                                    <li class="item" style="width: 414px;"> <img alt="" class="img_thumb" src="https://ssl.phinf.net/naverbooking/20170119_135/1484789767866RPO6o_JPEG/%B7%CE%B9%CC%BF%C0%C1%D9%B8%AE%BF%A7_1242.jpg?type=ff1242_1242"> <span class="img_bg"></span>
                                        <div class="visual_txt">
                                            <div class="visual_txt_inn">
                                                <h2 class="visual_txt_tit"> <span>${product.name }</span> </h2>
                                                <p class="visual_txt_dsc"></p>
                                            </div>
                                        </div>
                                    </li>
                                    <li class="item" style="width: 414px;"> <img alt="" class="img_thumb" src="https://ssl.phinf.net/naverbooking/20170119_135/1484789767866RPO6o_JPEG/%B7%CE%B9%CC%BF%C0%C1%D9%B8%AE%BF%A7_1242.jpg?type=ff1242_1242"> <span class="img_bg"></span>
                                        <div class="visual_txt">
                                            <div class="visual_txt_inn">
                                                <h2 class="visual_txt_tit"> <span>${product.name }</span> </h2>
                                                <p class="visual_txt_dsc"></p>
                                            </div>
                                        </div>
                                    </li>
                                    <li class="item" style="width: 414px;"> <img alt="" class="img_thumb" src="https://ssl.phinf.net/naverbooking/20170119_135/1484789767866RPO6o_JPEG/%B7%CE%B9%CC%BF%C0%C1%D9%B8%AE%BF%A7_1242.jpg?type=ff1242_1242"> <span class="img_bg"></span>
                                        <div class="visual_txt">
                                            <div class="visual_txt_inn">
                                                <h2 class="visual_txt_tit"> <span>${product.name }</span> </h2>
                                                <p class="visual_txt_dsc"></p>
                                            </div>
                                        </div>
                                    </li>
                                    -->
                                </ul>
                            </div>
                            <div class="prev">
                                <div class="prev_inn">
                                    <a href="#" class="btn_prev" title="이전">
                                        <!-- [D] 첫 이미지 이면 off 클래스 추가 -->
                                        <i class="spr_book2 ico_arr6_lt off"></i>
                                    </a>
                                </div>
                            </div>
                            <div class="nxt">
                                <div class="nxt_inn">
                                    <a href="#" class="btn_nxt" title="다음">
                                        <i class="spr_book2 ico_arr6_rt"></i>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="group_btn_goto">
                        <a class="btn_goto_home" title="홈페이지" href="#" target="siteUrl"> <i class="fn fn-home1"></i> </a>
                        <a class="btn_goto_tel" title="전화" href="#"> <i class="fn fn-call1"></i> </a>
						<a class="btn_goto_mail" title="이메일" href="#"> <i class="fn fn-mail1"></i> </a>
                        <a href="#" class="btn_goto_path" title="길찾기"> <i class="fn fn-path-find1"></i> </a>
                        <a href="#" class="fn fn-share1 naver-splugin btn_goto_share" title="공유하기"></a>
                    </div>
                </div>