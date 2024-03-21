package dao;

import java.util.List;

import metier.entities.Jeux;

public interface IJeuxDao {
	
		public Jeux save(Jeux p);
		public List<Jeux> JeuxsParMC(String mc);
		public Jeux getJeux(Long id);
		public Jeux updateJeux(Jeux p);
		public void deleteJeux(Long id);
		
}


