package br.eventos.persistencia;

import java.io.Serializable;
import java.util.List;

import br.eventos.util.EventosException;

/**
 * Interface que define as operacoes da camada de persistencia generica
 * @author Gilcimar
 *
 */
public interface GenericoDAO<T, ID extends Serializable> {

	/**
	 * Retorna a classe a ser persistida
	 * @return
	 */
	public Class<T> getObjectClass();

	/**
	 * Inclui um objeto T na base de dados
	 * @param object
	 * @return
	 * @throws EventosException
	 */
	public T incluir(T object) throws EventosException;

	/**
	 * Altera um objeto T na base de dados
	 * @param object
	 * @return
	 * @throws EventosException
	 */
	public T alterar(T object) throws EventosException;

	/**
	 * Consulta um objeto T da base de dados
	 * @param id
	 * @return
	 * @throws EventosException
	 */
	public T consultar(Integer id) throws EventosException;

	/**
	 * Exclui um objeto T  da base de dados
	 * @param id
	 * @throws EventosException
	 */
	public void excluir(Integer id) throws EventosException;

	/**
	 * Lista os objetos T da base de dados
	 * @return
	 * @throws EventosException
	 */
	public List<T> listar() throws EventosException;
}
