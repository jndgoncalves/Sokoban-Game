package objects;

import pt.iscte.guitoo.Point;

public class LittleRock extends Objeto{
	public LittleRock(Point p) {
		super(p);
        setImagem("images/LittleRock.png");
        setTransponivel(false);
	}
}