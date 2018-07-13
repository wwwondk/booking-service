<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<div class="ct">
	<div class="wrap_review_list">
		<div class="review_header">
			<div class="top_title gr">
				<a href="#" class="btn_back" title="이전 화면으로 이동"> 
					<i class="fn fn-backward1"></i> 
				</a>
				<h2><a class="title" data-product-id="${comments.productId}">${comments.productName}</a></h2>
            </div>
		</div>
        <div class="section_review_list">
            <div class="review_box">
                <h3 class="title_h3">예매자 한줄평</h3>
                <div class="short_review_area">
					<tiles:insertAttribute name="grade"/>
                    <tiles:insertAttribute name="reviewList" />
                </div>
                <p class="guide"> 
                	<i class="spr_book2 ico_bell"></i> 
                	<span>네이버 예약을 통해 실제 방문한 이용자가 남긴 평가입니다.</span> 
                </p>
            </div>
        </div>
	</div>
</div>
<tiles:insertAttribute name="review-list-template" />
<hr> 
