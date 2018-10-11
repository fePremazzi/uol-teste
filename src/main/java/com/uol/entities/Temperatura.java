package com.uol.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "temperatura")
public class Temperatura {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long idTemp;
	
	private float tempMin;
	private float tempMax;
	

	public Long getIdTemp() {
		return idTemp;
	}
	public void setIdTemp(Long idTemp) {
		this.idTemp = idTemp;
	}
	public float getTempMin() {
		return tempMin;
	}
	public void setTempMin(float tempMin) {
		this.tempMin = tempMin;
	}
	public float getTempMax() {
		return tempMax;
	}
	public void setTempMax(float tempMax) {
		this.tempMax = tempMax;
	}
	
	

}
