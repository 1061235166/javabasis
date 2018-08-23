package com.k.disruptor;

import com.lmax.disruptor.EventHandler;

/**
 * created by wyk
 * 2018/7/27
 **/
public class MyExampleEventHandler implements EventHandler<PlayEvent> {

	@Override
	public void onEvent(PlayEvent playEvent, long l, boolean b) throws Exception {
//		System.out.println(playEvent+"_"+l);
		System.out.println(Thread.currentThread().getName());
	}
}
