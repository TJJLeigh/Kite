package com.kite.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Pause extends State implements InputProcessor {
	BitmapFont pausedfont = new BitmapFont(Gdx.files.internal("grunds-b90.fnt"));
	Texture PlayButtonImage = new Texture("play.png");
	Button.ButtonEvent PlayEvent = new Button.ButtonEvent() {
		@Override
		public void run() {
			StateManager.Pop();
			Game.ResumeTimer();
		}
	};
	Button PlayButton = new Button(PlayButtonImage, new Vector2(-360f, 640f - PlayButtonImage.getHeight()), PlayEvent,
			PlayButtonImage.getWidth(), PlayButtonImage.getHeight(), -0.1f);
	
	
	@Override
	public void Update(float dt) {
		

	}

	@Override
	public void Draw(SpriteBatch batch) {
		StateManager.getStates().first().Draw(batch);
		batch.begin();
		PlayButton.Draw(batch);
		batch.end();
		batch.begin();
		pausedfont.draw(batch, "Paused", -120, 100);
		batch.end();

	}
	 
	@Override
	public void OnEnter() {
		PlayButton.image.scale(-0.1f);
	}
	
	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		Vector2 v = Kite.getViewport().unproject(new Vector2(screenX, screenY));
		PlayButton.Press(v.x, v.y);
		return false;
	}
	
	//Here there be useless functions
	@Override
	public boolean keyDown(int keycode) {
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
