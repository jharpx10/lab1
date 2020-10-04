<%-- 
    Document   : studentInfo
    Created on : 2/10/2020, 02:35:45 PM
    Author     : Alejandro Rios
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
          <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.css">
        <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.js"></script>


        <script type="text/javascript">


            $(document).ready(function () {
                // Setup - add a text input to each footer cell
                $('#table_id tfoot th').each(function () {
                    var title = $(this).text();
                    $(this).html('<input type="text" placeholder="Buscar ' + title + '" />');
                });

                // DataTable
                var table = $('#table_id').DataTable({
                    initComplete: function () {
                        // Apply the search
                        this.api().columns().every(function () {
                            var that = this;

                            $('input', this.footer()).on('keyup change clear', function () {
                                if (that.search() !== this.value) {
                                    that
                                            .search(this.value)
                                            .draw();
                                }
                            });
                        });
                    },
                    "language": {
                        "lengthMenu": "Mostrar _MENU_ registros por página",
                        "zeroRecords": "Ningún registro coincide con la búsqueda",
                        "loadingRecords": "Cargando...",
                        "processing": "Procesando...",
                        "info": "Mostrando página _PAGE_ de _PAGES_",
                        "infoEmpty": "No hay registros disponibles",
                        "search": "Buscar",
                        "paginate": {"next": "Siguiente", "previous": "Anterior"},
                        "infoFiltered": "(Filtrado de _MAX_ registros totales)"
                    }


                });





            });

        </script>
        
    </head>
    <body>
        <jsp:include page="menu.jsp"></jsp:include>
            <h1>Información estudiante</h1>
 <br>
             <h2>Información personal</h2>
             <br>
           

                <c:forEach var="a" items="${student}">

                    <h2>Foto</h2>
                    <img src="${a.foto}" alt="Foto estudiante" width="250" height="250">     
                   
                          <h2>Cédula</h2>
                         ${a.cedula}
                          <h2>Nombres</h2>
                        ${a.nombres}
                         <h2>Appellidos</h2>
                          ${a.apellidos}
                           <h2>Edad</h2>
                           ${a.edad}
                           
                           <br><br>
                          <a onclick="
                     return confirm('Esta seguro?')" 
                                 href="MatriculasServlet?action=deleteStudent&id=${a.cedula}">Eliminar cuenta</a>
                       
                <hr/>
           
        </c:forEach>   

    

 <br>
             <h2>Matriculas realizadas</h2>
             <br>

<table  class="display" id="table_id" >

    <thead>

        <tr>

            <th>Código</th>
            <th>Nombre</th>
            <th>Créditos</th>
            <th>Eliminar</th>
        </tr>

    </thead>
    <tbody>

        <c:forEach var="a" items="${courses}">
            <tr>    
                <td>${a.codigo} </td>
                <td> ${a.nombre} </td>
                <td>${a.creditos} </td>
                <td> <a onclick="
                       return confirm('Esta seguro?')" 
                        href="MatriculasServlet?action=deleteCourse&course=${a.codigo}">Eliminar matricula</a></td>

            </tr>
        <hr/></c:forEach>   

</tbody>


<tfoot>

    <tr>
        <th>Código</th>
        <th>Nombre</th>
        <th>Créditos</th>
        <th>Eliminar</th>

    </tr>

</tfoot>

</table>


</body>
</html>
