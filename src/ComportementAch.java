import javax.swing.JFrame;
import javax.swing.JTextField;

import jade.core.behaviours.Behaviour;

public class ComportementAch extends Behaviour{
	Acheteur acheteur;
	Interface in;
	public ComportementAch(Acheteur agent,Interface interf ) {
		acheteur=agent;
		in=interf;
	}
	@Override
	public void action() {
		// TODO Auto-generated method stub
		in.getNomVendeur().setText("Hello");
	}

	@Override
	public boolean done() {
		// TODO Auto-generated method stub
		return false;
	}

}
