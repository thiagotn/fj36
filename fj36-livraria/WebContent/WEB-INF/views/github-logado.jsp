<!doctype html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="${css}">
</head>

<body class="index">

	Codigo de autenticacao: ${authToken}
	
	<br>
	AccessToken (Authorization:Bearer): ${accessToken}
	<br><br>

	Cole no campo abaixo o AccessToken para testar o request autorizado<br />

	<form action="github-emails">
		<label for="token">AccessToken:</label>
		<input type="text" name="accessToken">
		<input type="submit" value="Enviar Request ao Github">
	</form>
	
	${responseBody}

</body>
</html>
