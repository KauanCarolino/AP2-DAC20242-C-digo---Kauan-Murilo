package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entidade.Jogo;
import util.JPAUtil;

public class JogoDAO {
	public static void salvar(Jogo jogo) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.persist(jogo);
		em.getTransaction().commit();
		em.close();
	}
	
	public static void editar(Jogo jogo) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.merge(jogo);
		em.getTransaction().commit();
		em.close();
	}
	
	public static Jogo achar(Integer id) {
		EntityManager em = JPAUtil.criarEntityManager();
		Jogo jogo = em.find(Jogo.class, id);
		em.close();
		return jogo;
	}
	
	public static void Excluir(Jogo jogo) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		jogo = em.find(Jogo.class, jogo.getId());
		em.remove(jogo);
		em.getTransaction().commit();
		em.close();
	}
	
	public static List<Jogo> Listar(){
		EntityManager em = JPAUtil.criarEntityManager();
		Query q = em.createQuery("select j from Jogo j");
		List<Jogo> lista = q.getResultList();
		em.close();
		return lista;
	}
	
	public static int obterMaiorNumeroSorteado(Jogo jogo) {
	    EntityManager em = JPAUtil.criarEntityManager();        
	    Query query = em.createNamedQuery("Jogo.findMaxValue");
	    Integer maiorNumeroSorteado = (Integer) query.getSingleResult();
	    em.close();
	    return maiorNumeroSorteado;
	}
}
