package com.cameronbrowning.elementsofdesign;

import processing.core.PApplet;

/**
 * Created by cameron.browning on 6/5/16.
 */
public class SphereWrap {

    PApplet p; // parent app

    float t; // timer that counts 0-1
    float r; // radius
    float a; // angle

    float bx,by; // 2d pos

    float ax,ay;

    float cx,cy,cz;

    float ca, cr;

    float [] cxHistory;
    float [] cyHistory;
    float [] czHistory;
    float [] caHistory;

    int c;


    int trailLength;

    float angleOffset, angleSpeed, tOffset, rMultiplier, frameDivisor,spinMod;

    SphereWrap(PApplet _p){
        p = _p;
        t = 0;
        r = 100;
        trailLength = 64;
        a = 0;
        bx = by = 0;
        ax = ay = 0;
        cx = cy = cz = 0;

        ca = cr = 0;

        c = (int)p.random(64)+192;

        cxHistory = new float[trailLength];
        cyHistory = new float[trailLength];
        czHistory = new float[trailLength];
        caHistory = new float[trailLength];

        angleOffset = 0;
        angleSpeed = 15.0f;
        rMultiplier = 1.0f;
        frameDivisor = 100.0f;
        spinMod = 1.0f;



    }
    public void setup(float _angleOffset, float _angleSpeed, float _tOffset, float _rMult, float _fDiv,float _spinMod){
        angleOffset = _angleOffset;
        angleSpeed = _angleSpeed;
        tOffset = _tOffset;
        rMultiplier = _rMult;
        r *= rMultiplier;
        frameDivisor = _fDiv;
        spinMod = _spinMod;
    }
    public void update(){




        //t = p.frameCount%300/300.0f;

        t = p.sin((float)p.frameCount/frameDivisor + tOffset)/2.0f+0.5f;


        cxHistory[0] = cx;
        cyHistory[0] = cy;
        czHistory[0] = cz;
        caHistory[0] = ca;
/*
        if(p.frameCount % 300 == 0){
            for(int i=0;i<trailLength;i++){
                cxHistory[i] = cyHistory[i] = czHistory[i] = 0;
            }
        }
        */

        a = (float)(t*2.0-1.0)*(float)Math.PI/2.0f;


        ax = 0;
        ay = (t*r*2.0f)-r;


        by = ay;
        bx = (float)Math.sqrt(r*r - by*by);

        ca = p.frameCount*angleSpeed+angleOffset;

        cy = by;
        cr = bx;
        cx = (float)Math.cos(ca)*cr;
        cz = (float)Math.sin(ca)*cr;

        for(int i=(trailLength-1);i>0;i--){
            cxHistory[i] = cxHistory[i-1];
            cyHistory[i] = cyHistory[i-1];
            czHistory[i] = czHistory[i-1];
            caHistory[i] = caHistory[i-1];

        }

    }
    public void draw(){
        //p.println(t);

        p.fill(0);
        p.pushMatrix();
        //p.translate(p.width/2,p.height/2);
        //p.println(x + ", " + y);

        //p.ellipse(bx,by,5,5);

        //p.fill(255,0,0);
        //p.noStroke();
        //p.ellipse(0,by,3,3);

        //p.fill(0,255,0);
        //p.ellipse(ax,ay,4,4);

        p.noFill();
        p.stroke(128);
        //rp.line(ax,ay,bx,by);

        //p.noStroke();
        //p.fill(128,64,192);
        //p.pushMatrix();
        //p.translate(cx,cy,cz);
        //p.ellipse(0,0,5,5);
        //p.popMatrix();




        //p.stroke(128,0,0);

        //p.line(0,cy,0,cx,cy,cz);

        p.stroke(128);
        for(int i=1;i<trailLength;i++){
            if(cxHistory[i] != 0 &&
                    cyHistory[i] != 0 &&
                    czHistory[i] != 0 &&
                    cxHistory[i-1] != 0 &&
                    cyHistory[i-1] != 0 &&
                    czHistory[i-1] != 0){
            //    p.line(cxHistory[i],cyHistory[i],czHistory[i],cxHistory[i-1],cyHistory[i-1],czHistory[i-1]);

            }
            //p.point(cxHistory[i],cyHistory[i],czHistory[i]);

            //cxHistory[i] = cxHistory[i-1];
            //cyHistory[i] = cyHistory[i-1];
            //czHistory[i] = czHistory[i-1];

        }
        p.noStroke();
        p.fill(c);
        //p.noFill();
        //p.stroke(c);
        p.beginShape(p.TRIANGLE_STRIP);
        for (int i = 0; i < trailLength; i++) {
            //float px = x + p.cos(radians(angle)) * outsideRadius;
            //float py = y + p.sin(radians(angle)) * outsideRadius;
            //angle += angleStep;
            if(cxHistory[i] != 0 &&
                    cyHistory[i] != 0 &&
                    czHistory[i] != 0) {
                float pos = (float)i/(float)trailLength*p.PI;
                float w = p.sin(pos)*20.0f;
                p.vertex(cxHistory[i], cyHistory[i]-w/2, czHistory[i]-w/2);
                //px = x + cos(radians(angle)) * insideRadius;
                //py = y + sin(radians(angle)) * insideRadius;


                p.vertex(cxHistory[i], cyHistory[i] + p.cos(caHistory[i] + p.HALF_PI) * w , czHistory[i] + p.sin(caHistory[i] + p.HALF_PI) * w);
                //angle += angleStep;
            }
        }
        p.endShape();





        p.popMatrix();

    }
}
