package objects;

import pt.iscte.guitoo.Point;

public class BigRock extends Objeto{
	public BigRock(Point p) {
		super(p);
        setImagem("images/BigRock.png");
        setTransponivel(false);
	}
}