package com.github.xavierdpt.trusting.antelope.job;

import java.util.logging.Logger;

import javax.batch.api.Decider;
import javax.batch.runtime.StepExecution;
import javax.batch.runtime.context.JobContext;
import javax.batch.runtime.context.StepContext;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

import com.github.xavierdpt.trusting.antelope.common.utils.TAUtils;

@Dependent
@Named("TARootDecider")
public class TARootDecider implements Decider {

	private final static Logger LOGGER = Logger.getLogger(TARootDecider.class.getName());

	@Inject
	private JobContext jobContext;

	@Inject
	private StepContext stepContext;

	public TARootDecider() {
		LOGGER.info(this.getClass().getName() + " : new instance " + System.identityHashCode(this));
	}

	@Override
	public String decide(StepExecution[] stepExecutions) throws Exception {

		LOGGER.info(TAUtils
				.json(new JobContextMore(jobContext, stepContext).more("method", this.getClass().getName() + " decide")
						.more("stepExecutions", new StepExecutionsWrapper(stepExecutions))));

		return stepExecutions[0].getExitStatus();
		
		
	}

}
