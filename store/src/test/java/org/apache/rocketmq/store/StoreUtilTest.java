package org.apache.rocketmq.store;

import org.junit.Test;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

import static org.junit.Assert.*;

public class StoreUtilTest {

    @Test
    public void getTotalPhysicalMemorySize() {
        OperatingSystemMXBean osmxb = ManagementFactory.getOperatingSystemMXBean();
        long physicalTotal = 0;
        if (osmxb instanceof com.sun.management.OperatingSystemMXBean) {
            physicalTotal = ((com.sun.management.OperatingSystemMXBean) osmxb).getTotalPhysicalMemorySize();
        }
        System.out.println(physicalTotal/(1024*1024*1024));

    }
}