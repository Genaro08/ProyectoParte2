package Grafo;

public class Tester {
	public static void main(String[] args){
		Graph grafo = new Graph();
		
		System.out.println("Elimino un nodo  y un arco cuando el grafo esta vacio");
		grafo.removeNode(1);
		grafo.removeEdge(1, 2);		
		
		System.out.println("Agrego nodos que no estan en el grafo");
		grafo.addNode(1);
		grafo.addNode(2);
		grafo.addNode(4);
		grafo.addNode(3);
		
		System.out.println("Agrego arcos que no estan en el grafo con nodos que si estan");
		grafo.addEdge(1,2);
		grafo.addEdge(3,4);
		grafo.addEdge(2,3);
		grafo.addEdge(4,1);
		
		System.out.println("Agrego nodos que ya estan en el grafo");
		grafo.addNode(4);
		grafo.addNode(2);
		grafo.addNode(1);
		grafo.addNode(3);
		
		System.out.println("Agrego arcos que ya estan en el grafo");
		grafo.addEdge(1,2);
		grafo.addEdge(3,4);
		grafo.addEdge(2,3);
		grafo.addEdge(4,1);
		
		System.out.println("Agrego arcos con nodos que no estan en el grafo");
		grafo.addEdge(5,6);
		grafo.addEdge(1,5);
		grafo.addEdge(6,2);
		
		System.out.println("Remuevo nodos que estan en el grafo");
		grafo.removeNode(1);
		
		System.out.println("Remuevo nodo que no esta en el grafo");
		grafo.removeNode(1);
		
		System.out.println("Remuevo arco que esta en el grafo");
		grafo.removeEdge(3,4);
		
		System.out.println("Remuevo un arco que no esta en el grafo");
		grafo.removeEdge(3,4);
		
		System.out.println("Remuevo arcos donde no estan los nodos");
		grafo.removeEdge(5, 6);
		grafo.removeEdge(2, 5);
	}
}
