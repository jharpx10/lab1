<%-- 
    Document   : newAccount
    Created on : 28/09/2020, 09:51:48 AM
    Author     : Alejandro Rios
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%><!DOCTYPE html>
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title><link rel="stylesheet" 
                                     href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="style.css"><!-- Optional theme-->
        <link rel="stylesheet" 
              href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
        <!-- Latest compiled and minified JavaScript --><script 
        src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    </head><body><jsp:include page="menu.jsp"></jsp:include>
        <h1>Registro estudiante</h1><div class="container well"><div align="center">
                <form action="MatriculasServlet?action=insert" method="post">
                    <table>
                        <tr><th><label><b>Cédula:</b></label><th>
  <input type="text" placeholder="Ingrese cédula" class="form-control" name="id" required=""/>
                         </th></tr>
                            <tr><th><label><b>Contraseña</b></label><th>
  <input type="password" placeholder="Ingrese Contraseña" class="form-control" name="password" required=""/>
                         </th></tr>
                     <tr><th><label><b>Nombres</b></label><th>
  <input type="text" placeholder="Ingrese Nombres" class="form-control" name="name" required=""/>
                         </th></tr>
                     <tr><th><label><b>Apellidos</b></label><th>
  <input type="text" placeholder="Ingrese Apellidos" class="form-control" name="lastname" required=""/>
                         </th></tr>
                     <tr><th><label><b>Sexo</b></label><th>
  <input type="text" placeholder="Ingrese Sexo" class="form-control" name="sex" required=""/>
                         </th></tr>
                       <tr><th><label><b>Edad</b></label><th>
  <input type="text" placeholder="Ingrese Edad" class="form-control" name="age" required=""/>
                         </th></tr>
                     
                            <tr><th><label><b>Foto</b></label><th>
  <input type="text" placeholder="Ingresar URL foto" class="form-control" name="photo" required=""/>
                         </th></tr>
                                
                            
                            <div class="break"></div></div><tr><td colspan="2">
                                <input class="btn icon-btn btn-success" type="submit" name="action"
                                       value="Insert"><span class="glyphicon glyphicon-ok-sign"></span>
                                <input class="btn icon-btn btn-lg" 
                                       type="reset" name="action" value="Reset">
                                <span class="glyphicon glyphicon-remove"></span>
                            </td></tr>
                    </table></form></div><br></div></body></html>

