import javax.swing.JFrame;
import javax.swing.JTextField;

import jade.core.AID;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;

public class ComportementAch extends Behaviour{
	Acheteur acheteur;
	Interface in;
	public static float prix;
	static String Text="";
	String Newligne=System.getProperty("line.separator");
	public ComportementAch(Acheteur agent,Interface in ) {
		acheteur=agent;
		prix=acheteur.getVendPrixInit();
		this.in=in; 
		
	}
	 
	@Override
	public void action() {
		// TODO Auto-generated method stub
		ACLMessage Amsg =new ACLMessage(ACLMessage.INFORM);
		Amsg.addReceiver(new AID(acheteur.getNom_Vend(),AID.ISLOCALNAME));
		if((prix + acheteur.getMise())< acheteur.getMaxPrix() ) {
			Amsg.setContent(String.valueOf(prix+acheteur.getMise()));
			acheteur.send(Amsg);
			System.out.println(acheteur.getLocalName()+" : j'ai proposé le prix suivant :" +Amsg.getContent());
			Text=Text+Newligne+acheteur.getLocalName()+" : j'ai proposé le prix suivant :" +Amsg.getContent();
		}else {
			System.out.println(acheteur.getLocalName()+" : je sors de l'enchere");
			Text=Text+Newligne+acheteur.getLocalName()+" : je sors de l'enchere";
			Amsg.setContent("-1");
			acheteur.send(Amsg);
			acheteur.doDelete();
		}
		this.block(); 
		ACLMessage Vmsg = acheteur.blockingReceive();
			System.out.println(acheteur.getLocalName()+" : j'ai recu le nouveau prix :"+Vmsg.getContent());
			Text=Text+Newligne+acheteur.getLocalName()+" : j'ai recu le nouveau prix :"+Vmsg.getContent();
			prix=Float.valueOf(Vmsg.getContent()).floatValue();
		/*try {
			ACLMessage fin = new ACLMessage(ACLMessage.INFORM); 
			String A="";
			if((A=fin.getContent()).equals("fin")&& fin!=null) {
				in.getExecutionAch().setText(Text);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

	}


	@Override
	public boolean done() {
		// TODO Auto-generated method stub
		return false;
	}

}
