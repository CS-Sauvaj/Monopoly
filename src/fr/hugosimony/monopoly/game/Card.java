package fr.hugosimony.monopoly.game;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.hugosimony.monopoly.Game;

public class Card extends JPanel {
	private static final long serialVersionUID = 1L;
	
	//**************************************************************************
	// Card settings
	
	public int width;
	private int height;
	public String name;
	private int prize;
	private String special;

	//**************************************************************************
	// Components and settings
	
	private JLabel housesLabel;
	
	public Card(Game game, int place, Color color, String name, int prize, String special) {
		
		/*
		 * Create a card panel with the right color, prize and orientation.
		 * The card can be clicked to show its informations.
		 * Chance card, community case card or other specials cards are created to with the "special" parameters.
		 */
		
		//**************************************************************************
		// Initializing panel
		
		setLayout(null);
		setVisible(false);
		setOpaque(true);
		setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		if(place == 1 || place ==3) {
			width = game.height/13;
			height = game.height/6;
		}
		else {
			width = 2 * game.height/13 + 1;
			height = game.height/13;
		}
		setSize(width, height);
		setBackground(new Color(150,150,150));
		this.name = name;
		this.prize = prize;
		this.special = special;
		
		//**************************************************************************
		// Creating components
		
		//**********************
		// Classic street
		
		if(special.equals("no")) {
			
			//**********************
			// Houses Label
			
			housesLabel = new JLabel();
			housesLabel.setVisible(true);
			housesLabel.setOpaque(true);
			housesLabel.setIcon(null);
			housesLabel.setBackground(color);
			housesLabel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
			
			if(place == 1) {
				housesLabel.setLocation(0,4*height/5);
				housesLabel.setSize(width, height/5);
			}
			else if(place == 2) {
				housesLabel.setLocation(4*width/5,0);
				housesLabel.setSize(width/5, height);
			}
			else if(place == 3) {
				housesLabel.setLocation(0,0);
				housesLabel.setSize(width, height/5);
			}
			else if(place == 4) {
				housesLabel.setLocation(0,0);
				housesLabel.setSize(width/5, height);
			}
			
			//**************************************************************************
			// Adding components
			
			add(housesLabel);
		}
		
		//**********************
		// Free Park
		else if(special.equals("freepark")) {
			setBackground(Color.RED);
			setSize(width*2,height);
		}
		
		//**********************
		// Prison
		else if(special.equals("prison")) {
			setBackground(Color.BLUE);
			setSize(width*2,height);
		}
		
		//**********************
		// Visit prison
		else if(special.equals("visitprison")) {
			setBackground(Color.ORANGE);
			setSize(width*2,height);
		}
		
		//**********************
		// Start
		else if(special.equals("start")) {
			setBackground(Color.GREEN);
			setSize(width*2,height);
		}

		//**********************
		// Mouse Listener
		
		addMouseListener(new ClickListener());
		
		//**************************************************************************
	}
	
	
	
	private class ClickListener implements MouseListener {
		
		/*
		 * Display the card information on a click.
		 */
	
		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO
			System.out.println("test for now");
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// Do nothing
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// Do nothing
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// Do nothing
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// Do nothing
		}
	}
	
}
