package com.github.xavierdpt.trusting.antelope.job;

import java.util.Properties;

import javax.batch.api.partition.PartitionPlan;

public class TAPartitionPlan implements PartitionPlan {

	private int partitionCount;
	private boolean partitionOverride;
	private int threadCount;
	private Properties[] partitionProperties;

	public TAPartitionPlan() {
	}

	public TAPartitionPlan(int partitionCount, boolean partitionOverride, int threadCount,
			Properties[] partitionProperties) {
		this.partitionCount = partitionCount;
		this.partitionOverride = partitionOverride;
		this.threadCount = threadCount;
		this.partitionProperties = partitionProperties;
	}

	@Override
	public void setPartitions(int count) {
		this.partitionCount = count;
	}

	@Override
	public void setPartitionsOverride(boolean override) {
		this.partitionOverride = override;
	}

	@Override
	public boolean getPartitionsOverride() {
		return partitionOverride;
	}

	@Override
	public void setThreads(int count) {
		this.threadCount = count;
	}

	@Override
	public void setPartitionProperties(Properties[] props) {
		this.partitionProperties = props;
	}

	@Override
	public int getPartitions() {
		return partitionCount;
	}

	@Override
	public int getThreads() {
		return threadCount;
	}

	@Override
	public Properties[] getPartitionProperties() {
		return partitionProperties;
	}

}
