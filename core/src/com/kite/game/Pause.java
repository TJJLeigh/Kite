package com.kite.game;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Pause extends State implements InputProcessor {
	//TODO: Birds still spawn when game is paused
	@Override
	public void Update(float dt) {
		

	}

	@Override
	public void Draw(SpriteBatch batch) {
		

	}

	@Override
	public void OnEnter() {
	

	}
	@Override
	public boolean keyDown(int keycode) {
		StateManager.Pop();
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
	
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		System.out.println(screenX+","+screenY);
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		
		return false;
	}

	

}
