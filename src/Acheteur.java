import javax.swing.JTextField;
import jade.core.Agent;
public class Acheteur extends Agent{
	protected void setup() {
		addBehaviour(new ComportementAch(this));
	}
}
