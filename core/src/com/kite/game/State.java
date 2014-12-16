package com.kite.game;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class State implements InputProcessor{
	
	public abstract void Update(float dt);
	public abstract void Draw(SpriteBatch batch);
	public abstract void OnEnter();

}
