package utils;

import java.util.ArrayList;

import objects.*;
import pt.iscte.guitoo.Point;

public class FabricaObjetos {

	public FabricaObjetos() {
	}

	public ArrayList<Objeto> criarObj(char c, Point point) {
		ArrayList<Objeto> aux = new ArrayList<>();

		switch (c) {
		case 'E':
			aux.add(new Empilhadora(point));
			aux.add(new Chao(point));
			break;
		case '#':
			aux.add(new Parede(point));
			break;
		case 'X':
			aux.add(new Alvo(point));
			break;
		case 'C':
			aux.add(new Caixote(point));
			aux.add(new Chao(point));
			break;
		case 'B':
			aux.add(new Bateria(point));
			aux.add(new Chao(point));
		case 'V':
			aux.add(new Chao(point));

			aux.add(new Veneno(point));
			
		case 'M':
			
			aux.add(new BigRock(point));
			aux.add(new Chao(point));

		case 'N':
			aux.add(new LittleRock(point));
			aux.add(new Chao(point));

		case 'O':
			aux.add(new Buraco(point));
		default:
			aux.add(new Chao(point));
			break;		
		}
		return aux;
	}

}
