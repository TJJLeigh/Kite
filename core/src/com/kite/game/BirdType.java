package com.kite.game;

import com.badlogic.gdx.graphics.Color;

public enum BirdType {
	Faste(600f, Color.PURPLE),
	Fast(400f, Color.RED),
	Normal(350f, Color.WHITE),
	Slow(250f,Color.BLUE),
	Slower(200f, Color.OLIVE);
	
	private float speed;
	private Color color;
	
	public Color getColor() {
		return color;
	}
	public float getSpeed() {
		return speed;
	}


	BirdType(float spd, Color c){
		speed = spd;
		color = c;
	}
	public static BirdType RandomBird(){
		int a = (int) Math.round(Math.random()*4);
		return BirdType.values()[a];
	}

}
