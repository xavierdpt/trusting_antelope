package com.github.xavierdpt.trusting.antelope.job;

import java.io.Serializable;

import javax.batch.api.partition.PartitionAnalyzer;
import javax.batch.runtime.BatchStatus;
import javax.batch.runtime.context.JobContext;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

@Dependent
@Named("TAPartitionAnalyzer")
public class TAPartitionAnalyzer implements PartitionAnalyzer {

	@Inject
	private JobContext jobContext;

	@Override
	public void analyzeCollectorData(Serializable arg0) throws Exception {
		System.out.println(this.getClass().getName() + " analyzeCollectorData");
	}

	@Override
	public void analyzeStatus(BatchStatus arg0, String arg1) throws Exception {
		System.out.println(this.getClass().getName() + " analyzeStatus");
	}

}
