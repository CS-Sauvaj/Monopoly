package fr.hugosimony.monopoly.menus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.hugosimony.monopoly.Const;
import fr.hugosimony.monopoly.Game;
import fr.hugosimony.monopoly.Variables;
import fr.hugosimony.monopoly.utils.Utils;

public class Menu extends JPanel {
	private static final long serialVersionUID = 1L;

	//**************************************************************************
	// Menu settings
	
	private int width;
	private int height;
	
	//**************************************************************************
	// Components and settings
	
	private JLabel screen;
	private JButton newGameButton;
	private JButton loadButton;
	private JButton exitButton;
	private boolean multi;
	private JButton soloButton;
	private JButton multiButton;
	private JButton backButton;
	
	public Menu(Game game) {
		
		/*
		 * Create the panel of the menu.
		 * This panel has 2 menus :
		 *  - Main menu : 3 buttons (New Game, Load, Exit)
		 *  - Game menu : 3 buttons (Solo, Multi, Back)
		 */
		
		//**************************************************************************
		// Initializing panel
		
		setLayout(null);
		setVisible(true);
		width = game.width;
		height = game.height;
		setSize(width, height);
		
		//**************************************************************************
		// Creating components
		
		//**********************
		// Background image
		
		screen = new JLabel();
		screen.setSize(width, height);
		screen.setLocation(0,0);
		screen.setIcon(Utils.resizeImage(Const.MAIN_SCREEN, width, height));
		
		int buttonWidth = (int) ((float) (300 * Variables.SIZE_MultiplicatorWidth));
		int buttonHeight = (int) ((float) (150 * Variables.SIZE_MultiplicatorHeight));
		
		//**********************
		// Action Listener
		
		ActionListener gameMenu = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				soloButton.setVisible(true);
				multiButton.setVisible(true);
				backButton.setVisible(true);
				newGameButton.setVisible(false);
				loadButton.setVisible(false);
				exitButton.setVisible(false);
			}
		};
		
		//**********************
		// New Game Button
		
		newGameButton = new JButton();
		newGameButton.setVisible(true);
		newGameButton.setLocation(width/3 - (int) (200 * Variables.SIZE_MultiplicatorWidth), height/4 * 3);
		newGameButton.setSize(buttonWidth, buttonHeight);
		newGameButton.setIcon(Utils.resizeImage(Const.BUTTON_NEW_GAME, buttonWidth, buttonHeight));
		newGameButton.addActionListener(gameMenu);
		// Adding here to prevent next buttons to be invisible
		add(newGameButton);
		
		//**********************
		// Load Button
		
		loadButton = new JButton();
		loadButton.setVisible(true);
		loadButton.setLocation(width/2 - (int) (150 * Variables.SIZE_MultiplicatorWidth), height/4 * 3);
		loadButton.setSize(buttonWidth, buttonHeight);
		loadButton.setIcon(Utils.resizeImage(Const.BUTTON_LOAD, buttonWidth, buttonHeight));
		loadButton.addActionListener(gameMenu);
		// Adding here to prevent next buttons to be invisible
		add(loadButton);
		
		//**********************
		// Exit Button
		
		exitButton = new JButton();
		exitButton.setVisible(true);
		exitButton.setLocation(width/3 * 2 - (int) (100 * Variables.SIZE_MultiplicatorWidth), height/4 * 3);
		exitButton.setSize(buttonWidth, buttonHeight);
		exitButton.setIcon(Utils.resizeImage(Const.BUTTON_EXIT, buttonWidth, buttonHeight));
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		// Adding here to prevent next buttons to be invisible
		add(exitButton);

		//**********************

		multi = false;
		
		//**********************
		// Solo Button
		
		soloButton = new JButton();
		soloButton.setVisible(false);
		soloButton.setLocation(width/3 - (int) (200 * Variables.SIZE_MultiplicatorWidth), height/4 * 3);
		soloButton.setSize(buttonWidth, buttonHeight);
		soloButton.setIcon(Utils.resizeImage(Const.BUTTON_SOLO, buttonWidth, buttonHeight));
		soloButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				multi = false;
				game.menu.setVisible(false);
				game.monopoly.setVisible(true);
				System.out.println("test");
			}
		});
		// Adding here to prevent next buttons to be invisible
		add(soloButton);
		
		//**********************
		// Multi Button
		
		multiButton = new JButton();
		multiButton.setVisible(false);
		multiButton.setLocation(width/2 - (int) (150 * Variables.SIZE_MultiplicatorWidth), height/4 * 3);
		multiButton.setSize(buttonWidth, buttonHeight);
		multiButton.setIcon(Utils.resizeImage(Const.BUTTON_MULTI, buttonWidth, buttonHeight));
		multiButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				multi = true;
			}
		});
		// Adding here to prevent next buttons to be invisible
		add(multiButton);
		
		//**********************
		// Back Button
		
		backButton = new JButton();
		backButton.setVisible(false);
		backButton.setLocation(width/3 * 2 - (int) (100 * Variables.SIZE_MultiplicatorWidth), height/4 * 3);
		backButton.setSize(buttonWidth, buttonHeight);
		backButton.setIcon(Utils.resizeImage(Const.BUTTON_BACK, buttonWidth, buttonHeight));
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				soloButton.setVisible(false);
				multiButton.setVisible(false);
				backButton.setVisible(false);
				newGameButton.setVisible(true);
				loadButton.setVisible(true);
				exitButton.setVisible(true);
			}
		});
		// Adding here to prevent next buttons to be invisible
		add(backButton);
		
		
		//**************************************************************************
		// Adding components
		
		add(screen);
	
		//**************************************************************************
	}
	
}
