package com.github.xavierdpt.trusting.antelope.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/newjob")
public class NewJobServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter writer = resp.getWriter();

		String flavor = req.getParameter("flavor");
		String sleep = req.getParameter("sleep");
		String result = req.getParameter("result");

		JobOperator jobOperator = BatchRuntime.getJobOperator();
		Properties props = new Properties();

		props.setProperty("flavor", flavor);
		props.setProperty("sleepTimeA", sleep);
		props.setProperty("sleepTimeB", sleep);
		props.setProperty("processResultA", result);
		props.setProperty("processResultB", result);

		long jobId = jobOperator.start("ta", props);
		writer.println(jobId);

	}

}
