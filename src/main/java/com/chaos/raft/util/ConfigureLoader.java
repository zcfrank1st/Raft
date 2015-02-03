package com.chaos.raft.util;

import com.chaos.raft.configure.Configuration;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Created by zcfrank1st on 1/30/15.
 */
public enum ConfigureLoader {
    INSTANCE;

    private static final String CONFIGURE_FILE_PATH = "src/main/resources/raft-site.xml";

    public Configuration loadConfigure(Class clazz) throws JAXBException {
        File configFile = new File(CONFIGURE_FILE_PATH);
        JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        return (Configuration) unmarshaller.unmarshal(configFile);
    }
}
