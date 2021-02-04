<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CoronApp</title>
<style type="text/css">
body {
	font-family: Arial, Helvetica, sans-serif;
	margin: 0;
}

html {
	box-sizing: border-box;
}

*, *:before, *:after {
	box-sizing: inherit;
}

.resultado {
	padding: 50px;
	text-align: center;
	background-color: #474e5d;
	color: white;
}


progress {
  background: #ccc;
  -webkit-appearance: none;
}

::-webkit-progress-value {
  max-value: 50;
  background-color: red;
}

::-webkit-progress-bar {
  background-color: green;
}

::-webkit-progress-bar {
  background-color: green;
}

::-moz-progress-bar {
  background-color: green;
}

::-ms-fill {
  background-color: green;
}



</style>
</head>
<body>
	<div class="resultado">
		<h1>Sr.: ${paciente.nome}</h1>
		<h2>Seu resultado é:</h2>
		
<h2>${paciente.resultado}%</h2>
<progress value="${paciente.resultado}" max="100"></progress>

	</div>
	<div style="margin: auto; padding: 10px; text-align: center;"><button onclick="location.href='/'" type="button">
         Novo Teste</button></div>
</body>
</html>