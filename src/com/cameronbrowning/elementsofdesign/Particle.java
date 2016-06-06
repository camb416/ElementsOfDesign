package com.cameronbrowning.elementsofdesign;

import processing.core.PApplet;

/**
 * Created by cameron.browning on 6/5/16.
 */
public class Particle {


    int c;
    PApplet p; // parent app
    float theta, phi;
    float x,y,z;
    float r, oR;

    float vT,vP,vF;
    float aT,aP,aF;
    float vA, aA;

    float m;


    public Particle(PApplet _p){
        c = (int)(Math.random()*255.0f);
        m = (float)Math.random()*1.0f+0.1f;
        oR = (float)Math.random()*0.0f+200.0f;
        r = 0.0f;
        p = _p;
        theta = p.PI;
        phi = p.random(p.TWO_PI);

        vA = p.random(p.TWO_PI);
        vF = p.random(-0.01f,0.01f);
        vT = p.cos(vA)* vF;
        vP = p.sin(vA)* vF;
        aT = aP = 0;

    }

    public void punch(){
        r += 10.0f/m;
    }

    public void setup(){

    }
    public void update(){

        r += (oR - r)/32.0f;

//         xoff = xoff + 0.01f;
        float n = p.noise(phi*1.0f,theta*1.0f+p.frameCount/100.0f);
        vA = p.map(n,0,1.0f,0,p.TWO_PI);


        vT = p.cos(vA)* vF;
        vP = p.sin(vA) * vF;


        // vT += aT;
        // vP += aP;

        theta += vT;
        phi += vP;


        x = p.cos(theta) * p.sin(phi) * r;
         y = p.sin(theta) * p.sin(phi) * r;
         z = p.cos(phi) * r;
    }
    public void draw(){
        p.pushMatrix();
        p.translate(x,y,z);
        //p.stroke(c,c,c,64);
        p.stroke(c );
        p.point(0,0,0);
        p.popMatrix();
    }
}
