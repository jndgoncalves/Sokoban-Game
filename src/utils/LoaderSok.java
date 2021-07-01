package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import objects.*;
import pt.iscte.guitoo.Point;

public class LoaderSok implements FileLoader{

	@Override
	public String getExtension() {
		return null;
	}

	@Override
	public Sokoban load(File f) {
		try {
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(f);
			
			ArrayList<Objeto> listaObj = new ArrayList<>();
			FabricaObjetos fo = new FabricaObjetos();

			int alvosDoNivel = 0;
			int energia = scanner.nextInt();
			int linhas = scanner.nextInt();
			int colunas = scanner.nextInt();
			int contadorLinha = 0;

			ArrayList<Objeto> listaObjAux = new ArrayList<>();
			ArrayList<Objeto> objCamada3 = new ArrayList<>();
			ArrayList<Objeto> objCamada2 = new ArrayList<>();
			ArrayList<Objeto> objCamada1 = new ArrayList<>();

			scanner.nextLine();
			while(scanner.hasNextLine()) {
				String linhaFich = scanner.nextLine();

				for (int i = 0; i < linhaFich.length(); i++) {
					char c = linhaFich.charAt(i);
					ArrayList<Objeto> ob = fo.criarObj(c, new Point(contadorLinha, i));
					listaObjAux.addAll(ob);
				}
				contadorLinha++;
			}

			
//			Foi necessário adicionar camada aos objetos,
//			adicionando-os a diferentes lista para os poder adiconar
//			à lista de objetos por uma certa ordem (empilhadora primeiro, caixas segundo etc).
//			Ocorria um bug em que tudo o que fosse desenhado primeiro que a empilhadora
//			sobrepunha-se à mesma na GUI
			for (int j = 0; j < listaObjAux.size(); j++) {
				Objeto o = listaObjAux.get(j);
				if (o.getCamada() == 3) {
					objCamada3.add(o);
				}else if (o.getCamada() == 2) {
					objCamada2.add(o);
				}else if (o.getCamada() == 1) {
					objCamada1.add(o);
				}else { 
					listaObj.add(o);
				}

				if (o instanceof Alvo) {
					alvosDoNivel++;
				}
			}
			listaObj.addAll(objCamada3);			
			listaObj.addAll(objCamada2);
			listaObj.addAll(objCamada1);
			
			Sokoban soko = new Sokoban(linhas, colunas, energia, listaObj, alvosDoNivel);
			return soko;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

}
