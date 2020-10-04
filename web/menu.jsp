<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${empty login}">
    |<a href="login.jsp">Login</a>
    |<a href="newAccount.jsp">Register</a>
</c:if>
<c:if test="${not empty login}">
    |<a href="MatriculasServlet?action=logout">Logout</a>
    |<a href="MatriculasServlet?action=getStudent">Actualizar Información</a>
    |<a href="MatriculasServlet?action=listem">Lista de materias</a>
    |<a href="MatriculasServlet?action=liste">Lista de estudiantes</a>
     |<a href="enroll.jsp">Matricular</a>
</c:if>
    <hr/>