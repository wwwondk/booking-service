<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

 <!-- 취소 팝업 -->
 <!-- [D] 활성화 display:block, 아니오 버튼 or 닫기 버튼 클릭 시 숨김 display:none; -->
 <div class="popup_booking_wrapper" style="display:none;">
     <div class="dimm_dark" style="display:block"></div>
     <div class="popup_booking refund">
         <h1 class="pop_tit">
             <span>서비스명/상품명</span>
             <small class="sm">2000.0.00.(월)2000.0.00.(일)</small>
         </h1>
         <div class="nomember_alert">
             <p>취소하시겠습니까?</p>
         </div>
         <div class="pop_bottom_btnarea">
             <div class="btn_gray">
                 <a href="#" class="btn_bottom"><span>아니오</span></a>
             </div>
             <div class="btn_green">
                 <a href="#" class="btn_bottom"><span>예</span></a>
             </div>
         </div>
         <!-- 닫기 -->
         <a href="#" class="popup_btn_close" title="close">
             <i class="spr_book2 ico_cls"></i>
         </a>
         <!--// 닫기 -->
     </div>
 </div>
 <!--// 취소 팝업 -->