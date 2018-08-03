<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<%-- <fmt:parseDate var='endDay' pattern='yyyymmdd' value='${product.displayEnd }' /> --%>
<div class="group_visual">
    <div class="container_visual" style="width: 414px;">
        <ul class="visual_img">
            <li class="item" style="width: 414px;"> <img alt="" class="img_thumb" src="/files/${product.fileId }?size=414"> <span class="img_bg"></span>
                <div class="preview_txt">
                    <h2 class="preview_txt_tit">${product.name }</h2> 
                   <!--  <em class="preview_txt_dsc">₩12,000 ~ </em> -->
                    <em class="preview_txt_dsc">
                    	<fmt:formatDate value="${product.displayStart }" pattern="yyyy.MM.dd.(E)"/> ~ <%-- , 잔여티켓 2769매 --%>
                    </em> 
                </div>
            </li>
        </ul>
    </div>
</div>