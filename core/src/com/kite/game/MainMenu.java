package com.kite.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class MainMenu extends State implements InputProcessor{
	static BitmapFont grundsb90= new BitmapFont(Gdx.files.internal("grunds-b90.fnt"));
	static BitmapFont grundsb36= new BitmapFont(Gdx.files.internal("grunds-b36.fnt"));
	static Label.LabelStyle titlestyle;
	static Label title;
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
	//------------------------------------------------------------
	private Button PlayB = new Button(grundsb36, GoToGame, "Play",new Vector2(-30, -100));
	private Button HelpB = new Button(grundsb36, GoToHelp, "Help",new Vector2(-30, -200));

	@Override
	public void OnEnter(){
		
		titlestyle = new Label.LabelStyle(grundsb90, Color.WHITE);	
	}

	@Override
	public void Update(float dt) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void Draw(SpriteBatch batch) {
		// TODO Auto-generated method stub
		batch.begin();
		grundsb90.drawWrapped(batch, "Kite", -360, 100, 720, BitmapFont.HAlignment.CENTER);
		PlayB.Draw(batch);
		HelpB.Draw(batch);
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
