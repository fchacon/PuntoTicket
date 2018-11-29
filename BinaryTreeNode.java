
public class BinaryTreeNode {
	
	// Valor del nodo
	private int value;
	
	// Nodo izquierdo
	private BinaryTree leftTree;
	
	// Nodo derecho
	private BinaryTree rightTree;
	
	// Constructor
	public BinaryTreeNode(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public BinaryTree getLeftTree() {
		return leftTree;
	}

	public void setLeftTree(BinaryTree leftTree) {
		this.leftTree = leftTree;
	}

	public BinaryTree getRightTree() {
		return rightTree;
	}

	public void setRightTree(BinaryTree rightTree) {
		this.rightTree = rightTree;
	}
	
	
}
