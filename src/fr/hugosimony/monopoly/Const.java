package fr.hugosimony.monopoly;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

public class Const {

	//****************************************************************************************************
	// Paths
	
	//***********************************
	// Icons
	
	public static final Image MAIN_LOGO = new ImageIcon(Main.class.getResource("logos/monop.jpg")).getImage();
	
	public static final ImageIcon PARAMETERS_ICON = new ImageIcon(Main.class.getResource("logos/parameters.gif"));
	public static final ImageIcon VOLUME_ICON = new ImageIcon(Main.class.getResource("logos/volume.gif"));
	
	//***********************************
	// Buttons
	
	public static final ImageIcon BUTTON_NEW_GAME = new ImageIcon(Main.class.getResource("logos/newGameButton.png"));
	public static final ImageIcon BUTTON_LOAD = new ImageIcon(Main.class.getResource("logos/loadButton.png"));
	public static final ImageIcon BUTTON_EXIT = new ImageIcon(Main.class.getResource("logos/exitButton.png"));
	public static final ImageIcon BUTTON_SOLO = new ImageIcon(Main.class.getResource("logos/soloButton.png"));
	public static final ImageIcon BUTTON_MULTI = new ImageIcon(Main.class.getResource("logos/multiButton.png"));
	public static final ImageIcon BUTTON_BACK = new ImageIcon(Main.class.getResource("logos/backButton.png"));
	public static final ImageIcon BUTTON_LEFT = new ImageIcon(Main.class.getResource("logos/windowLeftButton.png"));
	public static final ImageIcon BUTTON_RIGHT = new ImageIcon(Main.class.getResource("logos/windowRightButton.png"));
	public static final ImageIcon BUTTON_OPTIONS_BACK = new ImageIcon(Main.class.getResource("logos/backOptionsButton.png"));
	public static final ImageIcon BUTTON_EXIT_GAME = new ImageIcon(Main.class.getResource("logos/exitGameButton.png"));
	
	//***********************************
	// Titles
	
	public static final ImageIcon TITLE_BLANK = new ImageIcon(Main.class.getResource("logos/blankTitle.png"));
	public static final ImageIcon TITLE_OPTIONS = new ImageIcon(Main.class.getResource("logos/optionsTitle.png"));
	public static final ImageIcon TITLE_WINDOW = new ImageIcon(Main.class.getResource("logos/windowTitle.png"));
	public static final ImageIcon TITLE_WINDOW_RESTART = new ImageIcon(Main.class.getResource("logos/windowRestartTitle.png"));
	public static final ImageIcon TITLE_FULLSCREEN = new ImageIcon(Main.class.getResource("logos/fullscreenTitle.png"));
	public static final ImageIcon TITLE_FULLSCREEN_WINDOWED = new ImageIcon(Main.class.getResource("logos/fullscreenWindowedTitle.png"));
	public static final ImageIcon TITLE_WINDOWED = new ImageIcon(Main.class.getResource("logos/windowedTitle.png"));
	public static final ImageIcon TITLE_MUSIC = new ImageIcon(Main.class.getResource("logos/musicTitle.png"));
	public static final ImageIcon TITLE_MAIN_THEME = new ImageIcon(Main.class.getResource("logos/mainThemeTitle.png"));
	public static final ImageIcon TITLE_VOLUME = new ImageIcon(Main.class.getResource("logos/volumeTitle.png"));
	
	//***********************************
	// Screens
	
	public static final ImageIcon MAIN_SCREEN = new ImageIcon(Main.class.getResource("screens/monopoly_screen.png"));
	public static final ImageIcon MAIN_SCREEN_LOADING = new ImageIcon(Main.class.getResource("screens/monopoly_loading_screen.png"));
	
}
