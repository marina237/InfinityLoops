package fr.dauphine.JavaAvance.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;
import fr.dauphine.JavaAvance.Components.Orientation;
import fr.dauphine.JavaAvance.Components.Piece;
import fr.dauphine.JavaAvance.Components.PieceType;
import fr.dauphine.JavaAvance.Solve.Checker;
import fr.dauphine.JavaAvance.Solve.Generator;
import java.awt.event.MouseListener;
/**
 * This class handles the GUI
 * 
 *
 */
public class GUI implements MouseListener {

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


	public GUI(Grid grid) {

		initialize(grid);
	}

	public GUI() {
		// TODO Auto-generated constructor stub
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
		
		this.frame = new JFrame("Multiple panel");
		
		GridLayout gridLayout = new GridLayout(grid.getHeight(), grid.getWidth());
		JPanel infinityLoopGame_panel = new JPanel();
		infinityLoopGame_panel.setLayout(gridLayout);
		infinityLoopGame_panel.setBackground(Color.WHITE);
		
		this.frame.addMouseListener(this);
		
		for (int i = 0; i < grid.getHeight(); i++) {
			for (int j = 0; j < grid.getWidth(); j++) {
				
				Piece pieceClick = grid.getPiece(i, j);
				System.out.println(pieceClick);
				String pieceType = grid.getPiece(i, j).getType().toString();
				Orientation pieceOrientation = grid.getPiece(i, j).getOrientation();
				JButton btn_i = new JButton();
				btn_i.setIcon(getImageIcon(pieceClick));
				btn_i.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {								
						pieceClick.turn();
						btn_i.setIcon(getImageIcon(pieceClick));
						System.out.println(pieceClick.getOrientation().toString());
					}
					
				});
				
				infinityLoopGame_panel.add(btn_i);
				

			}
		}		
		
		
		JPanel buttonsControl_panel = new JPanel();
		buttonsControl_panel.setBackground(Color.GRAY);
		JButton btn_checker = new JButton("Check out  grid");
		btn_checker.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Checker");
				JOptionPane.showMessageDialog(buttonsControl_panel, "Trying to figure out ");
			}
		});
		JButton btn_solver = new JButton("Solve this grid");
		btn_solver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Click on Solver");
				JOptionPane.showMessageDialog(buttonsControl_panel, "Trying to solve... ");
				
			}
		});
		JButton btn_generate = new JButton("Generate new grid");
		btn_generate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Generate");
				
				String test = "ok";
				
				try {
					Generator.generateLevel(test,grid);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				initialize(grid);
				
			}
		});
		
		JButton btn_export = new JButton("Export grid");
		btn_export.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Export");
				
				
			}
		});
		
		
		buttonsControl_panel.add(btn_checker);
		buttonsControl_panel.add(btn_solver);
		buttonsControl_panel.add(btn_generate);
		buttonsControl_panel.add(btn_export);
		
		
		
		//Mise en place des boutons
				
		//CrÃ©ation des Panels
		this.frame.add(infinityLoopGame_panel, BorderLayout.CENTER);
		this.frame.add(buttonsControl_panel, BorderLayout.PAGE_END);
		
		
		
		this.frame.setSize(600, 600);
		this.frame.setLocationRelativeTo(null);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setVisible(true);
		
		

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
		boolean VOID = p.getType().equals(PieceType.VOID);
		
		
		boolean NORTH = p.getOrientation().equals(Orientation.NORTH);
		boolean EAST = p.getOrientation().equals(Orientation.EAST);
		boolean SOUTH = p.getOrientation().equals(Orientation.SOUTH);
		boolean WEST = p.getOrientation().equals(Orientation.WEST);
		
		
		if(VOID) {
			
			image = new ImageIcon("");
		
		}	
		
		
			
			
			if(ONECONN && NORTH) {
				
				image = new ImageIcon("../InfinityLoops/src/main/resources/fr/dauphine/JavaAvance/icons/io/1.png");
				
				
				}
			 if (ONECONN && EAST) {
					image = new ImageIcon("../InfinityLoops/src/main/resources/fr/dauphine/JavaAvance/icons/io/2.png");
				}
			 if (ONECONN && SOUTH) {
					image = new ImageIcon("../InfinityLoops/src/main/resources/fr/dauphine/JavaAvance/icons/io/3.png");
				}
			 if (ONECONN && WEST) {
					image = new ImageIcon("../InfinityLoops/src/main/resources/fr/dauphine/JavaAvance/icons/io/4.png");
				}
		
			
		
			if(BAR && NORTH) {
		
				image = new ImageIcon("../InfinityLoops/src/main/resources/fr/dauphine/JavaAvance/icons/io/5.png");
				}
			if (BAR && SOUTH) {
				image = new ImageIcon("../InfinityLoops/src/main/resources/fr/dauphine/JavaAvance/icons/io/6.png");
				}
			
			
		
				if (TTYPE && NORTH) {
					image = new ImageIcon("../InfinityLoops/src/main/resources/fr/dauphine/JavaAvance/icons/io/7.png");
				}
				 if (TTYPE && EAST) {
						image = new ImageIcon("../InfinityLoops/src/main/resources/fr/dauphine/JavaAvance/icons/io/8.png");
				}
				 if (TTYPE && SOUTH) {
						image = new ImageIcon("../InfinityLoops/src/main/resources/fr/dauphine/JavaAvance/icons/io/9.png");
				}
				 if (TTYPE && WEST) {
						image = new ImageIcon("../InfinityLoops/src/main/resources/fr/dauphine/JavaAvance/icons/io/10.png");
				}
			
			
			if(FOURCONN) {
				image = new ImageIcon("../InfinityLoops/src/main/resources/fr/dauphine/JavaAvance/icons/io/11.png");
			}
			
			if(LTYPE && NORTH ) {
				
				image = new ImageIcon("../InfinityLoops/src/main/resources/fr/dauphine/JavaAvance/icons/io/12.png");
				}
			if (LTYPE && EAST) {
				image = new ImageIcon("../InfinityLoops/src/main/resources/fr/dauphine/JavaAvance/icons/io/13.png");
				}
			if (LTYPE && SOUTH) {
				image = new ImageIcon("../InfinityLoops/src/main/resources/fr/dauphine/JavaAvance/icons/io/14.png");
				}
			if (LTYPE && WEST) {
				image = new ImageIcon("../InfinityLoops/src/main/resources/fr/dauphine/JavaAvance/icons/io/15.png");
				}
			
			
	
		
		
		//ImageIcon BACKGROUND = new ImageIcon("../InfinityLoops/src/main/resources/fr/dauphine/JavaAvance/icons/io/background.PNG");			 	

	return image;
		
			
		
	}
	


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}
