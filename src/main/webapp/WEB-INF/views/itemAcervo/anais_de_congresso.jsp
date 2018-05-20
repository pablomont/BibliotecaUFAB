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
                            <h1 class="page-header">Anais de congresso</h1>
                        </div>
                        <!-- /.col-lg-12 -->
                    </div>
                    <!-- /.row -->
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="panel panel-default">
                                <div class="panel-body">
                                    <table width="100%" class="table table-striped table-bordered table-hover" id="dataTable-anais_de_congresso">
                                        <thead>
                                            <tr>
												<th>Tipo</th>
												<th>Titulo</th>
												<th>Local</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="analDeCongresso" items="${anais_de_congresso}">
                                                <tr class="odd gradeX">
                                                    <td>${analDeCongresso.tipo}</td>
													<td>${analDeCongresso.titulo }</td>
                                                    <td>${analDeCongresso.local}</td>
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
        $('#dataTable-anais_de_congresso').DataTable({
            responsive: true,
            "columns": [
                { "data": "Tipo" },
                { "data": "Titulo" },
                { "data": "Local" },
            ]
        });
    });
    </script>
</body>
</html>
