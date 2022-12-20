package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.awt.*;

public class Tank extends Sprite {
    public World world;
    public Body b2body;
    BattleArena arena;
    public SpriteBatch batch;
    Sprite sprite;
    Image tank1;
    Stage stage;
    int pl;
    public Tank(BattleArena arena,int player){
        this.arena=arena;
        this.pl=player;
        this.world=arena.getWorld();
        if (player==1){

            tank1=arena.p1tank;
        } else if (player==2) {
            System.out.println("player:2"+pl);
            tank1=arena.p2tank;
        }
        tank1.setSize(50,50);

        stage=new Stage(new ScreenViewport());
        arena.stage.addActor(tank1);

        tankGenerate();
    }
    public void tankGenerate(){
        BodyDef bdef=new BodyDef();
        sprite=new Sprite(new Texture(Gdx.files.internal("Tanks/Abrams.png")));

        sprite.setSize(50f,50f);
        bdef.type=BodyDef.BodyType.DynamicBody;
        if (this.pl==1){

            bdef.position.set(200,600);
        } else if (this.pl==2) {


            bdef.position.set(1900,600);
        }
        b2body=world.createBody(bdef);

        FixtureDef fdef =new FixtureDef();
        CircleShape shape=new CircleShape();
        shape.setRadius(10);
        fdef.shape=shape;
        fdef.friction=0.1f;
//        fdef.
        b2body.createFixture(fdef);
    }
    public void update(){
//        arena.game.batch3.begin();
//        sprite.draw(arena.game.batch3);
//        arena.game.batch3.end();

        tank1.setPosition(b2body.getPosition().x/1.98f,b2body.getPosition().y/1.848f);
        stage.draw();
    }

}
