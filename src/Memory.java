import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Memory extends BasicGame {

	Tuiles tuiles;
	Grille grille;

	public Memory(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	/*
	 * La méthode render() est quant à elle dédiée au rendu visuel de votre
	 * application (encore une fois, le nom est assez explicite)
	 */
	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		// TODO Auto-generated method stub

		// grille.dessinerFaceCache(g);
		grille.dessinerTuiles(g);
		// tuiles.dessinerFaceOuvert(g);

	}

	/*
	 * Comme son nom l'indique, la méthode init() est chargée de regrouper
	 * l'ensemble des instructions à exécuter à l'initialisation du jeu
	 */
	@Override
	public void init(GameContainer arg0) throws SlickException {
		// TODO Auto-generated method stub

		grille = new Grille();

	}

	/*
	 * Pour finir, la méthode update() est chargée de gérer la dynamique du jeu,
	 * c'est à dire d'appliquer du mouvement aux objets, de réagir aux commandes du
	 * joueur, ou encore de gérer d'éventuelles collisions. C'est ici qu'on appelera
	 * les methode de la classe grille
	 */
	@Override
	public void update(GameContainer arg0, int arg1) throws SlickException {
		// TODO Auto-generated method stub
		Input input = arg0.getInput();

		// verifie si la grille est bterminée et retrace une nouvelle grille
		if (grille.isGrilleTermine())
			grille = new Grille();

		// verifie si le 2ème clic est fait
		else if (grille.getCase2() == null) {
			if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {// attends le premier clic
				if (grille.getCase1() == null) {
					// appel de la methode clicCase1
					grille.clicCase1(input.getMouseX(), input.getMouseY());
				} else {
					// appel de la methode clicCase1
					grille.clicCase2(input.getMouseX(), input.getMouseY());
				}
			}
		} else {
			/*
			 * Ici on met la methode comparerCartes dans un try catch pour gérer toute
			 * eventuelle erreur
			 */
			try {
				grille.comparerCartes();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
