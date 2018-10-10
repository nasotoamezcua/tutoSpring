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
			<p><span class="glyphicon glyphicon-tasks"></span> Combobox Dependientes.</p>
		</div>
		
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-success">
					<div class="panel-heading">
						<span class="glyphicon glyphicon-tasks"></span>
						Combobox Dependientes.
					</div>
					<div class="panel-body">
						<form:form action="" method="POSt"  commandName="cutomerUserOrders" cssClass="well form-vertica">
							<div class="row">
								<div class="col-md-4">
									<form:select path="cliente" class="form-control" id="cliente">
										<form:option value="-1" label="-- Selecciona Cliente --"/>	
										<c:forEach items="${customers}" var="customer">
											<form:option value="${customer.idCustomer}" label="${customer.firstName} ${customer.lastName}"/>	
										</c:forEach>
									</form:select>
								</div>
								<div class="col-md-4">
									<form:select path="usuario" class="form-control" id="usuario">
										<form:option value="-1" label="-- Selecciona Usuario --"/>
											<form:options items="${users}" itemLabel="nameUser" itemValue="idUser"/> 
									</form:select>
								</div>
								<div class="col-md-4">
									<form:select path="orden" class="form-control" id="orden" disabled="true">
										<form:option value="-1" label="-- Selecciona Orden --"/>
									</form:select>
								</div>
							</div>
							
						</form:form>
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
		     $('#orden').find('option').remove().end().append('<option value="-1">-- Selecciona Orden --</option>');
		     $("#usuario").attr("disabled","disabled"); 
		    
		        e.preventDefault(); 
		        var idCustomerVal = $(this).val(); 
		        $("#orden").removeAttr("disabled");
		        //alert(idCustomerVal);
		        
		        
		        $.ajax({ 
		        	type: "GET", 
		        	//Este formato de la URL ideal: '/jQueryAjax/comboboxOrdenIdCustomerProduces/' + idCustomerVal
		            url:  contexPath + '/jQueryAjax/comboboxOrdenIdCustomerProduces/' + idCustomerVal,
		            dataType: 'json',
		            success: function(data){
		            	alert(data);
		            	showOrders(data);
		               	},
		            error: 
		            	function(e){
		            	   alert('Error: ' + e); 
		               }
		        });
		}else{
			 $("#orden").attr("disabled","disabled"); 
	         $('#orden').find('option').remove().end().append('<option value="-1">-- Selecciona Orden --</option>');
	         $("#usuario").removeAttr("disabled");
		} 
	});
	
	
	$('#usuario').change( function(e) { 
		if($(this).val()!="-1"){ 
		     $('#orden').find('option').remove().end().append('<option value="-1">-- Selecciona Orden --</option>');
		     $("#cliente").attr("disabled","disabled"); 
		    
		        e.preventDefault(); 
		        var idUserVal = $(this).val(); 
		        $("#orden").removeAttr("disabled");
		        //alert(idUserVal);
		        		        
		        $.ajax({ 
		        	type: "GET",
		        	//Con este formato de la URL: '/jQueryAjax/comboboxOrdenIdUser/' + idUserVal + '.html'
		        	//Es necesario que nuestro controlador utilice gson.toJson
		            url:  contexPath + '/jQueryAjax/comboboxOrdenIdUser/' + idUserVal + '.html',
		            dataType: 'json',
		            success: function(data){
		            	//alert(data);
		            	showOrders(data);
		               	},
		            error: 
		            	function(e){
		            	   alert('Error: ' + e); 
		               }
		        });
		}else{
			 $("#orden").attr("disabled","disabled"); 
	         $('#orden').find('option').remove().end().append('<option value="-1">-- Selecciona Orden --</option>');
	         $("#cliente").removeAttr("disabled");
		} 
	});
	
	function showOrders(data) {
		for ( var i = 0, len = data.length; i < len; ++i) { 
            var msajax = data[i]; 
            $('#orden').append("<option value=\"" +msajax.idOrder + "\">" + msajax.idOrder+ "</option>"); 
        } 
    }
	
	function showOrders2(data){
		//var data = JSON.parse(data);
    	//alert(data)
    	var d = '<option value = "-1">-- Selecciona Orden --</option>';
    	for(var i=0; i<data.length; i++){
    		d += '<option value = "' + data[i].idOrder + '">' + data[i].idOrder + '</option>'
    	}
    	$("#orden").html(d);
	}
	
});
</script>
</body>
</html>