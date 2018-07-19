package com.k.jdk.bio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * created by k
 * 2018/6/15
 **/
public class BioHttpServer extends Thread{

	public static void main(String[] args) {
		new BioHttpServer().start();
	}

	static final AtomicInteger connects=new AtomicInteger(0);

	private ServerSocketChannel serverSocketChannel;

	public BioHttpServer() {
		try {
			this.serverSocketChannel = ServerSocketChannel.open();
			serverSocketChannel.bind(new InetSocketAddress("localhost",8080));
			System.out.println("服务器已启动");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true){
			try {
				//次数会阻塞
				SocketChannel client = serverSocketChannel.accept();
				System.out.println("已有一个客户端连接");
				Socket socket = client.socket();
				new BioHttpClient(socket).start();
				connects.incrementAndGet();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("请求次数："+connects.get());
		}
	}
}
