package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListBand;
import model.Listener;
import model.ListenerDetails;

/**
 * Servlet implementation class EditListenerDetailsServlet
 */
@WebServlet("/editListenerDetailsServlet")
public class EditListenerDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditListenerDetailsServlet() {
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
		ListenerDetailsHelper ldh = new ListenerDetailsHelper();
		BandHelper bh = new BandHelper();
		ListenerHelper lh = new ListenerHelper();
		
		int tempId = Integer.parseInt(request.getParameter("id"));
		ListenerDetails listToUpdate = ldh.searchForListenerDetailsById(tempId);
		
		String newListName = request.getParameter("listName");
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		
		String listenerName = request.getParameter("listenerName");
		Listener newListener = lh.findListener(listenerName);
		
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex) {
			ld = LocalDate.now();
		}
		
		try {
			String[] selectedItems = request.getParameterValues("allItemsToAdd");
			List<ListBand> selectedItemsInList = new ArrayList<ListBand>();
			
			for(int i = 0; i < selectedItems.length; i++) {
				System.out.println(selectedItems[i]);
				ListBand c = bh.searchForBandById(Integer.parseInt(selectedItems[i]));
				selectedItemsInList.add(c);
			}
			listToUpdate.setListOfBands(selectedItemsInList);
		} catch (NullPointerException ex) {
			List<ListBand> selectedItemsInList = new ArrayList<ListBand>();
			listToUpdate.setListOfBands(selectedItemsInList);
		}
		
		listToUpdate.setListName(newListName);
		listToUpdate.setEnteredDate(ld);
		listToUpdate.setListener(newListener);
		
		ldh.updateList(listToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}

}
