<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<div class="container container-fluid">
<ul class="thumbnails">
	<c:forEach var="item" items="${products}">
		<li class="span4">
			<div class="thumbnail">
				 <img src="<c:url value="${item.image}"/>" alt="http://placehold.it/300x200"> 				
				<h3 align="center">${item.name}</h3>
				<p align="center">${item.shortDescription}</p>
				<a class="btn btn-large btn-success" href="<c:url value="details/${item.id}"/>"><i
					class="icon-eye-open"></i> Details</a> <span
					class="badge badge-warning pull-right">${item.price}$</span>
			</div>
		</li>
	</c:forEach>
</ul>
</div>