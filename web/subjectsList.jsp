<%-- 
    Document   : studentsList
    Created on : 27/09/2020, 10:16:30 PM
    Author     : Alejandro Rios
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html><html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Materias</title>
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
            <h1>Lista de materias</h1>

            <table  class="display" id="table_id" >

                <thead>

                    <tr>

                        <th>Código</th>
                        <th>Nombre</th>
                        <th>Créditos</th>

                    </tr>

                </thead>
                <tbody>


                <c:forEach var="a" items="${subjects}">
                    <tr>             
                        <td>${a.codigo}</td>
                        <td>${a.nombre}</td>
                        <td>${a.creditos}</td>
                    </tr>
                <hr/></c:forEach>   
        </tbody>


        <tfoot>

            <tr>
                <th>Código</th>
                <th>Nombre</th>
                <th>Créditos</th>

            </tr>

        </tfoot>

    </table>


</body>
</html>

