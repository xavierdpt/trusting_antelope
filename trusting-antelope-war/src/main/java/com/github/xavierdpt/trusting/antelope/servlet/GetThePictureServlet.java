package com.github.xavierdpt.trusting.antelope.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;

import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.batch.runtime.JobExecution;
import javax.batch.runtime.JobInstance;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.StdDateFormat;

@WebServlet("/getthepicture")
public class GetThePictureServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ObjectMapper om = new ObjectMapper();
		om.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		om.setDateFormat(new StdDateFormat());
		ObjectWriter objectWriter = om.writerWithDefaultPrettyPrinter();

		PrintWriter writer = resp.getWriter();
		

		JobOperator jobOperator = BatchRuntime.getJobOperator();

		Set<String> names = jobOperator.getJobNames();
		for (String name : names) {
			writer.println("name " + name);
			int count = jobOperator.getJobInstanceCount(name);
			writer.print("count "+count);
			List<JobInstance> instances = jobOperator.getJobInstances(name, 0, count);
			for (JobInstance instance : instances) {
				writer.println("instace "+instance.getJobName()+" ; "+instance.getInstanceId());
				List<JobExecution> executions = jobOperator.getJobExecutions(instance);
				for (JobExecution execution : executions) {
					writer.println(objectWriter.writeValueAsString(execution));
				}
			}

		}

		writer.println("DONE.");
	}

}
