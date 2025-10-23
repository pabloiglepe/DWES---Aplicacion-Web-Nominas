<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="main-container">
    <div class="container">
        <div class="main-content">
            <h1>Estos son todos los empleados de la BBDD</h1>
            <table border="1px">
                <thead>
                <tr>
                    <th>DNI</th>
                    <th>NOMBRE</th>
                    <th>SEXO</th>
                    <th>CATEGORIA</th>
                    <th>AÑOS</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach var="item" items="${listaEmpleados}">

                    <tr>
                        <td><c:out value="${item.dni}"/></td>
                        <td><c:out value="${item.nombre}"/></td>
                        <td><c:out value="${item.sexo}"/></td>
                        <td><c:out value="${item.categoria}"/></td>
                        <td><c:out value="${item.anyos}"/></td>
                    </tr>

                </c:forEach>
                </tbody>

            </table>
        </div>
    </div>
</div>
