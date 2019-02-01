package filanti.gui;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageProvider {
	
	private static BufferedImage pallinaRossa, pallinaBlu, pallinaVerde, pallinaGialla, startGame1, startGame2, newgame1, newgame2, exit1, 
		exit2, backgroundStartPanel, backgroundMenuPanel, back1, back2, left, right, roundleft, roundright, speed, backgroundPlayPanel, left2, 
		right2, roundleft2, roundright2, speed2; 
	
	static {
		try {
			pallinaRossa = ImageIO.read(Thread.currentThread().getContextClassLoader().getResourceAsStream("ImageFolder/4.png"));
			pallinaBlu = ImageIO.read(Thread.currentThread().getContextClassLoader().getResourceAsStream("ImageFolder/1.png"));
			pallinaVerde = ImageIO.read(Thread.currentThread().getContextClassLoader().getResourceAsStream("ImageFolder/2.png"));
			pallinaGialla = ImageIO.read(Thread.currentThread().getContextClassLoader().getResourceAsStream("ImageFolder/3.png"));
			startGame1 = ImageIO.read(Thread.currentThread().getContextClassLoader().getResourceAsStream("ImageFolder/start.png"));
			startGame2 = ImageIO.read(Thread.currentThread().getContextClassLoader().getResourceAsStream("ImageFolder/start2.png"));
			newgame1 = ImageIO.read(Thread.currentThread().getContextClassLoader().getResourceAsStream("ImageFolder/newGame.png"));
			newgame2 = ImageIO.read(Thread.currentThread().getContextClassLoader().getResourceAsStream("ImageFolder/newGame2.png"));
			exit1 = ImageIO.read(Thread.currentThread().getContextClassLoader().getResourceAsStream("ImageFolder/exit.png"));
			exit2 = ImageIO.read(Thread.currentThread().getContextClassLoader().getResourceAsStream("ImageFolder/exit2.png"));
			backgroundStartPanel = ImageIO.read(Thread.currentThread().getContextClassLoader().getResourceAsStream("ImageFolder/BackgroundStartPanel.png"));
			backgroundMenuPanel = ImageIO.read(Thread.currentThread().getContextClassLoader().getResourceAsStream("ImageFolder/BackgroundMenuPanel.png"));
			back1 = ImageIO.read(Thread.currentThread().getContextClassLoader().getResourceAsStream("ImageFolder/back1.png"));
			back2 = ImageIO.read(Thread.currentThread().getContextClassLoader().getResourceAsStream("ImageFolder/back2.png"));
			left = ImageIO.read(Thread.currentThread().getContextClassLoader().getResourceAsStream("ImageFolder/left.png"));
			left2 = ImageIO.read(Thread.currentThread().getContextClassLoader().getResourceAsStream("ImageFolder/left2.png"));
			right = ImageIO.read(Thread.currentThread().getContextClassLoader().getResourceAsStream("ImageFolder/right.png"));
			right2 = ImageIO.read(Thread.currentThread().getContextClassLoader().getResourceAsStream("ImageFolder/right2.png"));
			roundleft = ImageIO.read(Thread.currentThread().getContextClassLoader().getResourceAsStream("ImageFolder/roundleft.png"));
			roundleft2 = ImageIO.read(Thread.currentThread().getContextClassLoader().getResourceAsStream("ImageFolder/roundleft2.png"));
			roundright = ImageIO.read(Thread.currentThread().getContextClassLoader().getResourceAsStream("ImageFolder/roundright.png"));
			roundright2 = ImageIO.read(Thread.currentThread().getContextClassLoader().getResourceAsStream("ImageFolder/roundright2.png"));
			speed = ImageIO.read(Thread.currentThread().getContextClassLoader().getResourceAsStream("ImageFolder/speed.png"));
			speed2 = ImageIO.read(Thread.currentThread().getContextClassLoader().getResourceAsStream("ImageFolder/speed2.png"));
			backgroundPlayPanel = ImageIO.read(Thread.currentThread().getContextClassLoader().getResourceAsStream("ImageFolder/backgroundPlayPanel.png"));
		}catch (final IOException e) {
			System.out.println("Cannot Read Image");
		}
	}

	public static Image getBack1() {
		return back1;
	}

	public static Image getBack2() {
		return back2;
	}

	public static Image getBackgroundMenuPanel() {
		return backgroundMenuPanel;
	}

	public static Image getBackgroundPlayPanel() {
		return backgroundPlayPanel;
	}

	public static Image getBackgroundStartPanel() {
		return backgroundStartPanel;
	}

	public static Image getExit1() {
		return exit1;
	}

	public static Image getExit2() {
		return exit2;
	}

	public static Image getLeft() {
		return left;
	}

	public static Image getLeft2() {
		return left2;
	}

	public static Image getNewgame1() {
		return newgame1;
	}

	public static Image getNewgame2() {
		return newgame2;
	}

	public static Image getPallinaBlu() {
		return pallinaBlu;
	}

	public static Image getPallinaGialla() {
		return pallinaGialla;
	}

	public static Image getPallinaRossa() {
		return pallinaRossa;
	}

	public static Image getPallinaVerde() {
		return pallinaVerde;
	}

	public static Image getRight() {
		return right;
	}

	public static Image getRight2() {
		return right2;
	}

	public static Image getRoundleft() {
		return roundleft;
	}

	public static Image getRoundleft2() {
		return roundleft2;
	}

	public static Image getRoundright() {
		return roundright;
	}

	public static Image getRoundright2() {
		return roundright2;
	}

	public static Image getSpeed() {
		return speed;
	}

	public static Image getSpeed2() {
		return speed2;
	}

	public static Image getStartGame1() {
		return startGame1;
	}

	public static Image getStartGame2() {
		return startGame2;
	}

}
