package com.cameronbrowning.elementsofdesign;

import processing.core.PApplet;

/**
 * Created by cameron.browning on 5/19/16.
 */
public class Line {


    private float x,y,r;
    private float x2,y2;
    private float ox,oy;
    private float maxNum;

    PApplet p;
    int f;
    int id;

    Line(PApplet _p){
        p = _p;
        f = 0;
        r = 5;
    }
    public void setUID(int _id){
        id = _id;
    }
    public void setup(float _x,float _y){
        ox = x = _x;
        oy = y = _y;
        r = 5;
    }
    public void setMax(float _maxNum){
        maxNum = _maxNum;
    }
    void setup2(float _x,float _y){
        x2 = _x;
        y2 = _y;

    }
    public void update(int _f){


        int maxLines = (int)maxNum;
        int width = 720;
        f = _f;
        x = ox;
        y = oy;

        float thisAngle = ((id+(float)f)/64.0f)*(float)Math.PI*2.0f/6.0f;
        x2 = ox + (float)Math.cos(thisAngle)*(float)Math.sin(f/32.0f+id)*64.0f;
        y2 =  oy + (float)Math.sin(thisAngle)*(float)Math.sin(f/32.0f+id)*64.0f;



    }
    public void draw(){
        p.stroke(0,0,0,128);
        p.strokeCap(p.SQUARE);
        p.strokeWeight(1);
        p.noFill();
        p.line(x,y,x2,y2);
    }
}
