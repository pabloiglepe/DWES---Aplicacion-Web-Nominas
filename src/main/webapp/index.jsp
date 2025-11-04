<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<%@ include file="header.jsp"%>

<body>

<h2> MENÚ CON OPCIONES </h2>

<ul>
    <li><a href="EmpleadoController?opcion=findAllEmpleados">Todos los empleados</a></li>
    <li><a href="EmpleadoController?opcion=mostrarSalario">Salario de un empleado</a></li>
    <li><a href="EmpleadoController?opcion=busquedaEmpleado">Modifica los datos de un empleado</a></li>
</ul>
</body>

</html>
