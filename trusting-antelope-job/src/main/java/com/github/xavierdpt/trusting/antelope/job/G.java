package com.github.xavierdpt.trusting.antelope.job;

import java.util.Properties;

import javax.batch.api.partition.PartitionPlan;

public class G implements PartitionPlan {

	@Override
	public Properties[] getPartitionProperties() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getPartitions() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getPartitionsOverride() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getThreads() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setPartitionProperties(Properties[] arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPartitions(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPartitionsOverride(boolean arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setThreads(int arg0) {
		// TODO Auto-generated method stub

	}

}
