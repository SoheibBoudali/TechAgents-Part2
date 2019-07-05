import javax.swing.JFrame;

import jade.core.behaviours.Behaviour;

public class ComportementVend extends Behaviour{
	Vendeur vendeur;
	Interface in;
	public ComportementVend(Vendeur agent,Interface interf ) {
		vendeur=agent;
		in=interf;
	}
	@Override
	public void action() {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean done() {
		// TODO Auto-generated method stub
		System.out.println(vendeur.getLocalName());
		return false;
	}

}
