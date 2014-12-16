package com.kite.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Timer;

public class Game extends State implements InputProcessor{
	static Player player;
	public static Array<Bird> birds = new Array<Bird>();
	public static Timer birdtimer;
	public static int Score;
	static BitmapFont scorefont;
	static Timer.Task birdspawner = new Timer.Task() {
		@Override
		public void run() {
			SpawnBird();
			}
			
	};
	@Override
	public void OnEnter(){
		player  = new Player(new Vector2(100,100), 60);
		birds = new Array<Bird>();
		SpawnBird();
		try{birdtimer.clear();} catch (NullPointerException e){}
		birdtimer = new Timer();
		birdtimer.scheduleTask(birdspawner, 3, 3);
		scorefont = new BitmapFont(Gdx.files.internal("grunds-b90.fnt"));
	}
	@Override
	public void Update(float dt){
		player.Update(dt);
		for (Bird bird: birds){
			bird.Update(dt);
		}
		
	}
	@Override
	public void Draw(SpriteBatch batch){
		batch.begin();
		for (Bird bird: birds){
			bird.Draw(batch);
		}
		player.Draw(batch);
		batch.end();
		
	
		batch.begin();
		scorefont.draw(batch, Integer.toString(Score), -20, 550);
		batch.end();
		
		
	}
	
	public static void Reset(){
		birdtimer.clear();
		birds = new Array<Bird>();
		Score = 0;
	}
	static void SpawnBird(){
		while (true){
			Vector2 birdspawn = new Vector2((float)Math.random()*720 - 360,(float)Math.random()*1280 - 640);
			if (new Vector2(birdspawn.x-player.getPos().x, birdspawn.y - player.getPos().y).len2() > 250000 ){
				birds.add(new Bird(player, birdspawn, BirdType.RandomBird()));
				break;
				}
			}
		
	}
	@Override
	public boolean keyDown(int keycode) {
		StateManager.Push(new Pause());
		return false;
	}
	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
}
