package com.github.xavierdpt.trusting.antelope.job;

import java.util.logging.Logger;

import javax.batch.api.listener.JobListener;
import javax.batch.runtime.context.JobContext;
import javax.batch.runtime.context.StepContext;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

import com.github.xavierdpt.trusting.antelope.common.utils.TAUtils;

@Dependent
@Named("TAJobListener")
public class TAJobListener implements JobListener {

	private final static Logger LOGGER = Logger.getLogger(TAJobListener.class.getName());

	@Inject
	private JobContext jobContext;

	@Inject
	private StepContext stepContext;

	public TAJobListener() {
		LOGGER.info(this.getClass().getName() + " : new instance " + System.identityHashCode(this));
	}

	@Override
	public void afterJob() throws Exception {
		LOGGER.info(TAUtils.json(
				new JobContextMore(jobContext, stepContext).more("method", this.getClass().getName() + " afterJob")));
	}

	@Override
	public void beforeJob() throws Exception {
		LOGGER.info(TAUtils.json(
				new JobContextMore(jobContext, stepContext).more("method", this.getClass().getName() + " beforeJob")));
	}

}
