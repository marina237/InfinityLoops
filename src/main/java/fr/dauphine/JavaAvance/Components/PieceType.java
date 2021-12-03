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
	
VOID,
ONE_NEIGHBOUR,
BAR,
T,
CROSS,
L,;

public  Orientation getOrientation(Orientation orientation) {
	Orientation etat = null;
	
	switch (orientation.getValue()) {
	case 0: 
		etat = Orientation.NORTH;
		break;
		
	case 1: 
		etat = Orientation.EAST;
		break;
		
		
	case 2: 
		etat = Orientation.SOUTH;
		break;
		
	case 3: 
		etat =Orientation.WEST;
		break;
		
	
	default:
		throw new IllegalArgumentException("Unexpected orientation: " + orientation);
	}
	
	return etat;
}

LinkedList<Orientation> setConnectorsList(Orientation north) {
	// TODO Auto-generated method stub
	return null;
}

ArrayList<Orientation> getListOfPossibleOri() {
	// TODO Auto-generated method stub
	return null;
}

}
