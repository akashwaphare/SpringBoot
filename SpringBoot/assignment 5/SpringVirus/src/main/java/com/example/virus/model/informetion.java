package com.example.virus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Data
@AllArgsConstructor
@Entity
@Table(name="informetion")
public class informetion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="virusPattern")
	private String virusPattern;
	
	@Column(name="noPatients")
	private long noPatients;
	
	@Column(name="bloodSamples")
	String bloodSamples;
	
	@Column(name="results")
	String Results;
	
	
	
	
		
	

}
