
/**
 * Clase BinaryTree: Representa un �rbol binario de b�squeda
 * @author Felipe Chac�n
 *
 */
public class BinaryTree {
	
	// Nodo ra�z del �rbol
	private BinaryTreeNode root;
	
	// Constructor: crea un �rbol a partir de un valor
	public BinaryTree(int value) {
		this.root = new BinaryTreeNode(value);
	}
	
	// Constructor: crea un �rbol a partir de un nodo
	public BinaryTree(BinaryTreeNode root) {
		this.root = root;
	}

	public BinaryTreeNode getRoot() {
		return root;
	}

	public void setRoot(BinaryTreeNode root) {
		this.root = root;
	}
	
	// M�todo que inserta un nodo dentro de otro (que representa un sub-�rbol)
	public void add(int value) {
		
		// Si la ra�z es nula, se setea con lo que viene
		if (this.root == null) {
			this.setRoot(new BinaryTreeNode(value));
		} else {
			
			// Si el valor del nodo a insertar es menor que el valor de la ra�z
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
	
	// M�todo que sirve para encontrar la distancia entre un valor y un nodo ra�z
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
		
		// Si alguno de ellos no existe dentro del �rbol, retornar distancia -1
		if(distance1 == -1 || distance2 == -1)
			return -1;
		
		// Si los valores son iguales, la distancia es 0
		if(value1 == value2)
			return 0;
		
		// Si el valor 1 es la ra�z, entonces la distancia entre ambos valores
		// corresponse a la distancia a la ra�z del valor 2
		if(value1 == this.root.getValue())
			return distance2;
		
		// Si el valor 2 es la ra�z, entonces la distancia entre ambos valores
		// corresponse a la distancia a la ra�z del valor 1
		if(value2 == this.root.getValue())
			return distance1;
		
		// Ahora:
		// - Los valores existen
		// - Los valores no son iguales
		// - Ninguno de ambos valores corresponde a la ra�z del �rbol
		
		// Si los valores est�n en ramas distintas a partir de la ra�z,
		// entonces la distancia entre ellos corresponde a la suma de las distancias
		// de ambos hacia la ra�z
		if(
			(value1 < this.root.getValue() && value2 > this.root.getValue()) || 
			(value1 > this.root.getValue() && value2 < this.root.getValue())
		)
			return distance1 + distance2;
		
		// Si los valores est�n en la misma rama izquierda, entonces con recursividad encontramos su distancia
		if(value1 < this.root.getValue() && value2 < this.root.getValue())
			return this.root.getLeftTree().getDistanceBetweenNodes(value1, value2);
		
		// Si los valores est�n en la misma rama derecha, entonces con recursividad encontramos su distancia
		return this.root.getRightTree().getDistanceBetweenNodes(value1, value2);
	}
}
