package fr.hugosimony.monopoly.utils.fonts;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.net.URL;

import fr.hugosimony.monopoly.Main;

public class Fonts {

	//***********************************
	// Fonts
	
	public static final URL FONT_KABEL = Main.class.getResource("utils/fonts/kabel.ttf");
	
	public static void loadFonts() {
		try {
	        File fontFile = new File(FONT_KABEL.toURI());
	        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
	        GraphicsEnvironment ge = GraphicsEnvironment
	                .getLocalGraphicsEnvironment();
	        ge.registerFont(font);
	    } catch (Exception ex) {
	    	System.out.println("Error while loading a font.");
	    }
	}
	
}
