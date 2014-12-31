package com.kite.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

public class StateManager {
	private static Array<State> states = new Array<State>();
	public static Array<State> getStates() {
		return states;
	}
	public static void Update(float dt,SpriteBatch batch){

		if (states.size != 0){
		states.peek().Update(dt);
		states.peek().Draw(batch);
		}
	}
	public static void Switch(State state){
		if (states.size != 0){ 
		Pop();
		}
		states.add(state);
		Gdx.input.setInputProcessor(states.peek());
		states.peek().OnEnter();
	}
	public static void Pop(){
		states.pop();
		if (states.size != 0){ 
		Gdx.input.setInputProcessor(states.peek());
		}
	}
	public static void Push(State state){
		states.add(state);
		Gdx.input.setInputProcessor(states.peek());
		
	}
}
