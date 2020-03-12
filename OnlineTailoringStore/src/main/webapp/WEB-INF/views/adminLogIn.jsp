<%@ include file="common/header.jspf"%>

<div class="container">


	<h1>
		<center>Admin Sign In</center>
	</h1>
 
	
 <center>
	<form:form class = "form-signin" method="post" action="/adminSuccessLogin"	modelAttribute="admin">
 	${error} 
		<table class="table">
 			
			<tr>
				<td id="id1"><label>User Id</label></td>
				<td id="id2"><form:input path="username" name="username" /></td>
				
			</tr>
			
			<tr>
				<td id="id1"><label>Password</label></td>
				<td id="id5">
				<form:password path="password"  name="password" />
				<form:errors path="password" cssClass="error"/>
				</td>
				
			</tr>
 
			
 
			<tr >
				<td colspan = "2"><input type="Submit" class="btn btn-lg btn-primary btn-block" name="SignIn" value="Sign In" /></td>
				
			</tr>
 
 
		</table>
	</form:form>

	<a href="/">Go to Home Page</a>
 </center>
</div>
<%@ include file="common/footer.jspf"%>