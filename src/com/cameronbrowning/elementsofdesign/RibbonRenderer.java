package com.cameronbrowning.elementsofdesign;

import processing.core.PApplet;

/**
 * Created by cameron.browning on 6/8/16.
 */
public class RibbonRenderer {

    int numPoints;
    Point3D [] points;
    PApplet p;
    float xRot,yRot;
    float r;

    public RibbonRenderer(PApplet _p){
        numPoints = 512;
        p = _p;
        points = new Point3D[numPoints];
        for(int i=0;i<numPoints;i++){
            points[i] = new Point3D(p);
        }

    }
    public void setup(float _mod, float _radius){
        r = _radius;
        float c; // count
        float tot; // total (half of numpoints)

        c = 0;
        tot = numPoints/2;
        for(int i=0;i<numPoints;i+=2){
            float thisTheta = (float)c/((float)tot)*p.PI*_mod;
            float thisPhi = (float)c/((float)tot)*p.PI;
            points[i].setup(thisTheta,thisPhi, r);
            c++; // haha
        }

        c = 0;
        tot = numPoints/2;
        for(int i=1;i<numPoints;i+=2){
            float thisTheta = (float)c/((float)tot)*p.PI*_mod;
            float thisPhi = (float)c/((float)tot)*p.PI + p.sin((float)i/(float)numPoints* p.PI)*0.1f;
            points[i].setup(thisTheta,thisPhi, r);
            c++;
        }

    }

    public void update(float _xrot, float _yrot){
        xRot = _xrot;
        yRot = _yrot;
        for(int i=0;i<numPoints;i++){
            points[i].update();
        }
    }
    public void update(){
        this.update(0.0f, 0.0f);
    }
    public void draw(){
        p.pushMatrix();
        p.rotateX(xRot);
        p.rotateY(yRot);
        p.noStroke();
        p.fill(255);
        p.beginShape(p.TRIANGLE_STRIP);
        for(int i=0;i<numPoints;i++){

            Point3D pt = points[i];
            p.vertex(pt.x,pt.y,pt.z);
        }
        p.endShape();

        for(int i=0;i<numPoints;i++){
            points[i].draw();
        }
        p.popMatrix();

    }
//    public void punch(){
//        for(int i=0;i<numPoints;i++){
//            points[i].punch();
//        }
//    }
}
