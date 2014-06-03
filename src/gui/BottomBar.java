package gui;

import game.GameRunner;
import game.Player;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import lib.GraphPaperLayout;

public class BottomBar extends JPanel{
	
	public ArrayList<ArrayList<KComponent>> playerComponents = new ArrayList<ArrayList<KComponent>>();
	
	public final static int INTERVAL = 20;
	private Timer timer;
	
	public BottomBar() {
		setBackground(Color.CYAN);
		
		setLayout(new GraphPaperLayout(new Dimension(4,7)));
		
		for (int i = 0; i < GameRunner.players.size(); i++) {
			ArrayList<KComponent> components = new ArrayList<KComponent>();
			components.add(new KComponent(new JLabel(GameRunner.players.get(i).getName()), new Rectangle(i,0,1,1)));
			add(components.get(0).getComponent(), components.get(0).getRectangle());
			
			for (int k = 1; k <= 6; k++) {
				components.add(new KComponent(new JLabel(""), new Rectangle(i,k,1,1)));
				components.get(k).getComponent().setFont(new Font("Arial", 1, 16));
				add(components.get(k).getComponent(), components.get(k).getRectangle());
			}
			
			playerComponents.add(components);
		}
		
		timer = new Timer(INTERVAL,
				new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						for (int i = 0; i < playerComponents.size(); i++) {
							updatePlayer(playerComponents.get(i), GameRunner.players.get(i));
						}
					}
				});
		timer.start();
		
	}
	
	/*
	public void update(Graphics g) {
		((JLabel)brick.getComponent()).setText("Brick: " + GameRunner.currentPlayer.getNumberResourcesType("BRICK"));
		((JLabel)wool.getComponent()).setText("Wool: " + GameRunner.currentPlayer.getNumberResourcesType("WOOL"));
		((JLabel)ore.getComponent()).setText("Ore: " + GameRunner.currentPlayer.getNumberResourcesType("ORE"));
		((JLabel)grain.getComponent()).setText("Grain: " + GameRunner.currentPlayer.getNumberResourcesType("GRAIN"));
		((JLabel)lumber.getComponent()).setText("Lumber: " + GameRunner.currentPlayer.getNumberResourcesType("LUMBER"));
		
		add(brick.getComponent(), brick.getRectangle());
		add(wool.getComponent(), wool.getRectangle());
		add(ore.getComponent(), ore.getRectangle());
		add(grain.getComponent(), grain.getRectangle());
		add(lumber.getComponent(), lumber.getRectangle());
		
	}
	*/
	
	public void updatePlayer(ArrayList<KComponent> components, Player p){
		((JLabel)components.get(1).getComponent()).setText("Brick: " + p.getNumberResourcesType("BRICK"));
		((JLabel)components.get(2).getComponent()).setText("Wool: " + p.getNumberResourcesType("WOOL"));
		((JLabel)components.get(3).getComponent()).setText("Ore: " + p.getNumberResourcesType("ORE"));
		((JLabel)components.get(4).getComponent()).setText("Grain: " + p.getNumberResourcesType("GRAIN"));
		((JLabel)components.get(5).getComponent()).setText("Lumber: " + p.getNumberResourcesType("LUMBER"));
		((JLabel)components.get(6).getComponent()).setText("VP: " + p.getVictoryPoints());
	}
	
	
}
