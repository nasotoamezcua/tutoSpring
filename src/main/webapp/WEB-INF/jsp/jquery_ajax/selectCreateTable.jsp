<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="../home/scriptsandcss.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>jQueey/Ajax</title>
</head>
<body>
	<jsp:include page="../home/header.jsp"/>
	<div class="container">
		<div class="jumbotron">
			<h1><span class="glyphicon glyphicon-transfer"></span> jQuery/Ajax</h1>
			<p><span class="glyphicon glyphicon-list-alt"></span> Generar Tabla.</p>
		</div>
		
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-success">
					<div class="panel-heading">
						<span class="glyphicon glyphicon-list-alt"></span>
						Generar Tabla.
					</div>
					<div class="panel-body">
						<form:form action="" method="POSt" commandName="cutomerUserOrders" cssClass="well form-vertica">
							<div class="row">
								<div class="col-md-6">
									<form:select path="cliente" class="form-control" id="cliente">
										<form:option value="-1" label="-- Selecciona Cliente --"/>	
										<c:forEach items="${customers}" var="customer">
											<form:option value="${customer.idCustomer}" label="${customer.firstName} ${customer.lastName}"/>	
										</c:forEach>
									</form:select>
								</div>
								<div class="col-md-6">
									<form:select path="usuario" class="form-control" id="usuario">
										<form:option value="-1" label="-- Selecciona Usuario --"/>
											<form:options items="${users}" itemLabel="nameUser" itemValue="idUser"/> 
									</form:select>
								</div>
							</div>
						</form:form>
						
						<div class="row" id="createTabla" style="display: none;">
							<div class="col-md-12">
							
								<div class="panel panel-info">
									<div class="panel-heading">
										<span class="glyphicon glyphicon-info-sign"></span>
										Detalle de Ordenes.
									</div>
								</div>
								<div class="panel-body">
									<div class="table-responsive">
										<table class="table table-condensed" id="tableOrder">
											<thead>
												<tr>
													<th>Id</th>
													<th>Fecha</th>
													<th>Total</th>
												</tr>
											</thead>
											<tbody></tbody>
										</table>
									</div>
								</div>
							
							</div>
						</div>
						
						
					</div>
				</div>
			</div>
		</div>
	</div>



<jsp:include page="../home/footer.jsp"/>
<jsp:include page="../home/scriptsjs.jsp"/>
<script type="text/javascript">
$(document).ready(function() { 
	
	var contexPath = "${pageContext.request.contextPath}";
	
	$('#cliente').change( function(e) { 
		if($(this).val()!="-1"){
			$('#tableOrder').find('tbody').remove().end().append('<tbody></tbody>');
		    $("#usuario").attr("disabled","disabled");
		    
		        e.preventDefault(); 
		        var idCustomerVal = $(this).val(); 
		        $("#createTabla").show();
		        //alert(idCustomerVal);
		        		       
		       
		        $.ajax({ 
		        	type: "GET", 
		            url:  contexPath + '/jQueryAjax/tableOrderIdCustomer/' + idCustomerVal + '.html',
		            dataType: 'json',
		            success: function(data){
		            	//alert(data);
		            	showOrdersTable(data);
		               	},
		            error: 
		            	function(e){
		            	   alert('Error: ' + e); 
		               }
		        });
		        
		}else{
			$('#tableOrder').find('tbody').remove().end().append('<tbody></tbody>');
			$("#usuario").removeAttr("disabled");
	        $("#createTabla").hide();
		} 
	});
	
	
	$('#usuario').change( function(e) { 
		if($(this).val()!="-1"){
			$('#tableOrder').find('tbody').remove().end().append('<tbody></tbody>');
		    $("#cliente").attr("disabled","disabled"); 
		    
		        e.preventDefault(); 
		        var idUserVal = $(this).val(); 
		        $("#createTabla").show();
		        //alert(idUserVal);
		        
		        
		        $.ajax({ 
		        	type: "GET", 
		            url:  contexPath + '/jQueryAjax/tableOrdenIdUser/' + idUserVal + '.html',
		            dataType: 'json',
		            success: function(data){
		            	//alert(data);
		            	showOrdersTable(data);
		               	},
		            error: 
		            	function(e){
		            	   alert('Error: ' + e); 
		               }
		        });
		        
		}else{
			$('#tableOrder').find('tbody').remove().end().append('<tbody></tbody>');
	        $("#cliente").removeAttr("disabled");
	        $("#createTabla").hide();
		} 
	});
	
	function showOrdersTable(data) {
        for ( var i = 0, len = data.length; i < len; ++i) { 
            var msajax = data[i]; 
            //$('#tableOrder tbody').append("<tr><td>" +msajax.idOrder + "</td><td>" + msajax.timeStamp + "</td><td> $" +  msajax.orderTotal + "</td></tr>" );
            $('#tableOrder').find('tbody').append("<tr><td>" +msajax.idOrder + "</td><td>" + msajax.timeStamp + "</td><td> $" +  msajax.orderTotal + "</td></tr>" );
        } 
    }
	
});
</script>
</body>
</html>