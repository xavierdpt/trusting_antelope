package com.github.xavierdpt.trusting.antelope.job;

import java.util.List;

import javax.batch.api.chunk.listener.ItemWriteListener;
import javax.batch.runtime.context.JobContext;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

@Dependent
@Named("TAItemWriteListener")
public class TAItemWriteListener implements ItemWriteListener {

	@Inject
	private JobContext jobContext;

	@Override
	public void afterWrite(List<Object> arg0) throws Exception {
		System.out.println(this.getClass().getName() + " afterWrite");
	}

	@Override
	public void beforeWrite(List<Object> arg0) throws Exception {
		System.out.println(this.getClass().getName() + " beforeWrite");
	}

	@Override
	public void onWriteError(List<Object> arg0, Exception arg1) throws Exception {
		System.out.println(this.getClass().getName() + " onWriteError");
	}

}
