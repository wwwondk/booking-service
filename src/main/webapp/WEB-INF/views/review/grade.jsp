<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

 <div class="grade_area"> 
 	<span class="graph_mask"> 
 		<em class="graph_value" style="width: 88%;"></em> 
      	</span> 
	<strong class="text_value"> 
		<span>${product.avgScore }</span> 
		<em class="total">5.0</em> 
	</strong> 
	<span class="join_count">
		<em class="green">${product.reviewCount }건</em> 등록
	</span>
</div>