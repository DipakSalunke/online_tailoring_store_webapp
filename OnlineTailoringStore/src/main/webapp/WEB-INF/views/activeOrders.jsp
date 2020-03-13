


<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation_tailor.jspf"%>


	<div class="container">
<body>
<table class="table table-striped">
			<caption>Active ORDER</caption>
			<thead>
				<tr>
					<th>Order Id</th>
					<th>Placed Date</th>
					<th>Expected Delivery Date</th>
					<th>Delivered Date</th>
					<th>Amount</th>
					
				</tr>
			</thead>
			<tbody>
		<c:forEach items="${activeOrderList}" var="ActiveOrder">
		<tr>
			<td>${ActiveOrder.order_id}</td>
			<td>${ActiveOrder.placed_date}</td>
			<td>${ActiveOrder.exp_delivery_date}</td>
			<td>${ActiveOrder.delivered_date}</td>
			<td>${ActiveOrder.amount}</td>
			
		</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</div>


<%@ include file="common/footer.jspf"%>