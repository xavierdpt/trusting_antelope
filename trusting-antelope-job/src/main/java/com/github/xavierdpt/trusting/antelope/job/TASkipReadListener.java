package com.github.xavierdpt.trusting.antelope.job;

import javax.batch.api.chunk.listener.SkipReadListener;
import javax.batch.runtime.context.JobContext;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

@Dependent
@Named("TASkipReadListener")
public class TASkipReadListener implements SkipReadListener {

	@Inject
	private JobContext jobContext;

	@Override
	public void onSkipReadItem(Exception arg0) throws Exception {
		System.out.println(this.getClass().getName() + " onSkipReadItem");
	}

}
