package com.kite.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Timer;

public class Game extends State implements InputProcessor{
	static Player player;
	static public Array<Bird> birds = new Array<Bird>();
	static Timer birdtimer;
	public static int Score;
	public static int HighScore;
	static BitmapFont scorefont;
	Texture PauseButtonImage = new Texture("pause.png");
	static private Button PauseButton;
	Button.ButtonEvent  PauseEvent = new Button.ButtonEvent(){
		@Override
		public void run(){
			StateManager.Push(new Pause());
			PauseTimer();
            Kite.actionResolver.showAds(true);
		}
	};
	static Timer.Task birdspawner = new Timer.Task() {
		@Override
		public void run() {
			SpawnBird();
			}
			
	};
	@Override
	public void OnEnter(){
		Score = 0;
		player  = new Player(new Vector2(0,0), 60);
		birds = new Array<Bird>();
		SpawnBird();
		try{birdtimer.clear();} catch (NullPointerException e){
			//Catches exception when this is run for the first time when switched into
		}
		birdtimer = new Timer();
		birdtimer.scheduleTask(birdspawner, 3, 3);
		scorefont = new BitmapFont(Gdx.files.internal("grunds-b90.fnt"));
		PauseButton = new Button(PauseButtonImage, new Vector2(-360f, 640f-PauseButtonImage.getHeight()), 
				PauseEvent, PauseButtonImage.getWidth(), PauseButtonImage.getHeight());
		PauseButton.image.scale(-0.1f);
		HighScore = Kite.prefs.getInteger("HS");
        Kite.actionResolver.showAds(false);
	}
	@Override
	public void Update(float dt){
		if (PauseButton.isHidden){
			PauseButton.Show();
		}
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
		PauseButton.Draw(batch);
		batch.end();
		
	
		batch.begin();
		scorefont.drawWrapped(batch, Integer.toString(Score), -360, 640 - scorefont.getXHeight(), 720, BitmapFont.HAlignment.CENTER);
		batch.end();
		
		
	}
	public static void HideButton(){
		PauseButton.Hide();
	}

	static void SpawnBird(){
        for (int i = 0; i < (Score/10)+1; i++) {
            while (true) {

                Vector2 birdspawn = new Vector2((float) Math.random() * 720 - 360, (float) Math.random() * 1280 - 640);
                if (new Vector2(birdspawn.x - player.getPos().x, birdspawn.y - player.getPos().y).len2() > 250000) {
                    birds.add(new Bird(player, birdspawn, BirdType.RandomBird()));
                    break;
                }
            }
        }
	}
	public static void ResumeTimer(){
		birdtimer.scheduleTask(birdspawner,3f,3f);
	}
	public static void PauseTimer(){
		birdtimer.clear();
	}
	@Override
	public boolean keyDown(int keycode) {
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
		Vector2 v = Kite.getViewport().unproject(new Vector2(screenX, screenY));
		PauseButton.Press(v.x, v.y);
		PauseButton.Hide();
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
