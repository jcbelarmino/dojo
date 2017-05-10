package org.jcb.dojo.dominio;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_Contrato")
public class Contrato {

		@Id
		@GeneratedValue(generator="contrato_seq")
		@SequenceGenerator(name="contrato_seq",sequenceName="CONTRATO_SEQ")
		private Long id;
		
		@Column(name="dataInicio",nullable=false)
		private Date dataInicio;

		@Column(name="dataFim", nullable=false)
		private Date dataFim;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Date getDataInicio() {
			return dataInicio;
		}

		public void setDataInicio(Date dataInicio) {
			this.dataInicio = dataInicio;
		}

		public Date getDataFim() {
			return dataFim;
		}

		public void setDataFim(Date dataFim) {
			this.dataFim = dataFim;
		}
		
}
