<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>PC Game Shop</title>
<!-- Bootstrap Core CSS -->
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link
	href="${pageContext.request.contextPath}/resources/css/shop-homepage.css"
	rel="stylesheet">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>
	<div class="page-header" align="center">
		<h1>Welcome in PC GAME Shop!</h1>
	</div>
	<!-- Navigation -->
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">

			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">

				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="${pageContext.request.contextPath}">Home</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="#">Sign in</a></li>
					<li><a href="#">Sign up</a></li>
				</ul>

			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->

	</nav>

	<!-- Page Content -->
	<div class="container">

		<div class="row">

			<div class="col-md-3">
				<div class="list-group">

					<a href="${pageContext.request.contextPath}/products/allProducts"
						class="list-group-item">SHOW ALL</a>

					<c:forEach var="category" items="${categories}">

						<a href=<c:url value="/products/${category}"></c:url>
							class="list-group-item">${category}</a>

					</c:forEach>
					<form action="${pageContext.request.contextPath}/products/search"
						method="get">

						<input type="text" class="form-control"
							placeholder="Search for..." name="productName"> <span
							class="input-group-btn">
							<button class="btn btn-default" type="submit">Search</button>

						</span>
					</form>

				</div>

			</div>

			<h3>
				${productListLabel}
			</h3>


			<div class="col-md-9">

				<div class="row">
					<c:forEach var="product" varStatus="status" items="${products}">
						<div class="col-sm-4 col-lg-4 col-md-4">
							<div class="thumbnail">
								<img
									src="${pageContext.request.contextPath}/resources/games_images${product.pathToImage}"
									alt="" style="max-height: 141px; max-width: 106px;">
								<div class="caption">
									<h4>
										<a href="#">${product.productName}</a>
									</h4>
									<h4 class="pull-right">${product.unitPrice}</h4>

									<p>
										See more snippets like this online store item at <a
											target="_blank" href="http://www.bootsnipp.com">Bootsnipp
											- http://bootsnipp.com</a>.
									</p>
								</div>
							</div>

						</div>
					</c:forEach>

				</div>

			</div>
		</div>

	</div>
	<!-- /.container -->

	<div class="container">

		<hr>

		<!-- Footer -->
		<footer>
			<div class="row">
				<div class="col-lg-12">
					<p>Copyright &copy; Your Website 2014</p>
				</div>
			</div>
		</footer>

	</div>
	<!-- /.container -->

	<!-- jQuery -->
	<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script
		src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>

</body>

</html>