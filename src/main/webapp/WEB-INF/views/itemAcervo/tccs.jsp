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
                            <h1 class="page-header">TCCs</h1>
                        </div>
                        <!-- /.col-lg-12 -->
                    </div>
                    <!-- /.row -->
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="panel panel-default">
                                <div class="panel-body">
                                    <table width="100%" class="table table-striped table-bordered table-hover" id="dataTable-tccs">
                                        <thead>
                                         	 <tr>
												<th>Titulo</th>
												<th>Tipo </th>
                                                <th>Ano de Defesa</th>
												<th>Local </th>                                                
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="tcc" items="${tccs}">
                                                  <tr class="odd gradeX"> 
													<td>${tcc.titulo}</td>
													<td>${tcc.tipo}</td>
													<td>${tcc.date}</td>
													<td>${tcc.local}</td>
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
        $('#dataTable-tccs').DataTable({
            responsive: true,
            "columns": [
                { "data": "Titulo" },
                { "data": "Tipo" },
                { "data": "Ano de Defesa" },
                { "data": "Local" }
            ]
        });
    });
    </script>
</body>
</html>
