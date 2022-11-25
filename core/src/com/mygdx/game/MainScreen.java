package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Button;

import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.awt.*;

public class MainScreen implements Screen {
    TankStars game;
    OrthographicCamera camera;
    Sprite sprite;
    Stage stage;

    Viewport viewport;
    final float GAME_WIDTH= 192;
    final float GAME_HEIGHT= 100;
    private Skin skin;
    public MainScreen(final TankStars game){
        this.game=game;
        sprite=new Sprite(new Texture(Gdx.files.internal("MainScreen - Copy.jpg")));
        sprite.setPosition(0,0);
        sprite.setSize(GAME_WIDTH,GAME_HEIGHT);
        stage=new Stage(new ScreenViewport());

//        float aspectRatio=(float)Gdx.graphics.getHeight()/(float)Gdx.graphics.getWidth();
        camera = new OrthographicCamera();
        viewport=new StretchViewport(GAME_WIDTH,GAME_HEIGHT,camera);
//        viewport=new ScreenViewport();
        viewport.apply();
//        camera.setToOrtho(false,800,400);
        camera.position.set(GAME_WIDTH/2,GAME_HEIGHT/2,0);
        skin=new Skin(Gdx.files.internal("skin/glassy-ui.json"));
        Button vsfriend=new TextButton("Vs friend",skin,"small");
        vsfriend.setSize(150,50);
        vsfriend.setPosition(760,400);
        vsfriend.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event,float x,float y){
                game.setScreen(new ChooseTankVSfriend(game));
            }
        });

        Button vscomp=new TextButton("VS COMPUTER",skin,"small");
        vscomp.setSize(150,50);
        vscomp.setPosition(760,300);
        vscomp.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event,float x,float y){
                game.setScreen(new ChooseTankVScomp(game));
            }
        });

        Button savedgames=new TextButton("SAVED\nGAMES",skin,"small");
        savedgames.setSize(150,50);
        savedgames.setPosition(760,200);
        savedgames.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event,float x,float y){
                System.out.println("Saved Games");
                game.setScreen(new Savedgames(game));
            }
        });

        ImageButton setting=new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("setting.png")))));
        setting.setSize(60,60);
        setting.setPosition(32,525);
//        stage=new Stage(viewport);
        stage.addActor(vsfriend);
        stage.addActor(vscomp);
        stage.addActor(setting);
        stage.addActor(savedgames);
        Gdx.input.setInputProcessor(stage);



    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0,0,0.2f,1);
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        sprite.draw(game.batch);
        game.batch.end();
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
//        update(delta);

    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width,height);
        camera.position.set(GAME_WIDTH/2,GAME_HEIGHT/2,0);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        sprite.getTexture().dispose();

    }
}
