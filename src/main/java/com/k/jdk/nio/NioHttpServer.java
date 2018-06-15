package com.k.jdk.nio;

import com.google.common.io.CharStreams;
import sun.misc.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * created by wyk
 * 2018/6/15
 **/
public class NioHttpServer {

	public static void main(String[] args) {
		try {
			Selector selector = Selector.open();
			ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
			serverSocketChannel.bind(new InetSocketAddress(8080));
			serverSocketChannel.configureBlocking(false);
			serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
			System.out.println("服务器已经启动，等待接受请求");
			while (true){
				int select = selector.select();
				System.out.println(select);
				if(select==0){
					continue;
				}
				Set<SelectionKey> selectionKeys = selector.selectedKeys();
				Iterator<SelectionKey> iterator = selectionKeys.iterator();
				while (iterator.hasNext()){
					SelectionKey next = iterator.next();
					if(next.isAcceptable()){
						SocketChannel socketChannel = serverSocketChannel.accept();
						socketChannel.configureBlocking(false);
						socketChannel.register(selector,SelectionKey.OP_READ);
					}else if(next.isReadable()){
						SelectableChannel channel = next.channel();
						SocketChannel socketChannel = (SocketChannel) channel;
						ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

						int read = socketChannel.read(byteBuffer);
						System.out.println(read);

					}else if(next.isWritable()){

					}
					iterator.remove();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}