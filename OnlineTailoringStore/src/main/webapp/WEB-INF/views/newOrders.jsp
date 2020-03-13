


<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation_tailor.jspf"%>


	<div class="container">
<body>
<table class="table table-striped">
			<caption>NEW ORDER</caption>
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
		<c:forEach items="${newOrdersList}" var="NewOrder">
		<tr>
			<td>${NewOrder.order_id}</td>
			<td>${NewOrder.placed_date}</td>
			<td>${NewOrder.exp_delivery_date}</td>
			<td>${NewOrder.delivered_date}</td>
			<td>${NewOrder.amount}</td>
			
		</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</div>


<%@ include file="common/footer.jspf"%>