package Downasour;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//import util.Resource;

public class EnemiesManager {
	
	private BufferedImage klcc;
	private BufferedImage kltower;  
	private Random rand;
	
	private List<Enemy> enemies;
	private MainCharacter mainCharacter;
	
	public EnemiesManager(MainCharacter mainCharacter) {
		rand = new Random();
		klcc = Resource.getResouceImage("data/klcc1.png");
		kltower = Resource.getResouceImage("data/kl tower1.png");
		enemies = new ArrayList<Enemy>();
		this.mainCharacter = mainCharacter;
		enemies.add(createEnemy());
	}
	
	public void update() throws SQLException {
		for(Enemy e : enemies) {
			e.update();
		}
		Enemy enemy = enemies.get(0);
		if(enemy.isOutOfScreen()) {
			mainCharacter.upScore();
			enemies.clear();
			enemies.add(createEnemy());
		}
	}
	
	public void draw(Graphics g) {
		for(Enemy e : enemies) {
			e.draw(g);
		}
	}
	
	private Enemy createEnemy() {
		// if (enemyType = getRandom)
		int type = rand.nextInt(2);
		if(type == 0) {
			return new Building(mainCharacter, 800, klcc.getWidth() - 10, klcc.getHeight() - 10, klcc);
		} else {
			return new Building(mainCharacter, 800, kltower.getWidth() - 10, kltower.getHeight() - 10, kltower);
		}
	}
	
	public boolean isCollision() {
		for(Enemy e : enemies) {
			if (mainCharacter.getBound().intersects(e.getBound())) {
				return true;
			}
		}
		return false;
	}
	
	public void reset() {
		enemies.clear();
		enemies.add(createEnemy());
	}
	
}
