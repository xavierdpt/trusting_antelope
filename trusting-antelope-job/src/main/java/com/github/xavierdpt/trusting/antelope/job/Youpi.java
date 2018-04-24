package com.github.xavierdpt.trusting.antelope.job;

import javax.batch.api.Batchlet;
import javax.batch.api.Decider;
import javax.batch.api.chunk.CheckpointAlgorithm;
import javax.batch.api.chunk.ItemProcessor;
import javax.batch.api.chunk.ItemReader;
import javax.batch.api.chunk.ItemWriter;
import javax.batch.api.chunk.listener.ChunkListener;
import javax.batch.api.chunk.listener.ItemProcessListener;
import javax.batch.api.chunk.listener.ItemReadListener;
import javax.batch.api.chunk.listener.ItemWriteListener;
import javax.batch.api.chunk.listener.RetryProcessListener;
import javax.batch.api.chunk.listener.RetryReadListener;
import javax.batch.api.chunk.listener.RetryWriteListener;
import javax.batch.api.chunk.listener.SkipProcessListener;
import javax.batch.api.chunk.listener.SkipReadListener;
import javax.batch.api.chunk.listener.SkipWriteListener;
import javax.batch.api.listener.JobListener;
import javax.batch.api.listener.StepListener;
import javax.batch.api.partition.PartitionAnalyzer;
import javax.batch.api.partition.PartitionCollector;
import javax.batch.api.partition.PartitionMapper;
import javax.batch.api.partition.PartitionPlan;
import javax.batch.api.partition.PartitionReducer;

public class Youpi {
	public void foo() {

		Decider decider = new TADecider();

		CheckpointAlgorithm c = new TACheckpointAlgorithm();

		Batchlet batchlet = new TABatchlet();
		ItemReader itemReader = new TAItemReader();
		ItemProcessor itemProcessor = new TAItemProcessor();
		ItemWriter itemWriter = new TAItemWriter();

		PartitionPlan partitionPlan = new TAPartitionPlan();
		PartitionMapper partitionMapper = new TAPartitionMapper();
		PartitionReducer partitionReducer = new TAPartitionReducer();
		PartitionCollector partitionCollector = new TAPartitionCollector();
		PartitionAnalyzer partitionAnalyzer = new TAPartitionAnalyzer();

		JobListener jobListener = new TAJobListener();
		StepListener stepListener = new TAStepListener();
		ItemReadListener itemReadListener = new TAItemReadListener();
		ItemProcessListener itemProcessListener = new TAItemProcessListener();
		ItemWriteListener itemWriteListener = new TAItemWriteListener();
		RetryReadListener retryReadListener = new TARetryReadListener();
		RetryProcessListener retryProcessListener = new TARetryProcessListener();
		RetryWriteListener retryWriteListener = new TARetryWriteListener();
		SkipReadListener skipReadListener = new TASkipReadListener();
		SkipProcessListener skipProcessListener = new TASkipProcessListener();
		SkipWriteListener skipWriteListener = new TASkipWriteListener();
		ChunkListener chunkListener = new TAChunkListener();

		use(batchlet, decider, c, itemReader, itemProcessor, itemWriter, partitionPlan, partitionMapper, partitionCollector,
				partitionReducer, partitionAnalyzer, jobListener, stepListener,  itemReadListener, itemProcessListener,
				itemWriteListener, retryReadListener, retryProcessListener, retryWriteListener, skipReadListener,
				skipProcessListener, skipWriteListener, chunkListener);
	}

	private void use(Object... objs) {
		objs.getClass().getName();
	}
}
