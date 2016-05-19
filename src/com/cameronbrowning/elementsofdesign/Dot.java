package com.cameronbrowning.elementsofdesign;
import processing.core.PApplet;
/**
 * Created by cam on 5/18/16.
 */
public class Dot{

    private float x,y,r;

    PApplet p;

    Dot(PApplet _p){
        p = _p;
    }
    public void setup(float _x,float _y){
        x = _x;
        y = _y;
        r = 5;
    }
    public void update(){

    }
    public void draw(){
        p.noStroke();
        p.fill(0);
        p.ellipse(x,y,r,r);
    }
}
