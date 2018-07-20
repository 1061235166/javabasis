package com.k.jdk.bio;

import java.io.*;
import java.net.Socket;
import java.nio.CharBuffer;
import java.util.HashMap;
import java.util.Map;

/**
 * created by k
 * 2018/6/15
 **/
public class BioHttpClient extends Thread{
	private Socket socket;

	public BioHttpClient(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			InputStream inputStream = socket.getInputStream();
			InputStreamReader reader = new InputStreamReader(inputStream);
			System.out.println(inputStream.available());
			byte[]bs=new byte[inputStream.available()];
			for(int i=0;i<inputStream.available();i++){
				bs[i]= (byte) reader.read();
			}
			System.out.println(new String(bs));
			OutputStream outputStream = socket.getOutputStream();
			OutputStreamWriter writer = new OutputStreamWriter(outputStream);
			HttpResponse response = new HttpResponse();
			Map<String,String>headers = new HashMap<>();
			headers.put("content-type","text/html;charset=utf-8");
			String text = "hello world";
			headers.put("content-length",text.length()+"");
			response.setHeaders(headers);
			StringBuilder sb = new StringBuilder();
			sb.append(response.getFisrtLine()).append("\r\n");
			for(String key:headers.keySet()){
				sb.append(key).append(":").append(headers.get(key)).append("\r\n");
			}
			sb.append("\r\n");
			sb.append(text);
			sb.append("\r\n");
			writer.write(sb.toString());
			//必须flush，否则客户端不会有响应
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
