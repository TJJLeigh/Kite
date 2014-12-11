package com.kite.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;



public class Kite extends ApplicationAdapter implements InputProcessor{
	static OrthographicCamera cam;
	static OrthographicCamera getCamera(){return cam;}
	static Viewport viewport;
	static Viewport getViewport(){return viewport;}
	SpriteBatch batch;

	
	static GameState Current_State = GameState.Mainmenu;
	public static GameState getCurrent_State() {
		return Current_State;
	}
	public static void setCurrent_State(GameState current_State) {
		Current_State = current_State;
	}
	@Override
	public void create () {
		Gdx.input.setInputProcessor(this);
		cam = new OrthographicCamera();
		viewport = new FitViewport(720,1280, cam);
		batch = new SpriteBatch();
		MainMenu.Switch();
	}
	public void Update(float dt){
		switch(Current_State){
			case Mainmenu:
				MainMenu.Update(dt);
				MainMenu.Draw(batch);				
			break;
			case Help:
				
			break;
			case Game:
				Game.Update(dt);	
				Game.Draw(batch);
			break;
			case Pause:
				
			break;
			case GameOver:
				GameOver.Update(dt);
				GameOver.Draw(batch);
			break;
		}
			
	}
	@Override
	public void pause(){
		Current_State = GameState.Pause;
		
	}
	@Override
	public void resume(){
		Current_State = GameState.Game;
		
		
	}
	@Override
	public void resize(int w, int h){
		viewport.update(w, h);
	}
	@Override
	public void render () {
		
		cam.update();
		batch.setProjectionMatrix(cam.combined);
		Gdx.gl.glClearColor(.52f,.81f,1f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Update(Gdx.graphics.getDeltaTime());
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
		if (Current_State == GameState.GameOver){
			GameOver.touchDown();
		}else if(Current_State == GameState.Mainmenu){
			MainMenu.touchDown();
		}
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
