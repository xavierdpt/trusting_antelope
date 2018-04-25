package com.github.xavierdpt.trusting.antelope.job;

import java.util.logging.Logger;

import javax.batch.api.listener.StepListener;
import javax.batch.runtime.context.JobContext;
import javax.batch.runtime.context.StepContext;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

import com.github.xavierdpt.trusting.antelope.common.utils.TAUtils;

@Dependent
@Named("TAStepListener")
public class TAStepListener implements StepListener {

	private final static Logger LOGGER = Logger.getLogger(TAStepListener.class.getName());

	@Inject
	private JobContext jobContext;

	@Inject
	private StepContext stepContext;

	public TAStepListener() {
		LOGGER.info(this.getClass().getName() + " : new instance " + System.identityHashCode(this));
	}

	@Override
	public void afterStep() throws Exception {
		LOGGER.info(TAUtils.json(
				new JobContextMore(jobContext, stepContext).more("method", this.getClass().getName() + " afterStep")));
	}

	@Override
	public void beforeStep() throws Exception {
		LOGGER.info(TAUtils.json(
				new JobContextMore(jobContext, stepContext).more("method", this.getClass().getName() + " beforeStep")));

	}

}
