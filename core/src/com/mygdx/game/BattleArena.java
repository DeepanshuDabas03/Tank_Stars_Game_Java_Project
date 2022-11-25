package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class BattleArena implements Screen {

    TankStars game;
    OrthographicCamera camera;
    Sprite sprite;
    Stage stage;
    static Image p1tank = null;
    static Image p2tank=null;




    Viewport viewport;
    final float GAME_WIDTH= 192;
    final float GAME_HEIGHT= 100;
    private Skin skin;

    public BattleArena(TankStars game, int mode) {
        this.game = game;
        sprite=new Sprite(new Texture(Gdx.files.internal("BlueNight.png")));
        sprite.setPosition(0,0);
        sprite.setSize(GAME_WIDTH,GAME_HEIGHT);
        Image terrain =new Image(new Texture(Gdx.files.internal("terrain.png")));
        terrain.setPosition(-10f,0f);
        terrain.setSize(1200,600f);
        stage=new Stage(new ScreenViewport());

        Gdx.input.setInputProcessor(stage);

//        float aspectRatio=(float)Gdx.graphics.getHeight()/(float)Gdx.graphics.getWidth();
        camera = new OrthographicCamera();
        viewport=new StretchViewport(GAME_WIDTH,GAME_HEIGHT,camera);
//        viewport=new ScreenViewport();
        viewport.apply();

//        camera.setToOrtho(false,800,400);
        camera.position.set(GAME_WIDTH/2,GAME_HEIGHT/2,0);
        skin=new Skin(Gdx.files.internal("skin/glassy-ui.json"));

        Image menu =new Image(new Texture(Gdx.files.internal("menu.png")));
        menu.setSize(60,60);
        menu.setPosition(32,525);

//        Adding tanks
//        if (mode==1){
//
//            vsfriendTanks(new ChooseTankVSfriend(game));
//        }
//        else vscompTanks(new ChooseTankVScomp(game));

        stage.addActor(terrain);
//        stage.addActor(this.p1tank);
//        stage.addActor(this.p2tank);
        stage.addActor(menu);

    }

    @Override
    public void show() {

    }
    public void vsfriendTanks(ChooseTankVSfriend option){
        if (option.tank1==1){
            this.p1tank=new Image(new Texture("Tanks/Abrams.png"));
        } else if (option.tank1==2) {
            this.p1tank=new Image(new Texture("Tanks/Frost.png"));

        } else if (option.tank1==3) {
            this.p1tank=new Image(new Texture("Tanks/Coalition.png"));
        }
        this.p1tank.setSize(200f,100f);
        this.p1tank.setPosition(300f,300f);

        if (option.tank2==1){
            this.p2tank=new Image(new Texture("Tanks/Abrams2.png"));
        } else if (option.tank2==2) {
            this.p2tank=new Image(new Texture("Tanks/Frost2.png"));

        } else if (option.tank2==3) {
            this.p2tank=new Image(new Texture("Tanks/Coalition2.png"));
        }
        this.p2tank.setSize(200f,100f);
        this.p2tank.setPosition(900f,300f);



    }
    public static void vscompTanks(ChooseTankVScomp option){
        if (option.tank1==1){
            p1tank=new Image(new Texture("Tanks/Abrams.png"));
        } else if (option.tank1==2) {
            p1tank=new Image(new Texture("Tanks/Frost.png"));

        } else if (option.tank1==3) {
            p1tank=new Image(new Texture("Tanks/Coalition.png"));
        }
        p1tank.setSize(200f,100f);
        p1tank.setPosition(300f,300f);

        if (option.tank2==1){
            p2tank=new Image(new Texture("Tanks/Abrams2.png"));
        } else if (option.tank2==2) {
            p2tank=new Image(new Texture("Tanks/Frost2.png"));

        } else if (option.tank2==3) {
            p2tank=new Image(new Texture("Tanks/Coalition2.png"));
        }
        p2tank.setSize(200f,100f);
        p2tank.setPosition(900f,300f);



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
