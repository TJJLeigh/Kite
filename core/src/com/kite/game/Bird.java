package com.kite.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;



public class Bird {
	private Texture birdtex = new Texture("bird.png");
	public Sprite birdsprite = new Sprite(birdtex);
	
	//Sprite getSprite(){return birdsprite;}
	private Player target;
	public Vector2 pos;
	private Vector2 vel;
	
	Bird(Player t, Vector2 p){
		pos = p;
		target = t;
		birdsprite.setOriginCenter();
	}
	Bird(Player t){
		pos = new Vector2(0,0);
		target = t;
	}
	public void Update(float dt){
		
		birdsprite.setRotation(new Vector2(target.pos.x - pos.x, target.pos.y- pos.y).angle());
		//birdsprite.rotate(1f);
		//System.out.println(Float.toString(birdsprite.getRotation()));
		
	}
	public void Draw(SpriteBatch batch){
		batch.draw(birdsprite, pos.x,pos.y, birdsprite.getOriginX(),birdsprite.getOriginY(),
				birdsprite.getWidth(), birdsprite.getHeight(), 1,1, birdsprite.getRotation());
	}
}
