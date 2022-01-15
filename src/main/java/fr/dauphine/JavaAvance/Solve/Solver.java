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
		
	} // fin de piece not to be tested 
	
	public static void PieceNotToBeTestedIfNeighborsAreFixed (Grid grid, Piece p) {
		
		Piece leftNeighbor = grid.leftNeighbor(p) ;
		Piece rightNeighbor = grid.rightNeighbor(p);
		Piece topNeighbor = grid.topNeighbor(p);
		Piece bottomNeighbor = grid.bottomNeighbor(p) ;
		
		for (int line = 0; line < grid.getWidth(); line ++) {
			for (int column = 0; column < grid.getHeight(); column++) {

				
				if (line == 0 && column == 0) {
					if(p.getType() == PieceType.LTYPE) {
						if(rightNeighbor.isFixed() == false) {
							if(rightNeighbor.getType() == PieceType.ONECONN) {
								rightNeighbor.setOrientation(3);
								rightNeighbor.setFixed(true);
							}
							else if (rightNeighbor.getType() == PieceType.LTYPE) {
								rightNeighbor.setOrientation(2);
								rightNeighbor.setFixed(true);
							}
						}else if (bottomNeighbor.isFixed() == false) {
							if(bottomNeighbor.getType() == PieceType.ONECONN || bottomNeighbor.getType() == PieceType.LTYPE) {
								bottomNeighbor.setOrientation(0);
								bottomNeighbor.setFixed(true);
							}
						}
					}else if (p.getType() == PieceType.VOID) {
						if(rightNeighbor.isFixed() == false) {
							if(rightNeighbor.getType() == PieceType.LTYPE) {
								rightNeighbor.setOrientation(1);
								rightNeighbor.setFixed(true);
							}
						} else if(bottomNeighbor.isFixed() == false) {
							bottomNeighbor.setOrientation(1);
							bottomNeighbor.setFixed(true);
						}
					}
				}
				
				//corner premiere ligne derniere colonne
				else if(line == 0 && column == grid.getWidth() -1) {
					if(p.getType() == PieceType.LTYPE) {
						if(leftNeighbor.isFixed()== false) {
							if(leftNeighbor.getType() == PieceType.LTYPE) {
								leftNeighbor.setOrientation(1);
								leftNeighbor.setFixed(true);
							} else if(leftNeighbor.getType() == PieceType.ONECONN) {
								leftNeighbor.setOrientation(1);
								leftNeighbor.setFixed(true);
							}
						}else if(bottomNeighbor.isFixed() == false) {
							if(bottomNeighbor.getType() == PieceType.LTYPE) {
								bottomNeighbor.setOrientation(3);
								bottomNeighbor.setFixed(true);
							}else if(bottomNeighbor.getType() == PieceType.ONECONN) {
								bottomNeighbor.setOrientation(0);
								bottomNeighbor.setFixed(true);
							}
						}
					} 
					else if (p.getType() == PieceType.VOID) {
						if(leftNeighbor.isFixed() == false) {
							if(leftNeighbor.getType() == PieceType.LTYPE) {
								leftNeighbor.setOrientation(2);
								leftNeighbor.setFixed(true);
							}
						}
					}
				}
				
				
				//premier colonne derniere ligne
				else if(column == 0 && line == grid.getHeight() -1) {
					if(p.getType() == PieceType.LTYPE) {
						if(topNeighbor.isFixed() == false) {
							if(topNeighbor.getType() == PieceType.ONECONN) {
								topNeighbor.setOrientation(2);
								topNeighbor.setFixed(true);
							}
							if(topNeighbor.getType() == PieceType.LTYPE) {
								topNeighbor.setOrientation(1);
								topNeighbor.setFixed(true);
							}
						}
						else if(rightNeighbor.isFixed() == false) {
							if(rightNeighbor.getType() == PieceType.ONECONN || rightNeighbor.getType() == PieceType.LTYPE) {
								rightNeighbor.setOrientation(3);
								rightNeighbor.setFixed(true);
							}
						}
					}
					else if (p.getType() == PieceType.VOID) {
						if(rightNeighbor.isFixed() == false) {
							if(rightNeighbor.getType() == PieceType.LTYPE) {
								rightNeighbor.setOrientation(0);
								rightNeighbor.setFixed(true);
							}
						}
					}
				}
				
				
				//dernier colonne et derniere ligne 
				else if(column == grid.getWidth() -1 && line == grid.getHeight() -1) {
					if(p.getType() == PieceType.LTYPE) {
						if(topNeighbor.isFixed() == false) {
							if(topNeighbor.getType() == PieceType.LTYPE || topNeighbor.getType() == PieceType.ONECONN) {
								topNeighbor.setOrientation(2);
								topNeighbor.setFixed(true);
							}
						}
						else if(leftNeighbor.isFixed() == false) {
							if(leftNeighbor.getType() == PieceType.ONECONN) {
								leftNeighbor.setOrientation(1);
								leftNeighbor.setOrientation(0);
							}
						}
					}
				}
				
				//BORDER LINE TOP
				else if(line == 0 && column > 0 && column < grid.getWidth() -1) {
					if(p.getType() == PieceType.TTYPE) {
						if(leftNeighbor.isFixed() == false) {
							if(leftNeighbor.getType() == PieceType.ONECONN || rightNeighbor.getType() == PieceType.LTYPE) {
								leftNeighbor.setOrientation(1);
								leftNeighbor.setFixed(true);
							}
						}
						else if(rightNeighbor.isFixed() == false) {
							if(rightNeighbor.getType() == PieceType.ONECONN) {
								rightNeighbor.setOrientation(3);
								rightNeighbor.setFixed(true);
							}
							else if(rightNeighbor.getType() == PieceType.LTYPE) {
								rightNeighbor.setOrientation(2);
								rightNeighbor.setFixed(true);
							}
						}
						else if(bottomNeighbor.isFixed() == false) {
							if(bottomNeighbor.getType() == PieceType.ONECONN || bottomNeighbor.getType() == PieceType.BAR) {
								bottomNeighbor.setOrientation(0);
								bottomNeighbor.setFixed(true);
							}
						}
					}
					else if(p.getType() == PieceType.BAR) {
						if(leftNeighbor.isFixed() == false) {
							if(leftNeighbor.getType() == PieceType.ONECONN || leftNeighbor.getType() == PieceType.LTYPE) {
								leftNeighbor.setOrientation(1);
								leftNeighbor.setFixed(true);
							}
						}
						else if (rightNeighbor.isFixed() == false) {
							if(rightNeighbor.getType() == PieceType.ONECONN) {
								rightNeighbor.setOrientation(3);
								rightNeighbor.setFixed(true);
							}
							else if(rightNeighbor.getType() == PieceType.LTYPE) {
								rightNeighbor.setOrientation(2);
								rightNeighbor.setFixed(true);
							}
						}
						else if(bottomNeighbor.isFixed() == false) {
							if(bottomNeighbor.getType() == PieceType.LTYPE) {
								bottomNeighbor.setOrientation(2);
								bottomNeighbor.setFixed(true);
							}
							else if(bottomNeighbor.getType() == PieceType.BAR) {
								bottomNeighbor.setOrientation(1);
								bottomNeighbor.setFixed(true);
							}
						}
					}
					else if(p.getType() == PieceType.VOID) {
						if (bottomNeighbor.isFixed() == false) {
							if(bottomNeighbor.getType() == PieceType.BAR) {
								bottomNeighbor.setOrientation(1);
								bottomNeighbor.setFixed(true);
							}
							else if(bottomNeighbor.getType() == PieceType.TTYPE) {
								bottomNeighbor.setOrientation(2);
								bottomNeighbor.setFixed(true);
								}
							}
						else if(leftNeighbor.isFixed() == false) {
							if(leftNeighbor.getType() == PieceType.LTYPE) {
								leftNeighbor.setOrientation(2);
								leftNeighbor.setFixed(true);
							}
						}
						else if(rightNeighbor.isFixed() == false) {
							if(rightNeighbor.getType() == PieceType.LTYPE) {
								rightNeighbor.setOrientation(1);
								rightNeighbor.setFixed(true);
							}
						}
					}
				}
				else if(column == 0 && line > 0 && line < grid.getHeight() -1) {
					if(p.getType() == PieceType.BAR) {
						if(topNeighbor.isFixed() == false) {
							if(topNeighbor.getType() == PieceType.ONECONN) {
								topNeighbor.setOrientation(2);
								topNeighbor.setFixed(true);
							}
							else if (topNeighbor.getType() == PieceType.LTYPE) {
								topNeighbor.setOrientation(1);
								topNeighbor.setFixed(true);
							}
						}
						else if(bottomNeighbor.isFixed() == false) {
							if(bottomNeighbor.getType() == PieceType.ONECONN || bottomNeighbor.getType() == PieceType.LTYPE) {
								bottomNeighbor.setOrientation(0);
								bottomNeighbor.setFixed(true);
							}
						}
						else if(rightNeighbor.isFixed() == false) {
							if(rightNeighbor.getType() == PieceType.BAR) {
								rightNeighbor.setOrientation(0);
								rightNeighbor.setFixed(true);
							}
							else if(rightNeighbor.getType() == PieceType.TTYPE) {
								rightNeighbor.setOrientation(1);
								rightNeighbor.setFixed(true);
							}
						}
						
					}
					else if(p.getType() == PieceType.TTYPE) {
						if(topNeighbor.isFixed() == false) {
							if(topNeighbor.getType() == PieceType.ONECONN) {
								topNeighbor.setOrientation(2);
								topNeighbor.setFixed(true);
							}
							else if(topNeighbor.getType() == PieceType.LTYPE) {
								topNeighbor.setOrientation(1);
								topNeighbor.setFixed(true);
							}
						}
						else if(bottomNeighbor.isFixed() == false) {
							if(bottomNeighbor.getType() == PieceType.ONECONN || bottomNeighbor.getType() == PieceType.LTYPE) {
								bottomNeighbor.setOrientation(0);
								bottomNeighbor.setFixed(true);
							}
						}
						else if(rightNeighbor.isFixed() == false) {
							if(rightNeighbor.getType() == PieceType.BAR) {
								rightNeighbor.setOrientation(1);
								rightNeighbor.setFixed(true);
							}
							else if(rightNeighbor.getType() == PieceType.ONECONN) {
								rightNeighbor.setOrientation(3);
								rightNeighbor.setFixed(true);
							}
						}	
					}
					else if(p.getType() == PieceType.VOID) {
						if(topNeighbor.isFixed() == false) {
							if(topNeighbor.getType() == PieceType.LTYPE) {
								topNeighbor.setOrientation(0);
								topNeighbor.setFixed(true);
							}
						}
						else if(bottomNeighbor.isFixed() == false) {
							if(bottomNeighbor.getType() == PieceType.LTYPE) {
								bottomNeighbor.setOrientation(1);
								bottomNeighbor.setFixed(true);
							}
						}
						else if(rightNeighbor.isFixed() == false) {
							if(rightNeighbor.getType() == PieceType.BAR) {
								rightNeighbor.setOrientation(0);
								rightNeighbor.setFixed(true);
							}
							else if(rightNeighbor.getType() == PieceType.TTYPE) {
								rightNeighbor.setOrientation(1);
								rightNeighbor.setFixed(true);
							}
						}
					}
				}//fin de leftborder
				else if(column > 0 && column < grid.getWidth() -1 && line == grid.getHeight() -1) {
					if(p.getType() == PieceType.TTYPE) {
						if(rightNeighbor.isFixed() == false) {
							if(rightNeighbor.getType() == PieceType.ONECONN || rightNeighbor.getType() == PieceType.LTYPE) {
								rightNeighbor.setOrientation(3);
								rightNeighbor.setFixed(true);
							}
					}
					else if(topNeighbor.isFixed() == false) {
						if(topNeighbor.getType() == PieceType.BAR) {
							topNeighbor.setOrientation(0);
							topNeighbor.setFixed(true);
						}
						else if(topNeighbor.getType() == PieceType.ONECONN) {
							topNeighbor.setOrientation(2);
							topNeighbor.setFixed(true);
							}
						}
					else if(leftNeighbor.isFixed() == false) {
						if(leftNeighbor.getType() == PieceType.ONECONN) {
							leftNeighbor.setOrientation(1);
							leftNeighbor.setFixed(true);
						}
						else if(leftNeighbor.getType() == PieceType.LTYPE) {
							leftNeighbor.setOrientation(0);
							leftNeighbor.setFixed(true);
						}
					}
					}
					else if(p.getType() == PieceType.BAR) {
						if(rightNeighbor.isFixed() == false) {
							if(rightNeighbor.getType() == PieceType.ONECONN || rightNeighbor.getType() == PieceType.LTYPE) {
								rightNeighbor.setOrientation(3);
								rightNeighbor.setFixed(true);
							}
						}
						else if(leftNeighbor.isFixed() == false) {
							if(leftNeighbor.getType() == PieceType.ONECONN) {
								leftNeighbor.setOrientation(1);
								leftNeighbor.setFixed(true);
							}
							else if(leftNeighbor.getType() == PieceType.LTYPE) {
								leftNeighbor.setOrientation(0);
								leftNeighbor.setFixed(true);
							}
						}
						else if(topNeighbor.isFixed() == false) {
							if(topNeighbor.getType() == PieceType.TTYPE) {
								topNeighbor.setOrientation(0);
								topNeighbor.setFixed(true);
							}
							else if(topNeighbor.getType() == PieceType.BAR) {
								topNeighbor.setOrientation(1);
								topNeighbor.setFixed(true);
							}
						}
					}
					else if(p.getType() == PieceType.VOID) {
						if(rightNeighbor.isFixed() == false) {
							if(rightNeighbor.getType() == PieceType.LTYPE) {
								rightNeighbor.setOrientation(0);
								rightNeighbor.setFixed(true);
							}
						}
						else if(leftNeighbor.isFixed() == false) {
							if(leftNeighbor.getType() == PieceType.LTYPE) {
								leftNeighbor.setOrientation(3);
								leftNeighbor.setFixed(true);
							}
						}
						else if(topNeighbor.isFixed() == false) {
							if(topNeighbor.getType() == PieceType.BAR) {
								topNeighbor.setOrientation(1);
								topNeighbor.setFixed(true);
							}
							else if(topNeighbor.getType() == PieceType.TTYPE) {
								topNeighbor.setOrientation(0);
								topNeighbor.setFixed(true);
							}
						}
					}
				}// fin de bottom border
				else if(line > 0 && line < grid.getHeight() -1 && column == grid.getWidth() -1) {
					if(p.getType() == PieceType.TTYPE) {
						if(leftNeighbor.isFixed() == false) {
							if(leftNeighbor.getType() == PieceType.BAR || leftNeighbor.getType() == PieceType.ONECONN) {
								leftNeighbor.setOrientation(1);
								leftNeighbor.setFixed(true);
							}
						}
						if(bottomNeighbor.isFixed() == false) {
							if(bottomNeighbor.getType() == PieceType.LTYPE) {
								bottomNeighbor.setOrientation(3);
								bottomNeighbor.setFixed(true);
							}
							else if(bottomNeighbor.getType() == PieceType.ONECONN) {
								bottomNeighbor.setOrientation(0);
								bottomNeighbor.setFixed(true);
							}
						}
						if(topNeighbor.isFixed() == false) {
							if(topNeighbor.getType() == PieceType.ONECONN || topNeighbor.getType() == PieceType.LTYPE) {
								topNeighbor.setOrientation(2);
								topNeighbor.setFixed(true);
							}
						}
					}
					else if(p.getType() == PieceType.BAR) {
						if(leftNeighbor.isFixed() == false) {
							if(leftNeighbor.getType() == PieceType.BAR) {
								leftNeighbor.setOrientation(0);
								leftNeighbor.setFixed(true);
							}
							else if(leftNeighbor.getType() == PieceType.TTYPE) {
								leftNeighbor.setOrientation(3);
								leftNeighbor.setFixed(true);
							}
						}
						if(bottomNeighbor.isFixed() == false) {
							if(bottomNeighbor.getType() == PieceType.ONECONN) {
								bottomNeighbor.setOrientation(0);
								bottomNeighbor.setFixed(true);
							}
							else if(bottomNeighbor.getType() == PieceType.LTYPE) {
								bottomNeighbor.setOrientation(3);
								bottomNeighbor.setFixed(true);
							}
						}
						if(topNeighbor.isFixed() == false) {
							if(topNeighbor.getType() == PieceType.ONECONN || topNeighbor.getType() == PieceType.LTYPE) {
								topNeighbor.setOrientation(2);
								topNeighbor.setFixed(true);
							}
						}
					}
					else if(p.getType() == PieceType.VOID) {
						if(leftNeighbor.isFixed() == false) {
							if(leftNeighbor.getType() == PieceType.BAR) {
								leftNeighbor.setOrientation(0);
								leftNeighbor.setFixed(true);
							}
							else if(leftNeighbor.getType() == PieceType.LTYPE) {
								leftNeighbor.setOrientation(3);
								leftNeighbor.setFixed(true);
							}
						}
						if(bottomNeighbor.isFixed() == false) {
							if(bottomNeighbor.getType() == PieceType.LTYPE) {
								bottomNeighbor.setOrientation(2);
								bottomNeighbor.setFixed(true);
							}
						}
						if(topNeighbor.isFixed() == false) {
							if(topNeighbor.getType() == PieceType.LTYPE) {
								topNeighbor.setOrientation(3);
								topNeighbor.setFixed(true);
							}
						}
					}
				}//Fin de right border
				//middle
				else if(line > 0  && line < grid.getHeight() -1 && column > 0 && column < grid.getWidth() -1) {
					if(p.getType() == PieceType.VOID) {
						if(topNeighbor.isFixed() == false) {
							if(topNeighbor.getType() == PieceType.BAR) {
								topNeighbor.setOrientation(1);
								topNeighbor.setFixed(true);
							}
							else if(topNeighbor.getType() == PieceType.TTYPE) {
								topNeighbor.setOrientation(0);
								topNeighbor.setFixed(true);
							}
						}
						else if(bottomNeighbor.isFixed() == false) {
							if(bottomNeighbor.getType() == PieceType.BAR) {
								bottomNeighbor.setOrientation(1);
								bottomNeighbor.setFixed(true);
							}
							else if(bottomNeighbor.getType() == PieceType.TTYPE) {
								bottomNeighbor.setOrientation(2);
								bottomNeighbor.setFixed(true);
							}
						}
						else if(leftNeighbor.isFixed() == false) {
							if(leftNeighbor.getType() == PieceType.TTYPE) {
								leftNeighbor.setOrientation(3);
								leftNeighbor.setFixed(true);
							}
							else if(leftNeighbor.getType() == PieceType.BAR) {
								leftNeighbor.setOrientation(0);
								leftNeighbor.setFixed(true);
							}
						}
						else if(rightNeighbor.isFixed() == false) {
							if(rightNeighbor.getType() == PieceType.TTYPE) {
								leftNeighbor.setOrientation(1);
								leftNeighbor.setFixed(true);
							}
							else if(rightNeighbor.getType() == PieceType.BAR) {
								leftNeighbor.setOrientation(0);
								leftNeighbor.setFixed(true);
							}
						}
					}
				}//fin de center
			}
		}
	}
}
