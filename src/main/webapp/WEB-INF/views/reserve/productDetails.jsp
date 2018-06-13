<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>

<div class="section_store_details">
    <div class="store_details">
        <h3 class="in_tit">${product.name }</h3>
        <p class="dsc">
            장소 : ${product.placeStreet }(${product.placeLot })<br> 
            기간 : <fmt:formatDate value="${product.displayStart }" pattern="yyyy.MM.dd.(E)"/> ~ <fmt:formatDate value="${product.displayEnd }" pattern="yyyy.MM.dd.(E)"/>
        </p>
        <h3 class="in_tit">관람시간</h3>
        <p class="dsc">
          ${product.observationTime }
        </p>
        <h3 class="in_tit">요금</h3>
        <p class="dsc">
        <c:forEach var="p" items="${prices}">
        	<c:if test="${p.priceType == 1 }">성인(만19~64세) <fmt:formatNumber value="${p.price }" pattern="#,###"/><br/></c:if>
        	<c:if test="${p.priceType == 2 }">청소년(만 13~18세) <fmt:formatNumber value="${p.price }" pattern="#,###"/><br/></c:if>
        	<c:if test="${p.priceType == 3 }">어린이(만 4~12세) <fmt:formatNumber value="${p.price }" pattern="#,###"/><br/></c:if>
        </c:forEach>
<!--             성인(만 19~64세) 5,000원 / 청소년(만 13~18세) 4,000원<br> 어린이(만 4~12세) 3,000원 / 20인 이상 단체 20% 할인<br> 국가유공자, 장애인, 65세 이상 4,000원 -->
        </p>
    </div>
</div>