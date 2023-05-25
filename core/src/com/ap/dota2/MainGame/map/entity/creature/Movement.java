package com.ap.dota2.MainGame.map.entity.creature;

import com.ap.dota2.MainGame.standards.Direction;
import com.badlogic.gdx.Input;

public class Movement extends Thread {
	private Hero hero;
	public int Xtarget;
	public int Ytarget;

	public Movement (Hero hero) {
		this.hero = hero;
		this.Xtarget = hero.getPosition().getX();
		this.Ytarget = hero.getPosition().getY();
	}

	private Direction Xdir (int x) { return x > 0 ? Direction.DOWN : Direction.UP; }
	private Direction Ydir (int y) { return y > 0 ? Direction.RIGHT : Direction.LEFT; }
	private int InputKeys (Direction dir) {
		if (dir == Direction.DOWN) return Input.Keys.DOWN;
		else if (dir == Direction.LEFT) return Input.Keys.LEFT;
		else if (dir == Direction.RIGHT) return Input.Keys.RIGHT;
		else return Input.Keys.UP;
	}

	@Override
	public void run () {
		while (true) {
			int dx = hero.getPosition().getX() - Xtarget;
			if (dx != 0) hero.keyDown(InputKeys(Xdir(dx)));
			int dy = hero.getPosition().getY() - Ytarget;
			if (dy != 0) hero.keyDown(InputKeys(Ydir(dy)));
			try {
				Thread.sleep(10);
			} catch (Exception e) { e.printStackTrace(); }
		}
	}
}
