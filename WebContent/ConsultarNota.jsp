<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Consultar Notas</title>
<link rel="stylesheet" href="css/site.css">
<!--link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"-->
</head>
<body>
	<div id="conteudo">
		<div id="caixa">
			<h2>Boletim Escolar</h2>

			<div class="form">
				<div class="p">
					<div class="info">Passo 1: Escreva seu nome na caixa branca</div>
					<div class="info">Passo 2: Escolha a serie</div>
					<div class="info">Passo 3: Clique no botao OK para ver as
						notas</div>
				</div>

				<form action="DadosBoletim?cmd=consultar" method="post">
					<div class="p">
						Nome do Aluno: <input type="text" name="nome" />
					</div>
					<div class="p">
						<table class="radio">
							<tr>
								<td>Série</td>
								<td><input type="radio" name="serie" value="1" />1ª</td>
								<td><input type="radio" name="serie" value="2" />2ª</td>
							</tr>
							<tr>
								<td></td>
								<td><input type="radio" name="serie" value="3" />3ª</td>
								<td><input type="radio" name="serie" value="4" />4ª</td>
							</tr>
							<tr>
								<td></td>
								<td><input type="radio" name="serie" value="5" />5ª</td>
								<td><input type="radio" name="serie" value="6" />6ª</td>
							</tr>
							<tr>
								<td></td>
								<td><input type="radio" name="serie" value="7" />7ª</td>
								<td><input type="radio" name="serie" value="8" />8ª</td>
							</tr>
						</table>
					</div>
					<div class="p">
						<div class="botoes">
							<input type="submit" value="OK" style="width: 80px;" /> <input
								type="button" value="Voltar" style="width: 80px;"
								onclick="javascript: history.back(); return true;" />
						</div>
					</div>
				</form>
			</div>
			<div class="p">
				<div class="info">${msg }</div>
			</div>
		</div>
	</div>
</body>
</html>
