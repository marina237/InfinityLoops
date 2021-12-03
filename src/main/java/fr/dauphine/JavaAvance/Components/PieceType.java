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
	
VOID(0),
ONE_NEIGHBOUR(1),
BAR(2),
T(3),
CROSS(4),
L(5),;
	


PieceType(int i) {
	// TODO Auto-generated constructor stub
}

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
 * @return
 */
ArrayList<Orientation> getListOfPossibleOri() {
	// TODO Auto-generated method stub
	return null;
}
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
		pieceType = PieceType.ONE_NEIGHBOUR;
		break;
		
		
	case 2: 
		pieceType = PieceType.BAR;
		break;
		
	case 3: 
		pieceType =PieceType.T;
		break;
		
		
	case 4: 
		pieceType =PieceType.CROSS;
		break;
		
	case 5: 
		pieceType =PieceType.L;
		break;
	
	default:
		throw new IllegalArgumentException("Unexpected value : " + typeValue);
	}
	
	return pieceType;
}






}
