<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Efecto copos -->
<script type="text/javascript" src="<c:url value="/resources/js/navidadEfecto.js"/>" ></script>
<!-- jQuery -->
<script src="<c:url value="/resources/vendor/jquery/jquery.min.js"/>"></script>
<!-- Bootstrap Core JavaScript -->
<script src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.min.js"/>"></script>
<!-- Metis Menu Plugin JavaScript -->
<script src="<c:url value="/resources/vendor/metisMenu/metisMenu.min.js"/>"></script>
<!-- Custom Theme JavaScript -->
<script src="<c:url value="/resources/dist/js/sb-admin-2.js"/>"></script>

<script>
$(document).ready(function(){
    $('[data-toggle="popover"]').popover();  
    
});
</script>