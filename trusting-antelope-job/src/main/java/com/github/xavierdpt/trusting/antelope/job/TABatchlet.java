package com.github.xavierdpt.trusting.antelope.job;

import java.util.Properties;

import javax.batch.api.Batchlet;
import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.batch.runtime.context.JobContext;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

@Dependent
@Named("TABatchlet")
public class TABatchlet implements Batchlet {

	@Inject
	private JobContext jobContext;

	private volatile boolean stopRequested;

	@Override
	public String process() throws Exception {
		try {
			throw new Exception();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		Long max = Long.valueOf(jobContext.getProperties().getProperty("max"));
		for (int i = 0; i < max; ++i) {
			System.out.println("Waiting #" + i);
			Thread.sleep(3000);
			launchMoreJobs(i);
			jobContext.setTransientUserData(i);
			if (stopRequested) {
				break;
			}
		}
		return "FINISHED";
	}

	@Override
	public void stop() throws Exception {
		stopRequested = true;
	}

	private void launchMoreJobs(int max) {
		System.out.println("Launching " + max + " new jobs within the next " + max * 10 + " seconds");
		Properties props = new Properties();
		props.setProperty("max", Long.toString(max));
		JobOperator jobOperator = BatchRuntime.getJobOperator();
		jobOperator.start("ta", props);
	}
}
