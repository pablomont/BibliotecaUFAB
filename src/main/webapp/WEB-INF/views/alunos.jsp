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
                            <h1 class="page-header">Alunos</h1>
                        </div>
                        <!-- /.col-lg-12 -->
                    </div>
                    <!-- /.row -->
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="panel panel-default">
                                <div class="panel-body">
                                    <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-alunos">
                                        <thead>
                                            <tr>
                                                <th>Nome</th>
                                                <th>CPF</th>
                                                <th>RG</th>
                                                <th>Naturalidade</th>                                                    
                                                <th>Enderešo</th>
                                                <th>MatrÝcula</th>
                                                <th>Curso</th>
                                                <th></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="aluno" items="${alunos}">
                                                <tr class="odd gradeX">
                                                    <td>${aluno.nome}</td>
                                                    <td>${aluno.cpf}</td>
                                                    <td>${aluno.rg}</td>
                                                    <td>${aluno.naturalidade}</td>
                                                    <td>${aluno.endereco}</td>
                                                    <td>${aluno.matricula}</td>
                                                    <td>${aluno.curso}</td>
                                                    <td>${aluno.id}</td>
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
		        $('#dataTables-alunos').DataTable({
		            responsive: true,
		            "columns": [
		                { "data": "Nome" },
		                { "data": "CPF" },
		                { "data": "RG" },
		                { "data": "Naturalidade" },
		                { "data": "Enderešo" },
		                { "data": "Matricula" },
		                { "data": "Curso" },
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
