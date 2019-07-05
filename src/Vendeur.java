import jade.core.Agent;

public class Vendeur extends Agent{
	protected void setup() {
		Object[] ArgsVend = getArguments();
		Interface in = (Interface) ArgsVend[5];
		addBehaviour(new ComportementVend(this,in));
	}
}
