<%@include file="head.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="p"%>
<div class="container">

	<p:choose>

		<p:when test="${applicationScope.quotes.size() > 0}">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Id</th>
						<th>Title</th>
						<th>Description</th>
						<th>Image</th>
						<th>Edit</th>
						<th>Delete</th>
					</tr>

				</thead>
				<p:forEach items="${applicationScope.quotes}" var="quotes">

					<tbody>
						<tr>
							<td>${quotes.id}</td>
							<td>${quotes.title}</td>
							<td>${quotes.description}</td>
							<td><img src="images/${quotes.image}" width="50" height="50"></td>
							<td><button class="btn btn-primary">Edit</button></td>
							<td>
								<form action="quotes">
									<input type="hidden" value="2" name="opt"> <input
										type="hidden" value="${quotes.id}" name="id"> <input
										type="submit" class="btn btn-danger" value="Delete">
								</form>
							</td>
						</tr>
					</tbody>

				</p:forEach>

			</table>
		</p:when>

		<p:otherwise>
			<div align="center">
				<h1>There is no Quotes.</h1>
			</div>
		</p:otherwise>

	</p:choose>


</div>