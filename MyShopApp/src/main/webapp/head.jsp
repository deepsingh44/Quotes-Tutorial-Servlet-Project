<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="p"%>
<head>
<title>Quotes Tutorial</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>

<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Quotes Tutorial</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<p:choose>
				<p:when test="${sessionScope.user !=null}">
					<ul class="nav navbar-nav">

						<li class="active"><a href="add.jsp">Add Quotes</a></li>
						<li class="active"><a href="quotes?opt=5">List Quotes</a></li>
						<li class="active"><a href="users?opt=3">Logout</a></li>
					</ul>

				</p:when>





				<p:otherwise>
					<ul class="nav navbar-nav navbar-right">
						<li><a href="register.jsp"><span class="glyphicon glyphicon-user"></span>
								Sign Up</a></li>
						<li><a href="login.jsp"><span class="glyphicon glyphicon-log-in"></span>
								Login</a></li>
					</ul>
				</p:otherwise>
			</p:choose>
		</div>
	</div>
</nav>