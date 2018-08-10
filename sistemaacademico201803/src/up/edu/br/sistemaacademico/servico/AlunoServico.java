package up.edu.br.sistemaacademico.servico;

import up.edu.br.sistemaacademico.dao.AlunoDao;
import up.edu.br.sistemaacademico.dao.Dao;
import up.edu.br.sistemaacademico.dao.FabricaDao;
import up.edu.br.sistemaacademico.entidades.Aluno;

public class AlunoServico {
	
	Dao<Aluno> alunoDao = FabricaDao.createDaoAluno();
	
	public void adicionar(Aluno aluno) throws ServicoException {
		if (aluno.getMatricula() == null) {
			throw new ServicoException("O campo matricula "
					+ "não pode ser vazio.");
		}
		
		alunoDao.adicionar(aluno);
	}
	
	public void editar(Aluno aluno) throws ServicoException {
		
		if(aluno.getId() == null) {
			throw new ServicoException("Aluno inexistente.");
		}
		
		alunoDao.editar(aluno);
		
	}
	
	public void deletar(Aluno aluno) throws ServicoException {
		
		if(aluno.getId() == null) {
			throw new ServicoException("Aluno inexistente.");
		}
		
		alunoDao.excluir(aluno);
		
	}
	
	public Aluno buscaPorId(Long id) throws ServicoException {
		return alunoDao.buscaPorId(id);
	}

}
