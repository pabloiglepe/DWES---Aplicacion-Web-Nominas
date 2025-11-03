<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="header.jsp" %>

<table>
    <thead>
    <tr>
        <th>DNI</th>
        <th>Nombre</th>
        <th>Categoría</th>
        <th>Años Trabajados</th>
        <th>Sueldo Calculado</th>
        <th>Acción</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="#" items="${empleados}">
        <tr>
            <td>${empleado.dni}</td>
            <td>${empleado.nombre}</td>
            <td>${empleado.categoria}</td>
            <td>${empleado.anosTrabajados}</td>
            <td>${empleado.sueldo}</td>
            <td>
                <a href="#">Modificar</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
