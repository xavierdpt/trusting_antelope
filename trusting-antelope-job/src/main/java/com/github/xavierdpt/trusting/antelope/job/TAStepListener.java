package com.github.xavierdpt.trusting.antelope.job;

import javax.batch.api.listener.StepListener;
import javax.batch.runtime.context.JobContext;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

@Dependent
@Named("TAStepListener")
public class TAStepListener implements StepListener {

	@Inject
	private JobContext jobContext;

	@Override
	public void afterStep() throws Exception {
		System.out.println(this.getClass().getName() + " afterStep");

	}

	@Override
	public void beforeStep() throws Exception {
		System.out.println(this.getClass().getName() + " beforeStep");

	}

}
