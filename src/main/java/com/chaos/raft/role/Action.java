package com.chaos.raft.role;

/**
 * Created by zcfrank1st on 2/2/15.
 */
public interface Action {
    void send();
    void receive();
}
