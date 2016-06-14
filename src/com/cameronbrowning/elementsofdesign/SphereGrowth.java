package com.cameronbrowning.elementsofdesign;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * Created by cameron.browning on 6/9/16.
 */
public class SphereGrowth {

    PImage img;

    PApplet p;

    Point3D [] pts;
    int numPts, numSpheres, numPtsPerSphere;
    float spinMod, dSpinMod;
    public SphereGrowth(PApplet _p){

        p = _p;
        numSpheres = 16;

        numPtsPerSphere = 128;
        numPts = numSpheres * numPtsPerSphere;
        pts = new Point3D[numPts];
    }
    public void setup(){
        img = p.loadImage("/Users/cameron.browning/check.png");
        spinMod = 1.0f;
        dSpinMod = 0.0f;
        for(int j = 0; j<numSpheres;j++){

            for(int i=0;i<numPtsPerSphere;i++){
                pts[i+j*numPtsPerSphere] = new Point3D(p);
                //   pts[i].setup();
                pts[i+j*numPtsPerSphere].setup((float)(i)/(float)numPtsPerSphere*p.PI*8.0f, (float)i/(float)numPtsPerSphere*p.PI,j*16+50);
            }
        }

    }
    public void update(){
        spinMod += (dSpinMod-spinMod)/128.0f;
        for(int i=0;i<numPts;i++){
            pts[i].update();
        }
    }
    public void draw(){

        p.sphereDetail(12);
        //p.texture(img);
        for(int j = 0; j<numSpheres;j++) {
            p.pushMatrix();
            p.rotateX(j*spinMod/2.0f);
            p.rotateY(j*spinMod/4.0f);
            for (int i = 0; i < numPtsPerSphere; i++) {
                pts[i+j*numPtsPerSphere].drawSphere(20-j);
            }
            p.popMatrix();
        }
    }
}
