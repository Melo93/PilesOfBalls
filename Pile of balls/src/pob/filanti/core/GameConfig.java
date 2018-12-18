package pob.filanti.core;

import java.awt.Point;

public class GameConfig {
	public static final int LOGIC_GAME_WIDTH=42;
	public static final int LOGIC_GAME_HEIGHT=35;
	
	public static final int GRAPHIC_GAME_WIDTH=1024;
	public static final int GRAPHIC_GAME_HEIGHT=768;
	
	public static final int FLOOR=31;
	public static final int LEFT=9; 
	public static final int RIGHT=33; 
	
	public static Point graphicsToLogic(int x, int y){
		
		int xLogic=LOGIC_GAME_WIDTH*x/GRAPHIC_GAME_WIDTH;
		int yLogic=LOGIC_GAME_HEIGHT*y/GRAPHIC_GAME_HEIGHT;
		
		return new Point(xLogic, yLogic);
		
	}
	
	public static Point logicToGraphic(int x, int y){
		
		int xGraphics=GRAPHIC_GAME_WIDTH*x/LOGIC_GAME_WIDTH;
		int yGraphics=GRAPHIC_GAME_HEIGHT*y/LOGIC_GAME_HEIGHT;
		
		return new Point(xGraphics, yGraphics);
	}
	
	public static int yLogicToGraphics(int x) {
		return GRAPHIC_GAME_HEIGHT*x/LOGIC_GAME_HEIGHT;
	}
	
}
