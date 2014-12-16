package com.kite.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class MainMenu extends State implements InputProcessor{
	static BitmapFont grundsb90;
	static BitmapFont grundsb36;
	static Label.LabelStyle titlestyle;
	static Label title;
	@Override
	public void OnEnter(){
		grundsb90 = new BitmapFont(Gdx.files.internal("grunds-b90.fnt"));
		titlestyle = new Label.LabelStyle(grundsb90, Color.WHITE);	
	}

	public void touchDown(){
		StateManager.Switch(new Game());
	}
	@Override
	public void Update(float dt) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void Draw(SpriteBatch batch) {
		// TODO Auto-generated method stub
		batch.begin();
		grundsb90.draw(batch, "Kite", -60, 100);
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
		StateManager.Switch(new Game());
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
