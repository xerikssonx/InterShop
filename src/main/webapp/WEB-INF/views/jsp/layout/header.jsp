<head>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@ taglib prefix='sec'
	uri='http://www.springframework.org/security/tags'%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script type="text/javascript"
	src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<%@ taglib prefix='sec'
	uri='http://www.springframework.org/security/tags'%>
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery.js" />"></script>
<!-- <script>
	$(document).ready(function() {
		$("#username").focusout(function() {
			$.post("usernamevalid", $("#username")).done(function(data) {
				$('#usernameanswer').html(data);
			});
		});
	});
</script> -->
</head>
<body>
	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<a class="brand" href="<c:url value='/'/>">InterShop</a>
			<ul class="nav">

				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"> Categories <b class="caret"></b>
				</a>

					<ul class="dropdown-menu">
						<c:forEach var="item" items="${types}">
							<li class="dropdown-submenu"><a
								href="<c:url value='/choosesingle/${item.name}'/>"
								class="dropdown-toggle"> ${item.name} 
							</a>
								<ul class="dropdown-menu">
									<c:forEach var="sub" items="${item.getSubtypes()}">
										<li><a
											href="<c:url value='/choosedouble/${item.name}/${sub.name}'/>">${sub.name}</a></li>
									</c:forEach>
								</ul></li>
						</c:forEach>
					</ul></li>
				
				<sec:authorize ifAnyGranted='anonim'>
					<li><a href="#myModal" data-toggle="modal">Registration</a></li>
				</sec:authorize>
				<sec:authorize ifAnyGranted='user'>
					<li><a href="<c:url value='/details/tobasket'/>" data-toggle="modal"><i class="icon-shopping-cart"></i> Basket</a></li>
				<li><a href="<c:url value='/details/topurchase'/>" data-toggle="modal"><i class="icon-list-alt"></i> Purchase</a></li> 
				</sec:authorize>
			</ul>

			<sec:authorize ifAnyGranted='anonim'>
				<form method="POST" class="navbar-form pull-right"
					action="<c:url value='/j_spring_security_check'/>">
					<input type="text" name="j_username" class="span2"
						placeholder="login"> <input type="password"
						name="j_password" class="span2" placeholder="password">

					<button type="submit" class="btn">Ok</button>
				</form>
			</sec:authorize>
			<sec:authorize ifAnyGranted='user'>

				<ul class="nav pull-right">
					<li><a href="#"><b><sec:authentication
									property="principal.username" /></b></a></li>
					<li><a href=<c:url value='/j_spring_security_logout'/>>Logout</a></li>
				</ul>

			</sec:authorize>
		</div>
	</div>

	<div class="modal hide" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true"></button>
			<h3 id="myModalLabel">Registration</h3>
		</div>
		<c:url var="post_url" value="/createuser" />
		<form:form id="form" method="POST" action="${post_url}"
			commandName="user">
			<div class="modal-body">


				<table class="table table-bordered table-hover text-center">



					<tr>
						<td>Name :</td>
						<td><form:input path="name" id="name" />
							<div id="nameanswer"></div></td>
					</tr>
					<tr>
						<td>Surname :</td>
						<td><form:input path="surname" id="surname" /></td>
					</tr>
					<tr>
						<td>Username :</td>
						<td><form:input path="username" id="username" />
							<div id="usernameanswer"></div></td>

					</tr>
					<tr>
						<td>Password :</td>
						<td><form:password path="password" /></td>
					</tr>


					<tr>
						<td>Email :</td>
						<td><form:input path="email" id="email" />
							<div id="emailvalid"></div></td>
					</tr>

					<tr>
						<td>Phone :</td>
						<td><form:input class="required" path="phone" /></td>
					</tr>

					<tr>
						<td>City :</td>
						<td><form:input path="city" /></td>
					</tr>
					<tr>
						<td>Street :</td>
						<td><form:input path="street" /></td>
					</tr>
					<tr>
						<td>House :</td>
						<td><form:input path="house" /></td>
					</tr>
					<tr>
						<td>Room :</td>
						<td><form:input path="room" /></td>
					</tr>

				</table>
			</div>
			<div class="modal-footer">
				<button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
				<input class="btn btn-primary" type="submit" value="submit">
			</div>
		</form:form>
	</div>
</body>