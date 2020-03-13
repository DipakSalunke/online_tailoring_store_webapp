<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body style="background-color: lavender">
MAke Payment
<br>
<h3>Enter Card Details</h3>

<form:form modelAttribute="payment" method="post"  action="/paymentSuccessful">
<table>
 <tr> <td>Enter Card Number </td>
  <td><form:input path="cardNumber"/>  </td>
</tr>

<tr> 
<td>Enter CVV </td>
<td><form:input path="cvv"/> </td>

</tr>

<tr>
					<td><input type="submit" value="Make Payment" /></td>
				</tr>
</table>
</form:form>

</body>
</html>