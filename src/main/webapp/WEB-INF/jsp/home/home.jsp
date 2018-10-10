<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="scriptsandcss.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tienda Virtual ::: HOME</title>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<div class="container">
		<div class="jumbotron">
			<h1>HOME</h1>
			<p>Tienda Virtual</p>
		</div>
		
		<div class="row">
			<!-- <div class="col-md-offset-1 col-md-10 col-md-offset-1"> -->
			<div class="col-md-12">
				<div class="panel panel-info">
					<div class="panel-heading">
						<span class="glyphicon glyphicon-list-alt"></span> 
						Informaci&oacute;n de Productos.
					</div>
					<div class="panel-body">
					
					<form action="" method="post">
					
					
						<div class="alert alert-success alert-dismissable fade in">
							<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
							<strong><span class="glyphicon glyphicon-info-sign"></span> Informaci&oacute;n:</strong>
							<br>
							<span class="glyphicon glyphicon-chevron-right"></span> Cantidad: <span class="glyphicon glyphicon-usd"></span> <strong>500.00 pesos.</strong>
							<br>
							<span class="glyphicon glyphicon-chevron-right"></span> Fecha de Intercambio: <strong>22-Diciembre-2017</strong>
							<br>
							<span class="glyphicon glyphicon-chevron-right"></span> Horario: <strong>10:00 AM - 05:00 PM</strong>
							<br>
							<span class="glyphicon glyphicon-chevron-right"></span> <strong> Fecha Limite para Registrar Intercambios: 15/12/2017</strong>
							<br>
						</div>
					
						<div class="table-responsive">
							<table class="table table-condensed">
								<tr>
									<th>#</th>
									<th>Nombre</th>
									<th>Descripci&oacute;n</th>
									<th>Categoria</th>
									<th>Price</th>
									<th>Cantidad</th>
								</tr>
								<c:choose>
									<c:when test="${not empty piDtoList}">
										<c:forEach items="${piDtoList}" var="pi" varStatus="i">
											<tr>
												<td>${i.count}</td>
												<td>${pi.productName}</td>
												<td>${pi.productDescription}</td>
												<td>${pi.productCategory}</td>
												<td>$ ${pi.productPrice}</td>
												<td>
													<div class="input-group">
			      										<input class="form-control" placeholder="0" size="2"/>
			    									</div>
												</td>
											</tr>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<tr><td>No existen productos</td></tr>
									</c:otherwise>
								</c:choose>
							</table>
						</div>
					</form>
					</div>
				</div>
			</div>
		</div>
		
	</div>
	
	<jsp:include page="footer.jsp"/>
	<jsp:include page="../home/scriptsjs.jsp"/>
</body>
</html>