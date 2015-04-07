package AppliSimu;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import DomaineVoiture.Voiture;

public class CommandeVoiture extends JPanel implements ActionListener, KeyListener{
	
	private JButton boutonAccelerer;
	private JButton boutonInverserDirection;
    private JButton boutonTurnLeft;
    private JButton boutonTurnRight;
    public Route routeHorizontale = new Route(0,285,1050,50);
    public  Route routeVerticale= new Route(210,73,50,1000);
	private Voiture maVoiture;
	
	
	public CommandeVoiture (JFrame fenetre, Voiture maVoiture) {
		
		super();
		this.setLayout(new FlowLayout());
 
		boutonAccelerer = new JButton("Accelerer");
		boutonAccelerer.addActionListener(this);
		this.add(boutonAccelerer);

		boutonInverserDirection = new JButton("Changer direction");
		boutonInverserDirection.addActionListener(this);
		this.add(boutonInverserDirection);

        boutonTurnLeft = new JButton("Gauche");
        boutonTurnLeft.addActionListener(this);
        this.add(boutonTurnLeft);

        boutonTurnRight = new JButton("Droite");
        boutonTurnRight.addActionListener(this);
        this.add(boutonTurnRight);
		fenetre.setFocusable(true);
        fenetre.addKeyListener(this);
		fenetre.add(this);
		this.maVoiture = maVoiture;
	}


    @Override
    public void actionPerformed(ActionEvent event) {
        JButton bouton = (JButton)event.getSource();
        if (bouton == boutonAccelerer)
            maVoiture.accelerer();
        else if(bouton == boutonInverserDirection) {
            maVoiture.inverserDirection();
        }
        else {
            if (bouton == boutonTurnLeft) {
                if((Integer)maVoiture.getDirection()==0) {
                    maVoiture.setDirection(90);
                } else if ((Integer)maVoiture.getDirection()==180) {
                    maVoiture.setDirection(270);
                } else if ((Integer)maVoiture.getDirection()== 90) {
                    maVoiture.setDirection(180);
                } else  {
                    maVoiture.setDirection(0);
                }

            } else {
                if((Integer)maVoiture.getDirection()==0) {
                    maVoiture.setDirection(270);
                } else if ((Integer)maVoiture.getDirection()==180) {
                    maVoiture.setDirection(90);
                } else if ((Integer)maVoiture.getDirection()== 90) {
                    maVoiture.setDirection(0);
                } else  {
                    maVoiture.setDirection(180);
                }
            }
        }
        bouton.setFocusable(false);
    }


    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == keyEvent.VK_SPACE) {
            maVoiture.setVitesse(0);
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
