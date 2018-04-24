package com.github.xavierdpt.trusting.antelope.job;

import javax.batch.api.listener.JobListener;
import javax.batch.runtime.context.JobContext;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

@Dependent
@Named("TAJobListener")
public class TAJobListener implements JobListener {

	@Inject
	private JobContext jobContext;

	@Override
	public void afterJob() throws Exception {
		System.out.println(jobContext.getJobName() + " " + jobContext.getInstanceId() + " "
				+ jobContext.getExecutionId() + " has finished with status " + jobContext.getExitStatus());
	}

	@Override
	public void beforeJob() throws Exception {
		System.out.println(jobContext.getJobName() + " " + jobContext.getInstanceId() + " "
				+ jobContext.getExecutionId() + " will start");
	}

}
