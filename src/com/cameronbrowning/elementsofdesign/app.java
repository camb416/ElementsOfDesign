package com.cameronbrowning.elementsofdesign;
import processing.core.PApplet;


/**
 * Created by cameron.browning on 5/3/16.
 */
public class app extends PApplet {

    Lines app;

    public void settings(){
        size(720,720);

    }

    public void setup(){
        frameRate(60);
        app = new Lines(this);
        background(255);
        app.setup();
    }
    public void draw(){
        background(255);
        app.update();
        app.draw();
        saveFrame();
//        stroke(0);
  //      line(random(width), random(height),random(width), random(height));
    }

}