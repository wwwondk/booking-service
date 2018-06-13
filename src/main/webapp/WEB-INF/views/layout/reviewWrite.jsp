<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<div class="ct">
	<div class="ct_wrap">
		<tiles:insertAttribute name="reviewTitle" />
		
		<!-- 리뷰 별점 -->
		<tiles:insertAttribute name="starpoint" />
		<!-- //리뷰 별점 -->
	
		<!-- 리뷰 입력 -->
		<tiles:insertAttribute name="reviewForm" />
		<!-- //리뷰 입력 -->
	
		<!-- 리뷰 작성 푸터 -->
		<tiles:insertAttribute name="photoForm" />
		<!-- //리뷰 작성 푸터 -->
	
		<!-- 리뷰 등록 -->
		<div class="box_bk_btn">
			<button class="bk_btn"><span class="btn_txt">리뷰 등록</span></button>
		</div>
		<!-- //리뷰 등록 -->
	</div>
</div>