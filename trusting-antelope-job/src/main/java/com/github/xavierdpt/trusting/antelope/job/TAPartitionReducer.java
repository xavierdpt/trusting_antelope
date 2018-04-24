package com.github.xavierdpt.trusting.antelope.job;

import javax.batch.api.partition.PartitionReducer;
import javax.batch.runtime.context.JobContext;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

@Dependent
@Named("TAPartitionReducer")
public class TAPartitionReducer implements PartitionReducer {

	@Inject
	private JobContext jobContext;

	@Override
	public void afterPartitionedStepCompletion(PartitionStatus arg0) throws Exception {
		System.out.println(this.getClass().getName() + " afterPartitionedStepCompletion");
	}

	@Override
	public void beforePartitionedStepCompletion() throws Exception {
		System.out.println(this.getClass().getName() + " beforePartitionedStepCompletion");

	}

	@Override
	public void beginPartitionedStep() throws Exception {
		System.out.println(this.getClass().getName() + " beginPartitionedStep");
	}

	@Override
	public void rollbackPartitionedStep() throws Exception {
		System.out.println(this.getClass().getName() + " rollbackPartitionedStep");

	}

}
