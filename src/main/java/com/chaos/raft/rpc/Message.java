package com.chaos.raft.rpc;

/**
 * Created by zcfrank1st on 2/2/15.
 */
public class Message {
    private MessageType type;
    private Message (MessageType messageType){
        type = messageType;
    }

    static class Builder {
        private MessageType messageType;
        public Builder heartbeat() {
            messageType = MessageType.HEARTBEAT;
            return this;
        }

        public Builder request() {
            messageType = MessageType.REQUEST;
            return this;
        }

        public Builder message() {
            messageType = MessageType.MESSAGE;
            return this;
        }

        public Message build() {
            return new Message(messageType);
        }
    }

    public MessageType getMessageType () {
        return type;
    }
}
