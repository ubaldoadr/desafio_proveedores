package cl.praxis.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.praxis.model.dao.ProveedoresDAO;
import cl.praxis.model.dao.ProveedoresDAOImpl;

@WebServlet("/delete")
public class PDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public PDeleteController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String strId = request.getParameter("id");
		
		int id = 0;
		
		if (strId != null) {
			id = Integer.parseInt(strId);
		}
		
		if (id > 0) {
			ProveedoresDAO pDAO = new ProveedoresDAOImpl();
			String res =  pDAO.delete(id);
			getServletContext().getRequestDispatcher("/proveedores").forward(request, response);
		}else {
			response.sendRedirect("error.html");
		}
	}

}