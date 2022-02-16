

import java.util.List;
import java.util.Scanner;

import controller.BandHelper;
import model.ListBand;

public class StartProgram {

		static Scanner in = new Scanner(System.in);
		static BandHelper bh = new BandHelper();

		//This method allows a user to enter a band into the database by entering the name, song, and genre
		private static void addAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Enter a band name: ");
			String bandName = in.nextLine();
			System.out.print("Enter band genre: ");
			String genre = in.nextLine();
			System.out.print("Enter your favorite song by them: ");
			String favSong = in.nextLine();
			ListBand toAdd = new ListBand(bandName, genre, favSong);
			bh.insertBand(toAdd);

		}
		
		//This method allows a user to delete a band from a database by entering the name, genre, and song
		private static void deleteAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Enter the band to delete: ");
			String bandName = in.nextLine();
			System.out.print("Enter the genre to delete: ");
			String genre = in.nextLine();
			System.out.print("Enter a song to delete: ");
			String favSong = in.nextLine();
			ListBand toDelete = new ListBand(bandName, genre, favSong);
			bh.deleteBand(toDelete);

		}

		private static void editAnItem() {
			// TODO Auto-generated method stub
			//This method allows a user to edit an existing band by searching for band name or genre, select if the want to edit the name or genre and then updating the new selection
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by Band");
			System.out.println("2 : Search by Genre");
			int searchBy = in.nextInt();
			in.nextLine();
			List<ListBand> foundItems;
			if (searchBy == 1) {
				System.out.print("Enter the band name: ");
				String bandName = in.nextLine();
				foundItems = bh.searchForBandByName(bandName);
				
			} else {
				System.out.print("Enter the genre: ");
				String genre = in.nextLine();
				foundItems = bh.searchForBandByGenre(genre);

			}

			if (!foundItems.isEmpty()) {
				System.out.println("Found Results.");
				for (ListBand l : foundItems) {
					System.out.println(l.getId() + " : " + l.toString());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				ListBand toEdit = bh.searchForBandById(idToEdit);
				System.out.println("Retrieved " + toEdit.getBandName() + " from " + toEdit.getGenre());
				System.out.println("1 : Update Band Name: ");
				System.out.println("2 : Update Genre: ");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New band name: ");
					String newBandName = in.nextLine();
					toEdit.setBandName(newBandName);
				} else if (update == 2) {
					System.out.print("New genre: ");
					String newGenre = in.nextLine();
					toEdit.setGenre(newGenre);
				}

				bh.updateBand(toEdit);

			} else {
				System.out.println("---- No results found");
			}

		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			//This method allows the viewing of the runMenu method
			runMenu();

		}
		
		//This method is run when the program is activated and acts as the view for the whole program
		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Welcome to our awesome shopping list! ---");
			while (goAgain) {
				System.out.println("*  Select an item:");
				System.out.println("*  1 -- Add an item");
				System.out.println("*  2 -- Edit an item");
				System.out.println("*  3 -- Delete an item");
				System.out.println("*  4 -- View the list");
				System.out.println("*  5 -- Exit the awesome program");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addAnItem();
				} else if (selection == 2) {
					editAnItem();
				} else if (selection == 3) {
					deleteAnItem();
				} else if (selection == 4) {
					viewTheList();
				} else {
					bh.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}

			}

		}

		//This method allows the user to see all of the bands entered into the database
		private static void viewTheList() {
			// TODO Auto-generated method stub
			List<ListBand> allBands = bh.showAllBands();
			for(ListBand singleBand: allBands) {
				System.out.println(singleBand.bandDetails());
			}

		}

	}
