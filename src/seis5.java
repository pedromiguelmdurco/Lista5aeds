import java.io.*;
import java.util.Scanner;

public class seis5 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		Pessoas[] pesso = new Pessoas[10];
		String nomea,nome,dia,mes;
		String[][] niver = new String[12][pesso.length];
		File arq;
		
		try 
		{//coletando o caminho do arquivo
			System.out.println("Digite o caminho do arquivo: ");
			nomea = teclado.nextLine();
			
			arq = new File(nomea);
			FileWriter save = new FileWriter(arq);
			//coletando dados sobre a pessoa
			for(int cont = 1;cont <= pesso.length;cont++)
			{
				System.out.println("Digite seu nome: ");
				nome = teclado.next();

				System.out.println("Digite o dia que você nasceu: ");
				dia = teclado.next();
				
				System.out.println("Digite o mes que você nasceu(escreva o número): ");
				mes = teclado.next();
				
				Pessoas pessoa = new Pessoas(nome,dia,mes);//armazenando as pessoas
				pesso[cont - 1] = pessoa; 
				
				
				
				pesso[cont-1].salvar(save);//salvando elas
				
				int mes2 = Integer.parseInt(mes);
				int dia2 = Integer.parseInt(dia);//criando variaveis para poder amarzenar e outra para calcular e convertendo de int para String
				
				niver[mes2-1][cont-1] = (nome+" dia: "+dia2); // armazenando na matriz
				
				for(int cont2 = 0; cont2< niver.length;cont2++)
				{
					for(int col = 0; col< niver[cont2].length;col++)
					{
						if(niver[cont2][col] != null) {// imprimindo no console toda vez q alguem entra e mostrando e ordem quem nasceu em cada mes e o dia
							System.out.println("Pessoas que nasceram no mes "+(cont2+1)+": "+niver[cont2][col]);
						}
						
					}
					
				}
				
				
				
			}
			
			save.close();
			
		}
		catch(IOException ioex)
		{
			System.out.println("Erro - arquivo de entrada inexistente");
		}
		
		teclado.close();
	}

}
class Pessoas
{
	String nome,dta,mes;

	public Pessoas(String nome, String dta, String mes) {
		super();
		this.nome = nome;
		this.dta = dta;
		this.mes = mes;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDta() {
		return dta;
	}
	public void setDta(String dta) {
		this.dta = dta;
	}

	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}
	
	public void salvar(FileWriter e) throws IOException
	{// salvando no arquivo
		e.write("Pessoa: \n"+"Nome: "+getNome()+"\nDia: "+getDta()+"\nMes: "+getMes()+"\n");
	}
}
