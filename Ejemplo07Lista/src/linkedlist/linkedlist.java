	package linkedlist;

import nodo.node;

public class linkedlist <T>{
	private node<T> sentinel=null;
		
	public linkedlist() { //contructor default
		sentinel = new node<T>(); //nodo centinela
		sentinel.setIndex(-1); //indice nodo centinela
	}
	
	public linkedlist(T value) {
		this(); //Llama al constructor con la firma del metodo
		node<T> tmp = new node<T>(value); //creacion de nodo. Nodo valor de tipo T
		tmp.setIndex(0);
		sentinel.setNext(tmp);
	}
	
	public void AddStart(T value) {

		node<T> tmp= sentinel.getNext();
		node <T> _new=new node<T>(value);
		
		_new.setNext(tmp);
		
		sentinel.setNext(_new);
		
	}
	
	public void AddEnd(T value) {
		node<T> tmp = sentinel;
		
		while(tmp.getNext()!=null) //recorre la lista, cuando llegue al final agrega el nuevo nodo (while sin llaves)
			tmp = tmp.getNext();
			tmp.setNext(new node<T>(value));
		
	}
	
	public void AddEndR(T value) {
		AddEndR(value,sentinel);			
		
	}
	
	private void AddEndR(T value,node<T> list) {
		if (list.getNext()==null) { //Si es nulo se agrega
			list.setNext(new node<T>(value));
			return;
		}
		AddEndR(value,list.getNext());
	}
	
	public node<T> remmove(T value){
		node<T> tmp = sentinel;
		while(tmp.getNext() != null){
			if (tmp.getNext().getValue().equals(value)) {
				tmp.setNext(tmp.getNext().getNext());
			}else {
				tmp = tmp.getNext();
			}
		}
		
		return null;
	}
	
	public boolean remove(T value) {
		node<T> tmp = sentinel;
		while(tmp.getNext() != null){
			if (tmp.getNext().getValue().equals(value)) {
				tmp.setNext(tmp.getNext().getNext());
			}else {
				tmp = tmp.getNext();
			}
		}
			
		return false; //No encontro el nodo a borrar
		
	}
	
	public boolean remover(T value) {
		return remover(value,sentinel);
	}
	
	private boolean remover (T value, node<T> list) {
		if (list.getNext()==null) 
			return false; //No lo encontro
		
		if (list.getNext().getValue().equals(value)) {
			list.setNext(list.getNext().getNext());
			return true; //Si lo encontro
		}
		return remover (value, list.getNext());
	}
	
	public void Reindex() {
		node<T> tmp=sentinel;
		int con = 0;
		while(tmp.getNext()!=null) {
			tmp=tmp.getNext();
			tmp.setIndex(con++);
		}
	}
	
	public void IndexOf(T value) {
		Reindex();
		node<T> finder = search(value);
		if (finder != null) {
			 System.out.println("La posición de: "+ value + " esta en: " + finder.getIndex()); 
		}
	}
	
	
	
	public node<T> search(T value) {
		
		return search(value,sentinel);
		
	}
	
	private node<T> search(T value, node<T>list) {
		if (list.getNext()==null) 
			return null;
		if (list.getNext().getValue().equals(value)) 
			return list.getNext();
		return search(value,list.getNext());
		
	}
	
	public void printer() {
		printer(sentinel);
	}
	
	
	public void pronter() {
		node<T> tmp=sentinel;
		while(tmp.getNext()!=null) {
			tmp=tmp.getNext();
			System.out.println(tmp.getValue());
		}
	}
	
	private void printer(node<T> tmp) {
		if (tmp.getNext()==null) {
			return;
		}
		else{
			System.out.println(tmp.getNext().getValue());
			printer(tmp.getNext());
		}
	}
	
	public boolean AddAfter(T value, T newvalue) {
		node<T> finder = search(value); //busca el valor
		if(finder != null)
			return AddAfter(new node<T>(newvalue),finder);
		else
			return false;//no lo encontro
	}
	
	public boolean AddAfter(T value,node<T> nodo) {
		node<T> finder = search(value);
		if(finder!=null)
			return AddAfter(nodo,finder);//agrega el nodo
		else
			return false;
	}
	private boolean AddAfter(node<T> nodo, node<T> list) {
		nodo.setNext(list.getNext());
		list.setNext(nodo);
		
		return true;
	}
	
	public boolean AddBefore(T value, T newvalue) {
		node<T> tmp = sentinel;
		//if(tmp.getNext()!=null)
		//	tmp=tmp.getNext();
		
		while(tmp.getNext()!=null && !tmp.getNext().getValue().equals(value))
			tmp = tmp.getNext();
		
		return (tmp.getNext()!=null)?AddAfter(new node<T>(newvalue),tmp):false;
			
	}
	
	public void List() {
		node<T> tmp = sentinel;
		while (tmp.getNext()!=null){		
			System.out.println(tmp.getNext());
		}
	}
	
	public void Remplace(T value, T newvalue){
		node<T> finder = search(value);
		if (finder != null) {
			finder.setValue(newvalue);
			}
		}
	
	public String IsEmpty(){
		node<T> tmp = sentinel;
		if (tmp.getNext() == null) {
			return "La lista se encuentra vacia morro";
		}else {
			return "La lista no se encuentra vacia morro";
		}
	}
	
	public int Size(){
		int con = 0;
		
		node<T> tmp = sentinel;
		
		while(tmp.getNext() != null){
			
			tmp = tmp.getNext();
			
			con++;
		}
		return con;
	}
	
	public void RemoveAfter(T value){
		node<T> finder = search(value);
		if (finder != null) {
			remove(finder.getNext().getValue());
			}
		}
	
	public boolean RemoveBefore(T value){
		node<T> tmp = sentinel;
		while(tmp.getNext()!=null && !tmp.getNext().getValue().equals(value))
			tmp = tmp.getNext();
		return (tmp.getNext()!=null)?remove(tmp.getValue()):false;
	}
	
	public void RemoveFirst(){
		node <T> tmp = sentinel;
		if (tmp != null){
			tmp = tmp.getNext();
		}
		
		remove(tmp.getValue());	
	}
	
	public void RemoveLast(){
		node<T> tmp=sentinel;
		while(tmp.getNext()!=null){
			tmp = tmp.getNext();	
		}
		remove(tmp.getValue());
	}
	
	public void GetLast(){
		node <T> tmp = sentinel;
		while (tmp.getNext() != null){
				tmp = tmp.getNext();
		}
		System.out.println(tmp.getValue());
    }
	
	public void GetFirst(){
		node <T> tmp = sentinel;
		if (tmp.getNext()!=null){
		System.out.println(tmp.getNext().getValue());
		}
	}
	
	public void ClearAll(){
		node<T> tmp=sentinel;
		while(tmp.getNext()!=null) {
			tmp=tmp.getNext();
			remove(tmp.getValue());
		}
		
	}
}
