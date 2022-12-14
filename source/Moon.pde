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
void update(){
  theta +=orbitspeed;
}
void display(){
  pushMatrix();
  rotate(theta);
  translate(distance,0);
  noStroke();
  lights();
  fill(#C1BFC1);
  sphere(diameter);
  popMatrix();
  }
}
