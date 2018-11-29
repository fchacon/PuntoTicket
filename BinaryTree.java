
/**
 * Clase BinaryTree: Representa un árbol binario de búsqueda
 * @author Felipe Chacón
 *
 */
public class BinaryTree {
	
	// Nodo raíz del árbol
	private BinaryTreeNode root;
	
	// Constructor: crea un árbol a partir de un valor
	public BinaryTree(int value) {
		this.root = new BinaryTreeNode(value);
	}
	
	// Constructor: crea un árbol a partir de un nodo
	public BinaryTree(BinaryTreeNode root) {
		this.root = root;
	}

	public BinaryTreeNode getRoot() {
		return root;
	}

	public void setRoot(BinaryTreeNode root) {
		this.root = root;
	}
	
	// Método que inserta un nodo dentro de otro (que representa un sub-árbol)
	public void add(int value) {
		
		// Si la raíz es nula, se setea con lo que viene
		if (this.root == null) {
			this.setRoot(new BinaryTreeNode(value));
		} else {
			
			// Si el valor del nodo a insertar es menor que el valor de la raíz
			if(value == this.root.getValue())
				return;
			else if(value < this.root.getValue()) {
				if(this.root.getLeftTree() == null)
					this.root.setLeftTree(new BinaryTree(value));
				else
					this.root.getLeftTree().add(value);
			}
			else {
				if(this.root.getRightTree() == null)
					this.root.setRightTree(new BinaryTree(value));
				else
					this.root.getRightTree().add(value);
			}
		}
		
	}
	
	// Método que sirve para encontrar la distancia entre un valor y un nodo raíz
	private int getDistance(int value) throws NullPointerException {
		if(this.root == null)
			return -1;
		
		if(this.root.getValue() == value)
			return 0;
		
		if(value < this.root.getValue())
			return 1 + this.root.getLeftTree().getDistance(value);
		else
			return 1 + this.root.getRightTree().getDistance(value);
	}
	
	public int getDistanceFromRoot(int value) {
		try {
			return getDistance(value);
		} catch(NullPointerException e) {
			return -1;
		}
	}
	
	public int getDistanceBetweenNodes(int value1, int value2) {
		int distance1 = this.getDistanceFromRoot(value1);
		int distance2 = this.getDistanceFromRoot(value2);
		
		// Si alguno de ellos no existe dentro del árbol, retornar distancia -1
		if(distance1 == -1 || distance2 == -1)
			return -1;
		
		// Si los valores son iguales, la distancia es 0
		if(value1 == value2)
			return 0;
		
		// Si el valor 1 es la raíz, entonces la distancia entre ambos valores
		// corresponse a la distancia a la raíz del valor 2
		if(value1 == this.root.getValue())
			return distance2;
		
		// Si el valor 2 es la raíz, entonces la distancia entre ambos valores
		// corresponse a la distancia a la raíz del valor 1
		if(value2 == this.root.getValue())
			return distance1;
		
		// Ahora:
		// - Los valores existen
		// - Los valores no son iguales
		// - Ninguno de ambos valores corresponde a la raíz del árbol
		
		// Si los valores están en ramas distintas a partir de la raíz,
		// entonces la distancia entre ellos corresponde a la suma de las distancias
		// de ambos hacia la raíz
		if(
			(value1 < this.root.getValue() && value2 > this.root.getValue()) || 
			(value1 > this.root.getValue() && value2 < this.root.getValue())
		)
			return distance1 + distance2;
		
		// Si los valores están en la misma rama izquierda, entonces con recursividad encontramos su distancia
		if(value1 < this.root.getValue() && value2 < this.root.getValue())
			return this.root.getLeftTree().getDistanceBetweenNodes(value1, value2);
		
		// Si los valores están en la misma rama derecha, entonces con recursividad encontramos su distancia
		return this.root.getRightTree().getDistanceBetweenNodes(value1, value2);
	}
}
