package com.k.jdk.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.Selector;

/**
 * created by k
 * 2018/6/15
 **/
public class Client {
	public static void main(String[] args) throws IOException {
		Socket socket =new Socket();
		socket.connect(new InetSocketAddress(8000));
		socket.getOutputStream().write("helloworld".getBytes());
		socket.getOutputStream().flush();
		socket.close();
	}
}
