package br.eventos.controle;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Component;

/**
 * Classe que representa o Formulário WEB de Eventos.
 * @author Wesley
 *
 */
@Component
@ManagedBean
@SessionScoped
public class EventoBean {
	
	private Integer codEvento;
	private Integer tipoEvento;
	private String tituloEvento;
	private String descricaoEvento;
	private Date dataEvento;
	private String horaEvento;
	private Integer emiteCertificado;
	private String logradEvento;
	private String bairroEvento;
	private String cidadeEvento;
	private String ufEstado;
	private Float valorIncricao;
	
	public Integer getCodEvento() {
		return codEvento;
	}
	public void setCodEvento(Integer codEvento) {
		this.codEvento = codEvento;
	}
	public Integer getTipoEvento() {
		return tipoEvento;
	}
	public void setTipoEvento(Integer tipoEvento) {
		this.tipoEvento = tipoEvento;
	}
	public String getTituloEvento() {
		return tituloEvento;
	}
	public void setTituloEvento(String tituloEvento) {
		this.tituloEvento = tituloEvento;
	}
	public String getDescricaoEvento() {
		return descricaoEvento;
	}
	public void setDescricaoEvento(String descricaoEvento) {
		this.descricaoEvento = descricaoEvento;
	}
	public Date getDataEvento() {
		return dataEvento;
	}
	public void setDataEvento(Date data) {
		this.dataEvento = data;
	}
	public String getHoraEvento() {
		return horaEvento;
	}
	public void setHoraEvento(String horaEvento) {
		this.horaEvento = horaEvento;
	}
	public Integer getEmiteCertificado() {
		return emiteCertificado;
	}
	public void setEmiteCertificado(Integer emiteCertificado) {
		this.emiteCertificado = emiteCertificado;
	}
	public String getLogradEvento() {
		return logradEvento;
	}
	public void setLogradEvento(String logradEvento) {
		this.logradEvento = logradEvento;
	}
	public String getBairroEvento() {
		return bairroEvento;
	}
	public void setBairroEvento(String bairroEvento) {
		this.bairroEvento = bairroEvento;
	}
	public String getCidadeEvento() {
		return cidadeEvento;
	}
	public void setCidadeEvento(String cidadeEvento) {
		this.cidadeEvento = cidadeEvento;
	}
	public String getUfEstado() {
		return ufEstado;
	}
	public void setUfEstado(String ufEstado) {
		this.ufEstado = ufEstado;
	}
	public Float getValorIncricao() {
		return valorIncricao;
	}
	public void setValorIncricao(Float valorIncricao) {
		this.valorIncricao = valorIncricao;
	}
}
