

package com.exampple.gateway;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.example.gateway.model.FreelancersData;
import com.example.gateway.rest.GatewayEndPoint;
import com.example.gateway.rest.RestApplication;
import com.example.gateway.service.FreelancerService;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.net.URI;

import static net.javacrumbs.jsonunit.fluent.JsonFluentAssert.assertThatJson;

@RunWith(Arquillian.class)
@RunAsClient
public class GatewayEndPointTest {

    // ======================================
    // = Injection Points =
    // ======================================

    @ArquillianResource
    private URI baseURI;
    private Client client;
    private WebTarget webTarget;

    // ======================================
    // = Deployment methods =
    // ======================================
    @Deployment
    public static Archive<?> archive() {
        if (System.getProperty("arquillian.launch", "").equals("arquillian-hammock")) {
            return ShrinkWrap.create(JavaArchive.class)
                    .addClasses(GatewayEndPoint.class, RestApplication.class, FreelancerService.class, FreelancersData.class);
        } else {
            return ShrinkWrap.create(WebArchive.class).addClass(RestApplication.class).addClass(GatewayEndPoint.class)
                    .addClass(FreelancerService.class).addClass(FreelancersData.class);
                    //.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
                    //.addAsWebInfResource(new FileAsset(new File("src/main/webapp/WEB-INF/beans.xml")), "beans.xml");
        }
    }

    @Before
    public void initWebTarget() {
        client = ClientBuilder.newClient();
        webTarget = client.target(baseURI);
    }

    // ======================================
    // = Test methods =
    // ======================================

    @Test
    public void testFreelancers() {
    	String body = webTarget.request(MediaType.APPLICATION_JSON).get(String.class);
        assertThatJson(body).isArray().ofLength(2);
        //assertTrue(body.startsWith("[{\"id\":"));
    }

    /*
    @Test
    public void should_have_five_items() {
        String body = webTarget.request(MediaType.APPLICATION_JSON).get(String.class);
        assertThatJson(body).isArray().ofLength(5);
        assertTrue(body.startsWith("[{\"id\":"));
    }
    */
}
