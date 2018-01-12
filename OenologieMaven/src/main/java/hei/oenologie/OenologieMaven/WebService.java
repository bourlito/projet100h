package hei.oenologie.OenologieMaven;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("seance")
public class WebService {
    @GET
    public Response getSeances(){return null;}

    @GET
    @Path("/{idSeance}")
    public Response getSeance(@PathParam("idSeance") int idSeance){return null;}
}
