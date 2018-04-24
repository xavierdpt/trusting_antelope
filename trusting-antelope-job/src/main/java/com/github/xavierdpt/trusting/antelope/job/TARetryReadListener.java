package com.github.xavierdpt.trusting.antelope.job;

import javax.batch.api.chunk.listener.RetryReadListener;
import javax.batch.runtime.context.JobContext;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

@Dependent
@Named("TARetryReadListener")
public class TARetryReadListener implements RetryReadListener {

	@Inject
	private JobContext jobContext;

	@Override
	public void onRetryReadException(Exception arg0) throws Exception {
		System.out.println(this.getClass().getName() + " onRetryReadException");

	}

}
