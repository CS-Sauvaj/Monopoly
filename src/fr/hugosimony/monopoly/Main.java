package fr.hugosimony.monopoly;

import fr.hugosimony.monopoly.utils.fonts.Fonts;

public class Main {
	
	/*
	 *  @author Hugo Simony-Jungo
	 */

	public static void main(String[] args) {
		
		/*
		 * Start the menu of the Monopoly (first function called)
		 */
	      
		// Load all the added fonts
		Fonts.loadFonts();
		
		// Start the game frame
		Game menu = new Game();
		menu.setVisible(true);
	}
	
}
