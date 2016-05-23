package com.cameronbrowning.elementsofdesign;
import processing.core.PApplet;

/**
 * Created by cam on 5/18/16.
 */
public class Lines {

    Line[] lines;
    PApplet p;

    int numLines;

    Lines(PApplet _p){
        numLines = 512;
        p = _p;
        lines = new Line[numLines];
        for(int i=0;i<numLines;i++){
            lines[i] = new Line(p);
        }
    }
    public void setup(){
        // setup code here
        for(int i=0;i<numLines;i++){
            Line d = lines[i];
            d.setMax(numLines);
            //d.setup((float)Math.sin(i/10)*i,(float)Math.cos(i)*i);
            d.setup((float)Math.cos(i)*i/numLines*p.width/2,(float)Math.sin(i)*i/numLines*p.width/2);
            d.setup2((float)Math.cos(i+0.5f)*i/numLines*p.width/2,(float)Math.sin(i+0.5f)*i/numLines*p.width/2);
            d.setUID(i);
        }
    }
    public void update(){
        // update code here
        for(int i=0;i<numLines;i++){
           Line d = lines[i];
            d.update(p.frameCount);
        }
    }
    public void draw(){
        // draw code here
        p.translate(p.width/2,p.height/2);
        for(int i=0;i<numLines;i++){
            Line d = lines[i];
            d.draw();
        }
        p.saveFrame();
    }

}
