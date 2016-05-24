package com.cameronbrowning.elementsofdesign;

import processing.core.PApplet;

/**
 * Created by cameron.browning on 5/23/16.
 */
public class Shape {


    private float x,y,r;
    int maxNum;

    PApplet p;
    int f;
    int id;
    float rotation;

    Shape(PApplet _p){
        p = _p;
        f = 0;
        r = 5;
    }
    public void setUID(int _id){
        id = _id;
    }
    public void setup(float _x,float _y){
        x = _x;
        y = _y;
        r = 5;
        rotation = 0;
    }
    public void setSize(float _r){
        r = _r;
    }
    public void setMax(float _maxNum){
        maxNum = (int)_maxNum;
    }

    public void update(int _f){


        f = _f;





    }
    public void setRotation(float _r){
        rotation = _r;
    }
    public void draw(){
        p.rotate((float)Math.PI,0,1,0);
        p.pushMatrix();

    p.rotate(rotation,(float)id/(float)maxNum+(float)Math.sin(f)/2.0f,1,0);

        p.noStroke();
        p.fill(0);
        p.rect(x-r/2,y-r/2,r,r);
        p.popMatrix();

    }
}
