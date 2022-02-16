package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListBand;

/**
 * Servlet implementation class AddBandServlet
 */
@WebServlet("/addBandServlet")
public class AddBandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBandServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String band = request.getParameter("band");
		String genre = request.getParameter("genre");
		String favSong = request.getParameter("favSong");
		
		ListBand lb = new ListBand(band, favSong, genre);
		BandHelper bh = new BandHelper();
		bh.insertBand(lb);
		
		getServletContext().getRequestDispatcher("/start.html").forward(request, response);
	}

}
