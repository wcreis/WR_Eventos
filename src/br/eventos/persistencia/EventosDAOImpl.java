package br.eventos.persistencia;

import org.springframework.stereotype.Repository;

import br.eventos.entidade.Evento;

/**
 * 
 * @author Wesley
 *
 */
@Repository
public class EventosDAOImpl extends GenericoDAOImpl<Evento, Integer> implements EventosDAO{}
