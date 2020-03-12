<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation_admin.jspf"%>

<div class="container">
<center><h1>Add Dress Type</h1></center>
<center>
  <form:form method="post">
  Category : <input type="text" name="category" />
  DressType : <input type= "text" name = "dressType" />
  <input type="submit" />
  </form:form>
</center>

</div>
<%@ include file="common/footer.jspf"%>