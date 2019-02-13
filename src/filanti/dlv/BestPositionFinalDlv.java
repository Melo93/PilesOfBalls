package filanti.dlv;

import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;

@Id("bestPosition")
public class BestPositionFinalDlv {
	@Param(0)
	private int xM;
	@Param(1)
	private int r;
	
	public BestPositionFinalDlv() {
	}

	public BestPositionFinalDlv(int xM, int r) {
		super();
		this.xM = xM;
		this.r = r;
	}

	public int getXM() {
		return xM;
	}

	public void setXM(int xM) {
		this.xM = xM;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	@Override
	public String toString() {
		return "BestPositionFInalDlv [xM=" + xM + ", r=" + r + "]";
	}
	
	
	
}
