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
	
	NORTH(0), //0
	EAST(1),  //1
	SOUTH(2), //2
	WEST(3)  //3
;
	/**
	 * Creation champ numero de l orientation
	 */
	private int value;
	
	
	Orientation(int nb) {
		// TODO Auto-generated constructor stub
		
		this.value = nb;
	}


	public int getValue() {
		return value;
	}



}
