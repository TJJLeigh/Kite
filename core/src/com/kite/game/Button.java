package com.kite.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFont.TextBounds;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Button{
	public Sprite image;
	private BitmapFont font = new BitmapFont();
	private String text ="";
	private Vector2 pos;
	private float Width;
	private float Height;
	
	public Boolean isHidden = false;
	public Boolean hasImage = true;
	public Boolean isString = false;
	
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
	
	Button(BitmapFont b, ButtonEvent e, Vector2 p ){
		this(b,e,"",p);
	}
	Button(BitmapFont b, ButtonEvent e,String i, Vector2 p){
		font = b;
		text = i;
		isHidden = false; 
		isString = true;
		hasImage = false;
		OnPressed = e;
		TextBounds bnds = font.getBounds(i);
		Width = bnds.width;
		Height = bnds.height;	
		pos = p;
	}
	Button(Texture i, ButtonEvent e, float w, float h){
		this(i, new Vector2(0f,0f), e,w,h);
	}
	Button(Texture i, Vector2 p, ButtonEvent e, float w, float h){
		this(i,p,e,w,h,0);
	}
	Button(Texture i, Vector2 p, ButtonEvent e, float w, float h, float scale){
		image = new Sprite(i);
		pos = p;
		OnPressed = e;
		Width = w;
		Height = h;
		isHidden = false;
		image.scale(scale);
		
	}
	public void Hide(){
		isHidden = true;
	}
	public void Show(){
		isHidden = false;
	}
	public void Draw(SpriteBatch batch){
		if (!isHidden){
			if(hasImage){
				//batch.draw(image, pos.x, pos.y);
				batch.draw(image, pos.x, pos.y, image.getOriginX(), image.getOriginY(), image.getWidth(),
						image.getHeight(), image.getScaleX(), image.getScaleY(), image.getRotation());
			}
			if(isString){
				//font.draw(batch, text, pos.x, pos.y);
				font.drawWrapped(batch, text, -360, pos.y, 720, BitmapFont.HAlignment.CENTER);
			}
		}
	}
	
	public void Press(float x, float y){
		
		if (x > pos.x && x < (pos.x + Width) && y < pos.y && y > (pos.y - Height) && isString){
			OnPressed.run();
		}
		if (hasImage){
		if (x > pos.x && x < (pos.x + Width * image.getScaleX()) && y > pos.y && y < (pos.y + Height * image.getScaleY())&& !isString){
			OnPressed.run();
		}}
	}
	
	//Button Event that is run when the button is pressed
	static public abstract class ButtonEvent implements Runnable{

		public abstract void run();
		
	}

	
}
