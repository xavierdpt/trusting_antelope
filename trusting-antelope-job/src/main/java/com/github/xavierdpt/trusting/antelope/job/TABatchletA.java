package com.github.xavierdpt.trusting.antelope.job;

import java.util.logging.Logger;

import javax.batch.api.Batchlet;
import javax.batch.runtime.context.JobContext;
import javax.batch.runtime.context.StepContext;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

import com.github.xavierdpt.trusting.antelope.common.utils.TAUtils;

@Dependent
@Named("TABatchletA")
public class TABatchletA implements Batchlet {

	private final static Logger LOGGER = Logger.getLogger(TABatchletA.class.getName());

	@Inject
	private JobContext jobContext;

	@Inject
	private StepContext stepContext;

	public TABatchletA() {
		LOGGER.info(this.getClass().getName() + " : new instance " + System.identityHashCode(this));
	}

	@Override
	public String process() throws Exception {
		LOGGER.info(this.getClass().getName() + " starting...");
		int sleepTime = Integer.valueOf(jobContext.getProperties().getProperty("sleepTimeA"));
		Thread.sleep(sleepTime * 1000);
		LOGGER.info(this.getClass().getName() + " done.");
		return jobContext.getProperties().getProperty("processResultA");
	}

	@Override
	public void stop() throws Exception {
		LOGGER.info(TAUtils
				.json(new JobContextMore(jobContext, stepContext).more("method", this.getClass().getName() + " stop")));
	}

}
