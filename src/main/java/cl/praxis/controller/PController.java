package cl.praxis.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.praxis.model.dto.ProvDTO;
import cl.praxis.model.dao.ProveedoresDAO;
import cl.praxis.model.dao.ProveedoresDAOImpl;

@WebServlet("/proveedor")
public class PController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public PController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//ver detalle de un proveedor
		String strId = request.getParameter("id");
		
		int id = 0;
		
		if (strId != null) {
			id = Integer.parseInt(strId);
		}
		
		if (id > 0) {
			ProveedoresDAO pDAO = new ProveedoresDAOImpl();
			ProvDTO p = pDAO.read(id);
			
			request.setAttribute("proveedor", p);
			
			getServletContext().getRequestDispatcher("/proveedor.jsp").forward(request, response);
		}else {
			response.sendRedirect("error.html");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// editar un proveedor
		doGet(request, response);
	}

}