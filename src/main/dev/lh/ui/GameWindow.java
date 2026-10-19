package dev.lh.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import dev.lh.FoodFactory;
import dev.lh.Snake;
import dev.lh.Snake.Direction;

public class GameWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private Snake s = new Snake(7);
	private FoodFactory foodFactory = FoodFactory.getInstance();

	public GameWindow(String title) {
		super(title);
		newFood();
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(new Rectangle(size));
		setLocationRelativeTo(null);
		setMinimumSize(size);
		setPreferredSize(size);
		setMaximumSize(size);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);


		add(new JPanel() {

			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(Color.black);
				g.fillRect(0, 0, super.getWidth(), super.getHeight());
				s.render(g);
				foodFactory.paintFood(g);
			}
		});

		addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				super.keyPressed(e);
				switch (e.getKeyCode()) {
				case KeyEvent.VK_W:
				case KeyEvent.VK_UP:
					s.setRichtung(Direction.Up);
					break;
				case KeyEvent.VK_A:
				case KeyEvent.VK_LEFT:
					s.setRichtung(Direction.Left);
					break;
				case KeyEvent.VK_S:
				case KeyEvent.VK_DOWN:
					s.setRichtung(Direction.Down);
					break;
				case KeyEvent.VK_D:
				case KeyEvent.VK_RIGHT:
					s.setRichtung(Direction.Right);
					break;
				}// switch
			}// keypressed
		});// keylistener

		Timer timer = new Timer(50, (evt) -> {
			s.tick();
			if(System.currentTimeMillis()>=foodFactory.getTimeOfNextFood()) newFood();
			repaint();
		});
		timer.start();

		setVisible(true);
	}

	public void newFood() {
		foodFactory.generateFood();
		foodFactory.generateFoodLocation(super.getWidth(), super.getHeight());
	}

	public void close() {
		dispose();
	}
}