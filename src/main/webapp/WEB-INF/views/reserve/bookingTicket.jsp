<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>

<div class="section_booking_ticket">
    <div class="ticket_body">
    	<c:forEach  var="price" items="${product.productPrices }" varStatus="status">
    	<div class="qty" id="ticket${status.index }" data-price-type="${price.priceType}">
            <div class="count_control">
                <!-- [D] 수량이 최소 값이 일때 ico_minus3, count_control_input에 disabled 각각 추가, 수량이 최대 값일 때는 ico_plus3에 disabled 추가 -->
                <div class="clearfix">
                    <a class="btn_plus_minus spr_book2 ico_minus3 disabled" title="빼기"> </a> 
                    <input type="tel" class="count_control_input disabled" value="0" readonly title="수량">
                    <a class="btn_plus_minus spr_book2 ico_plus3" title="더하기">
                    </a>
                </div>
                <!-- [D] 금액이 0 이상이면 individual_price에 on_color 추가 -->
                <div class="individual_price"><span class="total_price">0</span><span class="price_type">원</span></div>
            </div>
            <div class="qty_info_icon"> <strong class="product_amount"> 
            <span>
            	<c:choose>
            		<c:when test="${price.priceType == 1 }">성인</c:when>
            		<c:when test="${price.priceType == 2 }">청소년</c:when>
            		<c:when test="${price.priceType == 3 }">어린이</c:when>
            	</c:choose>
            </span>
             </strong> <strong class="product_price"> <span class="price"><fmt:formatNumber value="${price.price * (1-price.discountRate) }" pattern="#,###"/></span> <span class="price_type">원</span> </strong> <em class="product_dsc"><fmt:formatNumber value="${price.price }" pattern="#,###"/>원 (<fmt:formatNumber value="${price.discountRate*100 }" pattern=""/>% 할인가)</em> </div>
        </div>
    	</c:forEach>
    </div>
</div>