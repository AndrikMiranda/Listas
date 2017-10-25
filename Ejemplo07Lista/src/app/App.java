package app;

import linkedlist.linkedlist;

public class App {
	public static void main(String[] args) {
		linkedlist<String> names = new linkedlist<String>();
		linkedlist<String> lastnames = new linkedlist<String>();
		linkedlist<Integer> ages = new linkedlist<Integer>(19);
		
		
		names.AddEnd("Ana");
		names.AddStart("Julio");
		names.AddEnd("Ricardos");
		names.AddEnd("Pepe");
		names.AddEnd("Juan");
		names.AddAfter("Juan", "Lupe");
		names.AddEnd("Jose Arturo");
		//names.Remplace("Ana", "Juangas");
		//names.Remplace("Juangas", "Esto se va a descontrolaaaaaaaarrrrrr!!!!!!!!");
		names.AddBefore("Juan", "Jorge");
		//names.IndexOf("Juan");
		//names.RemoveBefore("Pepe");
		names.RemoveBefore("Pepe");
		names.AddStart("PepeGrillo");
		names.Reindex();
		
		System.out.println("------------------------------------------------");
		//names.RemoveFirst();
		//names.GetFirst();
		System.out.println(names.Size());
		//names.GetLast();
		//names.RemoveLast();
		//String resu = names.IsEmpty();
		//System.out.println(resu);
		//names.RemoveBefore("Pepe");
		//ages.AddBefore(19);
		
		
		//names.ClearAll();
		
		//ages.AddEnd(29);
		

		names.printer();		
		
		//names.remover("Ana");
		
		
		
		//if (ages.search(29)!=null) {
			//ages.AddAfter(29,35);
		//}
		
		//names.AddLast("Ricardos", "Ang");
		
		//ages.AddBefore(19,15);
		
		//names.pronter();
		//ages.printer();
		
		
		//System.out.println("No marco error");
		
	}

}
