<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation_tailor.jspf"%>


	<div class = "container">
		<h1>
			<center>Update Shop Details</center>
		</h1>
		<center>
		<form:form method="post" action="/tailorRegister" modelAttribute="tailor">
		${status}
			<table class = "table">
				<tr>
					<td>Shop Name</td>
					<td><form:input  name="shopName" path="shopName" /></td>
				</tr>

				<tr>
					<td>Address</td>
					<td><form:textarea name="address" path="address" /></td>
				</tr>

				<tr>
					<td>Contact Number</td>
					<td><form:input name="contactNumber" path="contactNumber" /></td>
				</tr>
				
				<tr>
					<td>working hours</td>
					<td><form:input name="workingHours" path="workingHours" /></td>
				</tr>

				<tr>
					<td>Available Services</td>
					<td><form:input name="availableServices" path="availableServices" /></td>
				</tr>

				<tr>
					<td>Courier Service Available ?</td>
					<td>YES <form:radiobutton path="courier" name="courier" value="1" /></td>
					<td>NO <form:radiobutton path="courier" name="courier" value="0" /></td>
				</tr>
              
				<tr>
					<td><input type="submit" value="register" /></td>
				</tr>
			</table>
		</form:form>
</div>
	<%@ include file="common/footer.jspf"%>



