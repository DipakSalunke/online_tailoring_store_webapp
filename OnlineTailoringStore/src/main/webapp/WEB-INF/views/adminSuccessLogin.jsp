<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation_admin.jspf"%>

<div class="container">
 <center>
	<h1>
		Hello Admin 
	</h1>
	<br><br>
	<table class="table">
	<tr><td><a href="/addCategory">Add New Category</a></td><td>${statusc}</td></tr>
	
	<tr><td><a href = "/addDressType">Add New DressType</a></td><td>${statusd}</td></tr>
</table>
 </center>

</div>
 <%@ include file="common/footer.jspf"%>