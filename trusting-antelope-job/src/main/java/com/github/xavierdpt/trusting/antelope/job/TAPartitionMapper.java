package com.github.xavierdpt.trusting.antelope.job;

import java.util.Properties;

import javax.batch.api.partition.PartitionMapper;
import javax.batch.api.partition.PartitionPlan;
import javax.batch.runtime.context.JobContext;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

@Dependent
@Named("TAPartitionMapper")
public class TAPartitionMapper implements PartitionMapper {

	@Inject
	private JobContext jobContext;

	@Override
	public PartitionPlan mapPartitions() throws Exception {
		Properties properties1 = new Properties();
		properties1.setProperty("partitionId", "first");
		Properties properties2 = new Properties();
		properties2.setProperty("partitionId", "last");
		Properties[] partitionProperties = new Properties[] { properties1, properties2 };
		return new TAPartitionPlan(2, false, 1, partitionProperties);
	}

}
