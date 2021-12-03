package io.radiosphere.mvnprotobuf;

import io.quarkus.runtime.StartupEvent;
import org.infinispan.client.hotrod.DefaultTemplate;
import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;
import org.jboss.logging.Logger;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @Inject
    public RemoteCacheManager cacheManager;

    Logger logger = Logger.getLogger(this.getClass());


    public void onStartup(@Observes StartupEvent startupEvent) {
        RemoteCache<String, CounterState> cache = cacheManager.administration().getOrCreateCache("default", DefaultTemplate.DIST_SYNC);

        cache.put("a", new CounterState(2L));
        CounterState state = cache.get("a");

        logger.infof("State: %s", state);
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy";
    }
}