<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation_user.jspf"%>


	<div class="container">
		<table class="table table-striped">
			<caption>Tailors</caption>
			<thead>
				<tr>
					<th>Shop Name</th>
					<th>Address</th>
					<th>Contact Number</th>
					<th>Working Hours</th>
					<th>Available Services</th>
					<th>Courier</th>
				</tr>
			</thead>
			<tbody>
		<c:forEach items="${TailorList}" var="Tailor">
		<tr>
			<td><a href = "/uploadmeasurement">${Tailor.shopName}</a></td>
			<td>${Tailor.address}</td>
			<td>${Tailor.contactNumber}</td>
			<td>${Tailor.workingHours}</td>
			<td>${Tailor.availableServices}</td>
			<td>${Tailor.courier}</td>
		</tr>
		</c:forEach>
	</tbody>
</table>
</div>


<%@ include file="common/footer.jspf"%>