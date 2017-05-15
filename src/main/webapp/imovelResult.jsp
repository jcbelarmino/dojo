
<%@ page language="java" contentType="text/html; charset=UTF-8"     pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Imóveis</title>
</head>
<body>

<h4>Imóveis</h4>
<table class="simpletablestyle">
<thead>
<tr>
<th>Latitude</th>
<th>Longitude</th>
<th>Valor</th>
</tr>
</thead>
<tbody>
<c:forEach items="${imoveis}" var="imovel">
	<tr>
		<td><c:out value="${imovel.lat}"/></td>
		<td><c:out value="${imovel.longi}"/></td>
		<td><c:out value="${imovel.valor}"/></td>
	</tr>
</c:forEach>
</tbody>
</table>	

</body>
</html>
