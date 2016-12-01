package bg.elsys.ip.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Path("/instruments")
@Api("instruments")
public class InstrumentResource
{

	@GET
	@ApiOperation(value = "get list of instruments", response = Instrument.class, responseContainer = "List")
	@Produces(MediaType.APPLICATION_JSON)
	public PagedResponse getInstruments(@QueryParam("page") int page, 
			@QueryParam("perPage") int perPage,
			@QueryParam("typeFilter") String typeFilter,
			@QueryParam("brandFilter") String brandFilter,
			@QueryParam("modelFilter") String modelFilter, 
			@QueryParam("yearFilter") int year,
			@QueryParam("priceMin") int priceMin,
			@QueryParam("priceMax") int priceMax)
	{
		InstrumentService instrumentService = InstrumentService.getInstance();
		PagedResponse instrumentPages = instrumentService.getPagedFiltered(page, perPage,
				typeFilter,
				brandFilter,
				modelFilter, 
				year,
				priceMin,
				priceMax);
		return instrumentPages;
	}

	@POST
	@ApiOperation(value = "create new instrument", response = Instrument.class)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createUser(Instrument instr)
	{
		InstrumentService.getInstance().addInstrument(instr);

		return Response.ok(instr).status(Status.CREATED).build();
	}
}
