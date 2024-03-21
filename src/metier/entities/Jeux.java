package metier.entities;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "JeuxS")
public class Jeux implements Serializable{
@Id
@Column (name="ID_Jeux")
@GeneratedValue (strategy=GenerationType.IDENTITY)
private Long idJeux;
@Column (name="NOM_Jeux")
private String nomJeux;
private double prix;
public Jeux() {
super();
}
public Jeux(String nomJeux, double prix) {
super();
this.nomJeux = nomJeux;
this.prix = prix;
}
public Long getIdJeux() {
return idJeux;
}
public void setIdJeux(Long idJeux) {
this.idJeux = idJeux;
}
public String getNomJeux() {
return nomJeux;
}
public void setNomJeux(String nomJeux) {
this.nomJeux = nomJeux;
}
public double getPrix() {
return prix;
}
public void setPrix(double prix) {
this.prix = prix;
}

}