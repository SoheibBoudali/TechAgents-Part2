import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextField;

import jade.core.AID;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;

public class ComportementVend extends Behaviour{
	Vendeur vendeur;	
	Interface in ;
	public static int cpt =0;
	public static float prix;
	public float receive ;
	public static int j=0;
	public static ArrayList<String> Liste ;
	static String Text="";
	String Newligne=System.getProperty("line.separator");
	public ComportementVend(Vendeur agent , Interface in ) {
		this.in=in;
		this.vendeur=agent;
		prix=vendeur.getVendPrixInit();
		Liste = vendeur.getListeNomAcheteurs();
	}
	
	@Override
	public void action() {
		// TODO Auto-generated method stub
		ACLMessage Amsg = vendeur.blockingReceive();
		if(Amsg.getContent().equals("-1")) {
			for (int i = 0; i < Liste.size(); i++) {
				if(Amsg.getSender().getLocalName().equals(Liste.get(i))) {
					Text=Text+Newligne+"L'acheteur Ach"+i+" a quitté l'enchere";
					Liste.remove(i);
				}
			}
		}else {
			Text=Text+Newligne+Amsg.getSender().getLocalName()+" : j'ai proposé le prix "+Amsg.getContent();
			Text=Text+Newligne+"Vendeur : j'ai recu "+Amsg.getContent()+" de la part de :"+Amsg.getSender().getLocalName();
			cpt++; 
			receive= Float.valueOf(Amsg.getContent()).floatValue();
			if(prix< receive) {
				prix=receive;
			}
		}
		if (cpt==(Liste.size())) {
			if(Liste.size()==1 && !Amsg.getContent().equals("-1")) {
				if(receive>vendeur.getVendPrixRes()) {
					in.getExecutionVend().setText(Text); 
					in.getResultat().setText("Produit vendu a l'agent :"+Amsg.getSender().getLocalName()+" au prix de :"+Amsg.getContent());
                    /*ACLMessage fin = Amsg.createReply();
                    fin.setPerformative( ACLMessage.INFORM );
                    fin.setContent("fin" );
                    vendeur.send(fin);*/
					vendeur.doDelete();
				}else {
					in.getExecutionVend().setText(Text); 
					in.getResultat().setText("Fin d'enchere produit non vendu ");
					vendeur.doDelete();
				}
			}else {
				for ( int i = 0; i < Liste.size(); i++) {
					ACLMessage Vmsg =new ACLMessage(ACLMessage.INFORM);
					Vmsg.addReceiver(new AID(Liste.get(i),AID.ISLOCALNAME));
					Vmsg.setContent(String.valueOf(prix));
					Text=Text+Newligne+"Vendeur : j'ai envoyé le nouveau prix "+prix+" a l'acheteur "+Liste.get(i);
					vendeur.send(Vmsg);
				}
				block();
				cpt=0;
			}
			if(Liste.size()==0) {
				in.getResultat().setText("Fin d'enchere Produit non vendu");
				vendeur.doDelete();
			}
		}
	}

	@Override
	public boolean done() {
		// TODO Auto-generated method stub
		return false;
	}

}
