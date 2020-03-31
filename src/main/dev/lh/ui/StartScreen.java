package dev.lh.ui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.KeyEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import dev.lh.Main;

/**
 * Project: <strong>Snake</strong><br>
 * File: <strong>StartScreen.java</strong><br>
 * Created: <strong>11 Mar 2020</strong><br>
 *
 * @author Leon Hofmeister
 * @since Snake 1.0
 */
public class StartScreen extends JFrame {

	private static final long	serialVersionUID	= 6055940532003735543L;
	private JPanel				contentPane;

	/**
	 * closes the application.
	 */
	public static void close() { System.exit(0); }

	/**
	 * Launches Snake.
	 *
	 * @param args the program arguments
	 * @since Snake 1.0
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				StartScreen frame = new StartScreen();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StartScreen() {
		try {
			// readInHighscores();
			setTitle("Snake - Startscreen");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(500, 200, 550, 550);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);

			JButton buPlay = new JButton("Start Game");
			buPlay.setBounds(158, 197, 190, 131);
			buPlay.setIcon(new ImageIcon(StartScreen.class.getResource("/com/sun/javafx/webkit/prism/resources/mediaPlayDisabled.png")));
			buPlay.setMnemonic(KeyEvent.VK_ENTER);
			buPlay.setFont(new Font("Times New Roman", Font.PLAIN, 16));

			buPlay.addActionListener(a -> {

				Main.startGame();
				setVisible(false);
				dispose();
				System.gc();
			});
			contentPane.setLayout(null);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
