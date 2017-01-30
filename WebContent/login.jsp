<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Login</title>

<!-- Bootstrap resources -->
<link rel="stylesheet" href="./resources/css/bootstrap.min.css" />
<script type="text/javascript" src="./resources/js/bootstrap.min.js"></script>

<!-- Raleway - Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Raleway:300,400,400i"
	rel="stylesheet">

<!-- Main CSS -->
<link rel="stylesheet" href="./resources/css/main.css" />

</head>

<body>

	<div class="login-page">
		<div class="form">

			<form class="login-form" action="login" method="post">
				<input type="text" placeholder="Usuário" name="usuario" /> <input
					type="password" placeholder="password" name="senha" />
				<button>login</button>

			</form>

			${mensagem }

		</div>
	</div>

</body>
</html>