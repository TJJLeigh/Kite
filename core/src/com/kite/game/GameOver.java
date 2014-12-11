package com.kite.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameOver {
		
	static BitmapFont go;
	
	public static void OnEnter(){
		go = new BitmapFont(Gdx.files.internal("grunds-b36.fnt"));
	}
	public static void Update(float dt){
		
	}
	public static void Draw(SpriteBatch batch){
		batch.begin();
		go.draw(batch, "Press Anywhere to restart", -200,100);
		batch.end();
	}
	public static void Switch(){
		Kite.setCurrent_State(GameState.GameOver);
		OnEnter();
	}
	public static void touchDown(){
		Game.Reset();
		Game.Switch();
	}
}
