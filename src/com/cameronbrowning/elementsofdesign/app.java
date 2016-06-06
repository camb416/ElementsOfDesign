package com.cameronbrowning.elementsofdesign;
import processing.core.PApplet;


/**
 * Created by cameron.browning on 5/3/16.
 */
public class app extends PApplet {

    SphereWrap [] wraps;
    int numWraps = 255;

    ParticleSphere particleSphere;



    boolean saveFrames;

    float rX,dRX;
    float rY,dRY;

    public void settings(){
        size(720,720,P3D);
        saveFrames = false;
        smooth(8);
       // noSmooth();
    }

    public void setup(){


        rX = 1.0f;
        rY = 2.0f;
        dRX = dRY = 0.0f;
        particleSphere = new ParticleSphere(this);


        wraps = new SphereWrap[numWraps];

        frameRate(60);
        for(int i=0;i<numWraps;i++){
            wraps[i] = new SphereWrap(this);
            wraps[i].setup(random(PI),
                    (random(-10.0f,10.0f))/100.0f, // angle speed
                    random(10.0f),
                    (float)i/(float)numWraps*0.5f+ 8.10f, // radius multiplier
                    random(100.0f,100.0f),
                    random(0.5f,0.7f) // spinspeed
            );
        }



        background(255);



    }

    float xoff = 0.0f;

    public void draw(){

        rX += (dRX-rX)/64.0f;
        rY += (dRY-rY)/64.0f;

        for(int i=0;i<numWraps;i++){
            wraps[i].update();
        }

        background(255);
        //fill(255,255,255,128);
        //rect(0,0,width,height);


        particleSphere.update();
        pushMatrix();
        translate(width/2,height/2);
        rotateX(rX);
        rotateY(rY);
        particleSphere.draw();

        for(int i=0;i<numWraps;i++){
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
        dRX = (mouseY-height/2)/30.0f;
        dRY = (mouseX-width/2)/30.0f;

    }

    public void keyPressed(){
        particleSphere.punch();
    }
}