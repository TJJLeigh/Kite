package com.kite.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Button{
	private Texture image;
	private Vector2 pos;
	private float Width;
	private float Height;
	public Boolean isHidden;
	private ButtonEvent OnPressed;
	
	public Vector2 getPos() {
		return pos;
	}
	public float getWidth() {
		return Width;
	}
	public float getHeight() {
		return Height;
	}

	Button(Texture i, ButtonEvent e, float w, float h){
		this(i, new Vector2(0f,0f), e,w,h);
	}
	Button(Texture i, Vector2 p, ButtonEvent e, float w, float h){
		image = i;
		pos = p;
		OnPressed = e;
		Width = w;
		Height = h;
		isHidden = false;
	}
	public void Hide(){
		isHidden = true;
	}
	public void Show(){
		isHidden = false;
	}
	public void Draw(SpriteBatch batch){
		if (!isHidden){
		batch.draw(image, pos.x, pos.y);
		}
	}
	
	public void Press(float x, float y){
		if (x > pos.x && x < (pos.x + Width) && y > pos.y && y < (pos.y + Height)){
			OnPressed.run();
		}
	}
	
	//Button Event that is run when the button is pressed
	static public abstract class ButtonEvent implements Runnable{

		public abstract void run();
		
	}

	
}
