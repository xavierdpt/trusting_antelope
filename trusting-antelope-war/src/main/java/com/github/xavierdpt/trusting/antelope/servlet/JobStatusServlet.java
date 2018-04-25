package com.github.xavierdpt.trusting.antelope.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.batch.runtime.JobExecution;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.xavierdpt.trusting.antelope.common.utils.TAUtils;

@WebServlet("/status")
public class JobStatusServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter writer = resp.getWriter();

		Long jobId = Long.valueOf(req.getParameter("jobid"));

		JobOperator jobOperator = BatchRuntime.getJobOperator();
		JobExecution jobExecution = jobOperator.getJobExecution(jobId);

		TAUtils.json(writer, jobExecution);
	}
}
