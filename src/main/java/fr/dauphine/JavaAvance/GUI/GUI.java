package fr.dauphine.JavaAvance.GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import fr.dauphine.JavaAvance.Components.Orientation;
import fr.dauphine.JavaAvance.Components.Piece;
import fr.dauphine.JavaAvance.Components.PieceType;
import fr.dauphine.JavaAvance.Solve.Checker;

/**
 * This class handles the GUI
 * 
 *
 */
public class GUI {

	private JFrame frame;

	/**
	 * 
	 * @param inputFile
	 *            String from IO
	 * @throws IOException
	 *             if there is a problem with the gui
	 */
	public static void startGUI(String inputFile) throws NullPointerException {
		// We have to check that the grid is generated before to launch the GUI
		// construction
		Runnable task = new Runnable() {
			public void run() {

				try {
					Grid grid = Checker.buildGrid(inputFile);
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							GUI window;
							window = new GUI(grid);
							window.frame.setVisible(true);
						}
					});
				} catch (IOException e) {
					throw new NullPointerException("Error with input file");
				}

			}
		};
		new Thread(task).start();

	}

	/**
	 * Create the application.
	 * 
	 * @throws IOException
	 */
	public GUI(Grid grid) {

		initialize(grid);
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws IOException
	 */
	private void initialize(Grid grid) {
		
		// To implement:
		// creating frame, labels
		// Implementing method mouse clicked of interface MouseListener.
		
		JFrame frame = new JFrame("Infinity Loops Game"); //titre 
		
		/*
		 * Pour chaque ligne et colonne de la grille, on définit une image
		 * la méthode MouseClicked permet d'appyer sur une piece et de la tourner
		 */
		for (int line = 0; line < grid.getHeight(); line++) {
			for (int column = 0; column < grid.getWidth(); column++) {
				
				Piece p = grid.getPiece(line, column); 
				
				JLabel label = new JLabel("", JLabel.CENTER); //Créer une étiquette pour afficher du texte centré
				label.setIcon(getImageIcon(p)); //définit l’image que l’étiquette va afficher
				
				frame.getContentPane().add(label, BorderLayout.CENTER);
				
				label.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						p.turn(); //on tourne la piece
						label.setIcon(getImageIcon(p)); //On redefinit l'image car la piece a change de sens 
					}});
				
				/*label.addMouseListener((MouseEvent e) -> {
					p.turn();
					label.setIcon(getImageIcon(p));
				});*/
			}
		}
		
		frame.setSize(700,700); //Taille de la fenetre (pas sur de 700, voir ce que ca donne)
		frame.setVisible(true); // méthode fait apparaître le cadre à l'écran. Si vous oubliez de le faire, l'objet cadre existera en tant qu'objet en mémoire, mais aucune image n'apparaîtra à l'écran.
		/*
		 * setting the grid layout grid.getHeight() * grid.getWidth() grid is created 
		 */
		frame.setLayout(new GridLayout(grid.getHeight(), grid.getWidth()));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

	}

	/**
	 * Display the correct image from the piece's type and orientation
	 * 
	 * @param p
	 *            the piece
	 * @return an image icon
	 */
	private ImageIcon getImageIcon(Piece p) {
		//To be implemented
		
		ImageIcon image = null;
		
		boolean ONECONN = p.getType().equals(PieceType.ONECONN);
		boolean BAR = p.getType().equals(PieceType.BAR);
		boolean TTYPE = p.getType().equals(PieceType.TTYPE);
		boolean LTYPE = p.getType().equals(PieceType.LTYPE);
		boolean FOURCONN = p.getType().equals(PieceType.FOURCONN);

		boolean NORTH = p.getOrientation().equals(Orientation.NORTH);
		boolean EAST = p.getOrientation().equals(Orientation.EAST);
		boolean SOUTH = p.getOrientation().equals(Orientation.SOUTH);
		boolean WEST = p.getOrientation().equals(Orientation.WEST);
		
		try {
			if(ONECONN) {
				if (NORTH) {
					 image = new ImageIcon(getClass().getResource("src/main/resources/fr/dauphine/JavaAvance/icons/io/1.png"));
				}
				else if (EAST) {
					 image = new ImageIcon(getClass().getResource("src/main/resources/fr/dauphine/JavaAvance/icons/io/2.png"));
				}
				else if (SOUTH) {
					 image = new ImageIcon(getClass().getResource("src/main/resources/fr/dauphine/JavaAvance/icons/io/3.png"));
				}
				else if (WEST) {
					 image = new ImageIcon(getClass().getResource("src/main/resources/fr/dauphine/JavaAvance/icons/io/4.png"));
				}
			}
			
			if(BAR) {
				if (NORTH) {
					 image = new ImageIcon(getClass().getResource("src/main/resources/fr/dauphine/JavaAvance/icons/io/5.png"));
				}
				else if (SOUTH) {
					 image = new ImageIcon(getClass().getResource("src/main/resources/fr/dauphine/JavaAvance/icons/io/6.png"));
				}
			}
			
			if(TTYPE) {
				if (NORTH) {
					 image = new ImageIcon(getClass().getResource("src/main/resources/fr/dauphine/JavaAvance/icons/io/7.png"));
				}
				else if (EAST) {
					 image = new ImageIcon(getClass().getResource("src/main/resources/fr/dauphine/JavaAvance/icons/io/8.png"));
				}
				else if (SOUTH) {
					 image = new ImageIcon(getClass().getResource("src/main/resources/fr/dauphine/JavaAvance/icons/io/9.png"));
				}
				else if (WEST) {
					 image = new ImageIcon(getClass().getResource("src/main/resources/fr/dauphine/JavaAvance/icons/io/10.png"));
				}
			}
			
			if(FOURCONN) {
					 image = new ImageIcon(getClass().getResource("src/main/resources/fr/dauphine/JavaAvance/icons/io/11.png"));
			}
			
			if(LTYPE) {
				if (NORTH) {
					 image = new ImageIcon(getClass().getResource("src/main/resources/fr/dauphine/JavaAvance/icons/io/12.png"));
				}
				else if (EAST) {
					 image = new ImageIcon(getClass().getResource("src/main/resources/fr/dauphine/JavaAvance/icons/io/13.png"));
				}
				else if (SOUTH) {
					 image = new ImageIcon(getClass().getResource("src/main/resources/fr/dauphine/JavaAvance/icons/io/14.png"));
				}
				else if (WEST) {
					 image = new ImageIcon(getClass().getResource("src/main/resources/fr/dauphine/JavaAvance/icons/io/15.png"));
				}
			}
			
		} catch (Exception e) {
			throw new NullPointerException("Image Not Found");
		}
		
		
	return image;
		
		//ImageIcon BACKGROUND = new ImageIcon(getClass().getResource("src/main/resources/fr/dauphine/JavaAvance/icons/io/background.png"));			 		
		
	}

}
