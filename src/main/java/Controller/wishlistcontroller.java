package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.WishlistDao;
import Model.Wishlist;

/**
 * Servlet implementation class wishlistcontroller
 */
@WebServlet("/wishlistcontroller")
public class wishlistcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public wishlistcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("addtowishlist")) {
			Wishlist w = new Wishlist();
			w.setPid(Integer.parseInt(request.getParameter("pid")));
			w.setCusid(Integer.parseInt(request.getParameter("cusid")));
			WishlistDao.insertwishlist(w);
			response.sendRedirect("customer-home.jsp");
		}
	}

}
