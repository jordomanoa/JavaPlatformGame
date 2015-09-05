package com.jordan.uni.framework;

import java.awt.image.BufferedImage;

import com.jordan.uni.window.BufferedImageloader;

public class Texture 
{

	SpriteSheet bs, ps;
	private BufferedImage block_sheet = null;
	private BufferedImage player_sheet = null;
	
	public BufferedImage[] block = new BufferedImage[2];
	public BufferedImage[] player = new BufferedImage[16];
	public BufferedImage[] playerjump = new BufferedImage[7];
	
	
	
	public Texture(){
		
		BufferedImageloader loader = new BufferedImageloader();
		try{
			block_sheet = loader.loadImage("/block_sheet.png");
			player_sheet = loader.loadImage("/player_sheet.png");		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		bs = new SpriteSheet(block_sheet);
		ps = new SpriteSheet(player_sheet);
		
		getTextures();
	}
	private void getTextures(){
		block[0] = bs.grabImage(5, 6, 32, 32);
		block[1] = bs.grabImage(2, 2, 32, 32);
		
		//right
		player[0] = ps.grabImage(1, 9, 64, 64);
		player[1] = ps.grabImage(1, 5, 64, 64);
		player[2] = ps.grabImage(2, 5, 64, 64);
		player[3] = ps.grabImage(3, 5, 64, 64);
		player[4] = ps.grabImage(4, 5, 64, 64);
		player[5] = ps.grabImage(5, 5, 64, 64);
		player[6] = ps.grabImage(6, 5, 64, 64);
		player[7] = ps.grabImage(7, 5, 64, 64);
		
		//left
		player[8] = ps.grabImage(2, 9, 64, 64);
		player[9] = ps.grabImage(1, 6, 64, 64);
		player[10] = ps.grabImage(2, 6, 64, 64);
		player[11] = ps.grabImage(3, 6, 64, 64);
		player[12] = ps.grabImage(4, 6, 64, 64);
		player[13] = ps.grabImage(5, 6, 64, 64);
		player[14] = ps.grabImage(6, 6, 64, 64);
		player[15] = ps.grabImage(7, 6, 64, 64);
		
		playerjump[0] = ps.grabImage(1, 7, 60, 64);
		playerjump[1] = ps.grabImage(2, 7, 64, 64);	
		playerjump[2] = ps.grabImage(3, 7, 64, 64);	
		playerjump[3] = ps.grabImage(4, 7, 64, 64);	
		playerjump[4] = ps.grabImage(5, 7, 64, 64);	
		playerjump[5] = ps.grabImage(6, 7, 64, 64);	
		playerjump[6] = ps.grabImage(7, 7, 64, 64);	
	}
	
}
