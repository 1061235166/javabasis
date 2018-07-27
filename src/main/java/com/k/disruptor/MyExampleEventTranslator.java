package com.k.disruptor;

import com.lmax.disruptor.EventTranslatorOneArg;

/**
 * created by wyk
 * 2018/7/27
 **/
public class MyExampleEventTranslator implements EventTranslatorOneArg<PlayEvent,String>{
	@Override
	public void translateTo(PlayEvent playEvent, long l, String s) {
//		System.out.println(s+"_"+l);
	}
}
