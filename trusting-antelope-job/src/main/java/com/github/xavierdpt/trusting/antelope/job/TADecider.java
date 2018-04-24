package com.github.xavierdpt.trusting.antelope.job;

import java.util.Random;

import javax.batch.api.Decider;
import javax.batch.runtime.StepExecution;
import javax.batch.runtime.context.JobContext;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

@Dependent
@Named("TADecider")
public class TADecider implements Decider {

	private static final String[] DECISIONS = new String[] { "FAILED", "COMPLETED", "STOPPED" };

	@Inject
	private JobContext jobContext;

	private Random random = new Random(System.currentTimeMillis());

	@Override
	public String decide(StepExecution[] arg0) throws Exception {
		return DECISIONS[random.nextInt(DECISIONS.length)];
	}

}
