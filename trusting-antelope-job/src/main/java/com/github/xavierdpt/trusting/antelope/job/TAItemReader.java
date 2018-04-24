package com.github.xavierdpt.trusting.antelope.job;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.Serializable;

import javax.batch.api.chunk.ItemReader;
import javax.batch.runtime.context.JobContext;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

@Dependent
@Named("TAItemReader")
public class TAItemReader implements ItemReader {

	private BufferedReader reader;
	private TACheckpoint checkpoint = new TACheckpoint();

	@Inject
    private JobContext jobContext;
	
	@Override
	public Serializable checkpointInfo() throws Exception {
		return checkpoint;
	}

	@Override
	public void close() throws Exception {
		reader.close();
	}

	@Override
	public void open(Serializable checkpoint) throws Exception {
		if (checkpoint != null) {
			this.checkpoint = (TACheckpoint) checkpoint;
		}
		reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(new byte[] {})));
	}

	@Override
	public Object readItem() throws Exception {
		return reader.read();
	}

}
