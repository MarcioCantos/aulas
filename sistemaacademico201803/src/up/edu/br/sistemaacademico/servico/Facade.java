package up.edu.br.sistemaacademico.servico;

import up.edu.br.sistemaacademico.entidades.Aluno;

public class Facade {

	public void addAluno(Aluno aluno) throws ServicoException  {
		new AlunoServico().adicionar(aluno); 
	}
	
	public void editarAluno(Aluno aluno) throws ServicoException {
		new AlunoServico().editar(aluno);
	}
	
	public void deletarAluno(Aluno aluno) throws ServicoException {
		new AlunoServico().deletar(aluno);
	}
	
	public Aluno buscarPorId(Long id) throws ServicoException {
		return new AlunoServico().buscaPorId(id);
	}

}
