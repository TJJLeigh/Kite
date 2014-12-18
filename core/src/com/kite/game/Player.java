package com.kite.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class Player extends GameObject{
	private Texture playertex = new Texture("kite.png");
	private Sprite playersprite = new Sprite(playertex);
	public Vector2 pos;
	public Vector2 getPos(){return new Vector2(pos.x + playersprite.getOriginX(), pos.y + playersprite.getOriginY());}
	private Vector2 vel;
	private float speed;
	private Array<KiteString> strings;
	public Array<KiteString> getStrings() {
		return strings;
		}
	private int stringlength;
	public Sprite getSprite(){
		return playersprite;
	}
	Player(Vector2 p, int stringlen){
		strings = new Array<KiteString>();
		pos = p;
		vel = new Vector2(1,0);
		stringlength = stringlen;
		playersprite.setOriginCenter();
		strings.add(new KiteString(this, getPos()));
		for (int i = 0; i < stringlength;i ++){
			strings.add(new KiteString(strings.get(i), getPos()));
		}
		
	}
	
	
	@Override
	void Update(float dt){
		Vector2 holder = Kite.getViewport().unproject(new Vector2(Gdx.input.getX(), Gdx.input.getY()));
		vel = new Vector2(holder.x-( pos.x + playersprite.getOriginX()), holder.y-(pos.y +playersprite.getOriginY()));
		speed = Math.min(vel.len()*2, 400);
		playersprite.setRotation(vel.angle());
		vel.nor();
		pos.mulAdd(vel, speed*dt);
		for(KiteString st:strings){
			st.Update(dt);
		}
		for(Bird bd: Game.birds){
			if (new Vector2(bd.getPos().x - getPos().x, bd.getPos().y - getPos().y).len() < 128f){
				StateManager.Switch(new GameOver());
			}
		}
	}
	@Override
	void Draw(SpriteBatch batch){
		for (KiteString st:strings){
			st.Draw(batch);
		}
		batch.draw(playersprite, pos.x, pos.y, playersprite.getOriginX(), playersprite.getOriginY(),
				playersprite.getWidth(),playersprite.getHeight(),1,1, playersprite.getRotation() );
		
		
	}
}
