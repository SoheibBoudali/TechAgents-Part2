import jade.core.behaviours.Behaviour;

public class ComportementAch extends Behaviour{
	Acheteur acheteur;
	public ComportementAch(Acheteur agent) {
		acheteur=agent;
	}
	@Override
	public void action() {
		// TODO Auto-generated method stub
		System.out.println(acheteur.getLocalName());
	}

	@Override
	public boolean done() {
		// TODO Auto-generated method stub
		return false;
	}

}
