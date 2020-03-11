package dev.lh.ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
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

	private final JPanel	contentPanel	= new JPanel();
	private static int		score			= 0;

	/**
	 * Create the dialog.
	 *
	 * @param score the highscore to set
	 */
	public Endscreen(int score) {
		Endscreen.score = score;
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
		contentPanel.setLayout(null);
		// JScrollPane scrollPane = new JScrollPane();
		// scrollPane.setBounds(10, 412, 349, 238);
		// contentPanel.add(scrollPane);
		// String[][] combis = new String[highscorePoints.length][2];
		// for (int i = 0; i < highscorePoints.length; i++) {
		// combis[i][0] = highscorePlayers[i];
		// combis[i][1] = String.valueOf(highscorePoints[i]);
		// }
		// table = new JTable(combis, tableTitle);
		// table.setRowSelectionAllowed(false);
		// table.setFillsViewportHeight(true);
		// table.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		// scrollPane.setViewportView(table);

		// JLabel lblNewLabel = new JLabel("Highscores");
		// lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC,
		// 18));
		// lblNewLabel.setBounds(65, 292, 98, 41);
		// contentPanel.add(lblNewLabel);

		JButton btnNewButton = new JButton("Play again");
		btnNewButton.setMnemonic(KeyEvent.VK_ENTER);

		btnNewButton.addActionListener(e -> { Main.startGame(); setVisible(false); dispose(); });
		// BLOß NICHT RAUSWERFEN
		btnNewButton.setIconTextGap(5);
		// btnNewButton.setIcon(new
		// ImageIcon(ClassLoader.getSystemResource("/com/sun/javafx/webkit/prism/resources/mediaPlayDisabled.png")));
		// Endscreen.class.getResource("/com/sun/javafx/webkit/prism/resources/mediaPlayDisabled.png")));
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton.setBounds(85, 512, 243, 100);
		contentPanel.add(btnNewButton);

		// JButton btnClose = new JButton("Close game");
		//
		// btnClose.addActionListener(new ActionListener() {// Beginn Listener new game
		// public void actionPerformed(ActionEvent e) {
		// System.exit(0);
		// }
		// });
		//
		// btnClose.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		// btnClose.setBounds(400, 500, 200, 100);
		// contentPanel.add(btnClose);
		//
		// tfName = new JTextField();
		// tfName.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		// tfName.setBounds(102, 344, 257, 40);
		// contentPanel.add(tfName);
		// tfName.setColumns(10);
		//
		// JTextArea txtrBitteErstNamen = new JTextArea();
		// txtrBitteErstNamen.setVisible(false);
		// txtrBitteErstNamen.setBackground(UIManager.getColor("ScrollBar.foreground"));
		// txtrBitteErstNamen.setText("Bitte erst Namen \r\neingeben und\r\ndann
		// Speichern!!!!");
		// txtrBitteErstNamen.setBounds(468, 412, 155, 92);
		// contentPanel.add(txtrBitteErstNamen);
		// txtrBitteErstNamen.setVisible(false);
		//
		// JButton btnSaveHighscore = new JButton("Save Highscore");
		// btnSaveHighscore.setMnemonic(KeyEvent.VK_ENTER);
		// btnSaveHighscore.setIconTextGap(5);
		// btnSaveHighscore.setIcon(
		// new
		// ImageIcon(Endscreen.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
		// btnSaveHighscore.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		//
		// btnSaveHighscore.addActionListener(new ActionListener() {// Beginn Listener
		// Save Highscore
		// public void actionPerformed(ActionEvent e) {
		// relocate(score1);
		// writeFiles();
		// table.updateUI();
		// }
		//
		// });
		//
		// btnSaveHighscore.setBounds(468, 344, 155, 50);
		// contentPanel.add(btnSaveHighscore);

		JLabel lblDeinPunktestand = new JLabel("Dein Punktestand:	     " + String.valueOf(score));
		lblDeinPunktestand.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblDeinPunktestand.setBounds(10, 45, 291, 50);
		contentPanel.add(lblDeinPunktestand);

		// JLabel lblYourName = new JLabel("Your Name:");
		// lblYourName.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		// lblYourName.setBounds(10, 355, 82, 29);
		// contentPanel.add(lblYourName);

		// JCheckBox chckbxNewCheckBox = new JCheckBox("");
		// JLabel lblDasIstEin = new JLabel("Das ist ein hervorragender Wert!");
		// lblDasIstEin.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		// if (score >= goodOrBadResult) {
		// chckbxNewCheckBox.setIcon(new
		// ImageIcon(ClassLoader.getSystemResource("/dev/lh/snake/1211548-200.png")));
		// chckbxNewCheckBox.setBounds(300, 200, 200, 200);
		// lblDasIstEin.setBounds(10, 100, 212, 50);
		// } else {
		// chckbxNewCheckBox.setIcon(new
		// ImageIcon(ClassLoader.getSystemResource("/dev/lh/snake/Try_Again.jpg")));
		// chckbxNewCheckBox.setBounds(300, 200, 250, 210);
		// lblDasIstEin.setText("Das kannst du aber noch verbessern!");
		// lblDasIstEin.setBounds(10, 100, 240, 50);
		// contentPanel.add(lblDasIstEin);
		// }
		// contentPanel.add(chckbxNewCheckBox);
		// contentPanel.add(lblDasIstEin);
		setVisible(true);
	}

	/**
	 * @return the highscore of the current game
	 * @since Snake 1.0
	 */
	public static int getScore() { return score; }

	/**
	 * @param score the new highscore
	 * @since Snake 1.0
	 */
	public static void setScore(int score) { Endscreen.score = score; }
	/*
	 * public static void readInHighscoresPoints() { try { // FileReader reads text
	 * files in the default encoding. FileReader fileReader = new
	 * FileReader(fileNamePoints);
	 * // Always wrap FileReader in BufferedReader. BufferedReader bufferedReader =
	 * new BufferedReader(fileReader);
	 * currentIndex = Integer.parseInt(bufferedReader.readLine()); for (int i = 0; i
	 * < currentIndex; i++) { highscorePoints[i]=
	 * Integer.parseInt(bufferedReader.readLine()); } // Always close files.
	 * bufferedReader.close(); fileReader.close(); } catch (FileNotFoundException
	 * ex) { System.out.println("Error 404:File '" + fileNamePoints +
	 * "' not found");
	 * } catch (IOException ex) { System.out.println("Error reading file '" +
	 * fileNamePoints + "'"); ex.printStackTrace(); } } private void
	 * readInHighscoresPlayers(){ try { // FileReader reads text files in the
	 * default encoding. FileReader fileReader = new FileReader(fileNamePlayers);
	 * // Always wrap FileReader in BufferedReader. BufferedReader bufferedReader =
	 * new BufferedReader(fileReader);
	 * for (int i = 0; i < currentIndex; i++) { highscorePlayers[i]=
	 * bufferedReader.readLine(); } // Always close files. bufferedReader.close();
	 * fileReader.close(); } catch (FileNotFoundException ex) {
	 * System.out.println("Error 404:File '" + fileNamePlayers + "' not found");
	 * } catch (IOException ex) { System.out.println("Error reading file '" +
	 * fileNamePlayers + "'"); ex.printStackTrace(); } } /* private void
	 * writeFiles() { File dateiPoints = new File("." + File.separator +
	 * fileNamePoints); FileWriter fwpoints = null; BufferedWriter bwpoints = null;
	 * try { fwpoints = new FileWriter(dateiPoints); bwpoints = new
	 * BufferedWriter(fwpoints); bwpoints.write(highscorePoints.length); for (int
	 * i=0;i<highscorePoints.length;i++) { bwpoints.write(highscorePoints[i]); } }
	 * catch (Exception e1) { e1.printStackTrace(); } finally { try {
	 * bwpoints.close(); fwpoints.close(); alreadySaved = true; } catch (IOException
	 * e2) { e2.printStackTrace(); } }
	 * File dateiPlayers = new File("." + File.separator + fileNamePlayers);
	 * FileWriter fwplayers = null; BufferedWriter bwplayers = null; try { fwplayers
	 * = new FileWriter(dateiPlayers); bwplayers = new BufferedWriter(fwplayers);
	 * for (int i=0;i<highscorePlayers.length;i++) {
	 * bwplayers.write(highscorePlayers[i]); } } catch (Exception e1) {
	 * e1.printStackTrace(); } finally { try { bwplayers.close(); fwplayers.close();
	 * alreadySaved = true; } catch (IOException e2) { e2.printStackTrace(); } }
	 * }
	 * /** Launch the application.
	 */
	/*
	 * public void relocate(int newScore) {
	 * String newPlayer = new String(tfName.getText()); if (newPlayer.equals("")) {
	 * txtrBitteErstNamen.setVisible(true); return; } else { sortFiles(newScore,
	 * newPlayer); } }
	 * private void sortFiles(int newScore, String newPlayer) { if
	 * (highscorePoints.length==highscorePlayers.length&&
	 * highscorePoints.length<=30) { for(int i=0;i<highscorePoints.length;i++) {
	 * if(highscorePoints[i]<newScore) { int tmp=highscorePoints[i];
	 * highscorePoints[i]=newScore; for(int k=i+1;k<highscorePoints.length;k++) {
	 * int tmp2=highscorePoints[k]; highscorePoints[k]=tmp; tmp=tmp2; } String
	 * temp=highscorePlayers[i]; highscorePlayers[i]=newPlayer; for(int
	 * k=i+1;k<highscorePlayers.length;k++) { String temp2=highscorePlayers[k];
	 * highscorePlayers[k]=temp; temp=temp2; } return; } } } else
	 * if(highscorePoints.length==highscorePlayers.length&&highscorePoints.length>=
	 * 30){ for (int i=30;i<highscorePoints.length;i++) { highscorePoints[i]=null;
	 * highscorePlayers[i]=null; } for(int i=0;i<highscorePoints.length;i++) {
	 * if(highscorePoints[i]<newScore) { int tmp=highscorePoints[i];
	 * highscorePoints[i]=newScore; for(int k=i+1;k<highscorePoints.length;k++) {
	 * int tmp2=highscorePoints[k]; highscorePoints[k]=tmp; tmp=tmp2; } String
	 * temp=highscorePlayers[i]; highscorePlayers[i]=newPlayer; for(int
	 * k=i+1;k<highscorePlayers.length;k++) { String temp2=highscorePlayers[k];
	 * highscorePlayers[k]=temp; temp=temp2; } return; } } } }
	 */
	/*
	 * private void relocate(int toCompare, boolean is30) { if(is30) { for(int i=0;
	 * i<30;i++) { if(temp[i]<toCompare) { int tmp=temp[i]; temp[i]=toCompare;
	 * for(int k=i+1;k<temp.length;k++) { int tmp2=temp[k]; temp[k]=tmp; tmp=tmp2; }
	 * arrange(temp); return; } else { temp[30]=toCompare; arrange(temp); } } } else
	 * { for(int i=0; i<temp.length;i++) { if(temp[i]<toCompare) { int tmp=temp[i];
	 * temp[i]=toCompare; for(int k=i+1;k<temp.length;k++) { int tmp2=temp[k];
	 * temp[k]=tmp; tmp=tmp2; } arrange(temp); return; } else { temp[30]=toCompare;
	 * arrange(temp); }
	 * } } }
	 */
}