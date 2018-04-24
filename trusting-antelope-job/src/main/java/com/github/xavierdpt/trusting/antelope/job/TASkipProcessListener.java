package com.github.xavierdpt.trusting.antelope.job;

import javax.batch.api.chunk.listener.SkipProcessListener;
import javax.batch.runtime.context.JobContext;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

@Dependent
@Named("TASkipProcessListener")
public class TASkipProcessListener implements SkipProcessListener {

	@Inject
	private JobContext jobContext;

	@Override
	public void onSkipProcessItem(Object arg0, Exception arg1) throws Exception {
		System.out.println(this.getClass().getName() + " onSkipProcessItem");
	}

}
