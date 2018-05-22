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
                    <h1 class="page-header">Cadastrar Curso</h1>
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
                                	<form:form action="curso_save" modelAttribute="cursoForm" method="post">
											  <div class="form-row">
												    <div class="form-group col-md-6">
												      <label for="inputNome">Nome</label>
												      <form:input path="nomeCurso" type="text" class="form-control" id="inputNome" placeholder="Nome do curso"/>
												    </div>
												    <div class="form-group col-md-6">
												      <label for="inputCodCurso">CodCurso</label>
												      <form:input path="codCurSo" type="text" class="form-control" id="inputCodCurso" placeholder="CC"/>
												    </div>
											    </div>
											    
											     <div class="form-row">
												    <div class="form-group col-md-6">
			                                            <label>Tipo do curso</label>
			                                            <div class="radio">
			                                                <label>
			                                                    <form:radiobutton  path="tipoCurso"  name="optionsRadios" id="optionsRadios1" value="GRA" />GRA
			                                                </label>
			                                            </div>
			                                            <div class="radio">
			                                                <label>
			                                                    <form:radiobutton path="tipoCurso"  name="optionsRadios" id="optionsRadios2" value="POS"/>POS
			                                                </label>
			                                            </div>
		                                   		     </div>	
		                                   		     
		                                   		      	<div class="form-group col-md-6">
													      <label for="inputAreaCurso">Area do curso</label>
													      <form:input path="areaCurso" type="text" class="form-control" id="inputAreaCurso" placeholder="Exatas"/>
												    	</div>
											 		</div>
										   		<div class="form-row">
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
