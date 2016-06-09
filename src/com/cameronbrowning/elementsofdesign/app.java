package com.cameronbrowning.elementsofdesign;
import processing.core.PApplet;


/**
 * Created by cameron.browning on 5/3/16.
 */
public class app extends PApplet {

    // sphere wrap
    // SphereWrap [] wraps;
    // int numWraps = 255;

    // ParticleSphere particleSphere;

    //RibbonRenderer r;
    //RibbonRenderer r2;


    // ribbonrenderers
//    RibbonRenderer[] ribbons;
//    int numRibbons;
//    float spinMod, dSpinMod;

    SphereGrowth s;

    boolean saveFrames;

    float rX,dRX;
    float rY,dRY;

    public void settings(){
        size(720,720,P3D);
        saveFrames = true;
        smooth(8);
       // noSmooth();

    }

    public void setup(){

        s = new SphereGrowth(this);
        s.setup();

        // ribbonrenderers
//        spinMod = 1.0f;
//        dSpinMod = 0.0f;
//        numRibbons = 32;
//        rX = 1.0f;
//        rY = 2.0f;
//        dRX = dRY = 0.0f;
//       // particleSphere = new ParticleSphere(this);
//
//
//        ribbons = new RibbonRenderer[numRibbons];
//
////        r = new RibbonRenderer(this);
////        r.setup(4.0f);
////        r2 = new RibbonRenderer(this);
////        r2.setup(-4.0f);
//
//        for(int i=0;i<numRibbons;i++){
//            RibbonRenderer r = new RibbonRenderer(this);
//            r.setup((float)i/(float)numRibbons*8.0f, i*5.0f+100.0f);
//            ribbons[i] = r;
//        }

/*
// sphere wrap setup
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
*/


        background(255);

        dRX = 5.0f;
        dRY = 3.0f;



    }

    float xoff = 0.0f;

    public void draw(){

        s.update();

       // lights();

        // ribbonrenders
//        spinMod += (dSpinMod-spinMod)/1024.0f;
//
//        for(int i=0;i<numRibbons;i++){
//            ribbons[i].update(((float)frameCount*(float)i/(float)numRibbons*0.02f-0.01f)*spinMod, ((float)frameCount*(float)i/(float)numRibbons*0.02f-0.01f*-1.0f)*spinMod);
//        }
//        r.update((float)frameCount*-0.01f);
//        r2.update((float)frameCount*0.01f);
//        particleSphere.update();

        rX += (dRX-rX)/64.0f;
        rY += (dRY-rY)/64.0f;

        //for(int i=0;i<numWraps;i++){
        //    wraps[i].update();
        //}

        background(255);
        //fill(255,255,255,128);
        //rect(0,0,width,height);





        pushMatrix();
        translate(width/2,height/2);
        rotateX(rX);
        rotateY(rY);

        s.draw();
        //particleSphere.draw();

        //for(int i=0;i<numWraps;i++){
        //    wraps[i].draw();
        //}

//        r.draw();
//        r2.draw();

        // ribbons
//        for(int i=0;i<numRibbons;i++){
//            ribbons[i].draw();
//        }




        popMatrix();



        if(saveFrames) saveFrame();
    }

    public void mousePressed(){
       // saveFrames = !saveFrames;
    }
    public void mouseMoved(){
        dRX = (mouseY-height/2)/30.0f;
        dRY = (mouseX-width/2)/30.0f;

    }

    public void keyPressed(){
        //particleSphere.punch();
    }
}