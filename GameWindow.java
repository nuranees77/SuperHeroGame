package Downasour;

import java.sql.SQLException;

import javax.swing.JFrame;

//import util.MySQLAccess;

@SuppressWarnings("serial")
public class GameWindow extends JFrame {
	
	public static final int SCREEN_WIDTH = 700;
	private GameScreen gameScreen;

	
	public GameWindow() {
		super("Super Hero Game");
		setSize(SCREEN_WIDTH, 290);
		setLocation(400, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		
		gameScreen = new GameScreen();
		addKeyListener(gameScreen);
		add(gameScreen);
	}
	
	public void startGame() {
		setVisible(true);
		gameScreen.startGame(); 
	}
	
	public static void main(String args[]) throws ClassNotFoundException {
		(new GameWindow()).startGame();
		
		 MySQLAccess db=new MySQLAccess();
		 
		  try {
				db.readData();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
}
