package com.chaos.raft.util;

import com.chaos.raft.core.Core;

/**
 * Created by zcfrank1st on 2/2/15.
 */
public class Tools {
    public static long randomfreezingTime() {
        long maxTimeout = Long.parseLong(Core.CONFIG_KVS.get(ConfigureKey.RAFT_TIMEOUT_MAX));
        return (long)(Math.random() * maxTimeout);
    }
}
