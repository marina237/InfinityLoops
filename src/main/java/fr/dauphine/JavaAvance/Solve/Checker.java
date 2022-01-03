package fr.dauphine.JavaAvance.Solve;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import fr.dauphine.JavaAvance.Components.Piece;
import fr.dauphine.JavaAvance.GUI.Grid;


public class Checker {
	
	// To be implemented
	
	/**
	 * Generate a grid based on the provided solution in the file
	 * @param inputFile          
	 * @throws IOException
	 *         
	 */
	
	//on doit retourner SOLVED : true et SOLVED : false dans standard output : normalement fait 

	public static Grid buildGrid(String inputFile) throws IOException {
		//generate a grid based on the provided solution in the file (on doit lire le fichier créer dans generator?)
		
		FileReader Reader = new FileReader(inputFile);
		BufferedReader br = new BufferedReader(Reader);
				
		//si on met pas Intefer.valueOf() la ligne sera lu en String donc pour convertir en int 
		int w = Integer.valueOf(br.readLine()); //lire première ligne pour récuperer la largeur 
		int h = Integer.valueOf(br.readLine()); //lire la seconde ligne pour récupérer la hauteur 
		
		//lire les types et les orientations de pièce
		//en cours de construction
		
		Grid grid = new Grid(w, h); //generer la grille avec w et h 
		br.close();
		
		return grid;
	}
	
	/**
	 * 
	 * @param inputFile          
	 * @throws IOException
	 * @return True if all the piece are connected, else it will return False
	 * If all piece are connected it means that the game is solved
	 */
	public static boolean isSolution(String inputFile) throws IOException {
		//en cours de construction
		//utiliser isTotallyConnected dans grid 
		/*for (Piece[] x : grid.getAllPieces()) {
			for (Piece y :x) {
				if (grid.isTotallyConnected(y) == true) {
					return true; 
			}
		}
	}*/
		return false;
		
	}

	
}
