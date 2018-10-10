<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<jsp:include page="../home/scriptsandcss.jsp"/>
    <title>Tienda Virtual ::: MI CUENTA</title>
</head>
<body>
	
	<jsp:include page="../home/header.jsp"/>
	<div class="container">
		<div class="jumbotron">
			<h1>Mi Cuenta</h1>
			<p>Sistema Tienda Virtual</p>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-success">
					<div class="panel-heading">
						<span class="glyphicon glyphicon-cog"></span>
						Mi cuenta.
					</div>
					<div class="imgcontainer">
						<a href="#" title="${userDto.nameUser}" data-toggle="popover" data-placement="right"
								data-trigger="hover" data-content="${userDto.createUser}">
							<img alt="Avatar" class="avatarUser" src='<c:url value="/resources/img/avatares/img_avatar2.png"/>'/>
						</a>
  					</div>
					<div class="panel-body">
						<div class="table-responsive">
							<table class="table table-condensed table-hover table-striped">
								<tr>
									<th>Usuario</th>
									<th>Password</th>
									<th>Create Date</th>
									<th>Products</th>
									<th>Active</th>
									<th>Ordenes</th>
								</tr>
								<c:choose>
									<c:when test="${not empty userDto}">
										<tr>
											<td>${userDto.nameUser}</td>
											<td>${userDto.passwordUser}</td>
											<td>${userDto.createUser}</td>
											<td>
												<span class="${userDto.productsUser eq 'Y' ? 'glyphicon glyphicon-thumbs-up':'glyphicon glyphicon-thumbs-down'}"></span>
											</td>
											<td>
												<span class="${userDto.activeUser eq '1' ? 'glyphicon glyphicon-thumbs-up':'glyphicon glyphicon-thumbs-down'}"></span>
											</td>
											<td>
												<div>
													<c:choose>
														<c:when test="${fn:length(orderDtoList) gt 0}">
															<button data-toggle="collapse" data-target="#order${userDto.nameUser}" 
																class="btn btn-info btn-sm">
																	<span class="badge">
																		<span class="glyphicon glyphicon-shopping-cart"></span>
																		${fn:length(orderDtoList)}
																	</span>
															</button>
														</c:when>
														<c:otherwise>
															<span class="badge">
																<span class="glyphicon glyphicon-shopping-cart"></span>
																${fn:length(orderDtoList)}
															</span>
														</c:otherwise>
													</c:choose>
												</div>
											</td>
										</tr>
										<!-- LISTA DE ORDENES -->
										<tr>
											<td colspan="6">
												<div id="order${userDto.nameUser}" class="collapse">
													<div class="panel panel-info">
														<div class="panel-heading">
															<span class="glyphicon glyphicon-shopping-cart"></span> 
															${userDto.nameUser} ::: Ordenes: 
															<span class="badge">${fn:length(orderDtoList)}</span>
														</div>
													</div>
													<div class="panel-body">
														<div class="table-responsive">
															<table class="table table-condensed table-hover table-striped">
																<tr>
																	<th>#</th>
																	<th>Cliente</th>
																	<th># Orden</th>
																	<th>Total</th>
																	<th>Fecha</th>
																	<th>Detalle</th>
																</tr>
																<c:choose>
																	<c:when test="${not empty orderDtoList}">
																		<c:forEach items="${orderDtoList}" var="order" varStatus="o">
																		<tr>
																			<td>${o.count}</td>
																			<td>${order.customerDto.firstName} ${order.customerDto.lastName} </td>
																			<td>${order.idOrder}</td>
																			<td>$ ${order.orderTotal}</td>
																			<td>${order.timeStamp}</td>
																			<td>
																				<div>
																					<button data-toggle="collapse" data-target="#orderItems${order.idOrder}" class="btn btn-warning btn-sm">
																						<span class="badge">
																							<span class="glyphicon glyphicon-list-alt"></span>
																							${fn:length(order.orderItemsDto)}
																						</span>
																					</button>
																				</div>
																			</td>
																		</tr>
																		<!-- DETALLE DE LAS ORDENES -->
																		<tr>
																			<td colspan="6">
																				<div id="orderItems${order.idOrder}" class="collapse">
																					<div class="panel panel-warning">
																						<div class="panel-heading">
																							<span class="glyphicon glyphicon-list-alt"></span> 
																							 Detalle Orden # ${order.idOrder}: 
																							<span class="badge">${fn:length(order.orderItemsDto)}</span>
																						</div>
																					</div>
																					<div class="panel-body">
																						<div class="table-responsive">
																							<table class="table table-condensed table-hover table-striped">
																								<tr>
																									<th>#</th>
																									<th>Articulo</th>
																									<th>Descripci&oacute;n</th>
																									<th>Categoria</th>
																									<th>Precio</th>
																									<th>Cantidad</th>
																									<th>Total</th>
																								</tr>
																								<c:forEach items="${order.orderItemsDto}" var="products" varStatus="p">
																									<tr>
																										<td>${p.count}</td>
																										<td>${products.productInfoDto.productName}</td>
																										<td>${products.productInfoDto.productDescription}</td>
																										<td>${products.productInfoDto.productCategory}</td>
																										<td>$ ${products.orderUnitPrice}</td>
																										<td>${products.orderQuantity}</td>
																										<td>$ ${products.orderQuantity * products.orderUnitPrice}</td>
																									</tr>
																								</c:forEach>
																							</table>
																						</div>
																					</div>
																				</div>
																			</td>
																		</tr>
																		
																		</c:forEach>
																	</c:when>
																	<c:otherwise>
																		<tr><td colspan="5">No existen Ordenes</td></tr>
																	</c:otherwise>
																</c:choose>
															</table>
														</div>
													</div>
												</div>
											</td>
										</tr>
									</c:when>
									<c:otherwise>
										<tr><td colspan="6">Usuario no encontrado</td></tr>
									</c:otherwise>
								</c:choose>
							</table>
						</div>
						<div class="text-center">
							<a href='<c:url value="/welcome"/>' class="btn btn-sm btn-success">OK</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<jsp:include page="../home/footer.jsp"/>
	<jsp:include page="../home/scriptsjs.jsp"/>
</body>
</html>