package utils;

import java.io.File;

public interface FileLoader {
	
	String getExtension();
	
	Sokoban load(File f);

}
