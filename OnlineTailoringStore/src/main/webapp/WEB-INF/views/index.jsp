<%@ include file="common/header.jspf"%>
<div class="container">
	<h1>
		<center>Online Tailoring Store</center>
	</h1>
	<div class="wrapper fadeInDown">
	<form:form method="post" class = "form-signin" action="/userSuccessLogin"	modelAttribute="user">
	${error} 
   <table class="table">	
	   <tr>
		   <td id="id1"><label>User Id</label></td>
		   <td id="id2"><form:input path="userId" name="userId" /></td>   
	   </tr>
	   <tr>
		   <td id="id1"><label>Password</label></td>
		   <td id="id5"><form:password path="password"  name="password" />
		   				<form:errors path="password" cssClass="error"/></td>	   
	   </tr>
	   <tr>
		   <td colspan = "2"><input type="Submit" class="btn btn-lg btn-primary btn-block" name="SignIn" value="Sign In" /></td>   
	   </tr>

   </table>
</form:form>
</div>

<br>
<center>
	<a href="/user">Not a user ? Sign Up ! </a>
<br><br>
<a href="/adminLogin">Admin Sign In</a>
</center>

</div>

<%@ include file="common/footer.jspf"%>