package com.cameronbrowning.elementsofdesign;
import processing.core.PApplet;


/**
 * Created by cameron.browning on 5/3/16.
 */
public class app extends PApplet {

    SphereWrap [] wraps;
    int numWraps = 16;

    boolean saveFrames;

    float rotateX;
    float rotateY;

    public void settings(){
        size(720,720,P3D);
        saveFrames = false;
        smooth(8);

    }

    public void setup(){

        wraps = new SphereWrap[numWraps];

        frameRate(60);
for(int i=0;i<numWraps;i++){
    wraps[i] = new SphereWrap(this);
    wraps[i].setup(random(PI),
            (random(-10.0f,10.0f))/100.0f, // angle speed
            random(10.0f),
            (float)i/(float)numWraps*2.0f+ 3.0f, // radius multiplier
            random(100.0f,100.0f),
            random(0.5f,0.7f) // spinspeed
             );
}



        background(255);

    }
    public void draw(){
        background(255);


            rotateX = sin((float)frameCount/100.0f);
        rotateY = cos((float)frameCount/100.0f);
        for(int i=0;i<numWraps;i++) {

            wraps[i].update();
        }

        lights();
        pushMatrix();
        translate(width/2,height/2);

        rotateX(rotateX);
        rotateY(rotateY);
        //stroke(128);
        //noFill();
        //line(0,0,0,10000,0,0);
        //line(0,0,0,0,10000,0);
        //line(0,0,0,0,0,10000);
        for(int i=0;i<numWraps;i++) {

            wraps[i].draw();

        }
        popMatrix();
        if(saveFrames) saveFrame();
//        stroke(0);
  //      line(random(width), random(height),random(width), random(height));
    }

    public void mousePressed(){
       // saveFrames = !saveFrames;
    }
    public void mouseMoved(){
        //rotateX = (mouseY-height/2)/30.0f;
        //rotateY = (mouseX-width/2)/30.0f;

    }
}