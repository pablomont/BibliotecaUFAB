<%@include file="/resources/includes/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <%@include file="/resources/includes/head.html" %>
</head>
</head>

<body>
    <div id="wrapper">
        <%@include file="/resources/includes/navigation.jsp" %>
        <!-- Page Content -->
        <div id="page-wrapper">
            
            <div class="container-fluid">
                <div class="row">
                        <div class="col-lg-12">
                            <h1 class="page-header">Livros</h1>
                        </div>
                        <!-- /.col-lg-12 -->
                    </div>
                    <!-- /.row -->
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="panel panel-default">
                                <div class="panel-body">
                                    <table width="100%" class="table table-striped table-bordered table-hover" id="dataTable-livros">
                                        <thead>
                                          <tr>
												<th>ISBN</th>
												<th>Titulo</th>
												<th>Editora</th>
												<th>Número de paginas</th>
												<th>Area</th>
												<th>Tema </th>                                                
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="livro" items="${livros}">
                                                <tr class="odd gradeX">
                                                   	<td>${livro.isbn}</td>
													<td>${livro.titulo}</td>
													<td>${livro.editora}</td>
                                                    <td>${livro.numPaginas}</td>
													<td>${livro.area}</td>
                                                    <td>${livro.tema}</td>
                                                </tr>   
                                             </c:forEach>             
                                        </tbody>
                                    </table>
                                </div>
                                <!-- /.panel-body -->
                            </div>
                            <!-- /.panel -->
                        </div>
                        <!-- /.col-lg-12 -->
                    </div>
            <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /#page-wrapper -->
    </div>
    <!-- /#wrapper -->
    <%@include file="/resources/includes/jsFiles.html" %>
      <script>
    $(document).ready(function() {
        $('#dataTable-livros').DataTable({
            responsive: true,
            "columns": [
                { "data": "ISBN" },
                { "data": "Titulo" },
                { "data": "Editora" },
                { "data": "Número de paginas" },
                { "data": "Area" },
                { "data": "Tema" }
            ]
        });
    });
    </script>
</body>
</html>
