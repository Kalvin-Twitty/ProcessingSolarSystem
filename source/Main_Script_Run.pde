Planet[] planets = new Planet[8];
Planet[] Asteroid = new Planet[150];

int x;
  void setup(){
    size(800,600,P3D);
    smooth();
    

for (int i =0;i<Asteroid.length;i++);{
  Asteroid[1] = new Planet(115,0.5,#B7B4B1,0.00001,false,0,0,0,0,false);
 
}

planets[0] = new Planet (50,3,#B7B4B1,0.009,false,0,0,0,0,false);
planets[1] = new Planet (65,5,#FF850A,0.007,false,0,0,0,0,false);
planets[2] = new Planet (80,5,#0AC4FA,0.005,true,1,8,2,0.1,false);
planets[3] = new Planet (95,4,#936138,0.002,true,2,7,2,0.05,false);
planets[4] = new Planet (140,11,#F2C39D,0.003,true,4,16,2,0.02,false);
planets[5] = new Planet (175,7,#936138,0.002,true,2,7,2,0.02,true);
planets[6] = new Planet (210,8,#5FFFF0,0.005,true,2,7,2,0.02,false);
planets[7] = new Planet (245,7,#5F8EFF,0.0032,true,2,7,2,0.02,false);
  }
  
  void draw(){
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
    fill(#FF850A);
    sphere(28);
    fill(#FF850A,40);
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
      rotate(radians(1.2*i));
      Asteroid[1].update();
      Asteroid[1].display();
    }
     
     strokeWeight(1);
  stroke(#A7A39F, 100);
  noFill();
  ellipse(0,0,100,100);
  ellipse(0,0,130,130);
  ellipse(0,0,160,160);
  ellipse(0,0,190,190);
  ellipse(0,0,280,280);

popMatrix();
}
