<%-- 
    Document   : enrroll
    Created on : 2/10/2020, 06:58:46 PM
    Author     : Alejandro Rios
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <jsp:include page="menu.jsp"></jsp:include>
        
         <form action="MatriculasServlet?action=enroll" method="post">
                    <table>
                       
                            <tr><th><label><b>Código materia</b></label><th>
  <input type="text" placeholder="Ingresar materia" class="form-control" name="course" required=""/>
                         </th></tr>
                     <tr><th><label><b>Fecha</b></label><th>
  <input type="text" placeholder="Ingresar fecha" class="form-control" name="date" required=""/>
                         </th></tr>
                                      
                            <div class="break"></div></div><tr><td colspan="2">
                                <input class="btn icon-btn btn-success" type="submit" name="action"
                                       value="Insert"><span class="glyphicon glyphicon-ok-sign"></span>
                                <input class="btn icon-btn btn-lg" 
                                       type="reset" name="action" value="Reset">
                                <span class="glyphicon glyphicon-remove"></span>
                            </td></tr>
                    </table></form>
    </body>
</html>
