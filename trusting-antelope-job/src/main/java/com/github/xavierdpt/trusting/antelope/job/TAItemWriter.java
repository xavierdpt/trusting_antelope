package com.github.xavierdpt.trusting.antelope.job;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.util.List;

import javax.batch.api.chunk.ItemWriter;
import javax.batch.runtime.context.JobContext;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

@Dependent
@Named("TAItemWriter")
public class TAItemWriter implements ItemWriter {

	private Serializable checkpoint = new TACheckpoint();
	private BufferedWriter writer;
	
	@Inject
    private JobContext jobContext;


	@Override
	public Serializable checkpointInfo() throws Exception {
		return checkpoint;
	}

	@Override
	public void close() throws Exception {
		writer.close();
	}

	@Override
	public void open(Serializable checkpoint) throws Exception {
		if (checkpoint != null) {
			this.checkpoint = checkpoint;
		}
		writer = new BufferedWriter(new OutputStreamWriter(new ByteArrayOutputStream()));
	}

	@Override
	public void writeItems(List<Object> items) throws Exception {
		for (Object item : items) {
			writer.write(item == null ? "null" : item.getClass().getName());
		}

	}

}
