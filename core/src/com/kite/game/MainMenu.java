package com.kite.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class MainMenu {
	static BitmapFont grundsb90;
	static BitmapFont grundsb36;
	static Label.LabelStyle titlestyle;
	static Label title;
	public static void OnEnter(){
		grundsb90 = new BitmapFont(Gdx.files.internal("grunds-b90.fnt"));
		titlestyle = new Label.LabelStyle(grundsb90, Color.WHITE);
	
		
	}
	public static void Update(float dt){
		
	}
	public static void Draw(SpriteBatch batch){
		batch.begin();
		grundsb90.draw(batch, "Kite", -60, 100);
		batch.end();
	}
	public static void Switch(){
		Kite.setCurrent_State(GameState.Mainmenu);
		OnEnter();
	}
	public static void touchDown(){
		Game.Switch();
	}
}
