<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="header.jsp" %>

<div class="container">
    <h2>BUSCA EMLEADOS POR CAMPO</h2>
    <form action="EmpleadoController?opcion=busquedaEmpleado" method="POST">

        <label for="dniBuscarEmpleado">DNI: </label>
        <input type="text" id="dniBuscarEmpleado" name="dniBuscarEmpleado" placeholder="12345678A">

        <label for="nombreBuscarEmpleado">Nombre: </label>
        <input type="text" id="nombreBuscarEmpleado" name="nombreBuscarEmpleado" placeholder="Pablo">

        <label for="categoriaBuscarEmpleado">Categoria: </label>
        <input type="number" id="categoriaBuscarEmpleado" name="categoriaBuscarEmpleado" placeholder="1-5">

        <label for="sexoBuscarEmpleado">Sexo: </label>
        <input type="text" id="sexoBuscarEmpleado" name="sexoBuscarEmpleado" placeholder="M/F">

        <label for="anyosBuscarEmpleado">Anyos: </label>
        <input type="number" id="anyosBuscarEmpleado" name="anyosBuscarEmpleado" placeholder="50">


        <button type="submit">Buscar Empleados</button>
    </form>

    <c:if test="${busquedaEmpleado != null}">
        <table class="tabla">
            <thead>
            <tr>
                <th>DNI</th>
                <th>Nombre</th>
                <th>Categoría</th>
                <th>Sexo</th>
                <th>Años trabajados</th>
            </tr>
            </thead>

            <tbody>
            <c:forEach var="item" items="${busquedaEmpleado}">
                <tr>
                    <td>${item.dni}</td>
                    <td>${item.nombre}</td>
                    <td>${item.categoria}</td>
                    <td>${item.sexo}</td>
                    <td>${item.anyos}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>




