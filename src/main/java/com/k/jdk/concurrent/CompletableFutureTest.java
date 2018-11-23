package com.k.jdk.concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * created by wyk
 * 2018/9/13
 **/
public class CompletableFutureTest {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		CompletableFuture<String> completableFuture = new CompletableFuture<>();
		boolean done = completableFuture.isDone();
		System.out.println(done);

		new Thread(()->{
			System.out.println(111);
			try {
				Thread.sleep(2000);
				int i=1/0;
			} catch (InterruptedException e) {
				e.printStackTrace();
				completableFuture.exceptionally(new Function<Throwable, String>() {
					@Override
					public String apply(Throwable throwable) {
						return "error";
					}
				});
				completableFuture.complete("exception");
			}
			System.out.println(222);
			completableFuture.complete("111");
		}).start();

		TimeUnit.SECONDS.sleep(3);
		System.out.println(completableFuture.isDone());

		boolean cancelled = completableFuture.isCancelled();
		System.out.println(cancelled);

		boolean completedExceptionally = completableFuture.isCompletedExceptionally();
		System.out.println(completedExceptionally);
		System.out.println(completableFuture.get());
	}
}
