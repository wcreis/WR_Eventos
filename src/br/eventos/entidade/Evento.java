package br.eventos.entidade;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="eventos")
public class Evento {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="codEvento")
	private Integer codEvento;

	@Column(name="tipoEvento")
	private Integer tipoEvento;

	@Column(name="tituloEvento")
	private String tituloEvento;

	@Column(name="descricaoEvento")
	private String descricaoEvento;

	@Column(name="dtevento")
	@Temporal(TemporalType.DATE)
	private Date dataEvento;

	@Column(name="horaEvento")
	private String horaEvento;

	@Column(name="emiteCertificado")
	private Integer emiteCertificado;

	@Column(name="logradEvento")
	private String logradEvento;

	@Column(name="bairroEvento")
	private String bairroEvento;

	@Column(name="cidadeEvento")
	private String cidadeEvento;

	@Column(name="ufEstado")
	private String ufEstado;

	@Column(name="valorIncricao")
	private Float valorIncricao;

	public Evento(){}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codEvento;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evento other = (Evento) obj;
		if (codEvento != other.codEvento)
			return false;
		return true;
	}

}
