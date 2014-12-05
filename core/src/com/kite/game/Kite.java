package com.kite.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Timer;



public class Kite extends ApplicationAdapter {
	static OrthographicCamera cam;
	static OrthographicCamera getCamera(){return cam;}
	SpriteBatch batch;
	static Player player;
	static Player getPlayer(){return  player;}
	
	void SpawnBird(){
		while (true){
			Vector2 birdspawn = new Vector2((float)Math.random()*1000,(float)Math.random()*1000);
			if (birdspawn.sub(player.pos).len2() > 62500 ){
				birds.add(new Bird(player, birdspawn));
				break;
				}
			}
		
	}
	Timer.Task birdspawner = new Timer.Task() {
		@Override
		public void run() {
			SpawnBird();
			}
			
	};
	Array<Bird> birds = new Array<Bird>();
	
	
	GameState Current_State = GameState.Game;
	@Override
	public void create () {
		cam = new OrthographicCamera(1000, 800* (Gdx.graphics.getWidth()/Gdx.graphics.getHeight()));
		cam.position.set(500, 500, 0);
		batch = new SpriteBatch();
		player  = new Player(new Vector2(100,100), 15f, 10);
		SpawnBird();
		new Timer().scheduleTask(birdspawner, 3, 3);
	}
	public void Update(float dt){
		switch(Current_State){
			case Mainmenu:
				
			break;
			case Help:
				
			break;
			case Game:
				player.Update(dt);
				for (Bird bird: birds){
					bird.Update(dt);
				}
			break;
			case Pause:
				
			break;
			case GameOver:
				
			break;
		}
			
	}
	@Override
	public void pause(){
		Current_State = GameState.Pause;
		
	}
	@Override
	public void resume(){
		
	}
	@Override
	public void resize(int w, int h){
		cam.viewportHeight = 800*(w/h);
		cam.update();
		
	}
	@Override
	public void render () {
		Update(Gdx.graphics.getDeltaTime());
		cam.update();
		batch.setProjectionMatrix(cam.combined);
		Gdx.gl.glClearColor(.52f,.81f,1f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		
		
		batch.begin();
		
		for (Bird bird: birds){
			bird.Draw(batch);
		}
		
		player.Draw(batch);
		batch.end();
	}
}
