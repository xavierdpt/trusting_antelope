package com.github.xavierdpt.trusting.antelope.job;

import javax.batch.api.chunk.CheckpointAlgorithm;
import javax.batch.runtime.context.JobContext;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

@Dependent
@Named("TACheckpointAlgorithm")
public class TACheckpointAlgorithm implements CheckpointAlgorithm {

	@Inject
	private JobContext jobContext;

	@Override
	public void beginCheckpoint() throws Exception {
		System.out.println(this.getClass().getName() + " beginCheckpoint");
	}

	@Override
	public int checkpointTimeout() throws Exception {
		return 0;
	}

	@Override
	public void endCheckpoint() throws Exception {
		System.out.println(this.getClass().getName() + " endCheckpoint");

	}

	@Override
	public boolean isReadyToCheckpoint() throws Exception {
		return true;
	}

}
