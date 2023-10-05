package objects;

import pt.iscte.guitoo.Point;

public class Caixote extends Objeto{
	public Caixote(Point p) {
		super(p);
        setImagem("images/Caixote.png");
        setTransponivel(false);
        setCamada(2);
        setMovivel(true);
	}
}
