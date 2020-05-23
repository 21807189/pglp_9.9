package Commande;
	
import java.security.InvalidParameterException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mou.*;
import DAO.*;
	
	public class DrawingTUI {

		  private Scanner scanner;
		  private Dessin dessin;
		  private DAO dao;
  
  public Command nextCommand() {
    
    String sc = this.scanner.nextLine();
    Command command = null;
    String nomForme = null;
    try {
      sc = sc.replaceAll("\\s+", "");
  String chaineDeCommande = sc.substring(0, sc.indexOf("("));
  if (chaineDeCommande.matches("move")) {
    nomForme = sc.substring(sc.indexOf("(") + 1, sc.indexOf(","));
    int x = Integer.parseInt(sc.substring(sc.lastIndexOf("(") + 1, sc.lastIndexOf(",")));
    int y = Integer.parseInt(sc.substring(sc.lastIndexOf(",") + 1, sc.indexOf(")")));
    
    for (ComposantDessin comp : dessin.getcomposants()) {
      if (comp.getNom().contentEquals(nomForme)) {
        command = new CommandDeplacer((Forme) comp, x, y);
        break;
      }
    }

  } else if (chaineDeCommande.matches("group")) {

    String nomGroupe = sc.substring(sc.indexOf("(") + 1, sc.indexOf(","));
    String[] tableDeNom = sc.substring(sc.lastIndexOf("(") + 1, sc.indexOf(")")).split(",");
    command = new CommandCreationGroupe(nomGroupe, tableDeNom, dessin);
    
  } else if (chaineDeCommande.matches("moveGroup")) {

    String[] info = sc.split(",");
    String nomGroupe = sc.substring(sc.indexOf("(") + 1, sc.indexOf(","));
    int x = Integer.parseInt(sc.substring(sc.lastIndexOf("(") + 1, sc.lastIndexOf(",")));
    int y = Integer.parseInt(sc.substring(sc.lastIndexOf(",") + 1, sc.indexOf(")")));
    
    for (ComposantDessin comp : dessin.getcomposants()) {
      if (comp.getNom().matches(nomGroupe)) {
        command = new CommandDeplacerGroupe((Groupe) comp, x, y);
        break;
      }
    }
  } else if (chaineDeCommande.matches("remove")) {

    nomForme = sc.substring(sc.indexOf("(") + 1, sc.indexOf(")"));
    command = new SupprimerElementCommand(dessin, nomForme);

  } else if (chaineDeCommande.matches("save")) {
    String nom = sc.substring(sc.indexOf("(") + 1, sc.indexOf(")"));
    DAO.nom = nom;
    command = new CommandSave(this.dessin);
    
  } else if (chaineDeCommande.matches("load")) {
    String nom = sc.substring(sc.indexOf("(") + 1, sc.indexOf(")"));
    DAO.nom = nom;
    command = new CommandLoad(DAO.nom, this);

  } else if (chaineDeCommande.matches("delete")) {
    String nom = sc.substring(sc.indexOf("(") + 1, sc.indexOf(")"));
    DAO.nom = nom;
    command = new CommandSupprimerDessin(DAO.nom);

  } else if (chaineDeCommande.matches("quit")) {
    command = new CommandQuitter();
    
  } else if (sc.contains("=")) {
    String[] creation = sc.split("=");
    nomForme = sc.substring(0, sc.indexOf("="));
    String typeForme = creation[1].substring(0, creation[1].indexOf("("));
    
    if (typeForme.matches("Cercle")) {
      try {
        int x = Integer.parseInt(sc.substring(sc.lastIndexOf("(") + 1, sc.indexOf(",")));
        int y = Integer.parseInt(sc.substring(sc.indexOf(",") + 1, sc.indexOf(")")));
        int rayon = Integer.parseInt(sc.substring(sc.lastIndexOf(",") + 1, sc.lastIndexOf(")")));
        command = new CommandCreationCercle(nomForme, new Point(x, y), rayon, dessin);
        
      } catch (NumberFormatException ne) { 
        System.out.println("Veuillez saisir les données.");
      }
      
    } else if (typeForme.matches("Carre")) {
      String[] carreInfo = sc.split(",");
      int x = Integer.parseInt(carreInfo[0].substring(carreInfo[0].lastIndexOf("(") + 1));
      int y = Integer.parseInt(carreInfo[1].substring(0, carreInfo[1].indexOf(")")));
      int cote = Integer.parseInt(carreInfo[2].substring(0, carreInfo[2].length() - 1));
      command = new CommandCreationCarre(nomForme, new Point(x, y), cote, dessin);
      
    } else if (typeForme.matches("Rectangle")) {
      String[] rectangleInfo = sc.split(",");
      
      int x =Integer.parseInt(rectangleInfo[0].substring(rectangleInfo[0].lastIndexOf("(") + 1));
      int y = Integer.parseInt(rectangleInfo[1].substring(0, 2));
      int longueur = Integer.parseInt(rectangleInfo[2]);
      int hauteur = Integer.parseInt(rectangleInfo[3].substring(0, rectangleInfo[3].indexOf(")") - 1));
      command = new CommandCreationRectangle(nomForme, new Point(x, y), longueur, hauteur, dessin);
      
    } else if (typeForme.matches("Triangle")) {
      String[] triangleInfo = sc.split(",");
      int ax = Integer.parseInt(triangleInfo[0].substring(triangleInfo[0].lastIndexOf("(") + 1));
      int ay = Integer.parseInt(triangleInfo[1].substring(0, triangleInfo[1].indexOf(")") - 1));
      int bx = Integer.parseInt(triangleInfo[2].substring(1));
      int by = Integer.parseInt(triangleInfo[3].substring(0, triangleInfo[3].indexOf(")") - 1));
      int cx = Integer.parseInt(triangleInfo[2].substring(1));
      int cy = Integer.parseInt(triangleInfo[3].substring(0, triangleInfo[3].indexOf(")") - 1));
      
      command = new CommandCreationTriangle( nomForme, new Point(ax, ay), new Point(bx, by), new Point(cx, cy), dessin);
    }
  }
} catch (StringIndexOutOfBoundsException | InvalidParameterException ie) {
  System.out.println(
      "Veuillez saisir les données.");
    }
    return command;
  }
  
	 public void setDessin(Dessin dessin) {
	    this.dessin = dessin;
	  }
	 
  public void afficherDessin() {

    for (ComposantDessin comp : dessin.getcomposants()) {
      comp.afficher();
    }
  }

 
}
