package dev.lh.snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import dev.lh.snake.Snake;

public class GameWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Toolkit tk = Toolkit.getDefaultToolkit();
	int xSize = ((int) tk.getScreenSize().getWidth());
	int ySize = ((int) tk.getScreenSize().getHeight());

	public GameWindow(int width, int height, String title) {
		super(title);
		setLocationRelativeTo(null);
		Dimension size = new Dimension(width, height);
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Snake s = new Snake(3);

		add(new JPanel() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(Color.black);
				g.fillRect(0, 0, width, height);
				s.render(g);
			}
		});

		addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				super.keyPressed(e);
				switch (e.getKeyCode()) {
				case KeyEvent.VK_W:
					s.setRichtung(Direction.Up);
					break;
				case KeyEvent.VK_A:
					s.setRichtung(Direction.Left);
					break;
				case KeyEvent.VK_S:
					s.setRichtung(Direction.Down);
					break;	
				case KeyEvent.VK_D:
					s.setRichtung(Direction.Right);
					break;
				case KeyEvent.VK_UP:
					s.setRichtung(Direction.Up);
					break;
				case KeyEvent.VK_LEFT:
					s.setRichtung(Direction.Left);
					break;
				case KeyEvent.VK_DOWN:
					s.setRichtung(Direction.Down);
					break;	
				case KeyEvent.VK_RIGHT:
					s.setRichtung(Direction.Right);
					break;		

				}// switch
			}// keypressed
		});// keylistener

		Timer timer = new Timer (200, (evt)->{
			s.tick();
			repaint();
		});
		timer.start();
		
		setVisible(true);
		
	}
}// Konstruktor