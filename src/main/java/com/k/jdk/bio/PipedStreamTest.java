package com.k.jdk.bio;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.nio.file.Files;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * created by wyk
 * 2018/9/4
 **/
public class PipedStreamTest {
	public static void main(String[] args) throws IOException {



		PipedInputStream pipedInputStream = new PipedInputStream();

		PipedOutputStream pipedOutputStream = new PipedOutputStream(pipedInputStream);

		int i = Integer.parseInt("0xFFB6C1", 16);
		System.out.println(i);


		ExecutorService service = Executors.newFixedThreadPool(1);
		service.execute(()->{
			try {
				pipedOutputStream.connect(pipedInputStream);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}
}
