package filanti.dlv;

import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;

@Id("finalPosition")
public class FinalPositionDlv {
	
	@Param(0)
	private BallDLV p1;
	@Param(1)
	private BallDLV p2;
	@Param(2)
	private BallDLV p3;
	
	public FinalPositionDlv(BallDLV p1, BallDLV p2, BallDLV p3) {
		super();
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
	}

	public FinalPositionDlv() {
		// TODO Auto-generated constructor stub
	}

	public BallDLV getP1() {
		return p1;
	}

	public void setP1(BallDLV p1) {
		this.p1 = p1;
	}

	public BallDLV getP2() {
		return p2;
	}

	public void setP2(BallDLV p2) {
		this.p2 = p2;
	}

	public BallDLV getP3() {
		return p3;
	}

	public void setP3(BallDLV p3) {
		this.p3 = p3;
	}

	@Override
	public String toString() {
		return "FinalPositionDlv [p1=" + p1 + ", p2=" + p2 + ", p3=" + p3 + "]";
	}
	
	
}
