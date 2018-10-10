<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<jsp:include page="../home/scriptsandcss.jsp"/>
    <title>Tienda Virtual ::: LOGIN</title>
</head>
<body>
	<jsp:include page="../home/header.jsp"/>
	<c:choose>
		<c:when test="${not empty errorMessage}">
			<c:set value="login-panel panel panel-danger" var="panel"/>
			<c:set value=" ${errorMessage}" var="title"/>
		</c:when>
		<c:otherwise>
			<c:set value="login-panel panel panel-primary" var="panel"/>
			<c:set value="Login" var="title"/>
		</c:otherwise>
	</c:choose>

    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="${panel}">
                    <div class="panel-heading">
                        <h3 class="panel-title"><span class="glyphicon glyphicon-modal-window"></span> ${title}</h3>
                    </div>
                    <div class="imgcontainer">
    					<img src="<c:url value="/resources/img/avatares/img_avatar2.png"/>" alt="Avatar" class="avatar" />
  					</div>
                    <div class="panel-body">
                        <form role="form" action="<c:url value="j_spring_security_check"/>" method="post">
                            <fieldset>
                                <div class="input-group">
                                	<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                    <input class="form-control" placeholder="Usuario" name="j_username" autofocus="true" />
                                </div>
                                <br>
                                <div class="input-group">	
                      				<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                         			<input class="form-control" placeholder="Password" name="j_password" type="password" value="" />
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input name="remember" type="checkbox" value="Remember Me"/>
                                        <p>Remember  me</p>
                                    </label>
                                </div>
                                <!-- Change this to a button or input when using this as a form -->
                                <input type="submit" value="Ingresar" class="btn btn-lg btn-primary btn-block" />
                                <!--  <a href="${now lt dateLimit ? '/spring-intercambios-navidad/registrar' : '#'}"
                                		class="btn btn-lg btn-success btn-block ${now lt dateLimit ? '' : 'disabled'}">Registar</a>
                                	 -->
                                	<a href="/spring-intercambios-navidad/registrar"
                                	class="btn btn-lg btn-success btn-block">Registar</a>
                                
                            </fieldset>
                        </form>
                    </div>
                </div>
                
            </div>
        </div>
    </div>
	<jsp:include page="../home/footer.jsp"/>
	<jsp:include page="../home/scriptsjs.jsp"/>
	
</body>
</html>