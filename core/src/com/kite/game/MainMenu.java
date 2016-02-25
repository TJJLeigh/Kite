package com.kite.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class MainMenu extends State implements InputProcessor{
	static BitmapFont grundsb90= new BitmapFont(Gdx.files.internal("grunds-b90.fnt"));
	static BitmapFont grundsb36= new BitmapFont(Gdx.files.internal("grunds-b36.fnt"));
	//Button Events!
	//------------------------------------------------------------
	Button.ButtonEvent GoToGame = new Button.ButtonEvent() {
		
		@Override
		public void run() {
			StateManager.Switch(new Game());
		}
	};
	Button.ButtonEvent GoToHelp = new Button.ButtonEvent() {
		
		@Override
		public void run() {
			StateManager.Push(new Help());
		}
	};
	Button.ButtonEvent GoToCredits = new Button.ButtonEvent() {
		@Override
		public void run() {
			StateManager.Push(new Credits());
		}
	};
	//------------------------------------------------------------
	private Button PlayB = new Button(grundsb36, GoToGame, "Play",new Vector2(-30, 0));
	private Button HelpB = new Button(grundsb36, GoToHelp, "Help",new Vector2(-30, -100));
	private Button CreditsB = new Button(grundsb36, GoToCredits, "Credits",new Vector2(-35, -200));


	@Override
	public void OnEnter(){
        AudioManager.getInstance().killme();
        //Kite.actionResolver.showAds(true);
		//AudioManager.getInstance().playMainMenuMusic();
	}

	@Override
	public void Update(float dt) {

	}
	@Override
	public void Draw(SpriteBatch batch) {
		batch.begin();
		grundsb90.drawWrapped(batch, "Kite", -360, 200, 720, BitmapFont.HAlignment.CENTER);
		PlayB.Draw(batch);
		HelpB.Draw(batch);
		CreditsB.Draw(batch);
		batch.end();
		
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		//StateManager.Switch(new Game());
		//StateManager.Switch(new Help());
		Vector2 v = Kite.getViewport().unproject(new Vector2(screenX, screenY));
		PlayB.Press(v.x, v.y);
		HelpB.Press(v.x, v.y);
		CreditsB.Press(v.x, v.y);
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
