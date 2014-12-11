package com.kite.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class KiteString extends GameObject{
	private Texture stringtex = new Texture("string.png");
	private Sprite stringsprite = new Sprite(stringtex);
	private GameObject target;
	private Vector2 pos;
	private Vector2 nextpos;
	public Vector2 getPos(){return pos;}
	
	KiteString(GameObject t, Vector2 p){
		target = t;
		pos = p;
		nextpos = t.getPos();
		stringsprite.setOriginCenter();

	}
	KiteString(GameObject t){
		this(t, t.getPos());
	}
	@Override
	public void Update(float dt){
		

		pos = nextpos;
		
		nextpos = target.getPos();
		
		
	}
	@Override
	public void Draw(SpriteBatch batch){
		batch.setColor(Color.BLACK);
		batch.draw(stringsprite, pos.x,pos.y);
		batch.setColor(Color.WHITE);
	}

}
