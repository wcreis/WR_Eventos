package br.eventos.controle;

//import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlInputHidden;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.eventos.entidade.Evento;
import br.eventos.negocio.EventosService;
import br.eventos.util.Convert;
import br.eventos.util.EventosException;

@ManagedBean(name="eventoController")
@SessionScoped
@Controller
public class EventoController {

	@Autowired
	private EventoBean eventoBean;
	@Autowired
	private List<EventoBean> listaEventoBean;
	@Autowired
	private EventosService eventosService;
	@Autowired
	private EventoBean eventoBeanSelecionado;

	/**
	 * Construtor de EventoController
	 */
	public EventoController(){
		eventoBean = new EventoBean();
	}

	/**
	 * Incluir um Evento no Banco de Dados.
	 * @return
	 */
	public String incluir(){

		Evento evento = new Evento();

		evento.setBairroEvento(getEventoBean().getBairroEvento());
		evento.setCidadeEvento(getEventoBean().getCidadeEvento());
		evento.setDataEvento(getEventoBean().getDataEvento());
		evento.setDescricaoEvento(getEventoBean().getDescricaoEvento());
		evento.setEmiteCertificado(getEventoBean().getEmiteCertificado());
		evento.setHoraEvento(getEventoBean().getHoraEvento());
		evento.setLogradEvento(getEventoBean().getLogradEvento());
		evento.setTipoEvento(getEventoBean().getTipoEvento());
		evento.setTituloEvento(getEventoBean().getTituloEvento());
		evento.setUfEstado(getEventoBean().getUfEstado());
		evento.setValorIncricao(getEventoBean().getValorIncricao());
		
		try {
			getEventosService().incluir(evento);
		} catch (EventosException e) {
			String msg = "Inclus„o n„o realizada. Movito: " + ((e instanceof EventosException ? ((EventosException)e).getEx().getMessage():""));
			FacesMessage message = new FacesMessage(msg);
			this.getFacesContext().addMessage("formulario", message);
			return "falha";
		}
		
		return "sucesso";
	}
	/**
	 * Lista todos os Eventos Cadastrados no Banco de Dados.
	 * @return
	 */
	public String listar(){
		try {
			List<Evento> listaEventos = getEventosService().listar();

			if(listaEventos==null || listaEventos.size()==0){
				FacesMessage message = new FacesMessage("Nenhum registro encontrado.");
				this.getFacesContext().addMessage("formulario", message);
				return "listar";
			}

			//preeche a lista de Eventos da tela
			setListaEventoBean(new ArrayList<EventoBean>());
			for (Evento evento : listaEventos) {

				EventoBean eventoBean = new EventoBean();

				eventoBean.setBairroEvento(evento.getBairroEvento());
				eventoBean.setCidadeEvento(evento.getCidadeEvento());
				eventoBean.setCodEvento(evento.getCodEvento());
				eventoBean.setDataEvento(Convert.utilToSqlDate(evento.getDataEvento()));
				eventoBean.setDescricaoEvento(evento.getDescricaoEvento());
				eventoBean.setEmiteCertificado(evento.getEmiteCertificado());
				eventoBean.setHoraEvento(evento.getHoraEvento());
				eventoBean.setLogradEvento(evento.getLogradEvento());
				eventoBean.setTipoEvento(evento.getTipoEvento());
				eventoBean.setTituloEvento(evento.getTituloEvento());
				eventoBean.setUfEstado(evento.getUfEstado());
				eventoBean.setValorIncricao(evento.getValorIncricao());

				getListaEventoBean().add(eventoBean);
			}
			
			eventoBeanSelecionado = new EventoBean();
			return "listar";
		} 
		catch (EventosException e) {
			String msg = "Listagem n„o realizada. Movito: " + ((e instanceof EventosException ? ((EventosException)e).getEx().getMessage():""));
			FacesMessage message = new FacesMessage(msg);
			this.getFacesContext().addMessage("formulario", message);
			return "falha";
		}
	}

	/**
	 * Metodo para Cadastro de novo evento no Banco de Dados.
	 * @return
	 */
	public String criar(){

		try{
			
			eventoBean = new EventoBean();
			return "criar";
		}
		catch (Exception e) {
			String msg = "Cadastro n√£o realizado. Movito: " + ((e instanceof EventosException ? ((EventosException)e).getEx().getMessage():""));
			FacesMessage message = new FacesMessage(msg);
			this.getFacesContext().addMessage("formulario", message);
			return "falha";
		}
	}

	/**
	 * Exclui um evento Cadastrado no Banco de Dados.
	 * @return
	 */
	public String excluir() {
		try{

			HtmlInputHidden codEvento = (HtmlInputHidden) this.getFacesContext().getViewRoot().findComponent("formulario:codEvento");

			Evento evento = getEventosService().consultar((Integer) codEvento.getValue());

			if(evento==null || evento.getCodEvento()== 0){
				FacesMessage message = new FacesMessage("Nenhum registro encontrado.");
				this.getFacesContext().addMessage("formulario", message);
				return "listar";
			}

			getEventosService().exclir(evento.getCodEvento());
			
			
		}
		catch (Exception e) {
			String msg = "Nao Consegui Excluir o Evento. Movito " + ((e instanceof EventosException ? ((EventosException)e).getEx().getMessage():""));
			FacesMessage message = new FacesMessage(msg);
			this.getFacesContext().addMessage("formulario", message);
			return "falha";
		}
		return "sucesso";
	}

	/**
	 * Altera um evento cadastrado
	 * @return
	 */
	public String alterar() {
		try{

			Evento evento = getEventosService().consultar(eventoBean.getCodEvento());

			if(evento==null || evento.getCodEvento()== -1){
				FacesMessage message = new FacesMessage("Nenhum registro encontrado.");
				this.getFacesContext().addMessage("formulario", message);
				return "listar";
			}

			//preenche os dados da tela vindos do objeto bean para ser persistido
			evento.setBairroEvento(eventoBean.getBairroEvento());
			evento.setCidadeEvento(eventoBean.getCidadeEvento());
			evento.setDataEvento(Convert.utilToSqlDate(eventoBean.getDataEvento()));
			evento.setDescricaoEvento(eventoBean.getDescricaoEvento());
			evento.setEmiteCertificado(eventoBean.getEmiteCertificado());
			evento.setHoraEvento(eventoBean.getHoraEvento());
			evento.setLogradEvento(eventoBean.getLogradEvento());
			evento.setTipoEvento(eventoBean.getTipoEvento());
			evento.setTituloEvento(eventoBean.getTituloEvento());
			evento.setUfEstado(eventoBean.getUfEstado());
			evento.setValorIncricao(eventoBean.getValorIncricao());

			getEventosService().alterar(evento);
			
			return "sucesso";

		}
		catch (Exception e) {
			String msg = "Nao Consegui Alterar o Evento. Movito: " + ((e instanceof EventosException ? ((EventosException)e).getEx().getMessage():""));
			FacesMessage message = new FacesMessage(msg);
			this.getFacesContext().addMessage("formulario", message);
			return "falha";
		}
	}

	/**
	 * Consulta um evento selecionado e Preenche o Formulario
	 * com os Dados Persistidos.
	 * @return
	 */
	public String consultar() {
		try{

			HtmlInputHidden codEvento = (HtmlInputHidden) this.getFacesContext().getViewRoot().findComponent("formulario:codEvento");

			Evento evento = getEventosService().consultar((Integer) codEvento.getValue());

			if(evento==null || evento.getCodEvento()== -1){
				FacesMessage message = new FacesMessage("Nenhum registro encontrado.");
				this.getFacesContext().addMessage("formulario", message);
				
				return "listar";
			}

			//preenche os dados do bean da tela
			eventoBean.setBairroEvento(evento.getBairroEvento());
			eventoBean.setCidadeEvento(evento.getCidadeEvento());
			eventoBean.setCodEvento(evento.getCodEvento());
			eventoBean.setDataEvento(evento.getDataEvento());
			eventoBean.setDescricaoEvento(evento.getDescricaoEvento());
			eventoBean.setEmiteCertificado(evento.getEmiteCertificado());
			eventoBean.setHoraEvento(evento.getHoraEvento());
			eventoBean.setLogradEvento(evento.getLogradEvento());
			eventoBean.setTipoEvento(evento.getTipoEvento());
			eventoBean.setTituloEvento(evento.getTituloEvento());
			eventoBean.setUfEstado(evento.getUfEstado());
			eventoBean.setValorIncricao(evento.getValorIncricao());
			
			return "editar";
		}
		catch (Exception e) {
			String msg = "Consulta n„o realizada. Movito: " + ((e instanceof EventosException ? ((EventosException)e).getEx().getMessage():""));
			FacesMessage message = new FacesMessage(msg);
			this.getFacesContext().addMessage("formulario", message);
			return "falha";
		}
	}

	/**
	 * Retorna EventoService
	 * @return
	 */
	public EventosService getEventosService() {
		return eventosService;
	}
	/**
	 * Seta um EventoService	
	 * @param eventosService
	 */
	public void setEventosService(EventosService eventosService) {
		this.eventosService = eventosService;
	}

	public EventoBean getEventoBean() {
		return eventoBean;
	}

	public void setEventoBean(EventoBean eventoBean) {
		this.eventoBean = eventoBean;
	}

	private FacesContext getFacesContext(){
		return FacesContext.getCurrentInstance();
	}

	@SuppressWarnings("unused")
	private Object getSession(String variavel){
		return this.getFacesContext().getExternalContext().getSessionMap().get(variavel);
	}
	@SuppressWarnings("unused")
	private void setSession(String variavel, Object objeto){
		this.getFacesContext().getExternalContext().getSessionMap().put(variavel, objeto);
	}

	public List<EventoBean> getListaEventoBean() {
		return listaEventoBean;
	}

	public void setListaEventoBean(List<EventoBean> listaEventoBean) {
		this.listaEventoBean = listaEventoBean;
	}

	public EventoBean getEventoBeanSelecionado() {
		return eventoBeanSelecionado;
	}

	public void setEventoBeanSelecionado(EventoBean eventoBeanSelecionado) {
		this.eventoBeanSelecionado = eventoBeanSelecionado;
	}
	
}
