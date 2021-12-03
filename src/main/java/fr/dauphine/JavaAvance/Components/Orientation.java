package fr.dauphine.JavaAvance.Components;

/**
 * 
 * Orientation of the piece enum
 * 
 */
public enum Orientation {
	/* Implement all the possible orientations and 
	 *  required methods to rotate
	 */

	/**
	 * Les valeurs des enum doivent etre en majuscule (car ce sont des constantes)
	 * Qd on appelle Orientation ds le Main --> on met en argument NORTH... 
	 * la class enum va associer une valeur a l orientation
	 */
	
	NORTH, //0
	EAST,  //1
	SOUTH, //2
	WEST  //3
;


	static Orientation getOrifromValue(int orientationValue) {
		Orientation orientation = null;
		
		switch (orientationValue) {
		case 0: 
			orientation = Orientation.NORTH;
			break;
			
		case 1: 
			orientation = Orientation.EAST;
			break;
			
			
		case 2: 
			orientation = Orientation.SOUTH;
			break;
			
		case 3: 
			orientation =Orientation.WEST;
			break;
			
			
	
		
		default:
			throw new IllegalArgumentException("Unexpected value : " + orientationValue);
		}
		
		return orientation;
	}

	int getValue() {
		// TODO Auto-generated method stub
		return 0;
	}



}
