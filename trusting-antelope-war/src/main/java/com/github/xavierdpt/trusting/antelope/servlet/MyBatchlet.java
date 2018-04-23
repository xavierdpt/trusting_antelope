package com.github.xavierdpt.trusting.antelope.servlet;

import java.io.File;

import javax.batch.api.Batchlet;
import javax.batch.runtime.context.JobContext;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

@Dependent
@Named("MyBatchlet")
public class MyBatchlet implements Batchlet {
    @Inject
    private JobContext jobCtx;
    
    @Override
    public String process() throws Exception {
        String fileName = jobCtx.getProperties()
                                .getProperty("output_file");
        System.out.println(""+(new File(fileName)).length());
        return "COMPLETED";
    }

	@Override
	public void stop() throws Exception {
		// TODO Auto-generated method stub
		
	}
}	