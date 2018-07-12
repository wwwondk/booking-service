<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<!-- 내 예약 리스트 -->
<div class="wrap_mylist">
	<ul class="list_cards" ng-if="bookedLists.length > 0">
		<!--[D] 예약확정: .confirmed, 취소된 예약&이용완료: .used 추가 card -->
		<c:forEach var="reservation" items="${reservationList }" varStatus="status">
	  		<c:if test="${status.index == 0 or (status.index > 0 and reservationList[status.index-1].reservationType ne reservation.reservationType )}">
	        <c:if test="${reservation.reservationType eq 'REQUESTING'}">
	        <li class="card" data-reservation-type="requesting">
	        </c:if>
	        <c:if test="${reservation.reservationType eq 'DUE'}">
	        <li class="card confirmed" data-reservation-type="due">
	        </c:if>
	        <c:if test="${reservation.reservationType eq 'USED'}">
	        <li class="card used" data-reservation-type="used">
	        </c:if>
	        <c:if test="${reservation.reservationType eq 'REFUND_CANCEL'}">
	        <li class="card used" data-reservation-type="refund_cancel">
	        </c:if>
				<div class="link_booking_details">
					<div class="card_header">
					    <div class="left"></div>
					    <div class="middle">
					        <!--[D] 예약 신청중: .ico_clock, 예약확정&이용완료: .ico_check2, 취소된 예약: .ico_cancel 추가 spr_book -->
					        <c:if test="${reservation.reservationType eq 'REQUESTING'}">
					        <i class="spr_book2 ico_clock"></i>
					        <span class="tit">예약신청</span>
					        </c:if>
					        <c:if test="${reservation.reservationType eq 'DUE'}">
					        <i class="spr_book2 ico_check2"></i>
					        <span class="tit">예약확정</span>
					        </c:if>
					        <c:if test="${reservation.reservationType eq 'USED'}">
					        <i class="spr_book2 ico_check2"></i>
					        <span class="tit">이용완료</span>
					        </c:if>
					        <c:if test="${reservation.reservationType eq 'REFUND_CANCEL'}">
					        <i class="spr_book2 ico_cancel"></i>
					        <span class="tit">취소 및 환불</span>
					        </c:if>
					    </div>
					    <div class="right"></div>
					</div>
				</div>
        	</c:if>
				<article class="card_item" id="card${reservation.id }">
					<a class="link_booking_details">
						<div class="card_body">
						    <div class="left"></div>
						    <div class="middle">
						        <div class="card_detail">
						            <em class="booking_number">No.<fmt:formatNumber value="${reservation.id }" pattern="00000000"/></em>
						            <h4 class="tit">${reservation.productName }</h4>
						            <ul class="detail">
						                <li class="item">
						                    <span class="item_tit">일정</span>
						                    <em class="item_dsc item_reservation_date">${reservation.reservationDate }</em>
					                    </li>
										<li class="item">
											<span class="item_tit">내역</span>
											<em class="item_dsc">
											<c:if test="${reservation.generalTicketCount ne 0}">일반(${reservation.generalTicketCount})</c:if>
											<c:if test="${reservation.youthTicketCount ne 0}"> 청소년(${reservation.youthTicketCount})</c:if>
											<c:if test="${reservation.childTicketCount ne 0}"> 어린이(${reservation.childTicketCount})</c:if>
											- 합계(${reservation.generalTicketCount+reservation.youthTicketCount+reservation.childTicketCount})
											</em>
										</li>
										<!-- <li class="item">
										    <span class="item_tit">상품</span>
										    <em class="item_dsc">내역이 없습니다.</em>
										</li>
										<li class="item">
										    <span class="item_tit">업체</span>
										    <em class="item_dsc">업체명이 없습니다.</em>
										</li> -->
									</ul>
					                <div class="price_summary">
					                	<span class="price_tit">결제 예정금액</span>
					                    <em class="price_amount"><span><fmt:formatNumber value="${reservation.totalPrice }" pattern="#,###"/></span><span class="unit">원</span></em>
					                </div>
					                <c:if test="${(reservation.reservationType eq 'REQUESTING') or (reservation.reservationType eq 'DUE')}">
					                <!-- [D] 예약 신청중, 예약 확정 만 취소가능, 취소 버튼 클릭 시 취소 팝업 활성화 -->
					                <div class="booking_cancel cancel" data-reservation-id="${reservation.id }">
                                        <button class="btn"><span>취소</span></button>
					                </div>
				                    </c:if>
				                    <c:if test="${reservation.reservationType eq 'USED'}">
					                <!-- [D] 예약 신청중, 예약 확정 만 취소가능, 취소 버튼 클릭 시 취소 팝업 활성화 -->
					                <div class="booking_cancel used" data-reservation-id="${reservation.id }" data-product-id="${reservation.productId }"
					                									data-product-name="${reservation.productName }">
                                        <button class="btn"><span>예매자 리뷰 남기기</span></button>
					                </div>
				                    </c:if>
					            </div>
					        </div>
					        <div class="right"></div>
					    </div>
					    <div class="card_footer">
					        <div class="left"></div>
					        <div class="middle"></div>
					        <div class="right"></div>
					    </div>
					</a>
					<a href="/products/${reservation.productId }" class="fn fn-share1 naver-splugin btn_goto_share" title="공유하기"></a>
				</article>
			<c:if test="${status.index == reservationList.size()-1 or (status.index < reservationList.size()-1 and reservationList[status.index+1].reservationType ne reservation.reservationType )}">
			</li>
			</c:if>	                   
    	</c:forEach>
	</ul>
</div>