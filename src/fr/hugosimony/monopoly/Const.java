package fr.hugosimony.monopoly;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

public class Const {

	//****************************************************************************************************
	// Paths
	
	//***********************************
	// Icons
	
	private static final URL mainLogoURL = Main.class.getResource("logos/monop.jpg");
	public static final Image MAIN_LOGO = new ImageIcon(mainLogoURL).getImage();
	
	private static final URL parametersURL = Main.class.getResource("logos/parameters.gif");
	public static final ImageIcon PARAMETERS_ICON = new ImageIcon(parametersURL);
	private static final URL volumeURL = Main.class.getResource("logos/volume.gif");
	public static final ImageIcon VOLUME_ICON = new ImageIcon(volumeURL);
	
	//***********************************
	// Buttons
	
	private static final URL newGameButtonURL = Main.class.getResource("logos/newGameButton.png");
	public static final ImageIcon BUTTON_NEW_GAME = new ImageIcon(newGameButtonURL);
	private static final URL loadButtonURL = Main.class.getResource("logos/loadButton.png");
	public static final ImageIcon BUTTON_LOAD = new ImageIcon(loadButtonURL);
	private static final URL exitButtonURL = Main.class.getResource("logos/exitButton.png");
	public static final ImageIcon BUTTON_EXIT = new ImageIcon(exitButtonURL);
	private static final URL soloButtonURL = Main.class.getResource("logos/soloButton.png");
	public static final ImageIcon BUTTON_SOLO = new ImageIcon(soloButtonURL);
	private static final URL multiButtonURL = Main.class.getResource("logos/multiButton.png");
	public static final ImageIcon BUTTON_MULTI = new ImageIcon(multiButtonURL);
	private static final URL backButtonURL = Main.class.getResource("logos/backButton.png");
	public static final ImageIcon BUTTON_BACK = new ImageIcon(backButtonURL);
	private static final URL leftButtonURL = Main.class.getResource("logos/windowLeftButton.png");
	public static final ImageIcon BUTTON_LEFT = new ImageIcon(leftButtonURL);
	private static final URL rightButtonURL = Main.class.getResource("logos/windowRightButton.png");
	public static final ImageIcon BUTTON_RIGHT = new ImageIcon(rightButtonURL);
	private static final URL backOptionsButtonURL = Main.class.getResource("logos/backOptionsButton.png");
	public static final ImageIcon BUTTON_OPTIONS_BACK = new ImageIcon(backOptionsButtonURL);
	private static final URL exitGameButtonURL = Main.class.getResource("logos/exitGameButton.png");
	public static final ImageIcon BUTTON_EXIT_GAME = new ImageIcon(exitGameButtonURL);
	
	//***********************************
	// Titles
	
	private static final URL blanckTitleURL = Main.class.getResource("logos/blankTitle.png");
	public static final ImageIcon TITLE_BLANK = new ImageIcon(blanckTitleURL);
	private static final URL optionsTitleURL = Main.class.getResource("logos/optionsTitle.png");
	public static final ImageIcon TITLE_OPTIONS = new ImageIcon(optionsTitleURL);
	private static final URL windowTitleURL = Main.class.getResource("logos/windowTitle.png");
	public static final ImageIcon TITLE_WINDOW = new ImageIcon(windowTitleURL);
	private static final URL windowRestartTitleURL = Main.class.getResource("logos/windowRestartTitle.png");
	public static final ImageIcon TITLE_WINDOW_RESTART = new ImageIcon(windowRestartTitleURL);
	private static final URL fullscreenTitleURL = Main.class.getResource("logos/fullscreenTitle.png");
	public static final ImageIcon TITLE_FULLSCREEN = new ImageIcon(fullscreenTitleURL);
	private static final URL fullscreenWindowedTitleURL = Main.class.getResource("logos/fullscreenWindowedTitle.png");
	public static final ImageIcon TITLE_FULLSCREEN_WINDOWED = new ImageIcon(fullscreenWindowedTitleURL);
	private static final URL windowedTitleURL = Main.class.getResource("logos/windowedTitle.png");
	public static final ImageIcon TITLE_WINDOWED = new ImageIcon(windowedTitleURL);
	private static final URL musicTitleURL = Main.class.getResource("logos/musicTitle.png");
	public static final ImageIcon TITLE_MUSIC = new ImageIcon(musicTitleURL);
	private static final URL mainThemeTitleURL = Main.class.getResource("logos/mainThemeTitle.png");
	public static final ImageIcon TITLE_MAIN_THEME = new ImageIcon(mainThemeTitleURL);
	private static final URL volumeTitleURL = Main.class.getResource("logos/volumeTitle.png");
	public static final ImageIcon TITLE_VOLUME = new ImageIcon(volumeTitleURL);
	
	//***********************************
	// Screens
	
	private static final URL mainScreenURL = Main.class.getResource("screens/monopoly_screen.png");
	public static final ImageIcon MAIN_SCREEN = new ImageIcon(mainScreenURL);
	private static final URL mainLoadingScreenURL = Main.class.getResource("screens/monopoly_loading_screen.png");
	public static final ImageIcon MAIN_SCREEN_LOADING = new ImageIcon(mainLoadingScreenURL);
	
}
