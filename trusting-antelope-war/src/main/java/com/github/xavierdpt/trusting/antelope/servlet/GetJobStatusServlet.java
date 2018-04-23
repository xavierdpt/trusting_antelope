package com.github.xavierdpt.trusting.antelope.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.TimeZone;

import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.batch.runtime.JobExecution;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.StdDateFormat;

@WebServlet("/getjobstatus")
public class GetJobStatusServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter writer = resp.getWriter();

		JobOperator jobOperator = BatchRuntime.getJobOperator();

		Long jobId = Long.valueOf(req.getParameter("jobId"));
		JobExecution jobExecution = jobOperator.getJobExecution(jobId);

		ObjectMapper om = new ObjectMapper();
		om.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		om.setDateFormat(new StdDateFormat());
		ObjectWriter objectWriter = om.writerWithDefaultPrettyPrinter();
		writer.println(objectWriter.writeValueAsString(jobExecution));

	}
}
