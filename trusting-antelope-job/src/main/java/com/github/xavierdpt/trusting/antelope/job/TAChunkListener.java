package com.github.xavierdpt.trusting.antelope.job;

import javax.batch.api.chunk.listener.ChunkListener;
import javax.batch.runtime.context.JobContext;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

@Dependent
@Named("TAChunkListener")
public class TAChunkListener implements ChunkListener {

	@Inject
	private JobContext jobContext;

	@Override
	public void beforeChunk() throws Exception {
		System.out.println(this.getClass().getName() + " beforeChunk");
	}

	@Override
	public void onError(Exception ex) throws Exception {
		System.out.println(this.getClass().getName() + " onError");
	}

	@Override
	public void afterChunk() throws Exception {
		System.out.println(this.getClass().getName() + " afterChunk");
	}

}
