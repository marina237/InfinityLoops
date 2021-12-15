package fr.dauphine.JavaAvance.Components;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * 
 * Type of the piece enum
 * 
 */
public enum PieceType {
	// Each Type has a number of connectors and a specific value

	VOID(0,0)//Empty
	, ONECONN(1,1) //only 1 neighbour
	, BAR(2,2) // 2 opposite neighbours.
	,TTYPE(3,3) //seeing 3 neighbours (a T)
	,FOURCONN(4,4) // seeing 4 neighbours (a cross).
	,LTYPE(2,5) //seeing 2 consecutive neighbours (an L)
	; 
	
	private int nbOfConnectors;
	private int SpecificValue;
	
	PieceType(int nbOfConnectors, int SpecificValue) {
        this.nbOfConnectors = nbOfConnectors;
        this.SpecificValue = SpecificValue;
    }
	
	
	 public int getNbConnectors() { return nbOfConnectors; } //acceder au nombre de connecteur
	 public double SpecificValue() { return SpecificValue; }


	

/**
 * getter de l orientation 
 * car champ privee
 * @param orientation
 * @return
 */
public  Orientation getOrientation(Orientation orientation) {
	
	return orientation;

}

LinkedList<Orientation> setConnectorsList(Orientation north) {
	// TODO Auto-generated method stub
	return null;
}
/**
 * 
 *  @return Orientation possible pour une piece
 */
ArrayList<Orientation> getListOfPossibleOri() {	
	 ArrayList<Orientation> O = new ArrayList<Orientation>();
	 
	 Orientation n = Orientation.NORTH;
	 Orientation e = Orientation.EAST;
	 Orientation s = Orientation.SOUTH;
	 Orientation w = Orientation.WEST;		
	 
	 PieceType piecetype = PieceType.VOID;
	 
	 switch(piecetype) {
	 	case VOID :
	 		O.add(null); 
	 		break;
	 	case ONECONN :
	 	case TTYPE :
	 	case LTYPE :
	 		O.add(n); O.add(e); O.add(s); O.add(w);
	 		break;
	 	case BAR : 
			 O.add(n); O.add(e);
			 break;
	 	case FOURCONN : 
			O.add(n);
			break;	
		default :
			throw new IllegalArgumentException("Ce type de pièce n'existe pas");
	 	}
	 	return O;
	 }

	 /*for (PieceType type : PieceType.values()) {
		 			 
		 	if (type == VOID) {
				O.add(null); 
				}
			
			if (type == ONECONN) {
				O.add(n); O.add(e); O.add(s); O.add(w);
				}
			
			if (type == BAR) {
				 O.add(n); O.add(e);
			}
			
			if (type == TTYPE) {
				O.add(n); O.add(e); O.add(s); O.add(w);
				}
			
			if (type == FOURCONN) {
				O.add(n);
				}
			
			if (type == LTYPE) {
				O.add(n); O.add(e); O.add(s); O.add(w);
				}
			
			}

	return O;
}*/
/**
 *  Selon moi, cette methode recoit @param typeValue
 *  et en fct de sa valeur,
 *  retourne le type de piece associe
 *  @return  PieceType
 */
static PieceType getTypefromValue(int typeValue) {
/**
 * Methode statique car: 
 * 1. on envoi un entier
 * 2. on creer l 'obj Piece Type
 * ==>  "est-il logique d'appeler cette méthode, même si aucun Obj n'a encore été construit?" oui . 
 * Donc c est une methode statique
 */
	PieceType pieceType = null;
	
	switch (typeValue) {
	case 0: 
		pieceType = PieceType.VOID;
		break;
		
	case 1: 
		pieceType = PieceType.ONECONN;
		break;
		
		
	case 2: 
		pieceType = PieceType.BAR;
		break;
		
	case 3: 
		pieceType =PieceType.TTYPE;
		break;
		
		
	case 4: 
		pieceType =PieceType.FOURCONN;
		break;
		
	case 5: 
		pieceType =PieceType.LTYPE;
		break;
	
	default:
		throw new IllegalArgumentException("Unexpected value : " + typeValue);
	}
	
	return pieceType;
}






}
