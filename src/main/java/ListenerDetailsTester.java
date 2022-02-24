import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.ListenerDetailsHelper;
import controller.ListenerHelper;
import model.ListBand;
import model.Listener;
import model.ListenerDetails;

/**
 * @author Carson Allbee callbee
 *CIS175 - Fall 2021
 * Feb 21, 2022
 */
public class ListenerDetailsTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Listener carson = new Listener("Carson");
		ListenerHelper lh = new ListenerHelper();
		ListenerDetailsHelper ldh = new ListenerDetailsHelper();
		
		ListBand coheed = new ListBand("Coheed and Cambria", "Alt-Metal", "A Favor House Atlantic");
		ListBand dgd = new ListBand("Dance Gavin Dance", "Metal", "Strawberry's Wake");
		
		List<ListBand> carsonsBands = new ArrayList<ListBand>();
		carsonsBands.add(coheed);
		carsonsBands.add(dgd);
		
		ListenerDetails carsonList = new ListenerDetails("Carson's List", LocalDate.now(), carson);
		
		ldh.insertNewListenerDetails(carsonList);
		
		List<ListenerDetails> allListeners = ldh.getLists();
		
		for(ListenerDetails a : allListeners) {
			System.out.println(a.toString());
		}
		
	}

}
