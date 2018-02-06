/*
 * TP 1 - IA Informatique : Sudoku
 * 
 * @author Tassadit BOUADI.
 */
import java.util.Stack;
import java.util.ArrayList;


public class Sudoku {
	public static int TAILLE = 9;

	
	public static void main(String[] args) {
		int[][] grille1 = {
					{0,8,0,4,0,2,0,6,0},
					{0,3,4,0,0,0,9,1,0},
					{9,6,0,0,0,0,0,8,4},
					{0,0,0,2,1,6,0,0,0},
					{0,0,0,0,0,0,0,0,0},
					{0,0,0,3,5,7,0,0,0},
					{8,4,0,0,0,0,0,7,5},
					{0,2,6,0,0,0,1,3,0},
					{0,9,0,7,0,1,0,4,0}
				};
		
		//initialisation
		Grille grilleInit1 = new Grille(TAILLE, grille1);
		grilleInit1.afficheGrille();
		
		Stack<Grille> pile = new Stack<Grille>();
		pile.push(grilleInit1);
		
		
		boolean resul = resoudreSudoku(pile);
		
		
		if(resul){
			System.out.println("La grille a ete resolue");
			Grille grilleResul = pile.peek();
			grilleResul.afficheGrille();
		}
		else{
			System.out.println("Aucune solution n'a ete trouvee");
			Grille grilleResul = pile.peek();
			grilleResul.afficheGrille();
		}
	}//main
	
	
	/*
	 * Fonction recursive qui recherche la solution, 
	 * en utilisant eventuellement des retours-arriere.
	 */
	public static boolean resoudreSudoku(Stack<Grille> pileGrilles){
		//to do
		return false;
	}//resoudreSudoku

}