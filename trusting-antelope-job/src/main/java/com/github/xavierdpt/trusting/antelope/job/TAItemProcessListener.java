package com.github.xavierdpt.trusting.antelope.job;

import javax.batch.api.chunk.listener.ItemProcessListener;
import javax.batch.runtime.context.JobContext;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

@Dependent
@Named("TAItemProcessListener")
public class TAItemProcessListener implements ItemProcessListener {

	@Inject
	private JobContext jobContext;

	@Override
	public void afterProcess(Object arg0, Object arg1) throws Exception {
		System.out.println(this.getClass().getName() + " afterProcess");

	}

	@Override
	public void beforeProcess(Object arg0) throws Exception {
		System.out.println(this.getClass().getName() + " beforeProcess");
	}

	@Override
	public void onProcessError(Object arg0, Exception arg1) throws Exception {
		System.out.println(this.getClass().getName() + " onProcessError");
	}

}
