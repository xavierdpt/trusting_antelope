package com.github.xavierdpt.trusting.antelope.job.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class JobInfo {
	
	@Id
	private Long id;
	
	private String data;
}
