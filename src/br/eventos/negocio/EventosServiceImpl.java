package br.eventos.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.eventos.entidade.Evento;
import br.eventos.persistencia.EventosDAO;
import br.eventos.util.EventosException;

@Service
@Transactional
public class EventosServiceImpl implements EventosService {
	
	
	private EventosDAO eventosDAO;
	
	public EventosDAO getEventosDAO() {
		return eventosDAO;
	}
	@Autowired
	public void setEventosDAO(EventosDAO eventosDAO) {
		this.eventosDAO = eventosDAO;
	}
	/**
	 * Inclui um Evento.
	 * @param eventos
	 * @return
	 * @throws EventosException
	 */
	
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public Evento incluir(Evento eventos) throws EventosException {
		return getEventosDAO().incluir(eventos);
	}
	/**
	 * Altera um Evento.
	 * @param eventos
	 * @return
	 * @throws EventosException
	 */
	
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public Evento alterar(Evento eventos) throws EventosException {
		
		return getEventosDAO().alterar(eventos);
	}
	/**
	 * Consulta um evento pelo código.
	 * @param codEvento
	 * @return
	 * @throws EventosException
	 */
	
	@Transactional(readOnly=true, propagation = Propagation.SUPPORTS)
	public Evento consultar(Integer codEvento) throws EventosException {
		Evento evento = getEventosDAO().consultar(codEvento);
		
		return evento;
	}
	/**
	 * Exclui um evento pelo Código.
	 * @param codEvento
	 * @throws EventosException
	 */
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public void exclir(Integer codEvento) throws EventosException {
		getEventosDAO().excluir(codEvento);
	}
	
	/**
	 * Lista todos os eventos.
	 * @return
	 * @throws EventosException
	 */
	@Transactional(readOnly=true, propagation = Propagation.SUPPORTS)
	public List<Evento> listar() throws EventosException {
		return getEventosDAO().listar();
	}

}
