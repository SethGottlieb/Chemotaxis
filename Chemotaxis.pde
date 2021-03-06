int bacRed = (int)(Math.random()*255);
int bacGreen = (int)(Math.random()*255);
int bacBlue = (int)(Math.random()*255);
Bacteria [] colony;   
void setup()   
{    
	size(600, 600);
	colony = new Bacteria[500];
	for (int i = 0; i < colony.length; i++) 
	{
		colony[i] = new Bacteria();
	}
}   
void draw()   
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
	void move()
	{
		bacX = bacX + (int)(Math.random()*10-5);
		bacY = bacY + (int)(Math.random()*10-5);
	}
	void show()
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
	void follow()
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