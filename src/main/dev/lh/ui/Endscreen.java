package dev.lh.ui;

import java.awt.*;
import java.awt.event.KeyEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import dev.lh.Main;

/**
 * Project: <strong>Snake</strong><br>
 * File: <strong>Endscreen.java</strong><br>
 * Created: <strong>11 Mar 2020</strong><br>
 *
 * @author Leon Hofmeister
 * @since Snake v1.1
 */
public class Endscreen extends JDialog {

	private static final long serialVersionUID = -4457484397259161063L;

	private final JPanel		contentPanel	= new JPanel();
	private int					score			= 0;
	private static final int	goodOrBadResult	= 200;

	/**
	 * Create the dialog.
	 *
	 * @param score the highscore to set
	 */
	public Endscreen(int score) {
		this.score = score;
		try {
			// readInHighscoresPoints();
			// readInHighscoresPlayers();

			setTitle("Endscreen");
			setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			setBounds(100, 100, 700, 700);
			getContentPane().setLayout(new BorderLayout());
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			getContentPane().add(contentPanel, BorderLayout.CENTER);
			addWindowListener(new java.awt.event.WindowAdapter() {

				@Override
				public void windowClosing(java.awt.event.WindowEvent windowEvent) {
					Thread.getAllStackTraces().forEach((thread, stackTraceElement) -> thread.interrupt());
					System.exit(0);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}

		JButton btnNewButton = new JButton("Play again");
		btnNewButton.setMnemonic(KeyEvent.VK_ENTER);
		btnNewButton.addActionListener(e -> { Main.startGame(); dispose(); });
		contentPanel.setLayout(new BorderLayout(0, 0));
		// btnNewButton.setIcon(new
		// ImageIcon(ClassLoader.getSystemResource("/com/sun/javafx/webkit/prism/resources/mediaPlayDisabled.png")));
		btnNewButton.setIconTextGap(5);
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		contentPanel.add(btnNewButton, BorderLayout.SOUTH);

		JLabel lblDeinPunktestand = new JLabel("Dein Punktestand:	     " + String.valueOf(score));
		lblDeinPunktestand.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		contentPanel.add(lblDeinPunktestand, BorderLayout.NORTH);

		Image resultImage = Toolkit.getDefaultToolkit()
			.getImage(this.getClass()
				.getResource((score < goodOrBadResult) ? "/Snake/src/main/resources/Try_Again.jpg" : "/Snake/src/main/resources/1211548-200.png"));
		resultImage.flush();

		setVisible(true);
	}

	/**
	 * @return the highscore of the current game
	 * @since Snake 1.0
	 */
	public int getScore() { return score; }

	/**
	 * @param score the new highscore
	 * @since Snake 1.0
	 */
	public void setScore(int score) { this.score = score; }
}
