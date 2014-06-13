<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery.js" />"></script>
<script>
	$(document).ready(function() {
		$('#toBuy').on('click', function() {
			var prices = [];
			var e1 = document.getElementById("payType");
			var payType = e1.options[e1.selectedIndex].value;
			var e2 = document.getElementById("deliveryType");
			var deliveryType = e2.options[e2.selectedIndex].value;

			$('.choise').each(function() {

				prices.push($(this).attr("value"));
			});
			$.ajax({
				url : "tofinishbuy",
				type : "POST",
				data : {
					list : prices,
					payType : payType,
					deliveryType : deliveryType

				},
				dataType : "json",
				traditional : true,
				success : function() {
					window.location = "<c:url value='/successbuy'/>";
				}
			});
		});
	});
</script>

<div class="container container-fluid">


	<table class="table table-hover table-bordered table-striped">
		<caption>Its your basket</caption>
		<thead>
			<tr>
				<th>#</th>
				<th>name</th>
				<th>amount</th>
				<th>total price</th>
			</tr>
		</thead>
		<tbody>
			<c:set var="count" value="0" scope="page" />
			<c:forEach var="item" items="${baskets}">
				<c:set var="count" value="${count + 1}" scope="page" />
				<tr>
					<td>${count}<input class="choise hide" value="${item.id}" /></td>
					<td>${item.product.name}</td>
					<td>${item.amount}</td>
					<td>${item.totalCost}</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>

	</br> <span class="pull-right badge badge-warning"><h6>Total ${total}$</h6></span></br>
	<div>
		<span>delivery</span> <select id="payType">
			<option value="1" selected="selected">cash</option>
			<option value="2">credit</option>
			<option value="3">noncash</option>
		</select> <span>pay</span> <select id="deliveryType">
			<option value="1" selected="selected">courier</option>
			<option value="2">post</option>
		</select>
	</div>

	<div class="pull-right">
		<a class="btn btn-large" href="<c:url value='/home'/>">Cancle</a>
		<button id="toBuy" class="btn btn-large btn-primary" type="button">Buy</button>
	</div>
</div>