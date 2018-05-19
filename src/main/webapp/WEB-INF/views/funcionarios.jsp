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
                            <h1 class="page-header">Funcionarios</h1>
                        </div>
                        <!-- /.col-lg-12 -->
                    </div>
                    <!-- /.row -->
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="panel panel-default">
                                <div class="panel-body">
                                    <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-Funcionarios">
                                        <thead>
                                            <tr>
                                                <th>Nome</th>
                                                <th>CPF</th>
                                                <th>RG</th>
                                                <th>Naturalidade</th>                                                    
                                                <th>Endereco</th>
                                                <th>Telefone</th>
                                                <th>Email</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="funcionario" items="${funcionarios}">
                                                <tr class="odd gradeX">
                                                    <td>${funcionario.nome}</td>
                                                    <td>${funcionario.cpf}</td>
                                                    <td>${funcionario.rg}</td>
                                                    <td>${funcionario.naturalidade}</td>
                                                    <td>${funcionario.endereco}</td>
                                                    <td>${funcionario.telefone}</td>
                                                    <td>${funcionario.email}</td>
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
        $('#dataTables-funcionarios').DataTable({
            responsive: true,
            "columns": [
                { "data": "Nome" },
                { "data": "CPF" },
                { "data": "RG" },
                { "data": "Naturalidade" },
                { "data": "Endereco" },
                { "data": "Telefone" },
                { "data": "Email" }
            ]
        });
    });
    </script>
</body>
</html>
