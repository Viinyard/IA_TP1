
/*
 * TP 1 - IA Informatique : Sudoku
 * 
 * @author Tassadit BOUADI.
 */

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Grille {
	private Case[][] grid;
	private int size;
	private int nbCasesVides;

	private SubGrid[] x, y;
	private SubGrid[][] sub;

	public Grille(int size) {
		if (size % 3 != 0) {
			throw new IllegalArgumentException("The size is " + size + " but it must be a multiple of 3 !");
		}
		this.size = size;
		this.nbCasesVides = size * size;
		this.grid = new Case[size][size];

		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				this.grid[x][y] = new Case(new Point(x, y));
			}
		}

		this.sub = new SubGrid[size / 3][size / 3];
		this.x = new SubGrid[size];
		this.y = new SubGrid[size];

		for (int x = 0; x < size; x++) {
			this.x[x] = new SubGrid();
			for (int y = 0; y < size; y++) {
				this.x[x].add(this.grid[x][y]);
			}
		}

		for (int y = 0; y < size; y++) {
			this.y[y] = new SubGrid();
			for (int x = 0; x < size; x++) {
				this.y[y].add(this.grid[x][y]);
			}
		}
		
		for (int x = 0; x < size / 3; x++) {
			for (int y = 0; y < size / 3; y++) {
				this.sub[x][y] = new SubGrid();
			}
		}
		
		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				this.sub[x/3][y/3].add(this.grid[x][y]);
			}
		}
		
		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				this.grid[x][y].link(this.x[x], this.y[y], sub[x / 3][y / 3]);
			}
		}
	}

	public Grille(int n, int[][] grille) {
		_taille = n;
		_nbCasesVides = n * n;
		_cases = new Case[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				_cases[i][j] = new Case(i, j, grille[i][j], n);
				if (_cases[i][j].getVal() != 0) {
					_nbCasesVides--;
				}
			}
		}
	}

	public Grille(Grille grille) {
		_taille = grille._taille;
		_nbCasesVides = grille._nbCasesVides;
		_cases = new Case[_taille][_taille];
		for (int i = 0; i < _taille; i++) {
			for (int j = 0; j < _taille; j++) {
				_cases[i][j] = new Case(grille.getCase(i, j));
			}
		}
	}

	public Case getCase(int i, int j) {
		return _cases[i][j];
	}

	public int getNbCasesVides() {
		return _nbCasesVides;
	}

	/*
	 * Fonction qui donne la liste des cases sans valeur (peut etre vide)
	 */
	public List<Case> getCasePossible() {
		// to do
		List<Case> casePoss = new ArrayList<Case>();
		for (int i = 0; i < _taille; i++) {
			for (int j = 0; j < _taille; j++) {
				if (this.getCase(i, j).getVal() == 0) {
					casePoss.add(this.getCase(i, j));
				}
			}
		}
		return casePoss;
	}

	/*
	 * Fonction qui donne la valeur v a la case c.
	 */
	public void setCase(Case c, int v) {
		if (c != null) {
			c.setVal(v);
		}
	}

	/*
	 * Fonction qui rend vrai si la valeur v peut etre donnee a la case C
	 * c'est-a-dire si la grille respecte toujours les contraintes du Sudoku.
	 */
	public boolean casePossible(Case c, int v) {
		for (int i = 0; i < _taille; i++) {
			if (this.getCase(i, c.getJ()).getVal() == v)
				return false;
		}

		for (int j = 0; j < _taille; j++) {
			if (this.getCase(c.getI(), j).getVal() == v)
				return false;
		}

		for (int i = (c.getI() / 3) * 3; i < ((c.getI() / 3) * 3) + 3; i++) {
			for (int j = (c.getI() / 3) * 3; j < ((c.getI() / 3) * 3) + 3; j++) {
				if (this.getCase(i, j).getVal() == v)
					return false;
			}
		}

		return true;
	}

	public void afficheGrille() {
		int v;
		int dim = (int) Math.sqrt(_taille);
		for (int i = 0; i < _taille; i++) {
			if (i % dim == 0) {
				System.out.print(" ");
				for (int k = 0; k <= _taille; k++)
					System.out.print("--");
				System.out.println();
			}
			for (int j = 0; j < _taille; j++) {
				if (j % dim == 0) {
					System.out.print("|");
				}
				v = _cases[i][j].getVal();
				if (v == 0) {
					System.out.print("  ");
				} else {
					System.out.print(v + " ");
				}
			}
			System.out.println("|");
		}
		System.out.print(" ");
		for (int k = 0; k <= _taille; k++)
			System.out.print("--");
		System.out.println();
	}
}