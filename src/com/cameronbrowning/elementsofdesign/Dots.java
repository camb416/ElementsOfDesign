package com.cameronbrowning.elementsofdesign;
import processing.core.PApplet;
/**
 * Created by cam on 5/18/16.
 */
public class Dots{

    Dot[] dots;
    PApplet p;

    int numDots;

    Dots(PApplet _p){
        numDots = 2048;
        p = _p;
        dots = new Dot[numDots];
        for(int i=0;i<numDots;i++){
            dots[i] = new Dot(p);
        }
    }
    public void setup(){
        // setup code here
        for(int i=0;i<numDots;i++){
            Dot d = dots[i];
            //d.setup((float)Math.sin(i/10)*i,(float)Math.cos(i)*i);
            d.setUID(i);
        }
    }
    public void update(){
        // update code here
        for(int i=0;i<numDots;i++){
            Dot d = dots[i];
            d.update(p.frameCount);
        }
    }
    public void draw(){
        // draw code here
        p.translate(p.width/2,p.height/2);
        for(int i=0;i<numDots;i++){
            Dot d = dots[i];
            d.draw();
        }
    }

}
