package com.mygdx.game;

import com.badlogic.gdx.physics.box2d.*;

public class MyContactListener implements ContactListener {

    @Override
    public void beginContact(Contact contact) {
        Fixture fa=contact.getFixtureA();
        Fixture fb=contact.getFixtureB();
        if (fa==null||fb==null)return;
        if(fa.getUserData()==fb.getUserData())
        System.out.println(fa.getBody().getType()+" has hit "+ fb.getBody().getType());
    }

    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}
