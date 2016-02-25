package com.kite.game;

import com.badlogic.gdx.Audio;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

import java.util.HashMap;

public class AudioManager {
    private static AudioManager instance = new AudioManager();
    private Music ambientWind = Gdx.audio.newMusic(Gdx.files.internal("audio/wind.mp3"));
    //private Music mainMenuSong = Gdx.audio.newMusic(Gdx.files.internal("audio/mainmenuSong.mp3"));
    private Sound[] birdDeath = {
            Gdx.audio.newSound(Gdx.files.internal("audio/bird_death_1.mp3")),
            Gdx.audio.newSound(Gdx.files.internal("audio/bird_death_2.mp3")),
            Gdx.audio.newSound(Gdx.files.internal("audio/bird_death_3.mp3")),
            Gdx.audio.newSound(Gdx.files.internal("audio/bird_death_4.mp3"))
    };


    public static AudioManager getInstance() {
        return instance;
    }

    private AudioManager() {
        ambientWind.setLooping(true);
        ambientWind.setVolume(2f);
        //mainMenuSong.setLooping(true);
    }
    // fuck libgdx for loading files strangely
    public void birdDeath(){
       birdDeath[(int)(Math.random()*3)].play(1f);
    }
    public void playMainMenuMusic(){
       // mainMenuSong.play();
    }
    public void playAmbientWind(){
        ambientWind.play();
    }
    public void killme(){
        //if(mainMenuSong.isPlaying()){
        //    mainMenuSong.stop();
        //}
        if(ambientWind.isPlaying()){
            ambientWind.stop();
        }
    }

}
