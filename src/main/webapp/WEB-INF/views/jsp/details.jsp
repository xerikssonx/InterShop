<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix='sec'
	uri='http://www.springframework.org/security/tags'%>
<div class="container container-fluid">

	<div class="hero-unit">
		<span class="badge badge-info">${product.type.name}</span> <span
			class="badge badge-success">${product.subtype.name}</span> <span
			class="badge badge-warning pull-right"><h3>Price:
				${product.price}$</h3></span></br> </br> </br> <span class="badge badge-success pull-right"><h5>Store
				amount: ${product.storeAmount}</h5></span>
		<h1 class="text-center">${product.name}</h1>
		</br> </br> <img src="<c:url value="${product.image}"/>"
			alt="http://placehold.it/300x200" class="pull-left"
			style="float: left; margin: 0 5px 0 0;">
		<h4
			style="font-size: 12px; padding: 10px; width: 100%; height: 100px;">
			${product.description}</h4>
		</br>

		<sec:authorize ifAnyGranted='user'>
			<form class="form-inline pull-right"
				action="<c:url value="tobasket"/>" method="POST">
				<input type="text" class="span2" placeholder="amount" name="amount">
				<input type="hidden" name="id" value="${product.id}">
				<button type="submit" class="btn btn-large btn-primary">
					<i class="icon-shopping-cart"></i> Buy
				</button>
			</form>
		</sec:authorize>
	</div>


</div>