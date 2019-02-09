package filanti.dlv;

import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;

@Id("trisball")
public class TrisballDlv {
	
	@Param(0)
	private int xMedia;
	@Param(1)
	private int rotation;
	@Param(2)
	private int color1;
	@Param(3)
	private int color2;
	@Param(4)
	private int color3;
	
	public TrisballDlv(int xMedia, int rotation, int color1, int color2, int color3) {
		super();
		this.xMedia = xMedia;
		this.rotation = rotation;
		this.color1 = color1;
		this.color2 = color2;
		this.color3 = color3;
	}

	public TrisballDlv() {
		// TODO Auto-generated constructor stub
	}
	
	public int getXMedia() {
		return xMedia;
	}
	public void setXMedia(int xMedia) {
		this.xMedia = xMedia;
	}
	public int getRotation() {
		return rotation;
	}
	public void setRotation(int rotation) {
		this.rotation = rotation;
	}

	public int getColor1() {
		return color1;
	}

	public void setColor1(int color1) {
		this.color1 = color1;
	}

	public int getColor2() {
		return color2;
	}

	public void setColor2(int color2) {
		this.color2 = color2;
	}

	public int getColor3() {
		return color3;
	}

	public void setColor3(int color3) {
		this.color3 = color3;
	}

	@Override
	public String toString() {
		return "TrisballDlv [xMedia=" + xMedia + ", rotation=" + rotation + ", color1=" + color1 + ", color2=" + color2
				+ ", color3=" + color3 + "]";
	}


	
	
	
}
