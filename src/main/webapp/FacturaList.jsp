<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Factura's</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>
<center>
    <h4>Factura Management</h4>
    <h6>
        <a href="new">Nueva Factura</a>
        &nbsp;&nbsp;&nbsp;
        <a href="list">Listar Facturas</a>
    </h6>
</center>
<div align="center">
    <caption><h6>Lista de Facturas</h6></caption>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Fecha Emisión</th>
            <th>Fecha Vencimiento</th>
            <th>ID Cliente</th>
            <th>ID Tipo Factura</th>
            <th>ID Moneda</th>
        </tr>
        <c:forEach var="factura" items="${listFactura}">
            <tr>
                <td><c:out value="${factura.id}" /></td>
                <td><c:out value="${factura.fecha_emision}" /></td>
                <td><c:out value="${factura.fecha_vencimiento}" /></td>
                <td><c:out value="${factura.cliente_id}" /></td>
                <td><c:out value="${factura.factura_tipo_id}" /></td>
                <td><c:out value="${factura.moneda_id}" /></td>
                <td>
                    <a href="edit?id=<c:out value='${factura.id}' />">Editar</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="delete?id=<c:out value='${factura.id}' />">Eliminar</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>