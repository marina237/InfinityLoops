package fr.dauphine.JavaAvance.Solve;


import java.util.EnumSet;
import java.util.Random;

import fr.dauphine.JavaAvance.Components.Piece;
import fr.dauphine.JavaAvance.Components.PieceType;
import fr.dauphine.JavaAvance.GUI.Grid;

/**
 * Generate a solution, number of connexe composant is not finished
 *
 */

public class Generator {

	private static Grid filledGrid;

	/**
	 * @param output
	 *            file name
	 * @throws IOException
	 *             - if an I/O error occurs.
	 * @return a File that contains a grid filled with pieces (a level)
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException
	 */
	public static void generateLevel(String fileName, Grid inputGrid) {
      
		// To be implemented
	}
	
	/**
	 * Placer les pièces dans les différents coins
	 * @param line
	 * @param column
	 * @param p
	 * @param inputGrid
	 */
	public static void PutPieceInCorner(int line, int column, Piece p, Grid inputGrid){
		Random random = new Random();	
		//Cas coin en haut à gauche 
		if (line == 0 && column == 0){
			//case qu'on constuit en première donc on n'a pas besoin de vérifier 
						
			EnumSet<PieceType> left_up = EnumSet.of(PieceType.VOID, PieceType.ONECONN, PieceType.LTYPE);			
			p.setType((PieceType) left_up.toArray()[random.nextInt(left_up.toArray().length)]);
			
			switch(p.getType()){
			/*case VOID -> p.setOrientation(0);
			case ONECONN -> p.setOrientation(random.nextInt(3-1) + 1); //nombre entre 1(inclus) et 3(exclu) donc entre 1 et 2 
			case LTYPE -> p.setOrientation(1);
			default -> break;*/
				case VOID : 
					p.setOrientation(0);
					break;
				case ONECONN : 
					p.setOrientation(random.nextInt(3-1) + 1);//nombre entre 1(inclus) et 3(exclu) donc entre 1 et 2 
					break;
				case LTYPE :
					p.setOrientation(1);
					break;
				default :
					break;
			} 
		}
		
		//Cas coin en haut à droite 
		else if (line == 0 && column == inputGrid.getWidth() - 1){
			//comme on constuit de gauche à droite et de haut en bas 
			//on doit vérifier si la case à coté (case à gauche) à une connection vers l'est 
			//si c'est le cas les pieces possibles sont ONECONN 3 et LTYPE 2
			//sinon si pas de connecteur VOID, ONECONN 2 
			if (inputGrid.getPiece(line, column - 1).hasRightConnector() == true) {
				EnumSet<PieceType> right_up_east_true = EnumSet.of(PieceType.ONECONN, PieceType.LTYPE);			
				p.setType((PieceType) right_up_east_true.toArray()[random.nextInt(right_up_east_true.toArray().length)]);

				switch(p.getType()){
					/*case ONECONN -> p.setOrientation(3); 
					case LTYPE -> p.setOrientation(2);
					default -> break;*/
					case ONECONN :
						p.setOrientation(3); 
						break;
					case LTYPE : 
						p.setOrientation(2);
						break;
					default :
						break;
				}
			}
			else {
				EnumSet<PieceType> right_up_east_false = EnumSet.of(PieceType.ONECONN, PieceType.VOID);			
				p.setType((PieceType) right_up_east_false.toArray()[random.nextInt(right_up_east_false.toArray().length)]);
				switch(p.getType()){
					/*case ONECONN -> p.setOrientation(2);
					case VOID -> p.setOrientation(0);
					default -> break; */
					case ONECONN :
						p.setOrientation(2);
						break;
					case VOID : 
						p.setOrientation(0);
						break;
					default : 
						break; 
					}
				}	
			}
		//Cas coin en bas à gauche 
		else if (line == inputGrid.getHeight() - 1 && column == 0){
			//on doit vérifier si la case du haut a une connection vers le sud
			//Si oui ONECONN 0 et LTYPE 0
			//si non, ONECONN 1, VOID, 
			if (inputGrid.getPiece(line -1 , column).hasBottomConnector() == true) {				
				EnumSet<PieceType> left_down_south_true = EnumSet.of(PieceType.ONECONN, PieceType.VOID);			
				p.setType((PieceType) left_down_south_true.toArray()[random.nextInt(left_down_south_true.toArray().length)]);
				switch(p.getType()){
					/*case ONECONN -> p.setOrientation(0);
					case LTYPE -> p.setOrientation(0);
					default -> break; */
					case ONECONN :
					case LTYPE : 
						p.setOrientation(0);
						break;
					default : 
						break;
				}
			}
			else {				
				EnumSet<PieceType> left_down_south_false = EnumSet.of(PieceType.ONECONN, PieceType.VOID);			
				p.setType((PieceType) left_down_south_false.toArray()[random.nextInt(left_down_south_false.toArray().length)]);
				switch(p.getType()){
					/*case ONECONN -> p.setOrientation(1);
					case VOID -> p.setOrientation(0);
					default -> break;*/
					case ONECONN : 
						p.setOrientation(1);
						break;
					case VOID :
						p.setOrientation(0);
						break;
					default : 
						break; 
				}
			}
		}
		
		//Cas coin en bas à droite
		else if (line == inputGrid.getHeight() && column == inputGrid.getWidth() - 1){
			if (inputGrid.getPiece(line, column - 1).hasRightConnector() == true){//EST right 
				if (inputGrid.getPiece(line -1, column).hasBottomConnector() == true) {
					p.setType(PieceType.LTYPE);
					p.setOrientation(3);
				}
				else {
					p.setType(PieceType.ONECONN);
					p.setOrientation(3);
				}
			}
			else if (inputGrid.getPiece(line, column - 1).hasRightConnector() == false){ //SUD bottom et //EST right 
				if (inputGrid.getPiece(line -1, column).hasBottomConnector() == true) { 
					p.setType(PieceType.ONECONN);
					p.setOrientation(0);
				}
				else {
					p.setType(PieceType.VOID);
					p.setOrientation(0);
				}
			}
		}
			inputGrid.setPiece(line, column, p);
	}//fin de PutPieceInCorner
	
	
	public static void PutPieceInBorderColumn(int line, int column, Piece p, Grid inputGrid){
		Random random = new Random();	
		//colonne à gauche (premiere colonne, ligne sauf premire ligne et derniere ligne 
		if (column == 0 && line > 0 && line < inputGrid.getHeight() -1 ){
			if (inputGrid.getPiece(line - 1, column).hasBottomConnector() == true) { //SOUTH connector 
				EnumSet<PieceType> left_column_south_true = EnumSet.of(PieceType.ONECONN, PieceType.BAR, PieceType.TTYPE, PieceType.LTYPE);			
				p.setType((PieceType) left_column_south_true.toArray()[random.nextInt(left_column_south_true.toArray().length)]);
				switch(p.getType()){
					case ONECONN : 
					case BAR : 
					case LTYPE : 
						p.setOrientation(0);
						break; 
					case TTYPE : 
						p.setOrientation(1);
						break;	
					default : 
						break; 	
				}
			} 
			else if (inputGrid.getPiece(line - 1, column).hasBottomConnector() == false){
				EnumSet<PieceType> left_column_south_false = EnumSet.of(PieceType.ONECONN, PieceType.LTYPE, PieceType.VOID);			
				p.setType((PieceType) left_column_south_false.toArray()[random.nextInt(left_column_south_false.toArray().length)]);
				switch(p.getType()){
					case ONECONN : 
						p.setOrientation(random.nextInt(3-1) + 1);//nombre entre 1(inclus) et 3(exclu) donc entre 1 et 2 
						break;
					case LTYPE : 
						p.setOrientation(1);
						break; 
					case VOID : 
						p.setOrientation(1);
						break;
					default :
						break;
				}
			
			}
		else if (column == inputGrid.getWidth() -1  && line > 0 && line < inputGrid.getHeight() -1 ){ //colonne de droite  
			if (inputGrid.getPiece(line - 1, column).hasBottomConnector() == true){ //SOUTH 
				if (inputGrid.getPiece(line, column - 1).hasRightConnector() == true) { //EAST
					EnumSet<PieceType> right_column_southeast_true = EnumSet.of(PieceType.TTYPE, PieceType.LTYPE);			
					p.setType((PieceType) right_column_southeast_true.toArray()[random.nextInt(right_column_southeast_true.toArray().length)]);
					p.setOrientation(3);
				}
				else if (inputGrid.getPiece(line, column - 1).hasRightConnector() == false) { // pas de co
					EnumSet<PieceType> right_column_south_true_east_false = EnumSet.of(PieceType.ONECONN, PieceType.BAR);			
					p.setType((PieceType) right_column_south_true_east_false.toArray()[random.nextInt(right_column_south_true_east_false.toArray().length)]);
					p.setOrientation(0);
				}
				
			}
			else if (inputGrid.getPiece(line - 1, column).hasBottomConnector() == false){ //SOUTH
				if (inputGrid.getPiece(line, column - 1).hasRightConnector() == true){ //EAST 
					EnumSet<PieceType> right_column_south_false_east_true = EnumSet.of(PieceType.ONECONN, PieceType.LTYPE);			
					p.setType((PieceType) right_column_south_false_east_true.toArray()[random.nextInt(right_column_south_false_east_true.toArray().length)]);
					switch(p.getType()){
						case ONECONN : 
							p.setOrientation(3);
							break; 
						case LTYPE : 
							p.setOrientation(2);
							break; 
						default : 
							break;
					}
				}else if (inputGrid.getPiece(line, column - 1).hasRightConnector() == false){
					EnumSet<PieceType> right_column_south_false_east_false = EnumSet.of(PieceType.ONECONN, PieceType.VOID);			
					p.setType((PieceType) right_column_south_false_east_false.toArray()[random.nextInt(right_column_south_false_east_false.toArray().length)]);
					switch(p.getType()){
						case ONECONN : 
							p.setOrientation(2);
							break; 
						case VOID : 
							p.setOrientation(0);
							break; 
						default : 
							break;
						}
					}
				}
			}
		}
		inputGrid.setPiece(line, column, p);
	}//fin de PutPieceInBordelColumn
	
	public static void PutPieceInBorderLine(int line, int column, Piece p, Grid inputGrid){
		Random random = new Random();	
		//ligne du haut 
		if (line == 0 && column > 0 && column < inputGrid.getWidth() -1 ){
			if (inputGrid.getPiece(line, column - 1).hasRightConnector() == true) { //EAST connector
				EnumSet<PieceType> line_up_east_true = EnumSet.of(PieceType.ONECONN, PieceType.BAR, PieceType.TTYPE, PieceType.LTYPE);			
				p.setType((PieceType) line_up_east_true.toArray()[random.nextInt(line_up_east_true.toArray().length)]);
				switch (p.getType()){
					case ONECONN : 
						p.setOrientation(3);
						break;
					case BAR : 
						p.setOrientation(1);
						break;
					case TTYPE : 
					case LTYPE : 
						p.setOrientation(2);
						break;
					default : 
						break;
				}
			} else if (inputGrid.getPiece(line, column - 1).hasRightConnector() == false){
				EnumSet<PieceType> line_up_east_false = EnumSet.of(PieceType.ONECONN, PieceType.LTYPE, PieceType.VOID);			
				p.setType((PieceType) line_up_east_false.toArray()[random.nextInt(line_up_east_false.toArray().length)]);
				switch(p.getType()){
					case ONECONN : 
						p.setOrientation(random.nextInt(3-1) + 1);//nombre entre 1(inclus) et 3(exclu) donc entre 1 et 2 
						break;
					case LTYPE : 
						p.setOrientation(1);
						break;
					case VOID : 
						p.setOrientation(0);
						break;
					default : 
						break;
				}
			}				
		}
		//ligne du bas
		else if (line == inputGrid.getHeight() -1 && column > 0 && column < inputGrid.getWidth() -1){
			//EAST TRUE AND SOUTH TRUE
			if(inputGrid.getPiece(line, column - 1).hasRightConnector() == true){
				if (inputGrid.getPiece(line - 1, column).hasBottomConnector() == true){
					EnumSet<PieceType> line_down_east_true_south_true = EnumSet.of(PieceType.TTYPE, PieceType.LTYPE);			
					p.setType((PieceType) line_down_east_true_south_true.toArray()[random.nextInt(line_down_east_true_south_true.toArray().length)]);
					switch(p.getType()){
						case TTYPE : 
							p.setOrientation(0);
							break;
						case LTYPE : 
							p.setOrientation(3);
							break;	
						default : 
							break; 
					}
					
				}
				//EAST TRUE AND SOUTH FALSE
				else if(inputGrid.getPiece(line - 1, column).hasBottomConnector() == false){
					EnumSet<PieceType> line_down_east_true_south_false = EnumSet.of(PieceType.ONECONN, PieceType.BAR);			
					p.setType((PieceType) line_down_east_true_south_false.toArray()[random.nextInt(line_down_east_true_south_false.toArray().length)]);
					switch(p.getType()){
						case ONECONN : 
							p.setOrientation(3);
							break;
						case BAR : 
							p.setOrientation(1);
							break;	
						default : 
							break; 
					}
				}
			}//EAST FALSE AND SOUTH TRUE
			else if (inputGrid.getPiece(line, column - 1).hasRightConnector() == false){
				if (inputGrid.getPiece(line - 1, column).hasBottomConnector() == true){
					EnumSet<PieceType> line_down_east_false_south_true = EnumSet.of(PieceType.ONECONN, PieceType.LTYPE);			
					p.setType((PieceType) line_down_east_false_south_true.toArray()[random.nextInt(line_down_east_false_south_true.toArray().length)]);
					switch(p.getType()){
						case ONECONN : 
						case LTYPE : 
							p.setOrientation(0);
							break;
						default : 
							break; 
					}
				}
				//EAST FALSE AND SOUTH FALSE
				else if (inputGrid.getPiece(line - 1, column).hasBottomConnector() == false){
					EnumSet<PieceType> line_down_east_false_south_false = EnumSet.of(PieceType.ONECONN, PieceType.VOID);			
					p.setType((PieceType) line_down_east_false_south_false.toArray()[random.nextInt(line_down_east_false_south_false.toArray().length)]);
					switch(p.getType()){
						case ONECONN : 
							p.setOrientation(1);
							break;
						case VOID : 
							p.setOrientation(0);
							break;
						default : 
							break; 
					}
				}
			}
		}
		inputGrid.setPiece(line, column, p);
	}//fin de PutPieceInBordelLine
	
	
	public static void PutPieceInTheCenter(int line, int column, Piece p, Grid inputGrid){
		//en cours de construction
	}//fin de PutPieceInTheCenter
	
	/**
	 * Permet de mélanger les pièces après avoir générer un niveau
	 * @param grid
	 * @return grid 
	 */
	public static Grid Mixed (Grid grid){
		//en cours de construction
		return grid;
		} 
	
	
	public static int[] copyGrid(Grid filledGrid, Grid inputGrid, int i, int j) {
		Piece p;
		int hmax = inputGrid.getHeight();
		int wmax = inputGrid.getWidth();

		if (inputGrid.getHeight() != filledGrid.getHeight())
			hmax = filledGrid.getHeight() + i; // we must adjust hmax to have the height of the original grid
		if (inputGrid.getWidth() != filledGrid.getWidth())
			wmax = filledGrid.getWidth() + j;

		int tmpi = 0;// temporary variable to stock the last index
		int tmpj = 0;

		// DEBUG System.out.println("copyGrid : i =" + i + " & j = " + j);
		// DEBUG System.out.println("hmax = " + hmax + " - wmax = " + wmax);
		for (int x = i; x < hmax; x++) {
			for (int y = j; y < wmax; y++) {
				// DEBUG System.out.println("x = " + x + " - y = " + y);
				p = filledGrid.getPiece(x - i, y - j);
				// DEBUG System.out.println("x = " + x + " - y = " +
				// y);System.out.println(p);
				inputGrid.setPiece(x, y, new Piece(x, y, p.getType(), p.getOrientation()));
				// DEBUG System.out.println("x = " + x + " - y = " +
				// y);System.out.println(inputGrid.getPiece(x, y));
				tmpj = y;
			}
			tmpi = x;
		}
		//DEBUGSystem.out.println("tmpi =" + tmpi + " & tmpj = " + tmpj);
		return new int[] { tmpi, tmpj };
	}

}