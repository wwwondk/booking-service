<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="ko">
        <div class="ct main">
            <div>
                <tiles:insertAttribute name="title" />
                <tiles:insertAttribute name="productInformation" />
                <tiles:insertAttribute name="event" />   
                <div class="section_btn"> <button type="button" class="bk_btn"> <i class="fn fn-nbooking-calender2"></i> <span>예매하기</span> </button> </div>
					
                <div class="section_review_list">
                    <div class="review_box">
                        <h3 class="title_h3">예매자 한줄평</h3>
                        <div class="short_review_area">
                            <tiles:insertAttribute name="grade" /> 
                			<tiles:insertAttribute name="reviewList" />
                        </div>
                        <p class="guide"> <i class="spr_book2 ico_bell"></i> <span>네이버 예약을 통해 실제 방문한 이용자가 남긴 평가입니다.</span> </p>
                    </div>
                    <a class="btn_review_more" href="#"> <span>예매자 한줄평 더보기</span> <i class="fn fn-forward1"></i> </a>
                </div>
				 
                <tiles:insertAttribute name="detailInformation" /> 
            </div>
        </div>
    <div id="photoviwer"></div>