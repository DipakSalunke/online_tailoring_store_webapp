<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation_user.jspf"%>

<div class="container">
	<h1>
		<center>Select DressType</center>
	</h1>


	<center>
		<form:form method="post" action="/addTailorDressType" modelAttribute="user">

			<table>
				<tr>
					<td>Category</td>
					<td><form:select path="dressType" id="dressType" items="${dressList}">
						</form:select></td>
				</tr>
				
				<tr>
					<td><input type="submit" value="Search" /></td>
				</tr>
			</table>
		</form:form>
		
	</center>

</div>
	<%@ include file="common/footer.jspf"%>