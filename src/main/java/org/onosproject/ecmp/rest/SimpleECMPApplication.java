package org.onosproject.ecmp.rest;

import org.onlab.rest.AbstractWebApplication;

import java.util.Set;

/**
 * Created by cr on 16-11-29.
 */
public class SimpleECMPApplication extends AbstractWebApplication{
    @Override
    public Set<Class<?>> getClasses() {
        return getClasses(SimpleECMPRest.class);
    }
}
