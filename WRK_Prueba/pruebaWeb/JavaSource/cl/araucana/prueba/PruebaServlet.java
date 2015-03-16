package cl.araucana.prueba;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.araucana.dao.PruebaDao;

/**
 * @version 	1.0
 * @author
 */
public class PruebaServlet extends HttpServlet implements Servlet {

	/**
	* @see javax.servlet.http.HttpServlet#void (javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	*/
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
			metodoPrueba(req,resp);
	}

	/**
	* @see javax.servlet.http.HttpServlet#void (javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	*/
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
			metodoPrueba(req,resp);
	}
	
	public void metodoPrueba(HttpServletRequest req, HttpServletResponse resp){
		
		String rut = req.getParameter("rut");
		String password = req.getParameter("password");
		
		req.setAttribute("rut",rut);
		req.setAttribute("password",password);
		
		PruebaDao dao = new PruebaDao();
		dao.Conectar();
		String pass = dao.getPassword(rut);
		dao.Desconectar();
		
		RequestDispatcher dispatcher = null;
		String destino = "/index2.jsp";
		if(!password.equals(pass)){
				destino ="/error.jsp";
		}
		
		try{
			dispatcher = req.getRequestDispatcher(destino);
			if (dispatcher != null)
					dispatcher.forward(req, resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
