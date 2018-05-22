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
                    <h1 class="page-header">Cadastrar funcionário</h1>
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
                                	<form:form action="funcionario_save" modelAttribute="funcionarioForm" method="post">
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
										      	<label for="inputEmail">Email</label>
										      	<input type="text" class="form-control" id="inputEmail">
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
										  	<div class="form-group col-md-4">
										      	<label for="inputNomeDeUsuario">Nome de usuario</label>
										      	<input type="text" class="form-control" id="inputNomeDeUsuario">
										    </div>
										    
										    <div class="form-group col-md-4">
										      	<label for="inputTelefone">Telefone</label>
										      	<input type="text" class="form-control" id="inputTelefone">
										    </div>
										    
										     <div class="form-group col-md-4">
                                            <label>Nivel de Acesso</label>
                                            <div class="radio">
                                                <label>
                                                    <input type="radio" name="optionsRadios" id="optionsRadios1" value="Administrador" checked>Administrador
                                                </label>
                                            </div>
                                            <div class="radio">
                                                <label>
                                                    <input type="radio" name="optionsRadios" id="optionsRadios2" value="Comum">Comum
                                                </label>
                                            </div>
                                   		     </div>	
				
	                                      </div>						
										  	<button type="submit" class="btn btn-primary">Cadastrar</button>
										</form:form>
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
