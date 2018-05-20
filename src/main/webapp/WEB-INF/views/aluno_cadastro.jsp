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
                                <div class="col-lg-12">
                                	<form>
										  <div class="form-row">
										    <div class="form-group col-md-4">
										      <label for="inputNomeCompleto">Nome</label>
										      <input type="text" class="form-control" id="inputNomeCompleto" placeholder="Nome completo">
										    </div>
										    <div class="form-group col-md-4">
										      <label for="inputSenhaAcesso">Senha de Acesso</label>
										      <input type="password" class="form-control" id="inputSenhaAcesso" placeholder="Password">
										    </div>
										    <div class="form-group col-md-4">
										      <label for="inputNomeDaMae">Nome da mãe</label>
										      <input type="password" class="form-control" id="inputNomeDaMae" placeholder="Nome completo da mãe">
										    </div>
										  </div>
										  
										  <div class="form-group">
										    <label for="inputEndereço">Endereço</label>
										    <input type="text" class="form-control" id="inputEndereço" placeholder="Rua São Paulo, 055, liberdade, Campina Grande, PB">
										  </div>
				
										  <div class="form-row">
										    <div class="form-group col-md-4">
										      <label for="inputCPF">CPF</label>
										      <input type="text" class="form-control" id="inputCPF">
										    </div>
										    <div class="form-group col-md-4">
										       	<label for="inputRG">RG</label>
										    	<input type="text" class="form-control" id="inputRG">
										    </div>
										    <div class="form-group col-md-4">
										      <label for="inputNaturalidade">Naturalidade:</label>
										      <input type="text" class="form-control" id="inputNaturalidade" placeholder="Brasileiro">
										    </div>
										  </div>
										  
										  <div class="form-row">
										  	 <div class="form-group col-md-6">
                                            	<label>Cursos de Graduação</label>
                                            	<select class="form-control">
                                                	<option>Administração</option>
                                                	<option>Ciência da Computação</option>
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
											<div class="form-group col-md-6">
                                            	<label>Cursos de Pós-Graduação</label>
                                            	<select class="form-control">
                                            		<option>Nenhum</option>
                                                	<option>Ciência da Computação</option>
                                                	<option>Engenaria Elétrica</option>
                                                	<option>Engenharia Espacial</option>
													<option>Engenharia Mecatrônica</option>
													<option>Psicologia</option>
                                            	</select>
	                                         </div>
	                                      </div>						
										 
										  	<button type="submit" class="btn btn-primary">Cadastrar</button>
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
