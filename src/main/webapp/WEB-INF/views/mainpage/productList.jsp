<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<div class="section_event_tab">
    <ul class="event_tab_lst tab_lst_min">
        <li class="item" data-category="0">
        	<input type="hidden" id="cate0" value="${productCount }"/>
            <a class="anchor active"> <span>전체</span> </a>
        </li>
	<c:forEach var="category" items="${categoryList}" varStatus="status">
	    <li class="item" data-category="${category.id}">
	    	<input type="hidden" id="cate${category.id}" value="${category.productCount }"/>
		 	<a class="anchor"> <span>${category.name}</span> </a>
		 <!--	
		 <c:choose>
			<c:when test="${status.last}">
	            <a class="anchor last"> <span>${category.name}</span> </a>

	    	</c:when>
		 	<c:otherwise>
	            <a class="anchor"> <span>${category.name}</span> </a>
	     	</c:otherwise>
	    </c:choose>
	    -->
		</li>
	</c:forEach>
    </ul>
</div>
<div class="section_event_lst">
     <p class="event_lst_txt">바로 예매 가능한 전시, 공연, 행사가 <span class="pink" id="product_count">${productCount}개</span> 있습니다</p>
     <div class="wrap_event_box">
		<div class="message_outer">
			<div class="loading_bar hide">
				<span class="ico_loading">로딩중</span>
			</div>
			<div class="nodata_message _lst_none hide">
				<p class="dsc_nodata">
					선택하신 행사가 없습니다.<br>다른 장르를 선택해주세요.
				</p>
			</div>
		</div>
         <ul class="lst_event_box" id="left_event_box">
         	<c:forEach var="product" items="${productList}" begin="0" end="8" step="2" varStatus="status">
              <li class="item">
                  <a href="/product-detail/${product.productId }" class="item_book">
                      <div class="item_preview"> 
                      	<img alt="${product.productName}" class="img_thumb" src="${product.saveFileName }">
                      	<span class="img_border"></span> 
                      </div>
                      <div class="event_txt">
                          <h4 class="event_txt_tit"> 
                          	<span>${product.productName }</span> 
                          	<small class="sm">${product.placeName }</small> 
                          </h4>
                          <p class="event_txt_dsc">${product.productDescription }</p>
                      </div>
                  </a>
              </li>
			</c:forEach>
         </ul>
         <ul class="lst_event_box" id="right_event_box">
         	<c:forEach var="product" items="${productList}" begin="1" end="9" step="2" varStatus="status">
              <li class="item">
                  <a href="/product-detail/${product.productId }" class="item_book">
                      <div class="item_preview"> 
                      	<img alt="${product.productName}" class="img_thumb" src="${product.saveFileName }">
                      	<span class="img_border"></span> 
                      </div>
                      <div class="event_txt">
                          <h4 class="event_txt_tit"> 
                          	<span>${product.productName }</span> 
                          	<small class="sm">${product.placeName }</small> 
                          </h4>
                          <p class="event_txt_dsc">${product.productDescription }</p>
                      </div>
                  </a>
              </li>
			</c:forEach>
         </ul>
     </div>
</div>


    