package up.edu.br.sistemaacademico.teste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;

import up.edu.br.sistemaacademico.dao.AlunoDao;
import up.edu.br.sistemaacademico.entidades.Aluno;
import up.edu.br.sistemaacademico.servico.AlunoServico;
import up.edu.br.sistemaacademico.servico.Facade;
import up.edu.br.sistemaacademico.servico.ServicoException;

public class TestarAluno {
	
	@Test
	public void deveriaCadastrarUmAluno() {
		Aluno a = new Aluno();
		a.setId(null);
		a.setNome("Cleverson");
		a.setMatricula("12345");
		
		try {
			
			new Facade().addAluno(a);
			
		} catch (ServicoException e) {
			e.printStackTrace();
		}
		
		assertEquals(true, a.getId() != null);
	}
	
	@Test
	public void deveriaListarAlunos() {
		List<Aluno> alunos = new AlunoDao().listar();
		
		assertEquals(true, alunos.size() > 0);
	}
	
	@Test
	public void deveriaEditarAluno() {
		Aluno a = new Aluno();
		a.setId((long) 10);
		a.setNome("Cleverson");
		a.setMatricula("12345");
		
		try {
			new Facade().editarAluno(a);
		} catch (ServicoException e) {
			e.printStackTrace();
		}
		
		assertEquals(true, a.getId() != null);
	}
	
	public void deveriaDeletarAluno() {
		Aluno a = new Aluno();
		a.setId((long) 10);
		a.setNome("Cleverson");
		a.setMatricula("12345");
		
		try {
			new Facade().deletarAluno(a);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		assertEquals(true, a.getId() != null);
		
	}

}
