package org.redquark.concurrency.executor;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Anirudh Sharma
 *
 */
public class ScheduledThreadPoolExecutorExample {

	public static void main(String[] args) {

		ScheduledThreadPoolExecutor executor = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(2);

		Task task = new Task("Cron Job");
		System.out.println("Created: " + task.getName());
		executor.scheduleWithFixedDelay(task, 2, 2, TimeUnit.SECONDS);
	}

	private static class Task implements Runnable {

		private String name;

		public Task(String name) {
			this.name = name;
		}

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		@Override
		public void run() {
			System.out.println("Executing: " + name + ", Current Seconds: " + LocalDateTime.now().getSecond());

		}

	}
}
