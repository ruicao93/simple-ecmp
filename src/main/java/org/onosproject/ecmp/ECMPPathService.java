package org.onosproject.ecmp;

import org.onlab.packet.IpAddress;
import org.onosproject.net.ElementId;
import org.onosproject.net.Host;
import org.onosproject.net.Path;
import org.onosproject.net.PortNumber;

import java.util.Set;

/**
 * Created by cr on 16-11-29.
 */
public interface  ECMPPathService {
    Path getPath(IpAddress srcIp, IpAddress dstIp, int srcPort, int dstPort);
}
