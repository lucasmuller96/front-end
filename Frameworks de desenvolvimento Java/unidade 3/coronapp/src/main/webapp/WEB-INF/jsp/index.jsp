<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CoronApp - Teste Seus Sintomas</title>
</head>
<body>
	<h2>Teste seus Sintomas - CoronApp</h2>
	<strong>Informe seu CPF para iniciar o teste:</strong>
	<br/> <br/>
	<form name="frmcpf" action="/buscar" method="post">
		<label for="cpf">CPF:</label>
		<input name="cpf" id="cpf" placeholder="CPF sem pontuação" type="number">
		<br/><br/>
		<button>Iniciar Teste</button>
	</form>
	<br/> <br/><br/>
		<h2>---------------------------------------------------------------------</h2>
	<strong>Informe seu nome:</strong>
	<br/> <br/>
	<form name="nome" action="/nome" method="post">
		<label for="nome">Nome:</label>
		<input name="nome" id="nome" placeholder="Nome" type="text">
		<br/><br/>
		<button>Ir</button>
	</form>
</body>
</html>