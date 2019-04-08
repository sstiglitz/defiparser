package com.crbauto.defiparser.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "dmssuci")
public class DMSSUCI {

	@Id
	@Column(name = "ReportId")
	private Long reportId;
	
	@Column(name = "SUCI001")
	private Integer suci001;
	
	@Column(name = "SUCI002")
	private Integer suci002;
	
}
