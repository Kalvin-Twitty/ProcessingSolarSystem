/* autogenerated by Processing revision 1286 on 2022-12-06 */
import processing.core.*;
import processing.data.*;
import processing.event.*;
import processing.opengl.*;

import java.util.HashMap;
import java.util.ArrayList;
import java.io.File;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

public class Main_Script_Run extends PApplet {

Planet[] planets = new Planet[8];
Planet[] Asteroid = new Planet[150];

int x;
   public void setup(){
    /* size commented out by preprocessor */;
    /* smooth commented out by preprocessor */;
    

for (int i =0;i<Asteroid.length;i++);{
  Asteroid[1] = new Planet(115,0.5f,0xFFB7B4B1,0.00001f,false,0,0,0,0,false);
 
}

planets[0] = new Planet (50,3,0xFFB7B4B1,0.009f,false,0,0,0,0,false);
planets[1] = new Planet (65,5,0xFFFF850A,0.007f,false,0,0,0,0,false);
planets[2] = new Planet (80,5,0xFF0AC4FA,0.005f,true,1,8,2,0.1f,false);
planets[3] = new Planet (95,4,0xFF936138,0.002f,true,2,7,2,0.05f,false);
planets[4] = new Planet (140,11,0xFFF2C39D,0.003f,true,4,16,2,0.02f,false);
planets[5] = new Planet (175,7,0xFF936138,0.002f,true,2,7,2,0.02f,true);
planets[6] = new Planet (210,8,0xFF5FFFF0,0.005f,true,2,7,2,0.02f,false);
planets[7] = new Planet (245,7,0xFF5F8EFF,0.0032f,true,2,7,2,0.02f,false);
  }
  
   public void draw(){
    background(0);
     //rotate X
      if (frameCount<400){
        x = 250 - frameCount;
        translate(0,0,x);
      }
     else {
       translate(0,0,x);
   }
    
    rotateX(radians(45));
   rotate(radians((1/30)*frameCount));
     
    
    //Sun Generation
    pushMatrix();
    lights();
    noStroke();
    translate(width/2,height/2,0);
    fill(0xFFFF850A);
    sphere(28);
    fill(0xFFFF850A,40);
    sphere(36);
    for(int i=0;i<planets.length;i++){
      planets[i].update();
      planets[0].display();
      planets[1].display();
      planets[2].display();
      planets[3].display();
      planets[4].display();
      planets[5].display();
      planets[6].display();
      planets[7].display();
    }
    for(int i=0; i<Asteroid.length;i++){
      rotate(radians(1.2f*i));
      Asteroid[1].update();
      Asteroid[1].display();
    }
     
     strokeWeight(1);
  stroke(0xFFA7A39F, 100);
  noFill();
  ellipse(0,0,100,100);
  ellipse(0,0,130,130);
  ellipse(0,0,160,160);
  ellipse(0,0,190,190);
  ellipse(0,0,280,280);

popMatrix();
}
class Moon{
  float theta;
  float diameter;
  float distance;
  float orbitspeed;
  
  Moon(float distance_,float diameter_, float orbitspeed_){
    distance = distance_;
    diameter = diameter_;
    theta=0;
    orbitspeed = orbitspeed_;
}
 public void update(){
  theta +=orbitspeed;
}
 public void display(){
  pushMatrix();
  rotate(theta);
  translate(distance,0);
  noStroke();
  lights();
  fill(0xFFC1BFC1);
  sphere(diameter);
  popMatrix();
  }
}
class Planet{
  float theta;
  float diameter;
  float distance;
  float orbitspeed;
  int colors;
  boolean ns_c;
  boolean ring;
  float nummon;
  
  Moon[] ns = new Moon[5];
  
  
  Planet(float distance_,float diameter_, int colors_, float orbitspeed_, boolean ns_, float nummon_, float nsdistance_, float nsdiameter_, float nsorbitspeed_, boolean ring_){
    distance = distance_;
    diameter = diameter_;
    theta = 0;
    orbitspeed = orbitspeed_;
    ring = ring_;
    colors = colors_;
    ns_c= ns_;
    nummon = nummon_;
    
    if (ns_){
      for (int i=0; i<nummon;i++){
        ns[i] = new Moon(nsdistance_, nsdiameter_, nsorbitspeed_);
    }
  }
}
 public void update() {
  theta +=orbitspeed;
  if (ns_c) {
     for (int i=0;i<nummon;i++){
       ns[i].update();
     }
  }
}

     public void display(){
    pushMatrix();
    rotate(theta);
    translate(distance,0,0);
    noStroke();
    lights();
    fill(colors);
    sphere(diameter);
  
   //Moon
   if(ns_c){
      rotateX(theta);
      for(int i=0;i<nummon;i++){
        rotate(radians(i+90));
        ns[i].display();
      }
    }
   

  if(ring){
  noFill();
  stroke(colors);
  rotateX(radians(-20));
  ellipse(0,0,diameter*3.8f,diameter*3.8f);
  ellipse(0,0,diameter*3.6f,diameter*3.6f);
  ellipse(0,0,diameter*3.4f,diameter*3.4f);
  ellipse(0,0,diameter*3.2f,diameter*3.2f);
  ellipse(0,0,diameter*3,diameter*3);
}

popMatrix();
  }
}


  public void settings() { size(800, 600, P3D);
smooth(); }

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--full-screen", "--bgcolor=#666666", "--stop-color=#cccccc", "Main_Script_Run" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
