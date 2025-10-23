<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="main-container">
    <div class="container">
        <div class="main-content">
            <h1>Búsqueda del cliente para mostrar su salario</h1>
            <form action="EmpleadoController?opcion=mostrarSalario" method="POST">
                <div>
                    <label for="dniEmpleado">Indica el dni del empleado:</label>
                    <input type="text" id="dniEmpleado" name="dniEmpleado" required/>
                </div>
                <input type="submit" value="Buscar"/>
            </form>

            <c:if test="${salario != 0.0}">
                <div>
                    El salario es de <c:out value="${salario}"/> euros
                </div>
            </c:if>

        </div>
    </div>
</div>

