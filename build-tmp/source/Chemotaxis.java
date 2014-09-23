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

public class Chemotaxis extends PApplet {

int bacRed = (int)(Math.random()*255);
int bacGreen = (int)(Math.random()*255);
int bacBlue = (int)(Math.random()*255);
Bacteria [] colony;   
public void setup()   
{    
	size(600, 600);
	colony = new Bacteria[500];
	for (int i = 0; i < colony.length; i++) 
	{
		colony[i] = new Bacteria();
	}
}   
public void draw()   
{   
	background(bacRed,bacGreen,bacBlue);
	for (int i = 0; i < colony.length; i++) 
	{
		colony[i].move();
		colony[i].show();
		colony[i].follow();
	}
}  
class Bacteria    
{     
	int  bacX, bacY, bacSize, bacNum, bacFade, bacRed, bacGreen, bacBlue;
	Bacteria()
	{
		bacX = 300;
		bacY = 300;
		bacFade = 255;
		bacRed = (int)(Math.random()*255);
		bacGreen = (int)(Math.random()*255);
		bacBlue = (int)(Math.random()*255);
	}
	public void move()
	{
		bacX = bacX + (int)(Math.random()*10-5);
		bacY = bacY + (int)(Math.random()*10-5);
	}
	public void show()
	{
		noStroke();
		bacSize = 13;
		fill(bacRed,bacGreen,bacBlue,bacFade);
		ellipse(bacX, bacY, bacSize, bacSize);
		if (mousePressed)
		{
			bacFade = 255;
		}			
	}
	public void follow()
	{
		if(mousePressed) 
		{
			if(bacX > mouseX)
			{
				bacX = bacX + (int)(Math.random()*-4+1);
			}
			else 
			{
				bacX = bacX - (int)(Math.random()*-4+1);
			}
			if(bacY > mouseY)
			{
				bacY = bacY + (int)(Math.random()*-4+1);
			}
			else 
			{
				bacY = bacY - (int)(Math.random()*-4+1);
			}
		}
	}
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Chemotaxis" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
