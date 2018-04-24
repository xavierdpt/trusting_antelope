package com.github.xavierdpt.trusting.antelope.job;

import javax.batch.api.chunk.ItemProcessor;
import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Dependent
@Named("TAItemProcessor")
public class TAItemProcessor implements ItemProcessor {
	
	@Override
	public Object processItem(Object item) throws Exception {
		if (item == null) {
			return "item is null";
		} else {
			return new TAProcessedItem(item);
		}
	}

}
