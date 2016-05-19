package com.cameronbrowning.elementsofdesign;
import processing.core.PApplet;


/**
 * Created by cameron.browning on 5/3/16.
 */
public class app extends PApplet {

    Dots dapp;

    public void settings(){
        size(720,720);
    }

    public void setup(){
        dapp = new Dots(this);
        background(255);
        dapp.setup();
    }
    public void draw(){
        background(255);
        dapp.update();
        dapp.draw();
        // saveFrame();
//        stroke(0);
  //      line(random(width), random(height),random(width), random(height));
    }

}