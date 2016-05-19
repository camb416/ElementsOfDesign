package com.cameronbrowning.elementsofdesign;
import processing.core.PApplet;
/**
 * Created by cam on 5/18/16.
 */
public class Dot{

    private float x,y,r;

    PApplet p;
    int f;
    int id;

    Dot(PApplet _p){
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
    }
    public void update(int _f){
        f = _f;
        x = (float)Math.cos((float)id/2.0f+f)*id/2048.0f*340;
        y = (float)Math.sin((float)id/2.0f+f)*id/4096.0f*340 + (float)Math.sin(((float)f*5.0f+(float)id/2.0f)/100.0f)*(2048-id)/32.0f;
        r = 10.0f-(float)id/2048.0f*10.0f;
    }
    public void draw(){
        p.noStroke();
        p.fill(0);
        p.ellipse(x,y,r,r);
    }
}
