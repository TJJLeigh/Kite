package com.kite.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;



public class Bird extends GameObject{
	private Texture birdtex = new Texture("bird.png");
	public Sprite birdsprite = new Sprite(birdtex);
	private BirdType type;
	private Player target;
	public Vector2 pos;
	public Vector2 getPos(){return new Vector2(pos.x + birdsprite.getOriginX(), pos.y + birdsprite.getOriginY());}
	public Body body;
	private float Speed = 100;
	
	public float getSpeed() {
		return Speed;
	}
	Bird(Player t, Vector2 p, BirdType b){
		target = t;
		pos = p;
		type = b;
		birdsprite.setOriginCenter();
		birdsprite.setColor(b.getColor());
		Speed = type.getSpeed();
		
		
	}
	Bird(Player t, Vector2 p){
		this(t,p, BirdType.Normal);
	}
	Bird(Player t){
		this(t, new Vector2(0,0));
	}
	@Override
	public void Update(float dt){
		Vector2 vel = new Vector2(target.pos.x - pos.x, target.pos.y- pos.y);
		birdsprite.setRotation(vel.angle());
		vel.nor();
		pos.mulAdd(vel, Speed*dt);
		for(KiteString st:target.getStrings()){
			if (new Vector2(st.getPos().x - getPos().x, st.getPos().y - getPos().y).len() < 68f){
				Game.birds.removeValue(this, true);
				Game.Score++;
				AudioManager.getInstance().birdDeath();
				break;
			}
		}
		
	}
	@Override
	public void Draw(SpriteBatch batch){
		batch.setColor(type.getColor());
		batch.draw(birdsprite, pos.x,pos.y, birdsprite.getOriginX(),birdsprite.getOriginY(),
				birdsprite.getWidth(), birdsprite.getHeight(), .5f,.5f, birdsprite.getRotation());
		batch.setColor(Color.WHITE);
	}
}
