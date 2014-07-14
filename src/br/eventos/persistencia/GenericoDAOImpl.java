package br.eventos.persistencia;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import  br.eventos.util.EventosException;

/**
 * Classe que define as operacoes da camada de persistencia generica
 * @author Gilcimar
 *
 */
public class GenericoDAOImpl<T, ID extends Serializable> implements GenericoDAO<T, ID> {
	
	private EntityManager entityManager;
	private final Class<T> oClass;

	//Classe a ser persistida
	public Class<T> getObjectClass() {
		return this.oClass;
	}

	//Gerenciador de persistencia
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@SuppressWarnings("unchecked")
	public GenericoDAOImpl(){
		this.oClass = (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	/**
	 * Inclui um objeto T na base de dados
	 * @param object
	 * @return
	 * @throws EventosException
	 */
	public T incluir(T object) throws EventosException {
		try{
			getEntityManager().merge(object);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new EventosException(e,"Não foi posssível realizar a inclusão.");
		}
		return object;
	}

	/**
	 * Altera um objeto T na base de dados
	 * @param object
	 * @return
	 * @throws EventosException
	 */
	public T alterar(T object) throws EventosException {
		try{
			getEntityManager().merge(object);
		}
		catch (Exception e) {
			throw new EventosException(e,"Não foi posssível realizar a alterão.");
		}
		return object;
	}

	/**
	 * Consulta um objeto T da base de dados
	 * @param id
	 * @return
	 * @throws EventosException
	 */
	public T consultar(Integer id) throws EventosException {
		T object = null;
		try{
			object = getEntityManager().find(getObjectClass(), id);
		}
		catch (EntityNotFoundException e) {
			throw new EventosException(e,"Registro Não encontrado.");
		}
		catch (Exception e) {
			throw new EventosException(e,"Não foi posssível realizar a consulta.");
		}
		return object;
	}

	/**
	 * Exclui um objeto T  da base de dados
	 * @param id
	 * @throws EventosException
	 */
	public void excluir(Integer id) throws EventosException {
		try{
			getEntityManager().remove(getEntityManager().getReference(getObjectClass(), id ));
		}
		catch (EntityNotFoundException e) {
			throw new EventosException(e,"Registro Não encontrado para exclusão.");
		}
		catch (Exception e) {
			throw new EventosException(e,"Não foi posssível realizar a exclusão.");
		}
		
	}

	/**
	 * Lista os objetos T da base de dados
	 * @return
	 * @throws EventosException
	 */
	@SuppressWarnings("unchecked")
	public List<T> listar() throws EventosException {
		List<T> lista = null;  
        try {  
            Query query = getEntityManager().createQuery("SELECT object(o) FROM " + getObjectClass().getSimpleName() + " AS o");  
            lista = query.getResultList();  
        } catch (Exception e) {  
            throw new EventosException(e, "Problemas na localizão dos objetos");  
        }  
        return lista;  
     }

}
