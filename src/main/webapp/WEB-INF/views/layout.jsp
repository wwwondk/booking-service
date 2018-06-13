<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
	<head>
	    <meta charset="utf-8">
	    <meta name="description" content="네이버 예약, 네이버 예약이 연동된 곳 어디서나 바로 예약하고, 네이버 예약 홈(나의예약)에서 모두 관리할 수 있습니다.">
	    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,minimum-scale=1,user-scalable=no">
	    <title><tiles:getAsString name="title" /></title>
	    <tiles:insertAttribute name="css" />
	</head>
	
	<body>
	    <div id="container">
	    	<tiles:insertAttribute name="header" />
	    	<tiles:insertAttribute name="content" />
	    	<tiles:insertAttribute name="footer" />
		</div>
		
		<tiles:insertAttribute name="js" />
		<tiles:insertAttribute name="page-js" />
	</body>
</html>