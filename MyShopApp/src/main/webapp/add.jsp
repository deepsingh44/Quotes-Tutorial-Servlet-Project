<%@include file="head.jsp"%>
<div class="container">
	<div class="row">
		<div class="col-sm-6"
			style="background-image: url('https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQYSyftHl9R-aiFBnSs4RuodoDM7v1FuwIOBw&amp;usqp=CAU'); background-size: cover; height: 100%;">

		</div>

		<div class="col-sm-6">
			<form action="quotes?opt=1">
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