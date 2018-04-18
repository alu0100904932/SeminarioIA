import norsys.netica.*;
import norsys.neticaEx.aliases.Node;
     
public class RedSeminario {

  public static void main (String[] args){
    try {
    	Node.setConstructorClass ("norsys.neticaEx.aliases.Node");
		Environ env = new Environ (null);
		
		Net net = new Net ();
		net.setName("Seminario_IA");
		
		Node St = new Node ("St", "Atacar, BuscarArmas, BuscarEnergia, Explorar, Huir, DetectarPeligro", net);
		Node St1 = new Node ("St1", "Atacar, BuscarArmas, BuscarEnergia, Explorar, Huir, DetectarPeligro", net);
		Node H = new Node ("H",   "alto, bajo",  net);
		Node OW = new Node ("OW",   "armado, desarmado",  net);
		Node HN = new Node ("HN",   "si, no",  net);
		Node NE = new Node ("NE",   "muchos, pocos",  net);
		Node PW = new Node ("PW",   "si, no",  net);
		Node PH = new Node ("PH",   "si, no",  net);
		Node W = new Node ("W",   "armado, desarmado",  net);
		
		St1.addLink(St);
		H.addLink(St1);
		OW.addLink(St1);
		HN.addLink(St1);
		NE.addLink(St1);
		PW.addLink(St1);
		PH.addLink(St1);
		W.addLink(St1);
		
		float[] stTable = {0.7f, 0.1f, 0.05f, 0.1f, 0.02f, 0.03f};
		St.setCPTable(stTable);
		
		float[] st1Atacar = {0.95f, 0.01f, 0.01f, 0.02f, 0.005f, 0.005f};
		St1.setCPTable("Atacar", st1Atacar);
		float [] st1Armas = {0.5f, 0.4f, 0.03f, 0.03f, 0.02f, 0.02f};
		St1.setCPTable("BuscarArmas", st1Armas);
		float[] st1Energia = {0.5f, 0.03f, 0.4f, 0.03f, 0.02f, 0.02f};
		St1.setCPTable("BuscarEnergia", st1Energia);
		float[] st1Explorar = {0.6f, 0.03f, 0.03f, 0.3f, 0.02f, 0.02f};
		St1.setCPTable("Explorar", st1Explorar);
		float[] st1Huir = {0.2f, 0.03f, 0.03f, 0.04f, 0.5f, 0.2f};
		St1.setCPTable("Huir", st1Huir);
		float[] st1Peligro = {0.65f, 0.02f, 0.02f, 0.01f, 0.1f, 0.2f};
		St1.setCPTable("DetectarPeligro", st1Peligro);
		
		H.setCPTable("Atacar", 0.5, 0.5);
		H.setCPTable("BuscarArmas", 0.5, 0.5);
		H.setCPTable("BuscarEnergia", 0.5, 0.5);
		H.setCPTable("Explorar", 0.5, 0.5);
		H.setCPTable("Huir", 0.1, 0.9);
		H.setCPTable("DetectarPeligro", 0.1, 0.9);
		
		OW.setCPTable("Atacar", 0.5, 0.5);
		OW.setCPTable("BuscarArmas", 0.5, 0.5);
		OW.setCPTable("BuscarEnergia", 0.5, 0.5);
		OW.setCPTable("Explorar", 0.5, 0.5);
		OW.setCPTable("Huir", 0.5, 0.5);
		OW.setCPTable("DetectarPeligro", 0.5, 0.5);
		
		HN.setCPTable("Atacar", 0.9, 0.1);
		HN.setCPTable("BuscarArmas", 0.5, 0.5);
		HN.setCPTable("BuscarEnergia", 0.5, 0.5);
		HN.setCPTable("Explorar", 0.8, 0.2);
		HN.setCPTable("Huir", 0.5, 0.5);
		HN.setCPTable("DetectarPeligro", 0.7, 0.3);
		
		NE.setCPTable("Atacar", 0.5, 0.5);
		NE.setCPTable("BuscarArmas", 0.2, 0.8);
		NE.setCPTable("BuscarEnergia", 0.2, 0.8);
		NE.setCPTable("Explorar", 0.5, 0.5);
		NE.setCPTable("Huir", 0.5, 0.5);
		NE.setCPTable("DetectarPeligro", 0.5, 0.5);
		
		PW.setCPTable("Atacar", 0.7, 0.3);
		PW.setCPTable("BuscarArmas", 0.1, 0.9);
		PW.setCPTable("BuscarEnergia", 0.5, 0.5);
		PW.setCPTable("Explorar", 0.7, 0.3);
		PW.setCPTable("Huir", 0.2, 0.8);
		PW.setCPTable("DetectarPeligro", 0.5, 0.5);
		
		PH.setCPTable("Atacar", 0.7, 0.3);
		PH.setCPTable("BuscarArmas", 0.5, 0.5);
		PH.setCPTable("BuscarEnergia", 0.1, 0.9);
		PH.setCPTable("Explorar", 0.7, 0.3);
		PH.setCPTable("Huir", 0.2, 0.8);
		PH.setCPTable("DetectarPeligro", 0.5, 0.5);
		
		W.setCPTable("Atacar", 0.5, 0.5);
		W.setCPTable("BuscarArmas", 0.1, 0.9);
		W.setCPTable("BuscarEnergia", 0.5, 0.5);
		W.setCPTable("Explorar", 0.5, 0.5);
		W.setCPTable("Huir", 0.1, 0.9);
		W.setCPTable("DetectarPeligro", 0.5, 0.5);
		
		net.compile();
		       
		St.finding().enterState ("DetectarPeligro");
		H.finding().enterState("bajo");
		OW.finding().enterState("armado");
		HN.finding().enterState("si");
		NE.finding().enterState ("muchos");
		PW.finding().enterState ("no");
		PH.finding().enterState ("no");
		W.finding().enterState ("desarmado");
		        
		System.out.println ("Atacar: " +St1.getBelief ("Atacar") + " Buscar Armas: " + St1.getBelief ("BuscarArmas") + " Buscar Energia: " + St1.getBelief ("BuscarEnergia")
				+ "\n Explorar: " + St1.getBelief ("Explorar") + " Huir: " + St1.getBelief ("Huir") + " Detectar peligro: " + St1.getBelief ("DetectarPeligro"));
		
		net.finalize();
    }
    catch (Exception e) {
    	e.printStackTrace();
    }
  }
}
