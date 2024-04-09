import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class cinco5 {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		String nomea,codigo,nome,idade,endereco,numero,complemento;
		
		int quant;
		File arq;
		//coletando o caminho do arquivo e quantas pessoas vao ser cadastradas
		System.out.println("Digite o caminho do arquivo: ");
		nomea = teclado.nextLine();
		System.out.println("Quantas pessoas você vai querer cadastrar");
		quant = teclado.nextInt();
		//criando o vetor de pessoas
		Pessoa[] pesso = new Pessoa[quant];
		
		try
		{
			for(int cont = 1; cont <= quant;cont++)
			{
				//coletando dados de cada pessoa
				System.out.println("Não deixa espaços em bracos");
				System.out.println("Código "+cont+": ");
				codigo = teclado.next();
				
				System.out.println("Nome "+cont+": ");
				nome = teclado.next();
				
				System.out.println("Idade "+cont+": ");
				idade = teclado.next();
				
				System.out.println("Endereço "+cont+": ");
				endereco = teclado.next();
				
				System.out.println("Número "+cont+": ");
				numero = teclado.next();
				
				System.out.println("Complemento "+cont+": ");
				complemento = teclado.next();
				//ativando a classe e criando um objeto
				Pessoa pessoa = new Pessoa(codigo,nome,idade,endereco, numero,complemento);
				pesso[cont-1] = pessoa;// armazenando em um vetor cada objeto
			
			
				arq = new File(nomea);
				FileWriter pass = new FileWriter(arq,true);
				// pegando o arquivo e atuzalizando ele
				
				pesso[cont-1].salvarPessoa(pass);
				
				
				pass.close();
			
			
			}
		}
		catch(IOException ioex)
		{
			System.out.println("Erro - arquivo de entrada inexistente");
		}
		
		
		
		
		teclado.close();
	}

}

class Pessoa{
	
	String codigo, nome, idade, endereco, numero, complemento;
	
	public Pessoa(String codigo, String nome, String idade,  String endereco, String numero, String complemento) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.idade = idade;
		this.endereco = endereco;
		this.numero = numero;
		this.complemento = complemento;
		
	}
	
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getIdade() {
		return idade;
	}
	public void setIdade(String idade) {
		this.idade = idade;
	}
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	public void salvarPessoa(FileWriter salva) throws IOException
	{// mostrando para o usuario q foi salvo cada pessoa e guardando no sistema
		salva.write("Pessoa: \n"+" Codigo:"+getCodigo()+"\n Nome:"+getNome()+"\n Idade:"+getIdade()+"\n Endereço:"+getEndereco()+"\n Número:"+getNumero()+"\n Complemento:"+getComplemento()+"\n");
		System.out.println("Pessoa salva");
	}
	
	
}