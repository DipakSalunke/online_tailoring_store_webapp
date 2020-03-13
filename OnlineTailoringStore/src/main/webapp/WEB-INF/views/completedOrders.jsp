


<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation_tailor.jspf"%>


	<div class="container">
<body>
<table class="table table-striped">
			<caption>Completed ORDER</caption>
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
		<c:forEach items="${completedOrderList}" var="CompletedOrder">
		<tr>
			<td>${CompletedOrder.order_id}</td>
			<td>${CompletedOrder.placed_date}</td>
			<td>${CompletedOrder.exp_delivery_date}</td>
			<td>${CompletedOrder.delivered_date}</td>
			<td>${CompletedOrder.amount}</td>
			
		</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</div>


<%@ include file="common/footer.jspf"%>