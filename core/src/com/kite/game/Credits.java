package com.kite.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Credits extends State {
    BitmapFont ruletext = new BitmapFont(Gdx.files.internal("grunds-b36.fnt"));
    Button.ButtonEvent Back = new Button.ButtonEvent() {

        @Override
        public void run() {
            StateManager.Pop();
        }
    };
    Button BackButton = new Button(ruletext, Back, "Back", new Vector2(-30, -300));
    @Override
    public void Update(float dt) {

    }

    @Override
    public void Draw(SpriteBatch batch) {
        batch.begin();
        ruletext.draw(batch, "Code and Art done by Terence Leigh", -290, 200);
        ruletext.draw(batch, "Bird Sounds taken from", -190, 100);
        ruletext.draw(batch, "http://www.freesfx.co.uk", -195, 0);
        ruletext.draw(batch, "Music by Stefan Vladusic", -190, -100);
        BackButton.Draw(batch);
        batch.end();
    }

    @Override
    public void OnEnter() {

    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        Vector2 v = Kite.getViewport().unproject(new Vector2(screenX, screenY));
        BackButton.Press(v.x, v.y);
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
