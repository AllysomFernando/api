package br.fag.controllers;
import br.fag.services.Divisao;
import br.fag.services.Multiplicacao;
import br.fag.services.Somar;
import br.fag.services.Substracao;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
@Path("/calculate")
public class CalculatorResource {
    @GET
    public Response calculate(@QueryParam("first") float first, @QueryParam("second") float second, @QueryParam("operator") String operator){

        Divisao divisao = new Divisao();
        Somar somar = new Somar();
        Substracao substracao = new Substracao();
        Multiplicacao multiplicacao = new Multiplicacao();
        float result;

        switch (operator) {
            case "+" -> result = somar.operacao(first, second);
            case "-" -> result = substracao.operacao(first,second);
            case "*" -> result = multiplicacao.operacao(first,second);
            case "/" -> result = divisao.operacao((int)first,(int)second);
            default -> {
                return Response.status(Response.Status.BAD_REQUEST).entity("Invalid operator").build();
            }
        }
        return Response.ok(String.valueOf(result)).build();
    }
}
