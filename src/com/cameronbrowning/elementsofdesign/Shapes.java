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
        numShapes = 8192;
        shapes = new Shape[numShapes];
        for(int i=0;i<numShapes;i++){
            shapes[i] = new Shape(p);

        }
    }
    public void setup(){
        for(int i=0;i<numShapes;i++){
            shapes[i].setup(i/10.0f,0);
            shapes[i].setSize((float)Math.sin((float)i/(float)numShapes*(float)Math.PI)*5.0f+1.0f);
            shapes[i].setUID(i);
            shapes[i].setMax(numShapes);

        }
    }
    public void update(){
        for(int i=0;i<numShapes;i++){
            shapes[i].setRotation(i+p.frameCount/100.0f);

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
