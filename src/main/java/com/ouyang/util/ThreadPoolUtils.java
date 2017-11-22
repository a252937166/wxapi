package com.ouyang.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolUtils {
	
	private static Log log = LogFactory.getLog(ThreadPoolUtils.class);
	
	private static ExecutorService  threadPool = Executors.newFixedThreadPool(20);
	
	
	public static void run(Runnable command) {
		try {
			threadPool.execute(command);
		} catch (Exception e) {
			log.debug(e.getMessage());
			throw new RuntimeException(e);
		}
	}
}
