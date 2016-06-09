package com.cameronbrowning.elementsofdesign;

import processing.core.PApplet;

/**
 * Created by cameron.browning on 6/8/16.
 */
public class Point3D {

    float x,y,z;
    float phi,theta;
    PApplet p;
    float r;

    Point3D(PApplet _p){
        p = _p;
        r = 200;
    }

    public void setup(){
        this.setup(p.random(p.TWO_PI),p.random(p.TWO_PI), 200);
    }

    public void setup(float _theta, float _phi, float _r){
        theta = _theta;
        phi = _phi;
        r = _r;
    }

    public void update(){

        x = p.cos(theta) * p.sin(phi) * r;
        y = p.sin(theta) * p.sin(phi) * r;
        z = p.cos(phi) * r;
    }
    public void draw(){
        p.pushMatrix();
        p.translate(x,y,z);
        p.noFill();
        p.stroke(0);
        p.point(0,0,0);
        p.popMatrix();
    }
    public void drawSphere(float _r){
        p.pushMatrix();
        p.translate(x,y,z);
        p.noFill();
        p.stroke(0);
        p.sphere(_r);
        p.popMatrix();
    }

}
