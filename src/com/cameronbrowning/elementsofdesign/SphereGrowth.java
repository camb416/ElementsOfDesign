package com.cameronbrowning.elementsofdesign;

import processing.core.PApplet;

/**
 * Created by cameron.browning on 6/9/16.
 */
public class SphereGrowth {

    PApplet p;

    Point3D [] pts;
    int numPts;

    public SphereGrowth(PApplet _p){

        p = _p;
        numPts = 8;
        pts = new Point3D[numPts];
    }
    public void setup(){
        for(int i=0;i<numPts;i++){
            pts[i] = new Point3D(p);
         //   pts[i].setup();
            pts[i].setup((float)i/(float)numPts*p.TWO_PI, (float)i/(float)numPts*p.PI,200);
        }
    }
    public void update(){
        for(int i=0;i<numPts;i++){
            pts[i].update();
        }
    }
    public void draw(){
        p.sphereDetail(8);
        for(int i=0;i<numPts;i++){
            pts[i].drawSphere(64);
        }
    }
}
