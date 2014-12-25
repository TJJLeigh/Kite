package com.kite.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;



public class Kite extends ApplicationAdapter{
	static OrthographicCamera cam;
	static OrthographicCamera getCamera(){return cam;}
	static Viewport viewport;
	static Viewport getViewport(){return viewport;}
	public static Preferences prefs;
	SpriteBatch batch;

	
	@Override
	public void create () {
		cam = new OrthographicCamera();
		viewport = new FitViewport(720,1280, cam);
		batch = new SpriteBatch();
		StateManager.Switch(new MainMenu());
		prefs= Gdx.app.getPreferences("HighScore");
		

	}

	@Override
	public void pause(){
		if (StateManager.getStates().peek().getClass() == Game.class){
		Game.HideButton();
		Game.PauseTimer();
		StateManager.Push(new Pause());
		}
	}
	@Override
	public void resume(){
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
		StateManager.Update(Gdx.graphics.getDeltaTime(), batch);
	}
	@Override
	public void dispose(){
		System.gc();
	}
	}