<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation_tailor.jspf"%>


<div class="container">
 <center>
	<h1>
        Hello tailor ${name} 
    </h1>
    
<a href="/updateShopDetails/${username}">update Shop Details</a>	${updateStatus} 
<br><br>
<a href="/updateDressTypes">update dress types</a> ${dressstatus}
<br><br>
<a href="/updatePatterns">update pattern and cost Details</a>
<br><br>
<a href="/viewOrders">view orders</a>
<br><br>
 </center>
</div>


<%@ include file="common/footer.jspf"%>


