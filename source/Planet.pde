class Planet{
  float theta;
  float diameter;
  float distance;
  float orbitspeed;
  color colors;
  boolean ns_c;
  boolean ring;
  float nummon;
  
  Moon[] ns = new Moon[5];
  
  
  Planet(float distance_,float diameter_, color colors_, float orbitspeed_, boolean ns_, float nummon_, float nsdistance_, float nsdiameter_, float nsorbitspeed_, boolean ring_){
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
void update() {
  theta +=orbitspeed;
  if (ns_c) {
     for (int i=0;i<nummon;i++){
       ns[i].update();
     }
  }
}

    void display(){
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
  ellipse(0,0,diameter*3.8,diameter*3.8);
  ellipse(0,0,diameter*3.6,diameter*3.6);
  ellipse(0,0,diameter*3.4,diameter*3.4);
  ellipse(0,0,diameter*3.2,diameter*3.2);
  ellipse(0,0,diameter*3,diameter*3);
}

popMatrix();
  }
}
