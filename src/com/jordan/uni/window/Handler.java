package com.jordan.uni.window;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import com.jordan.uni.Objects.Block;
import com.jordan.uni.Objects.Flag;
import com.jordan.uni.Objects.Player;
import com.jordan.uni.framework.GameObject;
import com.jordan.uni.framework.ObjectId;

public class Handler 
{

	public LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	private GameObject tempObject;
	
	private Camera cam;
	
	private BufferedImage level2, level3, level4, level5, End = null;
	
	public Handler (Camera cam){
		this.cam = cam;
		
		BufferedImageloader loader = new BufferedImageloader();
		level2 = loader.loadImage("/level2.png"); //loading the level
		level3 = loader.loadImage("/level3.png"); //loading the level
		level4 = loader.loadImage("/level4.png"); //loading the level
		level5 = loader.loadImage("/level5.png"); //loading the level
		End = loader.loadImage("/End.png"); //loading the level
	}
	
	public void tick()
	{
		for(int i = 0; i < object.size(); i++)
		{
			tempObject = object.get(i);
			
			tempObject.tick(object);
		}
	}
	
	public void render (Graphics g)
	{
		for(int i = 0; i < object.size(); i++)
		{
			tempObject = object.get(i);
			
			tempObject.render(g);
	}
}
	
	public void LoadImageLevel(BufferedImage image){
		int w = image.getWidth();
		int h = image.getHeight();
		
		System.out.println("width, height: " + w + " " + h);
		
		for(int xx = 0; xx < h; xx++){
		
			for (int yy = 0; yy < w; yy++){
				int pixel = image.getRGB(xx,  yy);
				int red = (pixel >> 16) & 0xff;
				int green = (pixel >> 8) & 0xff;
				int blue = (pixel) & 0xff;
				
				
				
				if (red == 255 && green == 255 & blue == 255) addObject(new Block(xx*32, yy*32, 0, ObjectId.Block));
				if (red == 128 && green == 128 & blue == 128) addObject(new Block(xx*32, yy*32, 1, ObjectId.Block));
				if (red == 0 && green == 0 & blue == 255) addObject(new Player(xx*32, yy*32, this, cam, ObjectId.Player));
				if (red == 255 && green == 216 & blue == 0) addObject(new Flag(xx*32, yy*32, ObjectId.Flag));
		}
		}
		
	}
	
	public void switchLevel(){
		clearLevel();
		cam.setX(0);
		
		
		switch(Game.LEVEL)
		{
		case 1:
			LoadImageLevel(level2);
			
			break;
		
		case 2: 
			LoadImageLevel(level3);
			
			break;
			
		case 3: 
			LoadImageLevel(level4);
			
			break;
			
		case 4: 
			LoadImageLevel(level5);
			
			break;
			
		case 5: 
			LoadImageLevel(End);
			
			break;
		}
		
		Game.LEVEL++;
		
			
	}
	private  void clearLevel(){
		object.clear();
	}
	
	
	public void addObject(GameObject object){
		this.object.add(object);
		}
	public void removeObject(GameObject object){
		this.object.remove(object);
	}
	
	//public void createLevel()
	//{
	//for(int yy = 0; yy < Game.HEIGHT+32; yy += 32)
		//addObject(new Block(0, yy, ObjectId.Block));
	
	//for(int xx = 0; xx < Game.WIDTH*2; xx += 32)
		//addObject(new Block(xx, Game.HEIGHT-32, ObjectId.Block));
	
	//for(int xx = 200; xx < 600; xx += 32)
		//addObject(new Block(xx, 400, ObjectId.Block));
	//}
}