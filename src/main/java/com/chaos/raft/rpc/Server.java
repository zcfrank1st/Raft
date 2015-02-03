package com.chaos.raft.rpc;

import com.chaos.raft.role.Role;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by zcfrank1st on 2/3/15.
 */
public class Server implements Runnable {
    private ServerSocketChannel serverSocketChannel = null;
    private Role role = null;

    public Server(Role role, int port) {
        this.role = role;
        try {
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.socket().bind(new InetSocketAddress(port));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("");
        }
    }

    @Override
    public void run() {
        try {
            SocketChannel socketChannel = serverSocketChannel.accept();
            if (socketChannel != null) {
                ObjectInputStream inputStream = new ObjectInputStream(new BufferedInputStream(socketChannel.socket().getInputStream()));
                while(true) {
                    try {
                        Message object = (Message)inputStream.readObject();
                        //object.outputMessage();
                    } catch (ClassNotFoundException e) {
                        socketChannel.socket().close();
                    }
                }
            }
        } catch (IOException e) {
        }
    }
}
