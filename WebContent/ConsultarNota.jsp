<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consultar Notas</title>
</head>  
<body>  
   <h3>Boletim Escolar</h3>     
    <h4>Passo 1: Escreva seu nome na caixa branca</h4>
    <h4>Passo 2: Escolha a serie </h4>
    <h4>Passo 3: Clique no botao Ok para ver as notas</h4>
       
   <form action="EnviaDadosBoletim?cmd=consultar" method="post">  
      <br />
      Nome do aluno: <input type="text" name="nome" />   
      <br /><br />
      Serie: <select name="serie">
		  		<option>1</option>
		  		<option>2</option>
		  		<option>3</option>
		  		<option>4</option>
		  		<option>5</option>
		  		<option>6</option>
		  		<option>7</option>
		  		<option>8</option>
			 </select> 
      <br /><br /> 
            
      <input type="submit" value="Ok" />
      <a href="index.jsp">Sair</a> 
      
   </form>  
   <br /><br />  
   ${msg }     
</body>  
</html>  
