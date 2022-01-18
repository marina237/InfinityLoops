package fr.dauphine.JavaAvance.Solve;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import fr.dauphine.JavaAvance.Components.Piece;
import fr.dauphine.JavaAvance.GUI.Grid;


public class Checker {
	
	// To be implemented
	
	/**
	 * Generate a grid based on the provided solution in the file (lire le fichier qu'on a cree
	 * @param inputFile          
	 * @throws IOException
	 * @return grid
	 */
	
	//on doit retourner SOLVED : true et SOLVED : false dans standard output : normalement fait 

	public static Grid buildGrid(String inputFile) throws IOException {
		//generate a grid based on the provided solution in the file (on doit lire le fichier créer dans generator?)
		
			//lire le fichier en entree
			FileReader Reader = new FileReader(inputFile);
					BufferedReader br = new BufferedReader(Reader);
				
				//si on met pas Intefer.valueOf() la ligne sera lu en String donc pour convertir en int 
				int w = Integer.valueOf(br.readLine()); //lire première ligne pour récuperer la largeur 
				int h = Integer.valueOf(br.readLine()); //lire la seconde ligne pour récupérer la hauteur 
				Grid grid = new Grid(w, h); //generer la grille avec w et h 
				
				for (int i = 0; i < w ; i++ ) {
					for (int j= 0 ; j < h; j ++) {
						//en cours de construction
						//le fichier est constuire avec sur chaque ligne pieceType PieceOrientation
						//on veut recuperer ces valeurs 
						String [] data = br.readLine().split(" "); //on divise la ligne en deux premier partie avant lespace et deuxieme apres lespace
						//lire les types et les orientations de pièce
						String type = data[0];
						String orientation = data[1];
						 
						grid.setPiece(i, j, new Piece(i,j ,Integer.valueOf(type), Integer.valueOf(orientation)));
					}
				}
					br.close();
			
				return grid; 
				
				/*catch (FileNotFoundException e){
					System.out.println("File Not Found");} */
			
	}

	
	/**
	 * Recupere la grille de buildGrid est verifie si les toutes pieces sont connectees
	 * @param inputFile          
	 * @throws IOException
	 * @return True if all the piece are connected, else it will return False
	 * If all piece are connected it means that the game is solved
	 */
	public static boolean isSolution(String inputFile) throws IOException {
		//utiliser isTotallyConnected dans grid
		//on recupere la grille a l'aide de buildgrid
		Grid grid = buildGrid(inputFile);
		for (Piece[] x : grid.getAllPieces()) {
			for (Piece y :x) {
				if (grid.isTotallyConnected(y) == true) {
					return true; //la grille resolu 
			}
		}
	}
		return false;//la grille n'est pas resolu 
		
	}

	public static boolean isSolution(Grid grid) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
