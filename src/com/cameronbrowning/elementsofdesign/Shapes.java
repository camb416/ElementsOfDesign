package com.cameronbrowning.elementsofdesign;

import processing.core.PApplet;

/**
 * Created by cameron.browning on 5/23/16.
 */
public class Shapes {

    Shape[] shapes;

    int numShapes;
    PApplet p;



    Shapes(PApplet _p){
        p = _p;
        numShapes = 1024;
        shapes = new Shape[numShapes];
        for(int i=0;i<numShapes;i++){
            shapes[i] = new Shape(p);

        }
    }
    public void setup(){
        for(int i=0;i<numShapes;i++){
            shapes[i].setup((float)i/(float)numShapes*720.0f,0);
            shapes[i].setSize((float)Math.sin((float)i/(float)numShapes*(float)Math.PI)*15.0f+2.0f);
            shapes[i].setUID(i);
            shapes[i].setMax(numShapes);

        }
    }
    public void update(){
        for(int i=0;i<numShapes;i++){
            shapes[i].update(p.frameCount);
            shapes[i].setRotation((float)i/(float)numShapes*(float)Math.PI*32.0f+p.frameCount/100.0f);

        }
    }
    public void draw(){
        p.pushMatrix();
        p.translate(p.width/2,p.height/2);
        p.rotateX(p.mouseY/100.0f);
        p.rotateY(p.mouseX/100.0f);
        for(int i=0;i<numShapes;i++){
            shapes[i].draw();

        }
        p.popMatrix();
    }
}
