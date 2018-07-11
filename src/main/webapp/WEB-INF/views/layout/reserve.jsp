<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

 <div class="ct" data-product-id="${product.id}">
     <div class="ct_wrap">
         <div class="top_title">
             <a href="#" class="btn_back" title="이전 화면으로 이동"> <i class="fn fn-backward1"></i> </a>
             <h2><span class="title">${product.name }</span></h2>
         </div>
         <tiles:insertAttribute name="title"/>
		 <tiles:insertAttribute name="productDetails"/>
         <tiles:insertAttribute name="bookingTicket" />
         <tiles:insertAttribute name="bookingForm" />
         <div class="box_bk_btn">
             <!-- [D] 약관 전체 동의가 되면 disable 제거 -->
             <div class="bk_btn_wrap disable"> 
             	<button type="button" class="bk_btn"> 
             		<i class="spr_book ico_naver_s"></i>  
             		<span>예약하기</span> 
             	</button> 
             </div>
         </div>
     </div>
 </div>
