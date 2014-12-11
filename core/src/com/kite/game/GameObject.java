package com.kite.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public abstract class GameObject {
	private Vector2 pos;
	public Vector2 getPos(){return pos;}
	abstract void Update(float dt);
	abstract void Draw(SpriteBatch batch);

}
