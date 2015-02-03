package com.chaos.raft.core;

import com.chaos.raft.configure.Configuration;
import com.chaos.raft.configure.Property;
import com.chaos.raft.role.Entity;
import com.chaos.raft.role.Role;
import com.chaos.raft.util.ConfigureLoader;
import com.chaos.raft.util.Tools;

import javax.xml.bind.JAXBException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zcfrank1st on 1/30/15.
 */
public class Core {
    final public static Map<String, String> CONFIG_KVS  = new HashMap<String, String>();

    static {
        try {
            Configuration configuration = ConfigureLoader.INSTANCE.loadConfigure(Configuration.class);
            for (Property property : configuration.getPropertyList()) {
                CONFIG_KVS.put(property.getName(), property.getValue());
            }
        } catch (JAXBException e) {
            throw new RuntimeException("");
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Entity entity = new Entity(Role.FOLLOWER);
        Thread.sleep(Tools.randomfreezingTime()); // 开始random时间
        entity.changeRole(Role.CANDIDATE);
        entity.send();
    }
}
