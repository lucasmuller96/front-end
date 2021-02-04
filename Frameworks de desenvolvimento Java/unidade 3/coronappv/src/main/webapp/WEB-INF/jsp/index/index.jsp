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
	<form name="frmcpf" action="/paciente/buscar" method="post">
		<label for="cpf">CPF:</label>
		<input name="cpf" id="cpf" placeholder="CPF sem pontuação" type="number">
		<br/><br/>
		<button>Iniciar Teste</button>
	</form>
	<br/><br/><br/>
	<h2>-----------------------------------------------</h2>
	<strong>Informe seu nome para aparecer na próxima tela:</strong>
	<br/> <br/>
	<form name="nome" action="/paciente/nome" method="post">
		<label for="nome">Nome:</label>
		<input name="nome" id="nome" placeholder="Insira o nome" type="text">
		<br/><br/>
		<button>Iniciar Teste</button>
	</form>
</body>
</html>