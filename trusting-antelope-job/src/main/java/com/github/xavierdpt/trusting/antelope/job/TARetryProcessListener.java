package com.github.xavierdpt.trusting.antelope.job;

import javax.batch.api.chunk.listener.RetryProcessListener;
import javax.batch.runtime.context.JobContext;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

@Dependent
@Named("TARetryProcessListener")
public class TARetryProcessListener implements RetryProcessListener {

	@Inject
	private JobContext jobContext;

	@Override
	public void onRetryProcessException(Object arg0, Exception arg1) throws Exception {
		System.out.println(this.getClass().getName() + " onRetryProcessException");
	}

}
