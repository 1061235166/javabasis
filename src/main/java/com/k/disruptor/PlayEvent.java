package com.k.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * created by k
 * 2018/7/19
 **/
public class PlayEvent implements EventFactory<PlayEvent>{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Override
	public PlayEvent newInstance() {
		return new PlayEvent();
	}
}
