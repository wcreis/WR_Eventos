/**
 * 
 */
package br.eventos.negocio;

import java.util.List;

import br.eventos.entidade.Evento;
import br.eventos.util.EventosException;

/**
 * @author Wesley
 *
 */
public interface EventosService {
	/**
	 * Inclui um Evento.
	 * @param eventos
	 * @return
	 * @throws EventosException
	 */
	public Evento incluir(Evento eventos)  throws EventosException;
	
	/**
	 * Altera um Evento.
	 * @param eventos
	 * @return
	 * @throws EventosException
	 */
	public Evento alterar(Evento eventos)  throws EventosException;
	
	/**
	 * Exclui um evento pelo Código.
	 * @param codEvento
	 * @throws EventosException
	 */
	public void exclir(Integer codEvento)  throws EventosException;	
	
	/**
	 * Consulta um evento pelo código.
	 * @param codEvento
	 * @return
	 * @throws EventosException
	 */
	public Evento consultar(Integer codEvento)  throws EventosException;
	
	/**
	 * Lista todos os eventos.
	 * @return
	 * @throws EventosException
	 */
	public List<Evento> listar() throws EventosException;
}
