package fr.hugosimony.monopoly.menus;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class Parameters extends JPanel {
	private static final long serialVersionUID = 1L;
	
	//**************************************************************************
	// Components and settings
	
	private JLabel volume_icon;
	private JSlider volume;
	private JButton parameters;
	
	public Parameters(Game game) {
		
		/*
		 * Create the options panel with
		 */
		
		//**************************************************************************
		// Initializing panel
		
		setLocation(0, 0);
		setLayout(null);
		//setBackground(new Color(180,180,220));
		setVisible(false);
		setOpaque(false);
		setSize(game.width, 40);
		
		//**************************************************************************
		// Creating components
		
		//**********************
		// Volume icon
		
		volume_icon = new JLabel();
		volume_icon.setBackground(getBackground());
		volume_icon.setSize(Const.VOLUME_ICON.getIconWidth(), Const.VOLUME_ICON.getIconHeight());
		volume_icon.setLocation(game.width - 250, 8); // Default
		volume_icon.setIcon(Const.VOLUME_ICON);
		
		
		//**********************
		// Volume slider
		
		volume = new JSlider();
		volume.setOpaque(false);
		volume.setSize(150, 25);
		volume.setMinimum(0);
		volume.setMaximum(75);
		volume.setValue((int) (Variables.VOLUME_Main * 75));
		volume.setMajorTickSpacing(1);
		volume.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent arg0) {
				Variables.VOLUME_Main = (float) volume.getValue() / 75;
				Music.refreshVolume();
			}
		});
		volume.setLocation(game.width - 210, 8); // Default
		
		//**********************
		// Parameters button
		
		parameters = new JButton();
		parameters.setBackground(new Color(255,255,255));
		parameters.setBorder(null);
		parameters.setOpaque(false);
		parameters.setSize(Const.PARAMETERS_ICON.getIconWidth(), Const.PARAMETERS_ICON.getIconHeight());
		parameters.setLocation(game.width - 50, 8); // Default
		parameters.setIcon(Const.PARAMETERS_ICON);
		parameters.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				game.options.setVisible(true);
				for(Component c : game.menu.getComponents()) {
					if(c instanceof JButton)
						c.setEnabled(false);
				}
			}
		});
		
		
		//**************************************************************************
		// Adding components
		
		add(volume_icon);
		add(volume);
		add(parameters);
		
		//**************************************************************************
	}
	
}
