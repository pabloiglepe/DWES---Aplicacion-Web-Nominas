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

                default:
                    request.setAttribute("error", "Opción de controlador no reconocida: " + opcion);
                    rd = request.getRequestDispatcher("error.jsp");
                    rd.forward(request, response);
                    break;q
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
}
