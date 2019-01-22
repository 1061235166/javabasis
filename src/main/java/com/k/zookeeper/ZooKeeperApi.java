package com.k.zookeeper;

import com.google.common.collect.Lists;
import org.apache.zookeeper.*;
import org.apache.zookeeper.client.ZooKeeperSaslClient;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Stat;
import org.apache.zookeeper.server.NIOServerCnxn;
import org.apache.zookeeper.server.ServerCnxn;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by k on 2019/1/13.
 */
public class ZooKeeperApi {

    public static void main(String[] args) throws InterruptedException, IOException, KeeperException {
        add();
    }

    public static void add() throws IOException, KeeperException, InterruptedException {
        Watcher watcher = new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println("监听到事件"+watchedEvent);
            }
        };

        ZooKeeper keeper =new ZooKeeper("localhost:2181",3000,watcher);

        ArrayList<ACL> list = ZooDefs.Ids.OPEN_ACL_UNSAFE;
        list.add(new ACL());

        keeper.create("/root", "asd".getBytes(), list, CreateMode.PERSISTENT);


    }

    public static void get(){

    }
}
