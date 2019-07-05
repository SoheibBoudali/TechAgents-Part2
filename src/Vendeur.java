import jade.core.Agent;

public class Vendeur extends Agent{
	protected void setup() {
		addBehaviour(new ComportementVend(this));
	}
}
