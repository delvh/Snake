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

/**
 * Project: <strong>Snake</strong><br>
 * File: <strong>GameWindow.java</strong><br>
 * Created: <strong>11 Mar 2020</strong><br>
 *
 * @author Leon Hofmeister
 * @since Snake 1.0
 */
public class GameWindow extends JFrame {

	private static final long	serialVersionUID	= 1L;
	private Snake				s					= new Snake(7);
	private FoodFactory			foodFactory			= FoodFactory.getInstance();

	/**
	 * @param title the title of the frame
	 * @since Snake 1.0
	 */
	public GameWindow(String title) {
		super(title);
		newFood();
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(new Rectangle(size));
		setLocation(0, 0);
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
						if (!s.getRichtung().equals(Direction.Down)) s.setRichtung(Direction.Up);
						break;
					case KeyEvent.VK_A:
					case KeyEvent.VK_LEFT:
						if (!s.getRichtung().equals(Direction.Right)) s.setRichtung(Direction.Left);
						break;
					case KeyEvent.VK_S:
					case KeyEvent.VK_DOWN:
						if (!s.getRichtung().equals(Direction.Up)) s.setRichtung(Direction.Down);
						break;
					case KeyEvent.VK_D:
					case KeyEvent.VK_RIGHT:
						if (!s.getRichtung().equals(Direction.Left)) s.setRichtung(Direction.Right);
						break;
				}
			}
		});

		Timer timer = new Timer(50,
				(evt) -> { s.nextFrame(); if (System.currentTimeMillis() >= foodFactory.getTimeOfNextFood()) newFood(); repaint(); });
		timer.start();

		setVisible(true);
	}

	/**
	 * Generates new food
	 *
	 * @since Snake 1.1
	 */
	public void newFood() {
		foodFactory.generateFood();
		foodFactory.generateFoodLocation(getWidth(), getHeight());
		repaint();
	}

	/**
	 * Disposes this frame
	 *
	 * @since Snake 1.1
	 */
	public void close() { dispose(); }
}