package Commande;

import static java.lang.System.exit;



public class CommandQuitter implements Command {

	  public CommandQuitter() {}

 
	  @Override
	  public void execute() {
	    exit(0);
	  }
}
