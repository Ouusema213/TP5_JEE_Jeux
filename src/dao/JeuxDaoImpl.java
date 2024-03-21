package dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import metier.entities.Jeux;
import util.JPAutil;
public class JeuxDaoImpl implements IJeuxDao {
private EntityManager entityManager=JPAutil.getEntityManager("TP5_JEE");
@Override
public Jeux save(Jeux p) {
	EntityTransaction tx = entityManager.getTransaction();
	tx.begin();
	entityManager.persist(p);
	tx.commit();
	return p;
	}
	@Override
	public List<Jeux> JeuxsParMC(String mc) {
	List<Jeux> prods = entityManager.createQuery("select p from Jeux p where p.nomJeux like :mc").setParameter("mc", "%"+mc+"%").getResultList();

	return prods;
	}
	@Override
	public Jeux getJeux(Long id) {
	return entityManager.find(Jeux.class, id);
	}
	@Override
	public Jeux updateJeux(Jeux p) {
	EntityTransaction tx = entityManager.getTransaction();
	tx.begin();
	entityManager.merge(p);
	tx.commit();
	return p;
	}
	@Override
	public void deleteJeux(Long id) {
	Jeux Jeux = entityManager.find(Jeux.class, id);
	entityManager.getTransaction().begin();
	entityManager.remove(Jeux);
	entityManager.getTransaction().commit();
	}
	}
