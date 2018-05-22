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
                            <h1 class="page-header">Cursos</h1>
                        </div>
                        <!-- /.col-lg-12 -->
                    </div>
                    <!-- /.row -->
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="panel panel-default">
                                <div class="panel-body">
                                    <table width="100%" class="table table-striped table-bordered table-hover" id="dataTable-cursos">
                                        <thead>
                                            <tr>
                                                <th>Nome do curso</th>
                                                <th>Codigo do curso</th>
                                                <th>Tipo do curso</th>
                                                <th>Area do curso</th> 
                                                <th></th>                                                                           
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="curso" items="${cursos}">
                                                <tr class="odd gradeX">
                                                    <td>${curso.nomeCurso}</td>
                                                    <td>${curso.codCurSo}</td>
                                                    <td>${curso.tipoCurso}</td>
                                                    <td>${curso.areaCurso}</td>    
                                                    <td>${curso.id}</td> 
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
		        $('#dataTable-cursos').DataTable({
		            responsive: true,
		            "columns": [
		                { "data": "Nome do curso" },
		                { "data": "Codigo do curso" },
		                { "data": "Tipo do curso" },
		                { "data": "Area do curso" },
		                { 
		                	"data": "id" ,
		                	render: function ( data, type, row ) {
		                    	data = '<a class="btn btn-danger btn" href="remove_aluno?id='+data+'">Remover</a>';
		                    	return data;
		                	}
						 }
		            ]
		        });
		    });
		    
		    
    </script>
</body>
</html>
