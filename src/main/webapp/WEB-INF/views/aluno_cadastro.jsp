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
                                	<form:form action="aluno_save" modelAttribute="alunoForm" method="post">
										  <div class="form-row">
										    <div class="form-group col-md-4">
										      <label for="inputNomeCompleto">Nome</label>
										      <form:input path="nome" type="text" class="form-control" id="inputNomeCompleto" placeholder="Nome completo"/>
										    </div>
										    <div class="form-group col-md-4">
										      <label for="inputSenhaAcesso">Senha de Acesso</label>
										      <form:input path="senhaAcesso" type="password" class="form-control" id="inputSenhaAcesso" placeholder="Password"/>
										    </div>
										    <div class="form-group col-md-4">
										      <label for="inputNomeDaMae">Nome da m�e</label>
										      <form:input path="nomeDaMae" type="text" class="form-control" id="inputNomeDaMae" placeholder="Nome completo da m�e"/>
										    </div>
										  </div>
										  
										  <div class="form-group">
										    <label for="inputEndere�o">Endere�o</label>
										    <form:input path="endereco" type="text" class="form-control" id="inputEndere�o" placeholder="Rua S�o Paulo, 055, liberdade, Campina Grande, PB"/>
										  </div>
				
										  <div class="form-row">
										    <div class="form-group col-md-3">
										      <label for="inputCPF">CPF</label>
										      <form:input path="cpf" type="text" class="form-control" id="inputCPF"/>
										    </div>
										    <div class="form-group col-md-3">
										       	<label for="inputRG">RG</label>
										    	<form:input path="rg" type="text" class="form-control"  id="inputRG"/>
										    </div>
										    <div class="form-group col-md-3">
										      <label for="inputNaturalidade">Naturalidade:</label>
										      <form:input path="naturalidade" type="text" class="form-control" id="inputNaturalidade" placeholder="Brasileiro"/>
										    </div>
										    
										    <div class="form-group col-md-3">
	                                            <label>Per�odo de ingresso</label>
	                                            <div class="radio">                              
	                                                <label>
	                                                   <form:radiobutton  path="periodoIngresso"  name="optionsRadios" id="optionsRadios1" value="S1"/>1� Per�odo
	                                                </label>
	                                            </div>
	                                            <div class="radio">
	                                                <label>
	                                                    <form:radiobutton path="periodoIngresso" name="optionsRadios" id="optionsRadios2" value="S2"/>2� Per�odo
	                                                </label>
	                                            </div>
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
