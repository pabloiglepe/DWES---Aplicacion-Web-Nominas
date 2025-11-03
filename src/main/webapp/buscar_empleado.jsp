<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="header.jsp" %>
<html>


<form action="#" method="POST">
    <input type="hidden" name="accion" value="buscar">

    <label for="dniBuscarEmpleado">Indica el DNI del empleado: </label>
    <input type="text" id="dniBuscarEmpleado" name="dniBuscarEmpleado"><br>

    <label for="BuscarEmpleado">Indica el nombre:</label>
    <input type="text" id="BuscarEmpleado" name="BuscarEmpleado"><br>

    <button type="submit">Buscar Empleados</button>
</form>
