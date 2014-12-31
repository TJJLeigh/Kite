package com.kite.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class GameOver extends State implements InputProcessor{
		
	static BitmapFont grundsb36= new BitmapFont(Gdx.files.internal("grunds-b36.fnt"));
	static BitmapFont grundsb90= new BitmapFont(Gdx.files.internal("grunds-b90.fnt"));
	
	
	Button.ButtonEvent GoToMainMenu = new Button.ButtonEvent() {
		
		@Override
		public void run() {
			StateManager.Switch(new MainMenu());
			
		}
	};
	Button.ButtonEvent PlayAgain = new Button.ButtonEvent() {
		@Override
		public void run() {
			StateManager.Switch(new Game());
		}
	};
	private Button MMButton = new Button(grundsb36, GoToMainMenu, "Main Menu", new Vector2(-85,-150));
	private Button AgainButton = new Button(grundsb36, PlayAgain, "Play Again", new Vector2(-85,-75));

	
	public void OnEnter(){
		if (Game.Score > Game.HighScore){
			Game.HighScore = Game.Score;
			Kite.prefs.putInteger("HS", Game.HighScore);
			Kite.prefs.flush();
		}
        Kite.actionResolver.showAds(true);
	}
	public void Update(float dt){
		
	}
	
	public void Draw(SpriteBatch batch){
		batch.begin();
		grundsb90.drawWrapped(batch, "Game Over", -360 ,210, 720, BitmapFont.HAlignment.CENTER);
		grundsb36.drawWrapped(batch, "Your Score: "+Integer.toString(Game.Score), -360, 100, 720, BitmapFont.HAlignment.CENTER);
		grundsb36.drawWrapped(batch, "Highscore: "+Integer.toString(Game.HighScore), -360, 25, 720, BitmapFont.HAlignment.CENTER);
		batch.end();
		batch.begin();
		AgainButton.Draw(batch);
		MMButton.Draw(batch);
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
		Vector2 v = Kite.getViewport().unproject(new Vector2(screenX, screenY));
		AgainButton.Press(v.x, v.y);
		MMButton.Press(v.x, v.y);
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
