package com.kite.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class Player {
	private Texture playertex = new Texture("kite.png");
	private Sprite playersprite = new Sprite(playertex);
	public Vector2 pos;
	private Vector2 vel;
	private float speed;
	private int stringlength;
	private float rot;
	public Sprite getSprite(){
		return playersprite;
	}
	Player(Vector2 p, float r, int stringlen){
		pos = p;
		rot = r;
		vel = new Vector2(1,0);
		stringlength = stringlen;
		//playersprite.setSize(100,100);
		playersprite.setOriginCenter();
		
	}
	void Update(float dt){
		Vector3 holder = Kite.getCamera().unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));
		playersprite.setRotation(new Vector2(holder.x- pos.x, holder.y-pos.y).angle());
		speed = Math.max((new Vector2().setAngle(playersprite.getRotation()).len()*2), 260);
		vel.setAngle(playersprite.getRotation());
		vel.nor();
		System.out.println(vel.toString());
		pos.mulAdd(vel, speed*dt);
		System.out.println(pos.toString());
		
		
	}
	void Draw(SpriteBatch batch){
		batch.draw(playersprite, pos.x, pos.y, playersprite.getOriginX(), playersprite.getOriginY(),
				playersprite.getWidth(),playersprite.getHeight(),1,1, playersprite.getRotation() );
		
	}
}
