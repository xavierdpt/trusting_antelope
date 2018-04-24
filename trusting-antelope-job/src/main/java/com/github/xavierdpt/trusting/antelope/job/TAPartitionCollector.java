package com.github.xavierdpt.trusting.antelope.job;

import java.io.Serializable;

import javax.batch.api.partition.PartitionCollector;
import javax.batch.runtime.context.JobContext;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

@Dependent
@Named("TAPartitionCollector")
public class TAPartitionCollector implements PartitionCollector {

	@Inject
	private JobContext jobContext;

	@Override
	public Serializable collectPartitionData() throws Exception {
		return "collected partition data";
	}

}
