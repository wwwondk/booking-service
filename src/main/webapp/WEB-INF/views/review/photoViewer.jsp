<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<div id="photoViewer" style="display:none">
	<a class="popup_btn_close" title="close">
        <i class="spr_book2 ico_cls"></i>
    </a>
	<div class="pagination">
        <div class="bg_pagination"></div>
        <div class="figure_pagination">
            <span class="num"><span class="page_index">1</span></span>
            <span class="num off">/ <span class="total_count">3</span></span>
        </div>
    </div>
    <div id="layer">
	    <div class="group_visual">
	        <div>
	            <div class="container_visual" style="width: 500px; margin-top: 48px;">
	                <ul class="visual_img">
	                	<li class="item" style="width: 500px;"> 
	                		<img alt="" class="img_thumb" src="/files/1"> <span class="img_bg"></span>
	                    </li>
	                    <li class="item" style="width: 500px;"> 
	                		<img alt="" class="img_thumb" src="/files/2"> <span class="img_bg"></span>
	                    </li>
	                </ul>
	            </div>
	            <div class="prev">
	                <div class="prev_inn">
	                    <a class="btn_prev" title="이전">
	                        <!-- [D] 첫 이미지 이면 off 클래스 추가 -->
	                        <i class="spr_book2 ico_arr6_lt off"></i>
	                    </a>
	                </div>
	            </div>
	            <div class="nxt">
	                <div class="nxt_inn">
	                    <a class="btn_nxt" title="다음">
	                        <i class="spr_book2 ico_arr6_rt"></i>
	                    </a>
	                </div>
	            </div>
	        </div>
	    </div>
	</div>
</div>