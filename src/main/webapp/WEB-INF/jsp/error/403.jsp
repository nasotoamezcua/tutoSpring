<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<jsp:include page="../home/scriptsandcss.jsp"/>
    <title>Tienda Virtual ::: ERROR 403</title>
</head>
<body>
	<jsp:include page="../home/header.jsp"/>
	<div class="container">
		<div class="jumbotron">
			<h1>
				<span class="glyphicon glyphicon-ban-circle"></span>
				ERROR 403 - ACCESO DENEGADO 
			</h1>
			<p>Tienda Virtual</p>
		</div>
        <div class="row">
            <div class="col-md-offset-3 col-md-6 col-md-offset-3">
                <div class="panel panel-warning">
                	<div class="panel-heading">
                		<span class="glyphicon glyphicon-ban-circle"></span>
                		Error 403 - Acceso Denegado
                	</div>
      				<div class="panel-body">
      					<div class="text-left">
      						<span class="glyphicon glyphicon-ban-circle"></span>
      						No cuentas con los permisos requeridos para accesar a esta pagina.
      					</div>
      					<br>
      					
      				 	 <div class="text-center">
      				 		<a href="<c:url value="/welcome"/>" class="btn btn-sm btn-warning">Home</a>
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