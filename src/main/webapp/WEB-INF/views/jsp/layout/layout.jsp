<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix='sec' uri='http://www.springframework.org/security/tags'%>
<html>
<head>
<%@ taglib prefix='sec' uri='http://www.springframework.org/security/tags'%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet"
	type="text/css" />
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.css" />" type="text/css" />
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap-responsive.css" />"
	type="text/css" />
<script type="text/javascript"
	src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

<script type="text/javascript"
	src="<c:url value="/resources/js/jquery.js" />"></script>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>
<body>
	<tiles:insertAttribute name="header" />
	<tiles:insertAttribute name="body" />
	<tiles:insertAttribute name="footer" />
</body>
</html>