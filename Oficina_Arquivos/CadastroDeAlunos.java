import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Scanner;

public class CadastroDeAlunos {

	private enum TipoDeLog {
		ERRO, INICIAR, EXIBIR, INSERIR, EXCLUIR, ENCERRAR
	}

	private Scanner entrada;
	private final String enderecoArquivoDeDados = "C:\\info\\dados.ser";
	private final String enderecoArquivoDeLog = "C:\\info\\log.txt";
	private File arquivo;
	private HashMap<String, Aluno> alunos;

	public static void main(String[] args) throws IOException {
		CadastroDeAlunos cadastro = new CadastroDeAlunos();
		
		cadastro.salvarNoLog(TipoDeLog.INICIAR, "Iniciando a aplicacao.");
		
		cadastro.iniciar();
	}

	public CadastroDeAlunos() {
		arquivo = new File(enderecoArquivoDeDados);
		alunos = new HashMap<String, Aluno>();
		entrada = new Scanner(System.in);
	}

	private void iniciar() {
		int opcao = -1;
		try {

			lerArquivo();

			do {
				exibeMenu();
				opcao = opcaoUsuario();
				switch (opcao) {
				case 1:
					exibirAlunos();
					break;
				case 2:
					novoAluno();
					break;
				case 3:
					removerAluno();
					break;
				case 4:
					break;

				default:
					System.out.println("Opcao inexistente.");
					opcao = -1;
				}

			} while (opcao != 4);

			finalizar();

		} catch (IOException exception) {
			System.err.println("Falha durante a manipulacao do arquivo.");
			System.err.println("Erro: " + exception.getMessage());
			salvarNoLog(TipoDeLog.ERRO, "Erro durante a manipulacao do arquivo.");
		} catch (ClassNotFoundException exception) {
			System.err.println("Falha durante convers�o do registro em Aluno.");
		}

		System.out.println("Encerrando...");
		System.exit(0);
	}

	private void finalizar() throws IOException {
		System.out.println("Salvando dados no arquivo...");
		gravarArquivo();
		salvarNoLog(TipoDeLog.ENCERRAR, "Programa finalizado.");
	}

	private void exibeMenu() {
		System.out.println(":: Menu ::\n");
		System.out.println(" 1. Ver Alunos\n 2. Adicionar Aluno\n 3. Remover Aluno\n 4. Sair");
		System.out.print(">> ");
	}

	private int opcaoUsuario() throws IOException {
		return entrada.nextInt();
	}

	private void exibirAlunos() {
		System.out.println("# Lista de Alunos\n");
		for (Aluno aluno : alunos.values()) {
			System.out.println("Matricula: " + aluno.getMatricula());
			System.out.println("Nome: " + aluno.getNome());
			if (aluno.getEndereco() != null && !aluno.getEndereco().isEmpty()) {
				System.out.println("Endereco: " + aluno.getEndereco());
			}
			if (aluno.getTelefone() != null && !aluno.getTelefone().isEmpty()) {
				System.out.println("Telefone: " + aluno.getTelefone());
			}
			System.out.println();
		}
		System.out.println("-----------------------");
		salvarNoLog(TipoDeLog.EXIBIR, "Alunos listados.");
	}

	private void novoAluno() {
		System.out.println("Informe matr�cula, nome, endere�o e telefone do aluno, separados por v�rgula.");
		System.out.print("* Apenas matr�cula e nome s�o obrigat�rios. \n>>");
		entrada.nextLine();

		String dados = entrada.nextLine();
		String[] dadosAluno = dados.split(",");

		Aluno aluno = new Aluno(dadosAluno[0], dadosAluno[1]);
		if (dadosAluno.length >= 3) {
			aluno.setEndereco(dadosAluno[2]);
		}
		if (dadosAluno.length >= 4) {
			aluno.setTelefone(dadosAluno[3]);
		}

		alunos.put(aluno.getMatricula(), aluno);
		salvarNoLog(TipoDeLog.INSERIR, "Novo aluno inserido.");
	}

	private void removerAluno() {
		System.out.print("Informe matr�cula do aluno que deseja remover.\n>>");
		entrada.nextLine();

		String matricula = entrada.nextLine();

		if (alunos.containsKey(matricula)) {
			Aluno aluno = alunos.remove(matricula);
			System.out.println("Aluno " + aluno.getNome() + " removido...");
			salvarNoLog(TipoDeLog.EXCLUIR, "Aluno removido.");
		} else {
			System.out.println("Matr�cula n�o encontrada...");
		}
	}

	private void lerArquivo() throws IOException, ClassNotFoundException {

		if (arquivo.length() <= 0)
			return;

		System.out.println("Carregando dados do arquivo...");
		ObjectInputStream leitor = new ObjectInputStream(new FileInputStream(arquivo));
		Aluno temp = null;

		try {

			while ((temp = (Aluno) leitor.readObject()) != null) {
				alunos.put(temp.getMatricula(), temp);
			}

		} catch (EOFException eofe) {
			System.out.println("Arquivo de registros vazio.");
		}
		leitor.close();
		leitor = null;
	}

	private void gravarArquivo() throws IOException {
		if (alunos != null) {
			ObjectOutputStream gravador = new ObjectOutputStream(new FileOutputStream(arquivo, false));
			for (Aluno a : alunos.values()) {
				gravador.writeObject(a);
			}
			gravador.flush();
			gravador.close();
			gravador = null;
		}
	}

	private void salvarNoLog(TipoDeLog tipoDeLog, String log) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime agora = LocalDateTime.now();
		
		String mensagemDeLog = "[" + agora.format(format) + "] [" + tipoDeLog + "] " + log + "\n";
		
		System.out.println(mensagemDeLog);

		File arquivo = new File("C:\\info\\log.txt");
		try {

			if (!arquivo.exists()){
				arquivo.createNewFile();
			}

			FileWriter arquivoDeLog = new FileWriter("C:\\info\\log.txt",true);
			arquivoDeLog.write(mensagemDeLog);
		}catch (IOException exception){
			System.err.println("Falha ao manipular o arquivo de log");
		}

	}

}
