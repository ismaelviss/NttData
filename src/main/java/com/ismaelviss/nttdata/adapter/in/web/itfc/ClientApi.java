package com.ismaelviss.nttdata.adapter.in.web.itfc;

import com.ismaelviss.nttdata.common.exception.ApplicationException;
import com.ismaelviss.nttdata.domain.Client;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.validation.Valid;
import java.util.List;

@Validated
@Api(tags = "Client")
@RequestMapping(value = "/v1")
public interface ClientApi {

    @ApiOperation(value = "Consultar cliente", nickname = "getClient", notes = "", response = Client.class, tags={ "Client", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = Client.class),
            @ApiResponse(code = 404, message = "not found") })
    @RequestMapping(value = "/clientes/{id}",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<Client> getClient(@ApiParam(value = "ID of client",required=true) @PathVariable("id") Long id) throws ApplicationException;

    @ApiOperation(value = "Consultar clientes", nickname = "getAllClients", notes = "", response = Client.class, tags={ "Client", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = Client.class),
            @ApiResponse(code = 404, message = "not found") })
    @RequestMapping(value = "/clientes",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<List<Client>> getAllClients() throws ApplicationException;

    @ApiOperation(value = "actualizar cliente", nickname = "updateClient", notes = "", response = Client.class, tags={ "Client", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = Client.class),
            @ApiResponse(code = 400, message = "Invalid client") })
    @RequestMapping(value = "/clientes",
            produces = { "application/json" },
            method = RequestMethod.PUT)
    ResponseEntity<Void> updateClient(@Valid @RequestBody Client client) throws ApplicationException;

    @ApiOperation(value = "eliminar cliente", nickname = "deleteClient", notes = "", response = Client.class, tags={ "Client", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = Client.class),
            @ApiResponse(code = 400, message = "Invalid client") })
    @RequestMapping(value = "/clientes/{id}",
            produces = { "application/json" },
            method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteClient(@ApiParam(value = "ID of client",required=true) @PathVariable("id") Long id) throws ApplicationException;

    @ApiOperation(value = "crear cliente", nickname = "addClient", notes = "", response = Client.class, tags={ "Client", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = Client.class)})
    @RequestMapping(value = "/clientes",
            produces = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<Client> addClient(@Valid @RequestBody Client client);
}
