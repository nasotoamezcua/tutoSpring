<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>

<jsp:useBean id="date" class="java.util.Date" />
<fmt:formatDate var="now" value="${date}" pattern="yyyy-MM-dd"/>
<c:set var="dateLimit" value="2017-12-18"/>

<nav class="navbar navbar-springns navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">
				<span class="glyphicon glyphicon-leaf"></span>
				TutoSpringMVC
			</a>
		</div>
		<security:authorize access="isAnonymous()">
			<a class="navbar-brand navbar-right" href="#">
				<span class="glyphicon glyphicon-leaf"></span>
				TutoSpringMVC
			</a>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active">
		      			<a href='<c:url value="/login"/>'>
		      				<span class="glyphicon glyphicon-log-in"></span> 
		      				login
		      			</a>
		      		</li>
				</ul>
			</div>
		</security:authorize>
		<div id="navbar" class="collapse navbar-collapse">
			<security:authorize access="isAuthenticated()">
			<ul class="nav navbar-nav">
				<li>
					<a href='<c:url value="/welcome" />' title="Home">
						<span class="glyphicon glyphicon-home"></span>
						Home
					</a>
				</li>
				<!-- JQuery/Ajax -->
				<li class="dropdown">
			    	<a class="dropdown-toggle" data-toggle="dropdown" href="#">
			    		<span class="glyphicon glyphicon-transfer"></span>
			    		JQuery/Ajax
			        	<span class="caret"></span>
			        </a>
			        	<ul class="dropdown-menu">
			          		<li>
			          			
			          			<a href='<c:url value="/jQueryAjax/comboboxDependiemtes"/>'>
			          				<span class="glyphicon glyphicon-tasks"></span>
			          				Combobox Dependientes
			          				</span>
			          			</a>
			          		</li>
			          		<li>
			          			<a href='<c:url value ="/jQueryAjax/selectCreateTable"/>'>
			          			<span class="glyphicon glyphicon-list-alt"></span>
			          				Generar Tabla 
			          			</a>
			          		</li>
			        	</ul>
			    </li>
			    <!-- Formularios -->
			    <li class="dropdown">
			    	<a class="dropdown-toggle" data-toggle="dropdown" href="#">
			    		<span class="glyphicon glyphicon-modal-window"></span>
			    		Formularios
			        	<span class="caret"></span>
			        </a>
			        	<ul class="dropdown-menu">
			          		<li>
			          			
			          			<a href='#'>
			          				<span class="glyphicon glyphicon-credit-card"></span>
			          				Componentes
			          				</span>
			          			</a>
			          		</li>
			        	</ul>
			    </li>
			    
			    
				<li class="dropdown">
					<a class="dropdown-toggle" data-toggle="dropdown" href="#">
						<span class="glyphicon glyphicon-eye-open"></span>
						Administrador
						<span class="caret"></span>
					</a>
					<ul class="dropdown-menu">
						<li>
							<a href='<c:url value="/admin/productInfo"/>'>
		          				<span class="glyphicon glyphicon-list-alt"></span>
		          				Productos
		          			</a>
						</li>
						<li class="divider"></li>
						<li>
							<a href='#'>
		          				<span class="glyphicon glyphicon-list-alt"></span>
		          				Clientes
		          			</a>
						</li>
					</ul>
				</li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
		      <li class="dropdown">
		      	<a class="dropdown-toggle" data-toggle="dropdown" href="#">
		      		<span class="glyphicon glyphicon-user"></span> 
		      		Usuario:
		      		<security:authentication property="principal.username" />
		      		<span class="caret"></span>
		      	</a>
		      	<ul class="dropdown-menu">
	          		<li>
	          			<a href='<c:url value="/cuentaUser" />'>
	          				<span class="glyphicon glyphicon-cog"></span>
	          				Mi Cuenta
	          			</a>
	          		</li>
	        	</ul>
		      </li>
		      <li>
		      	<a href='<c:url value="/logout"/>'>
		      		<span class="glyphicon glyphicon-log-out"></span> 
		      		logout
		      	</a>
		      </li>
		    </ul>
		    </security:authorize>
		</div>
		<!--/.nav-collapse -->
	</div>
</nav>