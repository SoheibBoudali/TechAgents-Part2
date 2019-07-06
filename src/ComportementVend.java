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
			System.out.println("MAJ");
			for (int i = 0; i < Liste.size(); i++) {
				if(Amsg.getSender().getLocalName().equals(Liste.get(i))) {
					Liste.remove(i);
				}
			}
		}else {
			System.out.println("Jai recu "+Amsg.getContent());
			cpt++;
			System.out.println(cpt+"=="+Liste.size());
			receive= Float.valueOf(Amsg.getContent()).floatValue();
			if(prix< receive) {
				prix=receive;
			}
		}
		if (cpt==(Liste.size())) {
			if(Liste.size()==1 && !Amsg.getContent().equals("-1")) {
				if(receive>vendeur.getVendPrixRes()) {
					in.getResultat().setText("Produit vendu a l'agent "+Amsg.getSender().getLocalName()+" au prix de "+Amsg.getContent());
					vendeur.doDelete();
				}else {
					in.getResultat().setText("Fin d'enchere produit non vendu ");
					vendeur.doDelete();
				}
			}else {
				for ( int i = 0; i < Liste.size(); i++) {
					ACLMessage Vmsg =new ACLMessage(ACLMessage.INFORM);
					Vmsg.addReceiver(new AID(Liste.get(i),AID.ISLOCALNAME));
					Vmsg.setContent(String.valueOf(prix));
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
