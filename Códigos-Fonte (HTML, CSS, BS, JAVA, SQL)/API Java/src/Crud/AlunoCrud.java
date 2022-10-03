package Crud;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Dao.AlunoDao;
import model.Aluno;

public class AlunoCrud {

	public static void main(String[] args) {
		//criar uma instancia do DAO para utilizar os metodos
		AlunoDao alunoDAO = new AlunoDao();
		
		Scanner input = new  Scanner(System.in);
		
		// setar as variaveis de navegaçao
		int opcao = 0;
		int posicao = 0;
		
		int id = 0;
		String nome = "";
		String endereco = "";
		String cidade = "";
		String estado = "";
		String cep = "";
		
		//instancia  da lista que vai armazenar
		List<Aluno> Aluno = new ArrayList<Aluno>();

		//Menu
		do {
			System.out.println("-----CRUD Aluno-----");
			System.out.println("1- Cadastro de Aluno");
			System.out.println("2- Consulta de Aluno");
			System.out.println("3- Delete de Aluno");
			System.out.println("4- Atualização do Aluno");
			System.out.println("0- sair");
			
			opcao = input.nextInt();
			
			//navegaçao do crud
			switch(opcao) {
			case 1:
				//CREATE
				System.out.println("****Cadastrar Aluno****");
				System.out.println("Digite o nome:");
				nome = input.nextLine();
				nome = input.nextLine();
				System.out.println("Digite o Endereço:");
				endereco = input.nextLine();
				System.out.println("Digite o Cidade:");
				cidade = input.nextLine();
				System.out.println("Digite o Estado:");
				estado = input.nextLine();
				System.out.println("Digite o Cep:");
				cep = input.nextLine();
				
				Aluno aluno = new Aluno();
				aluno.setNome(nome);
				aluno.setEndereco(endereco);
				aluno.setCidade(cidade);
				aluno.setEstado(estado);
				aluno.setCep(cep);
				
				AlunoDao.save(aluno);
				
				System.out.println("***Cadastrado***\n");
				break;
			case 2:
				for (Aluno a : alunoDAO.getAluno()) {
					System.out.println("Id: " + a.getId() + ", Nome: " + a.getNome() + ", Endereço: " + a.getEndereco() + ", Cidade: " + a.getCidade() + ", Estado: " + a.getEstado() + ", Cep: " + a.getCep());
				}
				
				System.out.println("*Consulta Finalizada*");
				break;
			case 3:
				System.out.println("ID para exclusão: ");
				posicao = input.nextInt();
				
				alunoDAO.deleteById(posicao);
				System.out.println("Aluno Excluído");
				break;
			case 4:
				System.out.println("Atualizando cadastro do Aluno");
				System.out.println("Digite o Id do Aluno:");
				id = input.nextInt();
				System.out.println("Digite o novo nome do Aluno:");
				nome = input.nextLine();
				nome = input.nextLine();
				System.out.println("Digite o novo Endereço:");
				endereco = input.nextLine();
				System.out.println("Digite o novo Cidade:");
				cidade = input.nextLine();
				System.out.println("Digite o novo Estado:");
				estado = input.nextLine();
				System.out.println("Digite o novo Cep:");
				cep = input.nextLine();
				
				Aluno aluno1 = new Aluno(id, nome, endereco, cidade, estado, cep);
				AlunoDao.update(aluno1);
				break;	

				
		
				
			default:
				System.out.println(opcao != 0 ? "\n Opcao invalida, tente novamente.\n":"");
			break;
			}
			
		}while(opcao != 0);
			
		input.close();
		System.out.println("***Finalizado***");
			
	}

}
