package com.chaos.raft.role;

/**
 * Created by zcfrank1st on 1/30/15.
 */
public enum Role {
    LEADER,
    CANDIDATE,
    FOLLOWER;

    public void realSend () {
        switch (this) {
            case LEADER:
                leaderSend();
                break;
            case CANDIDATE:
                candidateSend();
                break;
            case FOLLOWER:
                followerSend();
                break;
        }
    }

    public void realReceiveThenDo () {
        switch (this) {
            case LEADER:
                leaderReceiveThenDo();
                break;
            case CANDIDATE:
                candidateReceiveThenDo();
                break;
            case FOLLOWER:
                followerReceiveThenDo();
                break;
        }
    }

    private void leaderSend() {
        // send heartbeat and message
    }
    private void leaderReceiveThenDo() {
        // receive heartbeat and message and do something
    }

    private void candidateSend() {
        // send request
    }
    private void candidateReceiveThenDo() {
        // receive reply
    }

    private void followerSend() {
        // send message reply and send heartbeat reply
    }
    private void followerReceiveThenDo() {

    }
}
