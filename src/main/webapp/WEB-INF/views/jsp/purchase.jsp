<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery.js" />"></script>
<div class="container container-fluid">

	<table class="table table-hover table-bordered table-striped">
		<caption>You already bought</caption>
		<thead>
			<tr>
				<th>#</th>
				<th>name</th>
				<th>price</th>
				<th>Type</th>
				<th>Subtype</th>
			</tr>
		</thead>
		<tbody>
			<c:set var="count" value="0" scope="page" />
			<c:forEach var="item" items="${products}">
			<c:set var="count" value="${count + 1}" scope="page"/>
				<tr>
					<td>${count}</td>
					<td>${item.name}</td>
					<td>${item.price}</td>
					<td>${item.type.name}</td>
					<td>${item.subtype.name}</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>



</div>