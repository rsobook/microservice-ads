package si.fri.rsobook.rest;

import com.kumuluz.ee.logs.cdi.Log;
import org.eclipse.microprofile.metrics.Counter;
import org.eclipse.microprofile.metrics.annotation.Metric;
import si.fri.rsobook.config.AdsApiConfigProperties;
import si.fri.rsobook.models.AdsDTO;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;

@Path("Ads")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AdsResource {

    @Inject
    private AdsApiConfigProperties adsApiConfigProperties;

    @Inject
    @Metric(name = "about_returned")
    private Counter adsReturnedCounter;


    private static List<AdsDTO> adsList= Arrays.asList(
            new AdsDTO("BMW", "Best cars around"),
            new AdsDTO("AMD", "Best price/pref"),
            new AdsDTO("Intel", "High clock speed"),
            new AdsDTO("NVidia", "Buy new graphic")
    );

    @Log
    @GET
    public Response get() {
        if(adsApiConfigProperties.getAdsEnabled()) {
            adsReturnedCounter.inc();

            int i = (int)(Math.random() * adsList.size());
            return Response.ok(adsList.get(i)).build();
        }

        return Response.noContent().build();
    }

}
