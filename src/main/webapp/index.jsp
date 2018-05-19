<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Biblioteca Central - UFAB</title>

    <!-- Bootstrap Core CSS -->
    <link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="resources/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="resources/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="resources/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body style="background-image: url('resources/images/white-gradient-green-linear.jpg')">

    <div class="container">
        <div class="row">
            <h1 class="text-info mb-1" >Biblioteca Central</h1>
            <h3 class="mb-5">
                <em class="text-info">Universidade Federal Alto Bodocongo</em>
            </h3>
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title text-info">Entrar</h3>
                    </div>
                    <div class="panel-body">
                       <form role="form" action="home" method="post">
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" placeholder="cpf" name="cpf" type="text" autofocus>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Password" name="password" type="password" value="">
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input name="remember" type="checkbox" value="Remember Me">Lembre-se de mim
                                    </label>
                                </div>
                                <input type="submit" class="btn btn-lg btn-success btn-block" value = "Login">
                                <button type="button" class="btn btn-lg btn-primary btn-block">Registrar-se</button>
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- jQuery -->
    <script src="resources/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="resources/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="resources/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="resources/js/sb-admin-2.js"></script>

</body>

</html>
