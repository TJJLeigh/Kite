package com.kite.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Help extends State {
	BitmapFont ruletext = new BitmapFont(Gdx.files.internal("grunds-b36.fnt"));
	Button.ButtonEvent Back = new Button.ButtonEvent() {
		
		@Override
		public void run() {
			StateManager.Pop();
		}
	};
	Button BackButton = new Button(ruletext, Back, "Back", new Vector2(-30, -300));
	@Override
	public void Update(float dt) {

	}

	@Override
	public void Draw(SpriteBatch batch) {
		batch.begin();
		ruletext.draw(batch, "The String kills the birds", -200, 100);
		ruletext.draw(batch, "The Kite follows your finger", -210, 0);
		BackButton.Draw(batch);
		batch.end();

	}

	@Override
	public void OnEnter() {
		// TODO Auto-generated method stub

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
		Vector2 v = Kite.getViewport().unproject(new Vector2(screenX, screenY));
		BackButton.Press(v.x, v.y);
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
