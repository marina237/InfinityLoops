package fr.dauphine.JavaAvance.Solve;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Objects;
import java.util.Stack;

import fr.dauphine.JavaAvance.Components.Orientation;
import fr.dauphine.JavaAvance.Components.Pair;
import fr.dauphine.JavaAvance.Components.Piece;
import fr.dauphine.JavaAvance.Components.PieceType;
import fr.dauphine.JavaAvance.GUI.Grid;

import java.util.Stack;

public class Solver {
	
	
	/**
	 * Champs
	 * 
	 */
	
	private Grid jeuInitial;
	private int height;
	
	private int width;
	
	private Piece[][] pieces;
	
	private int compteur; 
	
	private Stack<Grid> pile = new Stack<>();
	

	/**
	 * @param jeuInitial
	 * @param height
	 * @param width
	 * @param pieces
	 * @param compteur
	 * @param pile
	 */
	public Solver(Grid jeuInitial) {
		super();
		this.jeuInitial = jeuInitial;
		this.height = jeuInitial.getHeight();
		this.width = jeuInitial.getWidth();
		this.pieces = jeuInitial.getAllPieces();
	
	
	}
	
	

	
	
	public Grid solve() throws IOException{
		
		Grid etatInitial = new Grid(0, 0);
		
		
		pile.push(etatInitial);
		
		
		pile.push(jeuInitial);
		
		while(!pile.isEmpty()) {
			
			compteur++;
			
			Grid outc= pile.peek();
			
			int x = outc.getHeight();
			
			int y = outc.getWidth();
			
			
			
			Grid etatCourant = outc;
			
			if (Checker.isSolution(outc.toString())) {
				
				return etatCourant;
			}
			
			
			 for (int i = 0;i  < pieces.length;i ++) {
				for (int j = 0; j < pieces.length; j++) {
					
					
					
					
					
					
				}
			}
				
				

			}
		return etatInitial;
			
		}
		
		
		
		
		
		
		
		

	
	
	
	
	
	
	
	
	
	
	
	





























	public static void main(String[] args) {

		// To be implemented
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}
	
	/**
	 * Choice the piece to be tested 
	 * Fixer les pièces pour quelles ne soient pas testées 
	 * @param grid
	 * @param p
	 */
	//remplacer grid par input file 
	//a revoir 
	public static void PieceNotToBeTested (Grid grid, Piece p) {
		if (p.isFixed() == false) {
			//si la pièce est FOURCONN ou VOID, on la fixe car une seule position possible 
			if (p.getType() == PieceType.FOURCONN || p.getType() == PieceType.VOID) {
				p.setFixed(true);
			}
			else {
				for (int line = 0; line < grid.getHeight(); line++) {
					for (int column = 0; column < grid.getWidth(); column++) {
						//coin en haut à gauche 
						if (grid.isCorner(line, column) == true) {
							if (line == 0 && column == 0) {
								if (p.getType() == PieceType.LTYPE) {
									p.setOrientation(1);
									p.setFixed(true);
								}
							}	
							//coin en haut à droite 
							else if (line == 0 && column == grid.getWidth() -1 ) {
								if (p.getType() == PieceType.LTYPE) {
									p.setOrientation(2);
									p.setFixed(true);
								}
							}
							//coin en bas à gauche 
							else if (line == grid.getHeight() -1 && column == 0) {
								if (p.getType() == PieceType.LTYPE) {
									p.setOrientation(0);
									p.setFixed(true);
								}
							}
							//coin en bas à droite 
							else if (line == grid.getHeight() -1 && column == grid.getWidth() -1 ) {
								if (p.getType() == PieceType.LTYPE) {
									p.setOrientation(3);
									p.setFixed(true);
								}
							}
						}
						else if (grid.isBorderLine(line, column) == true) {
							//premiere ligne 
							if (line == 0) {
								if (p.getType() == PieceType.TTYPE) {
									p.setOrientation(2);
									p.setFixed(true);
								}
								else if (p.getType() == PieceType.BAR) {
									p.setOrientation(1);
									p.setFixed(true);
								}
							}
							//derniere ligne
							else if (line == grid.getHeight() - 1) {
								if (p.getType() == PieceType.TTYPE) {
									p.setOrientation(0);
									p.setFixed(true);
								}
								else if (p.getType() == PieceType.BAR) {
									p.setOrientation(1);
									p.setFixed(true);
								}
							}
						}
						else if (grid.isBorderColumn(line, column) == true) {
							//premiere colonne 
							if (column == 0) {
								if (p.getType() == PieceType.TTYPE) {
									p.setOrientation(1);
									p.setFixed(true);
								}
								else if (p.getType() == PieceType.BAR) {
									p.setOrientation(0);
									p.setFixed(true);
								}
							}
							//dernire colonne
							else if (column == grid.getWidth() -1) {
								if (p.getType() == PieceType.TTYPE) {
									p.setOrientation(3);
									p.setFixed(true);
								}
								else if (p.getType() == PieceType.BAR) {
									p.setOrientation(0);
									p.setFixed(true);
								}
							}
							
						}	
						
					}

				}
				
			}
			
		}
		
	}
}
