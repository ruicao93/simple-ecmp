package org.onosproject.ecmp.rest;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.onlab.packet.Ip4Address;
import org.onlab.packet.IpAddress;
import org.onosproject.ecmp.ECMPPathService;
import org.onosproject.net.Host;
import org.onosproject.rest.AbstractWebResource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Set;

import static org.onlab.util.Tools.nullIsNotFound;

/**
 * Created by cr on 16-11-29.
 */
@Path("ecmp")
public class SimpleECMPRest extends AbstractWebResource {
    /**
     * Hello ECMP ^0^.
     * Sample for extending RESTful API.
     * @return Infos of Fnl.
     */
    @GET
    @Path("/hello")
    public Response fnl(){
        ObjectNode root = mapper().createObjectNode();
        ArrayNode array = root.putArray("Beijing Tower");
        array.add(118.5).add(120.3);

        root.put("708", "10.103.89.*").put("738", "10.103.90.*");

        return ok(root).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/path/{src}/{dst}/{srcPort}/{dstPort}")
    public Response getPath(@PathParam("src") String src,
                            @PathParam("dst") String dst,
                            @PathParam("srcPort") int srcPort,
                            @PathParam("dstPort") int dstPort) {
        // srcIp, dstIp
        IpAddress srcIp = Ip4Address.valueOf(src);
        IpAddress dstIp = Ip4Address.valueOf(dst);
        org.onosproject.net.Path path = get(ECMPPathService.class).getPath(srcIp, dstIp, srcPort, dstPort);
        nullIsNotFound(path, "Path not found");
        final ObjectNode root = codec(org.onosproject.net.Path.class).encode(path, this);
        return ok(root).build();
    }

}
