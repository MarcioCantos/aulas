package up.edu.br.sistemaacademico.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import up.edu.br.sistemaacademico.dao.AlunoDao;
import up.edu.br.sistemaacademico.entidades.Aluno;
import up.edu.br.sistemaacademico.servico.Facade;
import up.edu.br.sistemaacademico.servico.ServicoException;

@Path("/alunorest")
public class AlunoRest {

	// http://localhost:8080/sistemaacademico201803/rest
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void adicionar(Aluno a) {
		
		try {			
			new Facade().addAluno(a);
			
		} catch (ServicoException e) {
			e.printStackTrace();
		}
		
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void editar(Aluno a) {
		
		try {
			new Facade().editarAluno(a);
		} catch (ServicoException e) {
			e.printStackTrace();
		}
		
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public void excluir(Aluno a) {
		
		try {
			new Facade().deletarAluno(a);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Aluno> listar() {
		return new AlunoDao().listar();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Aluno buscaPorId(@PathParam("id") Long id) throws ServicoException {
		return new Facade().buscarPorId(id);
	}

}
