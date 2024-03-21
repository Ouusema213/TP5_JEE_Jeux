package dao;

import java.util.List;

import metier.entities.Jeux;

public class TestDao {
	
	public static void main(String[] args) {
		
		JeuxDaoImpl pdao= new JeuxDaoImpl();
		
		Jeux prod= pdao.save(new Jeux("CS:GO",2800));
		
		System.out.println(prod);
		
		List<Jeux> prods =pdao.JeuxsParMC("Action");
		
		for (Jeux p : prods)
			System.out.println(p);
		}


}
