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

	
	
	
/**
 * Methode permettant de pivoter une piece de 90° (dans le sens horaire)
 * @return
 */
	Orientation turn90() {

		Orientation orientationTurn90 = null;
		
		switch (Orientation.this) {
			case NORTH:
				orientationTurn90 = Orientation.EAST;
				break;
	
			case EAST:
				orientationTurn90 = Orientation.SOUTH;
				break;
			
			case SOUTH:
				orientationTurn90 = Orientation.WEST;
				break;
				
			case WEST:
				orientationTurn90 = Orientation.NORTH;
				break;
			
				
			default:
				throw new IllegalArgumentException("Unexpected value : " + Orientation.this);
		
		}
		return orientationTurn90;
		
	}

	public int[] getOpposedPieceCoordinates(Piece p) {
		
	int[] oppositeCoordinate = new int[2];
		
	switch (p.getOrientation()) {
	case NORTH : 
		oppositeCoordinate[0] = p.getPosX();
		oppositeCoordinate[1] = p.getPosY()+1;
		
		break;
		
	case EAST : 
		oppositeCoordinate[0] = p.getPosX()+1;
		oppositeCoordinate[1] = p.getPosY();
		break;
		
		
	case SOUTH : 
		oppositeCoordinate[0] = p.getPosX()-1;
		oppositeCoordinate[1] = p.getPosY();
		break;
		
	case WEST : 
		oppositeCoordinate[0] = p.getPosX()+1;
		oppositeCoordinate[1] = p.getPosY();
		break;
		
	default:
		throw new IllegalArgumentException("Unexpected value : " + p.getOrientation());
	}
	
	return oppositeCoordinate;
}




	public Orientation getOpposedOrientation() {
		Orientation orientationOpposite= null;
		
		switch (Orientation.this) {
		case NORTH:
			orientationOpposite = Orientation.SOUTH;
			break;

		case EAST:
			orientationOpposite = Orientation.WEST;
			break;
			
			
		case WEST:
			orientationOpposite = Orientation.EAST;
			break;
		
		case SOUTH:
			orientationOpposite = Orientation.NORTH;
			break;
			
			
			
		default:
			throw new IllegalArgumentException("Unexpected value : " + Orientation.this);
		}
		
		return orientationOpposite;

	}
		



}
