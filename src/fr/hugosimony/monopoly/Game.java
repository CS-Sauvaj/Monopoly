package fr.hugosimony.monopoly;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import fr.hugosimony.monopoly.audio.AudioPaths;
import fr.hugosimony.monopoly.audio.musics.Music;
import fr.hugosimony.monopoly.menus.Menu;
import fr.hugosimony.monopoly.menus.Options;
import fr.hugosimony.monopoly.menus.Parameters;

public class Game extends JFrame {
	private static final long serialVersionUID = 1L;
	
	//**************************************************************************
	// Game settings
	
	private Game game;
	public int width;
	public int height;
	public int windowSelection;
	
	//**************************************************************************
	// Components and settings
	
	public JPanel mainPanel;
	private JPanel options_cache;
	private Timer timer;
	private JPanel parameters;
	public JPanel menu;
	public JPanel options;
	
	//**************************************************************************
	
	public Game() {
		
		/*
		 * Create the frame of the game.
		 * Contains the panel of the Monopoly itself.
		 */

		//**************************************************************************
		// Initializing frame
		
		game = this;
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		width = dim.width;
		height = dim.height;
		// 1920:1080 is default size
		Variables.SIZE_MultiplicatorWidth = (float) dim.width / (float) 1920;
		Variables.SIZE_MultiplicatorHeight = (float) dim.height / (float) 1080;
		
		setIconImage(Const.MAIN_LOGO);
		setTitle("Monopoly");
		setResizable(false);
		setLayout(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);
		windowSelection = 0;
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
	    	public void windowClosed(WindowEvent e) {
	    		if(game.isVisible()){
	    			System.exit(0);
	    		}
	    	}
		});
		
		//**************************************************************************
		// Creating components
		
		//**********************
		// Main panel
		
		mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setLocation(0,0);
		mainPanel.setSize(width, height);
		
		//**********************
		// Options cache
		
		options_cache = new JPanel();
		options_cache.setLocation(0, 0);
		options_cache.setOpaque(false);
		options_cache.setVisible(true);
		options_cache.setSize(width, 40);
		timer = new Timer();
		options_cache.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent arg0) {
				showParametersPanel();
			}
			
			@Override
			public void mouseDragged(MouseEvent arg0) {
				showParametersPanel();
			}
		});
		
		//**********************
		// Parameters panel
		
		parameters = new Parameters(this);
		parameters.setLocation(0, 0);
		
		//**********************
		// Options panel
		
		options = new Options(this);
		options.setVisible(false);
		
		//**********************
		// Menu panel
		
		menu = new Menu(this);
		menu.setLocation(0,0);
		
		//**************************************************************************
		// Adding components
		
		mainPanel.add(options_cache);
		mainPanel.add(parameters);
		mainPanel.add(options);
		mainPanel.add(menu);
		add(mainPanel);
		
		//**************************************************************************
		// Start music
		
		if(Music.music != null)
			Music.music.close();
		Music.playMusic(AudioPaths.MainTheme);
		
		//**************************************************************************
		// Check music
		
		timer.schedule(new TimerTask() {
			
			/*
			 * Mute the game if it is not the focused program
			 */
			
			@Override
			public void run() {
				while(game != null) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if(game.isActive())
						Music.refreshVolume();
					else
						Music.setVolume(0);
				}
			}
		}, 1);
		
		//**************************************************************************
		// Keyboard listener
		
		KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
		manager.addKeyEventDispatcher(new MyDispatcher());
		
		//**************************************************************************
	}
	
	private void showParametersPanel() {
		
		/*
		 * Replace the cache options panel by the parameters panel
		 * If the mouse is not on the panel, it will be hide within the next 3 seconds. 
		 */
		
		timer.cancel();
		timer = new Timer();
		options_cache.setVisible(false);
		parameters.setVisible(true);
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				if(game.isVisible() && parameters.isVisible()) {
					options_cache.setVisible(true);
					parameters.setVisible(false);
				}
			}
		}, 3000);
	}
	
	private class MyDispatcher implements KeyEventDispatcher {
		
		/*
		 * Listener for the options key
		 *  - Show the parameters panel if the options menu is hidden
		 *  - Leave the options menu if active
		 */
		
        @Override
        public boolean dispatchKeyEvent(KeyEvent event) {
        	
        	if(isVisible()) {
        		if(event.getID() == KeyEvent.KEY_PRESSED) {
        			int keyCode = event.getKeyCode();
        			if(keyCode == KeyEvent.VK_ESCAPE) {
        				if(options.isVisible()) {
        					options.setVisible(false);
        					for(Component c : game.menu.getComponents()) {
        						if(c instanceof JButton)
        							c.setEnabled(true);
        					}
        				}
        				else
        					showParametersPanel();
        			}
        		}
        	}
        	return false;
        }
	}
	
}
