<%@include file="head.jsp"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="p"%>

<p:choose>
	<p:when test="${sessionScope.user !=null}">

		<div class="container">
			<div class="container">
				<div class="row">
					<div class="col-sm-6 d-xs-none">
						<br> <br> <br> <br> <img
							src="https://images-eu.ssl-images-amazon.com/images/I/71W43-d7l7L.png"
							width="100%" style="border-radius: 10px; height: 50%;">
					</div>

					<div class="col-sm-6">
						<form action="quotes?opt=1" method="post"
							enctype="multipart/form-data">

							<div align="center">
								<img
									src="https://images-eu.ssl-images-amazon.com/images/I/71W43-d7l7L.png"
									width="200" height="200">
							</div>

							<div class="form-group">
								<label for="title">Title:</label> <input type="text"
									class="form-control" id="title" name="title">
							</div>

							<div class="form-group">
								<label for="desc">Description:</label> <input type="text"
									class="form-control" id="desc" name="desc">
							</div>
							<div class="form-group">
								<label for="image">Image:</label> <input type="file"
									class="form-control" id="image" name="image">

							</div>

							<button type="submit" class="btn btn-default">Submit</button>
						</form>
					</div>
				</div>
			</div>
		</div>
		<script type="text/javascript" src="js/browse.js"></script>

	</p:when>

	<p:otherwise>
		<p:redirect url="login.jsp"></p:redirect>
	</p:otherwise>

</p:choose>

