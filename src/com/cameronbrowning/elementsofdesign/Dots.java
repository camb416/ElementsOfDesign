package com.cameronbrowning.elementsofdesign;
import processing.core.PApplet;
/**
 * Created by cam on 5/18/16.
 */
public class Dots{

    Dot[] dots;
    PApplet p;

    Dots(PApplet _p){
        p = _p;
        dots = new Dot[64];
        for(int i=0;i<64;i++){
            dots[i] = new Dot(p);
        }
    }
    public void setup(){
        // setup code here
        for(int i=0;i<64;i++){
            Dot d = dots[i];
            d.setup(i*10,i*10);
        }
    }
    public void update(){
        // update code here
        for(int i=0;i<64;i++){
            Dot d = dots[i];
            d.update();
        }
    }
    public void draw(){
        // draw code here
        for(int i=0;i<64;i++){
            Dot d = dots[i];
            d.draw();
        }
    }

}
