package bg.elsys.ip.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Path("/instruments")
@Api("instruments")
public class UserResource {

	@GET
	@ApiOperation(value = "get list of instruments", response = Instrument.class, responseContainer = "List")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsers() {
		UserService userService = UserService.getInstance();
		return Response.ok(userService.getInstr()).build();
	}

	@POST
	@ApiOperation(value = "create new instrument", response = Instrument.class)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createUser(Instrument instr) {
		UserService.getInstance().addInstr(instr);

		return Response.ok(instr).status(Status.CREATED).build();
	}
}
