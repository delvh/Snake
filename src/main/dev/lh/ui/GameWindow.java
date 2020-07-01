package dev.lh.ui;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

import dev.lh.*;
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

	private static final long serialVersionUID = 1L;

	private Viewport viewport;

	/**
	 * @param title the title of the frame
	 * @since Snake 1.0
	 */
	public GameWindow(String title) {
		// Initialize window
		super(title);
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(new Rectangle(size));
		setLocation(0, 0);
		setMinimumSize(size);
		setPreferredSize(size);
		setMaximumSize(size);
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Initialize game objects
		Snake snake = new Snake(7);
		FoodFactory foodFactory = new FoodFactory(getWidth(), getHeight());
		Handler handler = new Handler(snake, foodFactory);

		// Initialize viewport
		viewport = new Viewport(handler);
		add(viewport);

		addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				super.keyPressed(e);
				switch (e.getKeyCode()) {
					case KeyEvent.VK_W:
					case KeyEvent.VK_UP:
						if (!snake.getDirection().equals(Direction.DOWN))
							snake.setDirection(Direction.UP);
						break;
					case KeyEvent.VK_A:
					case KeyEvent.VK_LEFT:
						if (!snake.getDirection().equals(Direction.RIGHT))
							snake.setDirection(Direction.LEFT);
						break;
					case KeyEvent.VK_S:
					case KeyEvent.VK_DOWN:
						if (!snake.getDirection().equals(Direction.UP))
							snake.setDirection(Direction.DOWN);
						break;
					case KeyEvent.VK_D:
					case KeyEvent.VK_RIGHT:
						if (!snake.getDirection().equals(Direction.LEFT))
							snake.setDirection(Direction.RIGHT);
						break;
				}
			}
		});

		setVisible(true);
		viewport.start();
	}

	/**
	 * Disposes this frame.
	 *
	 * @since Snake 1.1
	 */
	public void close() {
		viewport.stop();
		setVisible(false);
		dispose();
	}
}
