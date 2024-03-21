package web;

import java.util.ArrayList;
import java.util.List;

import metier.entities.Jeux;

public class JeuxModele {
	
	private String motCle;
	List<Jeux> Jeuxs = new ArrayList<>();

	public String getMotCle() {
		return motCle;
	}

	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}

	public List<Jeux> getJeuxs() {
		return Jeuxs;
	}	

	public void setJeuxs(List<Jeux> Jeuxs) {
		this.Jeuxs = Jeuxs;
	}

}