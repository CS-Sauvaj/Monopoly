package fr.hugosimony.monopoly.game;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.hugosimony.monopoly.Game;
import fr.hugosimony.monopoly.game.MonopolyProfile;

public class Monopoly extends JPanel {
	private static final long serialVersionUID = 1L;
	
	//**************************************************************************
	// Monopoly settings
	
	private int width;
	private int height;
	
	public int nbIA;
	public int difficultyIA;
	public ArrayList<MonopolyProfile> playerList;
	
	
	//**************************************************************************
	// Components and settings
	
	private JPanel plate;
	private Color BROWN = new Color(88,41,0);
	private Color PURPLE = new Color(128,0,128);
	
	public Monopoly(Game game) {
		
		/*
		 * Create the panel of the monopoly and the game itself.
		 * Contains the plate of the game and all the monopoly related components.
		 */
		
		//**************************************************************************
		// Initializing panel
		
		setLayout(null);
		setVisible(true);
		this.width = game.width;
		this.height = game.height;
		setSize(width, height);
		
		//**************************************************************************
		// Creating components

		//**********************
		// Plate label
		
		plate = new JPanel();
		plate.setLayout(null);
		plate.setSize(height, height);
		plate.setOpaque(true);
		plate.setLocation((game.width - height)/2, 0);
		plate.setBackground(new Color(200,200,200));
		plate.setVisible(true);
		
		//**********************
		// North Side
		
		for(int i = 0; i < 11; i++) {
			Card card;
			if(i == 0)
				card = new Card(game, 1, new Color(0, 0, 0), "freepark", 100, "freepark");
			else if(i == 1)
				card = new Card(game, 1, Color.RED, "matignon", 100, "no");
			else if(i == 2)
				card = new Card(game, 1, Color.BLUE, "chance", 100, "no");
			else if(i == 3)
				card = new Card(game, 1, Color.RED, "malesherbes", 100, "no");
			else if(i == 4)
				card = new Card(game, 1, Color.RED, "henrimartin", 100, "no");
			else if(i == 5)
				card = new Card(game, 1, Color.GRAY, "garedunord", 100, "no");
			else if(i == 6)
				card = new Card(game, 1, Color.YELLOW, "sainthonore", 100, "no");
			else if(i == 7)
				card = new Card(game, 1, Color.YELLOW, "labourse", 100, "no");
			else if(i == 8)
				card = new Card(game, 1, Color.WHITE, "cpnieau", 100, "no");
			else if(i == 9)
				card = new Card(game, 1, Color.YELLOW, "lafayette", 100, "no");
			else
				card = new Card(game, 1, new Color(0, 0, 0), "prison", 100, "prison");
			int x = i >= 1 ? game.height/13 : 0;
			card.setLocation(i*game.height/13 + x, 0);
			card.setVisible(true);
			plate.add(card);
		}
		
		//**********************
		// West Side
		
		for(int i = 1; i < 10; i++) {
			Card card;
			if(i == 1)
				card = new Card(game, 2, Color.ORANGE, "pigalle", 100, "no");
			else if(i == 2)
				card = new Card(game, 2, Color.ORANGE, "saintmichel", 100, "no");
			else if(i == 3)
				card = new Card(game, 2, Color.BLUE, "caisse", 100, "no");
			else if(i == 4)
				card = new Card(game, 2, Color.ORANGE, "mozart", 100, "no");
			else if(i == 5)
				card = new Card(game, 2, Color.GRAY, "garedelyon", 100, "no");
			else if(i == 6)
				card = new Card(game, 2, PURPLE, "paradis", 100, "no");
			else if(i == 7)
				card = new Card(game, 2, PURPLE, "neuilly", 100, "no");
			else if(i == 8)
				card = new Card(game, 2, Color.WHITE, "cpnielec", 100, "no");
			else
				card = new Card(game, 2, PURPLE, "lavillette", 100, "no");
			int x = i >= 1 ? - game.height/13 : 0;
			card.setLocation(0, game.height/6 + i*2*game.height/27 + x);
			card.setVisible(true);
			plate.add(card);
		}

		//**********************
		// South Side
		
		for(int i = 0; i < 11; i++) {
			Card card;
			if(i == 0) 
				card = new Card(game, 1, new Color(0, 0, 0), "hello", 100, "visitprison");
			else if(i == 1)
				card = new Card(game, 3, Color.CYAN, "republique", 100, "no");
			else if(i == 2)
				card = new Card(game, 3, Color.CYAN, "courcelles", 100, "no");
			else if(i == 3)
				card = new Card(game, 3, Color.BLUE, "chance", 100, "no");
			else if(i == 4)
				card = new Card(game, 3, Color.CYAN, "vaugirad", 100, "no");
			else if(i == 5)
				card = new Card(game, 3, Color.GRAY, "garemontparnasse", 100, "no");
			else if(i == 6)
				card = new Card(game, 3, Color.BLACK, "impots", 100, "no");
			else if(i == 7)
				card = new Card(game, 3, BROWN, "lecourbe", 100, "no");
			else if(i == 8)
				card = new Card(game, 3, Color.BLUE, "caisse", 100, "no");
			else if(i == 9)
				card = new Card(game, 3, BROWN, "belleville", 100, "no");
			else {
				card = new Card(game, 1, new Color(0, 0, 0), "hello", 100, "start");
			}
			int x = i >= 1 ? game.height/13 : 0;
			card.setLocation(i*game.height/13 + x, 5*game.height/6);
			
			card.setVisible(true);
			plate.add(card);
		}
		
		//**********************
		// East Side
		
		for(int i = 1; i < 10; i++) {
			Card card;
			if(i == 1)
				card = new Card(game, 4, Color.GREEN, "breteuil", 100, "no");
			else if(i == 2)
				card = new Card(game, 4, Color.GREEN, "foch", 100, "no");
			else if(i == 3)
				card = new Card(game, 4, Color.BLUE, "caisse", 100, "no");
			else if(i == 4)
				card = new Card(game, 4, Color.GREEN, "capucines", 100, "no");
			else if(i == 5)
				card = new Card(game, 4, Color.GRAY, "garesaintlazare", 100, "no");
			else if(i == 6)
				card = new Card(game, 4, Color.BLUE, "chance", 100, "no");
			else if(i == 7)
				card = new Card(game, 4, Color.BLUE, "champselysees", 100, "no");
			else if(i == 8)
				card = new Card(game, 4, Color.BLACK, "tax", 100, "no");
			else
				card = new Card(game, 4, Color.BLUE, "paix", 100, "no");
			int x = i >= 1 ? game.height/13 : 0;
			card.setLocation(height - 2*game.height/13 - 2, i*game.height/13 + x);
			card.setVisible(true);
			plate.add(card);
		}
		
		//**************************************************************************
		// Adding components
		
		add(plate);
		
		//**************************************************************************
	}
}
