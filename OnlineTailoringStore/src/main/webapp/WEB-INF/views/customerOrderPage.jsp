<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation_user.jspf"%>


	<div class="container">
<center>
<form:form method="post" modelAttribute="order" action="/uploadmeasurement" >

${status} 
 <table class = "table table-striped">
 <tr> 
   <td colspan = "2"> <h1>Enter Top Measurements </h1>  </td>
  </tr>
 <tr>
 <td>Select Top_Fabric </td><td> <form:input path="top_fabric" name="top_fabric" /> </td>
 </tr>
 
  <tr><td>Select Top material</td><td> <form:input path="top_material" /></td>  </tr>
<tr> <td>Enter Delivery date </td><td><form:input path="top_duration" /> </td> </tr>
 <tr><td>Enter Length</td><td> <form:input path="toplength" /> </td> </tr>
 <tr><td>Enter Quantity </td><td><form:input path="top_quantity" /> </td> </tr>
 <tr><td>Enter Neck Size </td><td><form:input path="neck" /> </td> </tr>
 <tr><td>Enter Waist Size </td><td><form:input path="topwaist" /> </td> </tr>
 <tr><td>Enter Chest Size </td><td><form:input path="chest" /> </td> </tr>
 <tr><td>Enter Shoulder Length </td><td><form:input path="shoulderLength" /></td>  </tr>
 
 
  <tr> 
   <td colspan = "2"> <h1>Enter Lower Measurements </h1>  </td>
  </tr>
 <tr>
 <td>Select Top_Fabric</td><td><form:input path="bottom_fabric"  /> </td>
 </tr>
 
  <tr><td>Select Lower material</td><td> <form:input path="bottom_material" /></td>  </tr>
<tr> <td>Enter Delivery date</td><td> <form:input path="bottom_duration" /> </td> </tr>
 <tr><td>Enter Length </td><td><form:input path="bottomlength" /> </td> </tr>
 <tr><td>Enter Quantity </td><td><form:input path="bottom_quantity" /> </td> </tr>
 <tr><td>Enter hip Size </td><td><form:input path="hip" /> </td> </tr>
 <tr><td>Enter Knee Length </td><td><form:input path="kneelength" /> </td> </tr>
 
 <tr>
					<td colspan = "2"><input class="btn btn-lg btn-primary btn-block" type="submit" value="place order" /></td>
				</tr>
				
				
 </table>
</form:form>



	
</center>
</div>


<%@ include file="common/footer.jspf"%>