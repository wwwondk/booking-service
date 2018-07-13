<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

 <div class="grade_area"> 
 	<span class="graph_mask"> 
 		<em class="graph_value" style="width: 88%;"></em> 
      	</span> 
	<strong class="text_value">
		<span>${comments.avgScore }</span> 
		<em class="total">5.0</em> 
	</strong> 
	<span class="join_count">
		<em class="green" data-review-count="${comments.reviewCount }">${comments.reviewCount }건</em> 등록
	</span>
</div>