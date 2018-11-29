import java.util.Scanner;

public class Main {
	
	@SuppressWarnings("resource")
	public static void main(String args[]) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Test para PuntoTicket. Creado por Felipe Chacón. Para salir, ingrese 'exit'.");
		
		// Iteramos sobre un ciclo infinito hasta que el usuario ingrese exit
		while(true) {
			System.out.println("Ingrese valores de los nodos (Ej: 4,3,16,10,7,20,12): ");
			
			// Leemos input
		    String input = scanner.nextLine();
		    
		    // Salir si escribe exit
		    if(checkExit(input, scanner))
		    	break;
		    
		    // Crear árbol binario a partir del input
		    BinaryTree tree = createTree(input);
		    
		    // Dar a escoger las opciones del programa
		    System.out.println("Escoja una opción: ");
		    System.out.println("1: Encontrar la distancia entre la raíz y un nodo en particular");
		    System.out.println("2: Encontrar la distancia entre 2 nodos");
		    System.out.println("> ");
		    
		    // Leer la opción escogida
		    String option = scanner.nextLine();
		    
		    // Salir si escribió 'exit'
		    if(checkExit(option, scanner))
		    	break;
		    
		    // Opción escogida N° 1
		    if(option.trim().equalsIgnoreCase("1")) {
		    	System.out.println("Ingrese valor del nodo: ");
		    	
		    	// Leer valor del nodo
		    	String node_value = scanner.nextLine();
		    	
		    	// Salir si escribió 'exit'
		    	if(checkExit(node_value, scanner))
			    	break;
		    	
		    	int value = Integer.parseInt(node_value);
		    	
		    	// Imprimir la distancia entre la raíz y el nodo ingresado
		    	System.out.println("La distancia entre la raíz y " + value + " es: " + tree.getDistanceFromRoot(value));
		    } 
		    // Opción escogida N° 2
		    else if(option.trim().equalsIgnoreCase("2")) {
		    	System.out.println("Ingrese valor del nodo 1: ");
		    	
		    	// Leer valor del nodo 1
		    	String node_value1 = scanner.nextLine();
		    	
		    	// Salir si escribió 'exit'
		    	if(checkExit(node_value1, scanner))
			    	break;
		    	
		    	int value1 = Integer.parseInt(node_value1);
		    	
		    	System.out.println("Ingrese valor del nodo 2: ");
		    	
		    	// Leer valor del nodo 2
		    	String node_value2 = scanner.nextLine();
		    	
		    	// Salir si escribió 'exit'
		    	if(checkExit(node_value2, scanner))
			    	break;
		    	
		    	int value2 = Integer.parseInt(node_value2);
		    	
		    	// Imprimir la distancia entre los nodos ingresados
		    	System.out.println("La distancia entre "+value1+" y "+value2+" es: " + tree.getDistanceBetweenNodes(value1, value2));
		    } else { // Opción inválida
		    	System.out.println("Opción inválida");
		    }
		    
		    // Imprimir un salto de línea
		    System.out.println("");
		}
	    
		// Cerrar scanner
	    scanner.close();
	}
	
	// Método auxiliar que crea un árbol binario a partir del input del usuario
	private static BinaryTree createTree(String input) {
		// Hacemos un split del input para obtener todos los números
		String valuesStr[] = input.split(",");
		
		// Partimos con árbol vacío
		BinaryTree tree = new BinaryTree(0);
		
		// Recorremos el array de strings para ingresar cada valor dentro de un árbol binario
		for(int i = 0; i < valuesStr.length; i++) {
			int value = Integer.parseInt(valuesStr[i].trim()); // Eliminamos espacios en blanco
			
			// Insertamos el primer valor al árbol, creándolo previamente
			if(i == 0)
				tree = new BinaryTree(value);
			
			// Insertamos el valor en el árbol
			tree.add(value);
		}
		
		return tree;
	}
	
	// Método auxiliar que revisa si el usuario escribió 'exit'
	private static boolean checkExit(String input, Scanner scanner) {
		if(input.trim().equalsIgnoreCase("exit")) {
			System.out.println("Hasta pronto.");
			scanner.close();
			return true;
		}
		
		return false;
	}
}
