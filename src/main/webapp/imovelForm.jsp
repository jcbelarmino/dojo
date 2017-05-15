
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro de Imóveis</title>
</head>
<body>


	<form id="reg" action="imovel" method="POST">
		<h2>Cadastro de Imóvel</h2>
		<table>
			<tr>
				<td style="text-align: right;"><label for="latitude">Latitude:</label>
				</td>
				<td><input type="text" id=latitude name="latitude" value="" /></td>
			</tr>
			<tr>
				<td style="text-align: right;"><label for="longitude">Longitude:</label>
				</td>
				<td><input type="text" id=longitude name="longitude" value="" /></td>
			</tr>
			<tr>
				<td style="text-align: right;"><label for="preco">Valor$:</label></td>
				<td><input id="preco" name="preco" type="text" value="" /></td>
			</tr>
		</table>
		<p>
			<input id="grava" type="submit" value="Grava" />
		</p>
		<p>
			<label style="color: green; width: 100%; text-align: left;">${infoMessage}</label>
		</p>
		<p>
			<label style="color: red; width: 100%; text-align: left;">${errorMessage}</label>
		</p>
	</form>




</body>
</html>
