package cl.praxis.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.praxis.model.dao.ProveedoresDAO;
import cl.praxis.model.dao.ProveedoresDAOImpl;
import cl.praxis.model.dto.ProvDTO;


@WebServlet("/proveedores")
public class ProveedoresController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ProveedoresController() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProveedoresDAO pDAO = new ProveedoresDAOImpl();
		
		List<ProvDTO> proveedores = pDAO.read();
		
		
		request.setAttribute("proveedores", proveedores);
		
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//crear nuevo proveedor
		ProveedoresDAO pDAO = new ProveedoresDAOImpl();
		pDAO.create(new ProvDTO(0, request.getParameter("nombre"),request.getParameter("rut"),
				request.getParameter("direccion"),request.getParameter("correo"),
				request.getParameter("telefono"),request.getParameter("contacto"),
				request.getParameter("telcon")));
		doGet(request, response);
	}

}