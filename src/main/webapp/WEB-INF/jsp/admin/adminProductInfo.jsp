<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="../home/scriptsandcss.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tienda Virtual ::: Productos</title>
</head>
<body>
	<jsp:include page="../home/header.jsp"/>
	<div class="container">
		<div class="jumbotron">
			<h1>Productos</h1>
			<p>Tienda Virtual</p>
		</div>
		
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-warning">
					<div class="panel-heading">
						<span class="glyphicon glyphicon-list-alt"></span> 
						Activar / Inactivar Productos.
					</div>
					<div class="panel-body">
						<div class="table-responsive">
							<table class="table table-condensed">
								<tr>
									<th>#</th>
									<th>Articulo</th>
									<th>Descripci&oacute;n</th>
									<th>Categoria</th>
									<th>Price</th>
									<th>Activar/Inactivar</th>
								</tr>
								<c:choose>
									<c:when test="${not empty productInfoDtoList}">
										<c:forEach items="${productInfoDtoList}" var="pidl" varStatus="i">
											<tr>
												<td>${i.count}</td>
												<td>${pidl.productName}</td>
												<td>${pidl.productDescription}</td>
												<td>${pidl.productCategory}</td>
												<td>$ ${pidl.productPrice}</td>
												<td>
													<c:choose>
														<c:when test="${pidl.productAvail eq 'Y' }">
															<a href='<c:url value="/admin/productInfo/update/${pidl.idProduct}?active=I"/>' 
																class="btn btn-sl btn-danger" title="Inactivar">
																	<span class="glyphicon glyphicon-eye-close"></span>
															</a>
														</c:when>
														<c:otherwise>
															<a href='<c:url value="/admin/productInfo/update/${pidl.idProduct}?active=A"/>' 
																class="btn btn-sl btn-success" title="Activar">
																	<span class="glyphicon glyphicon-eye-open"></span>
															</a>
														</c:otherwise>
													</c:choose>
												</td>
											</tr>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<tr><td colspan="6">No existen productos</td></tr>
									</c:otherwise>
								</c:choose>
							</table>
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