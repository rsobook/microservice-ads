package si.fri.rsobook.rest;

import si.fri.rsobook.models.AdsDTO;

import javax.enterprise.context.RequestScoped;
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

    private static List<AdsDTO> adsList= Arrays.asList(
            new AdsDTO("BMW", "Best cars around"),
            new AdsDTO("AMD", "Best price/pref"),
            new AdsDTO("Intel", "High clock speed"),
            new AdsDTO("NVidia", "Buy new graphic")
    );

    @GET
    public Response get() {
        int i = (int)(Math.random() * adsList.size());
        return Response.ok(adsList.get(i)).build();
    }
}
