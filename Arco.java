package Grafo;
public class Arco {
	private Vertice inicio;
	private Vertice fin;
	
	public Arco(){
		inicio = null;
		fin = null;
	}
	
	public Vertice getInicio(){
		return inicio;
	}
	
	public Vertice getFin(){
		return fin;
	}
	
	public void setInicio(Vertice inicio){
		this.inicio = inicio;
	}
	
	public void setFin(Vertice fin){
		this.fin = fin;
	}
}
