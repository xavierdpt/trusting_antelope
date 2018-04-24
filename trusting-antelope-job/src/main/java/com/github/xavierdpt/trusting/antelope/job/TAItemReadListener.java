package com.github.xavierdpt.trusting.antelope.job;

import javax.batch.api.chunk.listener.ItemReadListener;
import javax.batch.runtime.context.JobContext;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

@Dependent
@Named("TAItemReadListener")
public class TAItemReadListener implements ItemReadListener {

	@Inject
	private JobContext jobContext;

	@Override
	public void afterRead(Object arg0) throws Exception {
		System.out.println(this.getClass().getName() + " afterRead");
	}

	@Override
	public void beforeRead() throws Exception {
		System.out.println(this.getClass().getName() + " beforeRead");
	}

	@Override
	public void onReadError(Exception arg0) throws Exception {
		System.out.println(this.getClass().getName() + " onReadError");
	}

}
