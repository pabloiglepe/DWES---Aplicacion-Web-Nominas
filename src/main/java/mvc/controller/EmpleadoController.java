package mvc.controller;


import mvc.excepciones.RepositoryException;
import mvc.model.entity.Empleado;
import mvc.model.service.EmpleadoService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/*
* -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
* FRONTCONTROLLER:
* Proporciona un único punto de entrada que maneja las peticiones para todas las solicitudes que llegan a la aplicación.
* Centraliza la lógica de control y el flujo de las peticiones y permite gestionar de forma unificada las tareas.
* -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
* */


@WebServlet("/EmpleadoController")
public class EmpleadoController extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public EmpleadoController() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String opcion = request.getParameter("opcion");
        RequestDispatcher rd = null;

        if (opcion == null || opcion.isEmpty()) {
            request.setAttribute("error", "Opcion invalida");
            rd = request.getRequestDispatcher("error.jsp");
            rd.forward(request, response);
        } else {
            switch (opcion) {
                case "findAllEmpleados":
                    findAllEmpleados(request, response);
                    break;

                case "mostrarSalario":
                    mostrarSalarioPorDni(request, response);
                    break;

                case "busquedaEmpleado":
                    buscarEmpleadosParaModificar(request, response);
                    break;

                default:
                    request.setAttribute("error", "Opción de controlador no reconocida: " + opcion);
                    rd = request.getRequestDispatcher("error.jsp");
                    rd.forward(request, response);
                    break;
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    private void findAllEmpleados(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Empleado> empleados;
        try {
            empleados = EmpleadoService.findAll();
            request.setAttribute("listaEmpleados", empleados);
            RequestDispatcher rd = request.getRequestDispatcher("find-all-empleados.jsp");
            rd.forward(request, response);
        } catch (RepositoryException e) {
            e.printStackTrace();
            request.setAttribute("error", "Se produjo un error al acceder al repositorio de datos");
            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
            rd.forward(request, response);
        }
    }

    private void mostrarSalarioPorDni(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Double sueldo;
        try {
            String dni = request.getParameter("dniEmpleado");
            sueldo = EmpleadoService.mostrarSalarioPorDni(dni);

            if (sueldo != null) {
                request.setAttribute("salario", sueldo);
                RequestDispatcher rd = request.getRequestDispatcher("mostrar-salario.jsp");
                rd.forward(request, response);
            }

        } catch (RepositoryException e) {
            e.printStackTrace();
            request.setAttribute("error", "Se produjo un error al acceder al repositorio de datos");
            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
            rd.forward(request, response);
        }
    }

    private void buscarEmpleadosParaModificar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Empleado> listaEmpleados;
        try {
            String dni = request.getParameter("dniBuscarEmpleado");
            String nombre = request.getParameter("nombreBuscarEmpleado");

            String categoria = request.getParameter("categoriaBuscarEmpleado");
            Integer catgInteger = null;

            String sexo = request.getParameter("sexoBuscarEmpleado");
            Character sexoChar = null;

            String anyos = request.getParameter("anyosBuscarEmpleado");
            Integer anyosInteger = null;

            if (categoria != null && !categoria.trim().isEmpty()) {
                catgInteger = Integer.valueOf(categoria);
            }

            if (anyos != null && !anyos.trim().isEmpty()) {
                anyosInteger = Integer.valueOf(anyos);
            }

            if (sexo != null && !sexo.trim().isEmpty()) {
                sexoChar = sexo.toCharArray()[0];
            }

            listaEmpleados = EmpleadoService.buscarEmpleadosParaModificar(dni, nombre, catgInteger, sexoChar, anyosInteger);

            request.setAttribute("busquedaEmpleado", listaEmpleados);
            RequestDispatcher rd = request.getRequestDispatcher("buscar_empleado.jsp");
            rd.forward(request, response);

        } catch (RepositoryException e) {
            e.printStackTrace();
            request.setAttribute("error", "Se produjo un error al acceder al repositorio de datos");
            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
            rd.forward(request, response);
        }

    }
}
