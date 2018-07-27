package com.k.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * created by wyk
 * 2018/7/27
 **/
public class MyExampleEventFactory implements EventFactory<PlayEvent> {
	@Override
	public PlayEvent newInstance() {
		return new PlayEvent();
	}
}
