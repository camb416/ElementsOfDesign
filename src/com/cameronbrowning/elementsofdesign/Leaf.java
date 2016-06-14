package com.cameronbrowning.elementsofdesign;

import processing.core.PApplet;

/**
 * Created by cameron.browning on 6/13/16.
 */
public class Leaf {

    Point3D [] pts;
    PApplet p;
    int numPts;
    int numSlices;
    int numRows;

    int c; // color

    float totalAngle;
    float angleStep;

    float rowSpread;
    boolean hasCap;
    float radius;

    float openingRotation;

    float angleOffset;
    float angleOffsetX,angleOffsetY;


    public Leaf(PApplet _p){

        c = (int)(Math.random()*64.0f)+192;
        p = _p;
        openingRotation = (float)(Math.random()*Math.PI/4.0f);
       //openingRotation = 0.0f;
        numSlices = 12;
        numRows = 24;
        rowSpread = 15.0f;
        totalAngle = 120.0f;
        numPts = (numRows+1)*numSlices+1;
        if(totalAngle == 180.0f){
            hasCap = true;
            numPts++;
            angleStep = totalAngle/(numRows+2);
        } else {
            hasCap = false;
            angleStep = totalAngle/(numRows+1);
        }

    }
    public void setup(float _angleOffset, float _radius, float _totalAngle){
        totalAngle = _totalAngle;
        if(totalAngle == 180.0f){
            hasCap = true;
            numPts++;
            angleStep = totalAngle/(numRows+2);
        } else {
            hasCap = false;
            angleStep = totalAngle/(numRows+1);
        }

        radius = _radius;
        angleOffset = _angleOffset;
        angleOffsetX = (float)Math.cos(angleOffset+rowSpread/2.0f/180.0f*(float)Math.PI+Math.PI/2.0f);
        angleOffsetY = (float)Math.sin(angleOffset+rowSpread/2.0f/180.0f*(float)Math.PI+Math.PI/2.0f);
        pts = new Point3D[numPts];
        pts[0] = new Point3D(p);
        pts[0].setup(_angleOffset,0,radius);
        for(int i=0;i<numSlices;i++){
            pts[i+1] = new Point3D(p);
            pts[i+1].setup(_angleOffset+(float)i/(float)numSlices*rowSpread/180.0f*(float)Math.PI,angleStep*(float)Math.PI/180.0f,radius);
        }
        if(hasCap) {
            pts[numPts - 1] = new Point3D(p);
            pts[numPts - 1].setup(_angleOffset+rowSpread / 180.0f * (float) Math.PI / 2.0f, totalAngle * (float) Math.PI / 180.0f, radius);
        }
            /*
        for(int i=0;i<numSlices;i++){
            pts[i+numSlices+1] = new Point3D(p);
            pts[i+numSlices+1].setup((float)i/(float)numPts*(float)Math.PI,30.0f*(float)Math.PI/180.0f,200.0f);

        }
        for(int i=0;i<numSlices;i++){
            pts[i+numSlices*2+1] = new Point3D(p);
            pts[i+numSlices*2+1].setup((float)i/(float)numPts*(float)Math.PI,45.0f*(float)Math.PI/180.0f,200.0f);

        }
        */
        for(int j = 0; j < numRows;j++){
            for(int i=0;i<numSlices;i++){
                pts[i+numSlices*(j+1)+1] = new Point3D(p);
                pts[i+numSlices*(j+1)+1].setup(_angleOffset+(float)i/(float)numSlices*rowSpread/180.0f*(float)Math.PI,angleStep*(j+2)*(float)Math.PI/180.0f,radius);

            }
        }


    }
    public void update(){
        for(int i=0;i<numPts;i++) {
            pts[i].update();
        }
    }
    public void draw(){
        p.pushMatrix();

      //  p.stroke(255,0,0);


        p.rotate((float)p.frameCount/100.0f,angleOffsetX,angleOffsetY,0);
        p.translate(0.0f,0.0f,-radius*1.5f);

      //  p.stroke(0);
      //  p.line(0,0,radius,radius+angleOffsetX*1000,radius+angleOffsetY*1000,radius);
      //  p.noStroke();

       // p.rotate()

//p.stroke(0);
  //      p.fill(255);
        p.beginShape(p.TRIANGLE_FAN);
        for(int i=0;i<numSlices+1;i++) {
            p.vertex(pts[i].x,pts[i].y,pts[i].z);
       //     p.text(i,pts[i].x,pts[i].y,pts[i].z);
        }
        p.endShape();


//        for(int i=0;i<numSlices+1;i++) {
//            p.text(i,pts[i].x,pts[i].y,pts[i].z);
//        }
        /*
        p.beginShape(p.TRIANGLE_STRIP);

        for(int i=1;i<numSlices+1;i++){

            p.vertex(pts[i].x,pts[i].y,pts[i].z);
            p.vertex(pts[i+numSlices].x,pts[i+numSlices].y,pts[i+numSlices].z);

        }
        p.endShape();

        p.beginShape(p.TRIANGLE_STRIP);

        for(int i=1;i<numSlices+1;i++){

            p.vertex(pts[i+numSlices].x,pts[i+numSlices].y,pts[i+numSlices].z);
            p.vertex(pts[i+numSlices*2].x,pts[i+numSlices*2].y,pts[i+numSlices*2].z);

        }
        p.endShape();
        */
for(int j=0;j<numRows;j++){
  /*
    p.fill(255);
    if(j%2==0){
        p.stroke(255,0,0);
    } else {
        p.stroke(0);
    }
    */

    p.fill(c);

    p.beginShape(p.TRIANGLE_STRIP);
    for(int i=1;i<numSlices+1;i++){

        p.vertex(pts[i + j*numSlices].x,pts[i+ j*numSlices].y,pts[i+ j*numSlices].z);
        p.vertex(pts[i+ (j+1)*numSlices].x,pts[i+ (j+1)*numSlices].y,pts[i+ (j+1)*numSlices].z);

    }
    p.endShape();
}

        /*
p.fill(0);
        for(int i=0;i<numPts;i++) {
            p.text(i,pts[i].x,pts[i].y,pts[i].z);
      }
      */
        if(hasCap) {
        //    p.stroke(0, 255, 0);
        //    p.fill(255);
            p.beginShape(p.TRIANGLE_FAN);
            for (int i = numPts - 1; i > numPts - 2 - numSlices; i--) {
                p.vertex(pts[i].x, pts[i].y, pts[i].z);
                //     p.text(i,pts[i].x,pts[i].y,pts[i].z);
            }
            p.endShape();
        }
p.popMatrix();
    }
}
