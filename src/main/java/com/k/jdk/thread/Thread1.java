package com.k.jdk.thread;

/**
 * 线程的几种状态，和生命周期
 * 新建-》就绪（可运行）-》运行中-》结束
 * 运行中的状态可以变为可运行，比如调用yield，交出cpu时间片
 * 比如调用wait，将线程状态变为等待状态，可以被notify和noftifyall唤醒变为可运行状态
 * 调用sleep，线程进入睡眠状态，睡眠时间结束恢复为可运行状态
 * 线程进入同步块，如果没有获取到锁的话状态变为阻塞，直到获取锁状态变为可运行
 * created by k
 * 2018/5/11
 **/
public class Thread1 {
    /**
     * 线程总共有几种状态：新建，可运行，正在运行，死亡，阻塞
     * 阻塞可以细分为 block，wait
     * @param args
     */
    public static void main(String[] args) {

    }
}
