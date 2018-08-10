package up.edu.br.sistemaacademico.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import up.edu.br.sistemaacademico.entidades.Aluno;

public class AlunoDao implements Dao<Aluno> {
	
	static EntityManager em = Conexao.getInstance().createEntityManager();	
	
	public void adicionar(Aluno aluno) {
			
		em.getTransaction().begin();
		em.persist(aluno);
		em.getTransaction().commit();
	}
	
	public void editar(Aluno aluno) {		
		
		try {
			buscaPorId(aluno.getId());				
			em.merge(aluno);
			em.getTransaction().commit();
			
		} catch (Exception e) {
			e.getMessage().toString();
		}
		
	}
	
	public void excluir(Aluno aluno) {
		em.remove(aluno);
		em.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	public List<Aluno> listar() {

		Query q = em.createQuery("select a from Aluno a");
		return q.getResultList();
	}

	@Override
	public Aluno buscaPorId(Long id) {

		return em.find(Aluno.class, id);
	}

}
