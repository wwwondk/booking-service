<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<hr>
<div class="ct">
    <div class="section_my">
        <tiles:insertAttribute name="mySummary"/>
		<tiles:insertAttribute name="myreservationList" />
		<!-- 예약 리스트 없음 -->
<!--         <div class="err"> 
        	<i class="spr_book ico_info_nolist"></i>
            <h1 class="tit">예약 리스트가 없습니다</h1>
        </div> -->
        <!--// 예약 리스트 없음 -->
    </div>
</div>
<hr>

<tiles:insertAttribute name="canclePopup"/>