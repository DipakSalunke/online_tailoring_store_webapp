<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation_tailor.jspf"%>


<div class="container">
<form:form method="post" action="/updatePatternsSuccess" modelAttribute="update">
${updateStatus}
<form:select path="dressType" items="${dresstype}" />

<form:input path="pattern" id="pattern"/>
<form:input path="cost" id="cost"/>
<input type="submit" value="Add" />

</form:form>
</div>


<%@ include file="common/footer.jspf"%>
