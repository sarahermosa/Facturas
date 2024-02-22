<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Factura's</title>
</head>
<body>
<center>
    <h1>Factura Management</h1>
    <h2>
        <a href="new">Nueva Factura</a>
        &nbsp;&nbsp;&nbsp;
        <a href="list">Listar Facturas</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>Lista de Facturas</h2></caption>
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