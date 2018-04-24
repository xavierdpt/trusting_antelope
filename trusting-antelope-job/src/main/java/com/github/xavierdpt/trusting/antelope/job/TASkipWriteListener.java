package com.github.xavierdpt.trusting.antelope.job;

import java.util.List;

import javax.batch.api.chunk.listener.SkipWriteListener;
import javax.batch.runtime.context.JobContext;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

@Dependent
@Named("TASkipWriteListener")
public class TASkipWriteListener implements SkipWriteListener {

	@Inject
	private JobContext jobContext;

	@Override
	public void onSkipWriteItem(List<Object> arg0, Exception arg1) throws Exception {
		System.out.println(this.getClass().getName() + " onSkipWriteItem");
	}

}
