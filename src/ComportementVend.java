import jade.core.behaviours.Behaviour;

public class ComportementVend extends Behaviour{
	Vendeur vendeur;
	public ComportementVend(Vendeur agent) {
		vendeur=agent;
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
