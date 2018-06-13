<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- 예약 현황 -->
<div class="my_summary">
    <ul class="summary_board">
        <li class="item">
            <!--[D] 선택 후 .on 추가 link_summary_board -->
            <a href="#" class="link_summary_board on"> <i class="spr_book2 ico_book2"></i> <em class="tit">전체</em> <span class="figure">${summary.ALL }</span> </a>
        </li>
        <li class="item">
            <a href="#" class="link_summary_board"> <i class="spr_book2 ico_book_ss"></i> <em class="tit">이용예정</em> <span class="figure">${summary.DUE_REQUESTING }</span> </a>
        </li>
        <li class="item">
            <a href="#" class="link_summary_board"> <i class="spr_book2 ico_check"></i> <em class="tit">이용완료</em> <span class="figure">${summary.USED}</span> </a>
        </li>
        <li class="item">
            <a href="#" class="link_summary_board"> <i class="spr_book2 ico_back"></i> <em class="tit">취소·환불</em> <span class="figure">${summary.REFUND_CANCEL}</span> </a>
        </li>
    </ul>
</div>
<!--// 예약 현황 -->