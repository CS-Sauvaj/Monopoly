package fr.hugosimony.monopoly.menus;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import fr.hugosimony.monopoly.Const;
import fr.hugosimony.monopoly.Game;
import fr.hugosimony.monopoly.Variables;
import fr.hugosimony.monopoly.audio.musics.Music;
import fr.hugosimony.monopoly.utils.Utils;

public class Options extends JPanel{
	private static final long serialVersionUID = 1L;

	//**************************************************************************
	// Options settings
	
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
	private JLabel musicTitle;
	private JLabel musicSelectionTitle;
	private JButton musicLeftButton;
	private JButton musicRightButton;
	private JLabel volumeTitle;
	private JPanel volumeBarTitle;
	public JSlider volumeSlider;
	private JButton backButton;
	private JButton exitButton;
	
	
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
			windowSelectionTitle.setIcon(Utils.resizeImage(Const.TITLE_FULLSCREEN, labelWidth / 2, labelHeight));
		else if(game.windowSelection == 1) 
			windowSelectionTitle.setIcon(Utils.resizeImage(Const.TITLE_WINDOWED, labelWidth / 2, labelHeight));
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
		
		//**********************
		// Music Title
		
		musicTitle = new JLabel();
		musicTitle.setIcon(Utils.resizeImage(Const.TITLE_MUSIC, labelWidth / 2, labelHeight));
		musicTitle.setSize(labelWidth / 2, labelHeight);
		musicTitle.setLocation(5, labelHeight * 2 + 5);
		
		//**********************
		// Music Selection Title
		
		musicSelectionTitle = new JLabel();
		musicSelectionTitle.setIcon(Utils.resizeImage(Const.TITLE_MAIN_THEME, labelWidth / 2, labelHeight));
		musicSelectionTitle.setSize(labelWidth / 2, labelHeight);
		musicSelectionTitle.setLocation(labelWidth / 2 + 5, labelHeight * 2 + 5);
		
		//**********************
		// Left Button
		
		musicLeftButton = new JButton();
		musicLeftButton.setBorder(null);
		musicLeftButton.setIcon(Utils.resizeImage(Const.BUTTON_LEFT, buttonWidth, buttonHeight));
		musicLeftButton.setSize(buttonWidth,  buttonHeight);
		musicLeftButton.setLocation(labelWidth / 2 + 15, labelHeight * 2 + 5 + (labelHeight - buttonHeight) / 2);
		musicLeftButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Change music
			}
		});
		// Adding here to prevent next buttons to be invisible
		add(musicLeftButton);
		
		//**********************
		// Right Button
		
		musicRightButton = new JButton();
		musicRightButton.setBorder(null);
		musicRightButton.setIcon(Utils.resizeImage(Const.BUTTON_RIGHT, buttonWidth, buttonHeight));
		musicRightButton.setSize(buttonWidth,  buttonHeight);
		musicRightButton.setLocation(width - 15 - buttonWidth, labelHeight * 2 + 5 + (labelHeight - buttonHeight) / 2);
		musicRightButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Change music
			}
		});
		// Adding here to prevent next buttons to be invisible
		add(musicRightButton);
		
		//**********************
		// Volume Title
		
		volumeTitle = new JLabel();
		volumeTitle.setIcon(Utils.resizeImage(Const.TITLE_VOLUME, labelWidth / 2, labelHeight));
		volumeTitle.setSize(labelWidth / 2, labelHeight);
		volumeTitle.setLocation(5, labelHeight * 3 + 5);
		
		//**********************
		// Volume Slider
		
		volumeBarTitle = new JPanel();
		volumeBarTitle.setBackground(background);
		volumeBarTitle.setLayout(null);
		volumeBarTitle.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
		volumeBarTitle.setSize(labelWidth / 2, labelHeight);
		volumeBarTitle.setLocation(labelWidth / 2 + 5, labelHeight * 3 + 5);
		
		volumeSlider = new JSlider();
		volumeSlider.setOpaque(false);
		volumeSlider.setSize(volumeBarTitle.getSize().width - 10, volumeBarTitle.getSize().height - 10);
		volumeSlider.setLocation(5, 5);
		volumeSlider.setMinimum(0);
		volumeSlider.setMaximum(75);
		volumeSlider.setValue((int) (Variables.VOLUME_Main * 75));
		volumeSlider.setMajorTickSpacing(1);
		volumeSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				Variables.VOLUME_Main = (float) volumeSlider.getValue() / 75;
				game.parameters.volume.setValue(volumeSlider.getValue());
				Music.refreshVolume();
			}
		});
		volumeBarTitle.add(volumeSlider);
		
		//**********************
		// Back Button
		
		backButton = new JButton();
		backButton.setVisible(true);
		backButton.setLocation(5, height - labelHeight - 5);
		backButton.setSize(labelWidth / 2, labelHeight);
		backButton.setIcon(Utils.resizeImage(Const.BUTTON_OPTIONS_BACK, labelWidth / 2, labelHeight));
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				game.options.setVisible(false);
				for(Component c : game.menu.getComponents()) {
					if(c instanceof JButton)
						c.setEnabled(true);
				}
			}
		});
		// Adding here to prevent next buttons to be invisible
		add(backButton);
		
		//**********************
		// Exit Game Button
		
		exitButton = new JButton();
		exitButton.setVisible(true);
		exitButton.setLocation(width / 2, height - labelHeight - 5);
		exitButton.setSize(labelWidth / 2, labelHeight);
		exitButton.setIcon(Utils.resizeImage(Const.BUTTON_EXIT_GAME, labelWidth / 2, labelHeight));
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		// Adding here to prevent next buttons to be invisible
		add(exitButton);
		
		//**************************************************************************
		// Adding components

		add(title);
		add(windowTitle);
		add(windowSelectionTitle);
		add(musicTitle);
		add(musicSelectionTitle);
		add(volumeTitle);
		add(volumeBarTitle);
	
		//**************************************************************************
	}
	
}
