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
            
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Cadastrar aluno</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6">
                                    <form role="form">										
                                        <div class="form-group">
                                            <label>CPF:</label>
                                            <input class="form-control" placeholder="Enter text">
                                        </div>									
                                        <div class="form-group">
                                            <label>RG:</label>
                                            <input class="form-control" placeholder="Enter text">
                                        </div>
                                        <div class="form-group">
                                            <label>Naturalidade:</label>
                                            <input class="form-control" placeholder="Enter text">
                                        </div>
                                        <div class="form-group">
                                            <label>Nome Comleto:</label>
                                            <input class="form-control" placeholder="Enter text">
                                        </div>						
                                        <div class="form-group">
                                            <label>Nome da Mãe:</label>
                                            <input class="form-control" placeholder="Enter text">
                                        </div>
                                        <div class="form-group">
                                            <label>Endereço:</label>
                                            <input class="form-control" placeholder="Enter text">
                                        </div>  
                                        <div class="form-group">
                                            <label>Telefone para contato:</label>
                                            <input class="form-control" placeholder="Enter text">
                                        </div>
										
                                        <div class="form-group">
                                            <label>Nivel de Escolaridade</label>
                                            <div class="radio">
                                                <label>
                                                    <input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked>Graduação
                                                </label>
                                            </div>
                                            <div class="radio">
                                                <label>
                                                    <input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">Pós-Graduação
                                                </label>
                                            </div>
                                        </div>	
                                        <div class="form-group">
                                            <label>Cursos de Graduação</label>
                                            <select class="form-control">
                                                <option>Administração</option>
                                                <option>Ciências da Computação</option>
                                                <option>Direito</option>
                                                <option>Engenaria Elétrica</option>
                                                <option>Engenharia Espacial</option>
												<option>Engenharia Mecatrônica</option>
												<option>Matemática</option>
												<option>Medicina</option>
												<option>Nutrição</option>
												<option>Odontologia</option>
												<option>Psicologia</option>
												<option>Veterinária</option>
                                            </select>
                                        </div>
										<div class="form-group">
                                            <label>Cursos de Pós-Graduação</label>
                                            <select class="form-control">
                                                <option>Ciências da Computação</option>
                                                <option>Engenaria Elétrica</option>
                                                <option>Engenharia Espacial</option>
												<option>Engenharia Mecatrônica</option>
												<option>Psicologia</option>
                                            </select>
                                        </div>										
										<div class="form-group">
                                            <label>Ano:</label>
                                            <input class="form-control" placeholder="Enter text">
                                        </div>
										
										<div class="form-group">
                                            <label>Período de ingesso:</label>
                                            <input class="form-control" placeholder="Enter text">
                                        </div>
										<div class="form-group">
                                            <label>Senha de Acesso:</label>
                                            <input class="form-control" placeholder="Enter text">
                                        </div> 								
                                        <button type="submit" class="btn btn-default">Submit Button</button>
                                        <button type="reset" class="btn btn-default">Reset Button</button>
                                    </form>
                                </div>                                
                            </div>
                            <!-- /.row (nested) -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->
    </div>
    <!-- /#wrapper -->
    <%@include file="/resources/includes/jsFiles.html" %>
</body>
</html>
