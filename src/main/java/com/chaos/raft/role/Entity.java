package com.chaos.raft.role;

/**
 * Created by zcfrank1st on 2/2/15.
 */
public class Entity implements Action {
    private Role role;

    public Entity(Role role) {
        this.role = role;
    }

    @Override
    public void send() {
        role.realSend();
    }

    @Override
    public void receive() {
        role.realReceiveThenDo();
    }

    public void changeRole (Role newRole) {
        this.role = newRole;
    }
}
