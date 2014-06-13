
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery.js" />"></script>
<script>
	$(document).ready(function() {
		$('#toDelete').on('click', function() {
			var prices = [];
			$('input:checked').each(function() {

				prices.push($(this).attr("value"));
			});
			$.ajax({
				url : "deletefrombasket",
				type : "POST",
				data : {
					list : prices
				},
				dataType : "json",
				traditional : true,
				success : function() {
					window.location = "<c:url value='/details/tobasket'/>";
				}
			});
		});
	});

	$(document)
			.ready(
					function() {
						$('#toBuy')
								.on(
										'click',
										function() {
											var ids = [];
											$('input:checked').each(
													function() {

														ids.push($(this).attr(
																"value"));
													});
											window.location
													.replace("<c:url value='/details/buyfrombasket'/>"
															+ "/" + ids);
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
				<th>check</th>
			</tr>
		</thead>
		<tbody>
			<c:set var="count" value="0" scope="page" />
			<c:forEach var="item" items="${baskets}">
				<c:set var="count" value="${count + 1}" scope="page" />
				<tr>
					<td>${count}</td>
					<td>${item.product.name}</td>
					<td>${item.amount}</td>
					<td>${item.totalCost}</td>
					<td><input id="${item.id}" type="checkbox" value="${item.id}"
						class="choise"></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
	
	<button id="toBuy" class="pull-right btn btn-large btn-primary">Buy</button>
	<button id="toDelete" class="pull-right btn btn-large">Delete</button>
</div>

