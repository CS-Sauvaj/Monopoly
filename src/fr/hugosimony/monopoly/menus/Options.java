package fr.hugosimony.monopoly.menus;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.hugosimony.monopoly.Const;
import fr.hugosimony.monopoly.Game;
import fr.hugosimony.monopoly.Utils;
import fr.hugosimony.monopoly.Variables;

public class Options extends JPanel{
	private static final long serialVersionUID = 1L;

	//**************************************************************************
	// Menu settings
	
	private int width;
	private int height;
	private Color background = new Color(220,220,220);
	
	//**************************************************************************
	// Components and settings
	
	private int labelWidth;
	private int labelHeight;
	private int buttonWidth;
	private int buttonHeight;
	private JLabel title;
	private JLabel windowTitle;
	private JLabel windowSelectionTitle;
	private JButton windowLeftButton;
	private JButton windowRightButton;
	
	
	public Options(Game game) {
		
		/* 
		 * Create the panel of the options menu.
		 * Allow the player to change the volume, the resolution, the controls
		 */
		
		//**************************************************************************
		// Initializing panel
		
		setLayout(null);
		setVisible(true);
		setBackground(background);
		width = game.width/2;
		height = game.height/5 * 4;
		setSize(width, height);
		setLocation(game.width/2 - game.width/4, game.height/2 - game.height/5 * 2);
		setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.RED));
		
		//**************************************************************************
		// Creating components
		
		labelWidth = width - 10;
		labelHeight = (int) (100 * Variables.SIZE_MultiplicatorHeight);
		
		//**********************
		// Options Title
		
		title = new JLabel();
		title.setIcon(Utils.resizeImage(Const.TITLE_OPTIONS, labelWidth, labelHeight));
		title.setSize(labelWidth, labelHeight);
		title.setLocation(5, 5);

		//**********************
		// Window Title
		
		windowTitle = new JLabel();
		windowTitle.setIcon(Utils.resizeImage(Const.TITLE_WINDOW, labelWidth / 2, labelHeight));
		windowTitle.setSize(labelWidth / 2, labelHeight);
		windowTitle.setLocation(5, labelHeight + 5);
		
		//**********************
		// Window Selection Title
		
		windowSelectionTitle = new JLabel();
		
		if(game.windowSelection == 0)
			windowSelectionTitle.setIcon(Utils.resizeImage(Const.TITLE_WINDOWED, labelWidth / 2, labelHeight));
		else if(game.windowSelection == 1) 
			windowSelectionTitle.setIcon(Utils.resizeImage(Const.TITLE_FULLSCREEN, labelWidth / 2, labelHeight));
		else if(game.windowSelection == 2) 
			windowSelectionTitle.setIcon(Utils.resizeImage(Const.TITLE_FULLSCREEN_WINDOWED, labelWidth / 2, labelHeight));
		
		windowSelectionTitle.setSize(labelWidth / 2, labelHeight);
		windowSelectionTitle.setLocation(labelWidth / 2 + 5, labelHeight + 5);

		//**********************
		
		buttonWidth = (int) (50 * Variables.SIZE_MultiplicatorWidth);
		buttonHeight = (int) (50 * Variables.SIZE_MultiplicatorHeight);
		
		//**********************
		// Left Button
		
		windowLeftButton = new JButton();
		windowLeftButton.setBorder(null);
		windowLeftButton.setIcon(Utils.resizeImage(Const.BUTTON_LEFT, buttonWidth, buttonHeight));
		windowLeftButton.setSize(buttonWidth,  buttonHeight);
		windowLeftButton.setLocation(labelWidth / 2 + 15, labelHeight + 5 + (labelHeight - buttonHeight) / 2);
		windowLeftButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				windowTitle.setIcon(Utils.resizeImage(Const.TITLE_WINDOW_RESTART, labelWidth / 2, labelHeight));
				if(game.windowSelection == 0) {
					windowSelectionTitle.setIcon(Utils.resizeImage(Const.TITLE_WINDOWED, labelWidth / 2, labelHeight));
					game.windowSelection = 2;
				}
				else if(game.windowSelection == 1) {
					windowSelectionTitle.setIcon(Utils.resizeImage(Const.TITLE_FULLSCREEN, labelWidth / 2, labelHeight));
					game.windowSelection = 0;
				}
				else if(game.windowSelection == 2) {
					windowSelectionTitle.setIcon(Utils.resizeImage(Const.TITLE_FULLSCREEN_WINDOWED, labelWidth / 2, labelHeight));
					game.windowSelection = 1;
				}
			}
		});
		// Adding here to prevent next buttons to be invisible
		add(windowLeftButton);
		
		//**********************
		// Right Button
		
		windowRightButton = new JButton();
		windowRightButton.setBorder(null);
		windowRightButton.setIcon(Utils.resizeImage(Const.BUTTON_RIGHT, buttonWidth, buttonHeight));
		windowRightButton.setSize(buttonWidth,  buttonHeight);
		windowRightButton.setLocation(width - 15 - buttonWidth, labelHeight + 5 + (labelHeight - buttonHeight) / 2);
		windowRightButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				windowTitle.setIcon(Utils.resizeImage(Const.TITLE_WINDOW_RESTART, labelWidth / 2, labelHeight));
				if(game.windowSelection == 0) {
					windowSelectionTitle.setIcon(Utils.resizeImage(Const.TITLE_FULLSCREEN_WINDOWED, labelWidth / 2, labelHeight));
					game.windowSelection = 1;
				}
				else if(game.windowSelection == 1) {
					windowSelectionTitle.setIcon(Utils.resizeImage(Const.TITLE_WINDOWED, labelWidth / 2, labelHeight));
					game.windowSelection = 2;
				}
				else if(game.windowSelection == 2) {
					windowSelectionTitle.setIcon(Utils.resizeImage(Const.TITLE_FULLSCREEN, labelWidth / 2, labelHeight));
					game.windowSelection = 0;
				}
			}
		});
		// Adding here to prevent next buttons to be invisible
		add(windowRightButton);
		
		//**************************************************************************
		// Adding components

		add(title);
		add(windowTitle);
		add(windowSelectionTitle);
	
		//**************************************************************************
	}
	
}
