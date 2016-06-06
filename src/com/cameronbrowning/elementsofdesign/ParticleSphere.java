package com.cameronbrowning.elementsofdesign;

import processing.core.PApplet;

/**
 * Created by cameron.browning on 6/5/16.
 */
public class ParticleSphere {

    int numParticles;
    Particle [] particles;
    PApplet p;

    public ParticleSphere(PApplet _p){
        numParticles = 8192*4;
        p = _p;
        particles = new Particle[numParticles];
        for(int i=0;i<numParticles;i++){
            particles[i] = new Particle(p);
        }

    }
    public void setup(){
        for(int i=0;i<numParticles;i++){
            particles[i].setup();
        }
    }
    public void update(){
        for(int i=0;i<numParticles;i++){
            particles[i].update();
        }
    }
    public void draw(){
        for(int i=0;i<numParticles;i++){
            particles[i].draw();
        }
    }
    public void punch(){
        for(int i=0;i<numParticles;i++){
            particles[i].punch();
        }
    }
}
