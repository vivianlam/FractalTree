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

public class FractalTree extends PApplet {

//Vivian Lam, AP CS MOD 6/7, Fractal Tree
private double fractionLength = .8f; 
private int smallestBranch = 8; 
private double branchAngle = .5f;  
public void setup() 
{   
	size(640,480);    
	noLoop(); 
} 
public void draw() 
{   
	background(0);   
	stroke(0,255,0);   
	line(320,480,320,380);   
	drawBranches(320,380,100,3*Math.PI/2); 
} 
public void drawBranches(int x,int y, double branchLength, double angle) 
{   
	double angle1 = angle+branchAngle;
	double angle2 = angle-branchAngle; 
	branchLength = fractionLength *branchLength;
	int endX1 = (int)(branchLength*Math.cos(angle1)+x);
	int endY1 = (int)(branchLength*Math.sin(angle1)+y);
	int endX2 = (int)(branchLength*Math.cos(angle2)+x);
	int endY2 = (int)(branchLength*Math.sin(angle2)+y);
	line(x,y,endX1,endY1);
	line(x,y,endX2,endY2);
	//recursion
	if(branchLength>smallestBranch)
	{
		stroke((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255)); 
		drawBranches(endX1,endY1,branchLength, angle1);
		drawBranches(endX2,endY2,branchLength, angle2);
	}

} 

/*public void keyTyped()
{
	if(key==CODED && key=='a')
		branchAngle +=0.1;
	else if(key==CODED && key=='d')
		branchAngle -=0.1;
	if(key==CODED && key=='g')
		fractionLength+=0.1;
	else if(key==CODED && key=='h')
		fractionLength-=0.1;
	if(key==CODED && key=='j')
		smallestBranch++;
	else if(key==CODED && key=='l')
		smallestBranch--;

	redraw();

}*/
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "FractalTree" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
