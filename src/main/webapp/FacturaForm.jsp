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
    <c:if test="${factura != null}">
    <form action="update" method="post">
        </c:if>
        <c:if test="${factura == null}">
        <form action="insert" method="post">
            </c:if>
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        <c:if test="${factura != null}">
                            Editar Factura
                        </c:if>
                        <c:if test="${factura == null}">
                            Nueva Factura
                        </c:if>
                    </h2>
                </caption>
                <c:if test="${factura != null}">
                    <input type="hidden" name="id" value="<c:out value='${factura.id}' />" />
                </c:if>
                <tr>
                    <th>Fecha Emisión: </th>
                    <td>
                        <input type="date" name="fecha_emision"
                               value="<c:out value='${factura.fecha_emision}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Fecha Vencimiento: </th>
                    <td>
                        <input type="date" name="fecha_vencimiento"
                               value="<c:out value='${factura.fecha_vencimiento}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>ID Cliente: </th>
                    <td>
                        <input type="number" name="cliente_id" size="5"
                               value="<c:out value='${factura.cliente_id}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>ID Tipo Factura: </th>
                    <td>
                        <input type="number" name="factura_tipo_id" size="5"
                               value="<c:out value='${factura.factura_tipo_id}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>ID Moneda: </th>
                    <td>
                        <input type="number" name="moneda_id" size="5"
                               value="<c:out value='${factura.moneda_id}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Guardar" />
                    </td>
                </tr>
            </table>
        </form>
</div>
</body>
</html>