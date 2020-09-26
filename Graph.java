package Grafo;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.*;

public class Graph {
	private List<Vertice> listaVertices;
	private List<Arco> listaArcos;
	private static Logger logger;
	
	public Graph(){
		listaVertices = new LinkedList<Vertice>();
		listaArcos = new LinkedList<Arco>();
		if(logger == null){
			logger = logger.getLogger(Graph.class.getName());
			Handler hnd = new ConsoleHandler();
			hnd.setLevel(Level.FINE);
			logger.addHandler(hnd);
			logger.setLevel(Level.WARNING);
			Logger rootLogger = logger.getParent();
			for(Handler h : rootLogger.getHandlers()){
				h.setLevel(Level.OFF);
			}
		}
	}
	
	public void addNode(int node){
		Vertice verticeNuevo = new Vertice(node);
		int indice = 0;
		boolean agrego = false;
		for(Vertice v : listaVertices){
			if(verticeNuevo.getRotulo() == v.getRotulo()){
				logger.warning("El nodo "+v.getRotulo()+" ya estaba en el grafo");
				agrego = true;
				break;
			}else{
				if(verticeNuevo.getRotulo() < v.getRotulo()){
					logger.fine("Se agrego correctamente el nodo "+node+" al grafo");
					listaVertices.add(indice, verticeNuevo);
					agrego = true;
					break;
				}
			}
			indice++;
		}
		if(!agrego){
			logger.fine("Se agrego correctamente el nodo "+node+" al grafo");
			listaVertices.add(new Vertice(node));
		}
	}
	
	public void removeNode(int node){
		boolean eliminado = false;
		List<Arco> listaArcosBorrados = new LinkedList<Arco>();
		for(Vertice v : listaVertices){
			if(node == v.getRotulo()){
				logger.fine("Se removio el nodo "+v.getRotulo()+" del grafo");
				listaVertices.remove(v);
				eliminado = true;
				break;
			}
			if(node < v.getRotulo()){
				break;
			}
		}
		if(eliminado){
			for(Arco a : listaArcos){
				if(a.getInicio().getRotulo() == node || a.getFin().getRotulo() == node){
					listaArcosBorrados.add(a);
				}
			}
			listaArcos.removeAll(listaArcosBorrados);
		}else {
			logger.warning("El nodo "+node+" no puedo ser eliminado porque no se encuentra en el grafo");
		}
	}
	
	public void addEdge(int node1, int node2){
		boolean inicio = false;
		boolean fin = false;
		boolean esta = false;
		Arco arco = new Arco();
		for(Arco a : listaArcos){
			if(a.getInicio().getRotulo() == node1 && a.getFin().getRotulo() == node2){
				esta = true;
				logger.warning("El arco entre "+node1+" y "+node2+" ya estaba en el grafo");
				break;
			}
		}
		if(!esta){
			for(Vertice v : listaVertices){
				if(!inicio && v.getRotulo() == node1){
					inicio = true;
					arco.setInicio(v);
				}
				if(!fin && v.getRotulo() == node2){
					fin = true;
					arco.setFin(v);
				}
				if(inicio && fin){
					break;
				}
			}
			if(inicio && fin){
				logger.fine("Se agrego el arco entre "+node1+" y "+node2+" de forma correcta");
				listaArcos.add(arco);
			}else{
				if(!inicio && !fin){
					logger.warning("No se pudo agregar el arco ya que ninguno de los nodos estaba en el grafo");	
				}else{
					if(!inicio){
						logger.warning("No se pudo agregar el arco ya que el nodo "+node1+" no esta en el grafo");
					}else{
						logger.warning("No se pudo agregar el arco ya que el nodo "+node2+" no esta en el grafo");
					}
				}
			}	
		}
	}
	
	public void removeEdge(int node1, int node2){
		boolean removio = false;
		boolean inicio = false;
		boolean fin = false;
		for(Vertice v : listaVertices){
			if(!inicio && v.getRotulo() == node1){
				inicio = true;
			}
			if(!fin && v.getRotulo() == node2){
				fin = true;
			}
			if(inicio && fin){
				break;
			}
		}
		if(!inicio && !fin){
			logger.warning("No se pudo remover el arco ya que ninguno de los nodos estaba en el grafo");	
		}else{
			if(!inicio){
				logger.warning("No se pudo remover el arco ya que el nodo "+node1+" no esta en el grafo");
			}else{
				if(!fin){
					logger.warning("No se pudo remover el arco ya que el nodo "+node2+" no esta en el grafo");
				}
			}
		}
		if(inicio && fin){
			for(Arco a : listaArcos){
				if(a.getInicio().getRotulo() == node1 && a.getFin().getRotulo() == node2){
					logger.fine("Se removio el arco entre los nodos "+node1+" y "+node2+" de forma correcta");
					listaArcos.remove(a);
					removio = true;
					break;
				}
			}
			if(!removio){
				logger.warning("No existe arco entre los nodos "+node1+ " y "+node2);
			}
		}
	}
}
