package br.edu.iftm.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import br.edu.iftm.model.domain.Categoria;

public class CategoriaDao {
	
	@PersistenceContext(unitName="ds2016-2Ecommerce")
	private EntityManager entityManager;

	@Transactional
	public void salvar(Categoria categoria){
		Categoria merge = entityManager.merge(categoria);
		entityManager.persist(merge);
	}
	
	@Transactional
	public void atualizar(Categoria categoria) {
		Categoria merge = entityManager.merge(categoria);
		entityManager.persist(merge);
	}

	@Transactional
	public void excluir(Integer codigo) {
		Categoria merge = entityManager.merge(new Categoria(codigo));
		entityManager.remove(merge);
	}

	@SuppressWarnings("unchecked")
	public List<Categoria> buscar(Categoria categoria) {
		Query query = entityManager.createQuery("from Categoria");
		return query.getResultList();
	}

	public Categoria buscarPorId(Integer codigo) {
		Query query = entityManager.createQuery("from Categoria where codigo = :codigo");
		query.setParameter("codigo", codigo);
		return (Categoria)query.getSingleResult();
	}
}
