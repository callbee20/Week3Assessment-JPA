import java.util.List;

import controller.ListenerHelper;
import model.Listener;

/**
 * @author Carson Allbee callbee
 *CIS175 - Fall 2021
 * Feb 21, 2022
 */
public class ListenerTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Listener carson = new Listener("Carson");
		ListenerHelper lh = new ListenerHelper();
		lh.insertListener(carson);
		
		List<Listener> allListeners = lh.showAllListeners();
		for(Listener a: allListeners) {
			System.out.println(a.toString());
		}
		
	}

}
