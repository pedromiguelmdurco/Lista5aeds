import java.io.*;
import java.util.Scanner;
public class um5 {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		//declarando variaveis
		String nome1,nome2,linha1,linha2 ;// A alguns txt q vcs podem usar de teste neste projeto
		File arq1, arq2; // se for usar use apenas os (teste1.txt  teste2.txt  testo2.txt)
		int cont = 0;
		//coletando o caminho do arquivo
		
		System.out.println("Digite o caminho do primeiro arquivo: ");
		nome1 = teclado.nextLine();
		
		System.out.println("Digite o caminho do segundo arquivo: ");
		nome2 = teclado.nextLine();
		
		try
		{
			
			arq1 = new File(nome1);
			arq2 = new File(nome2);
			//lendo os arquivos
			FileReader let1 = new FileReader(arq1);
			FileReader let2 = new FileReader(arq2);
			
			
			BufferedReader leitor1 = new BufferedReader(let1);
			BufferedReader leitor2 = new BufferedReader(let2);
			//guardando os valores da linhas
			linha1 = leitor1.readLine();
			linha2 = leitor2.readLine();
			
			while(linha1 != null || linha2 != null)
			{
	
				linha1 = leitor1.readLine();
				linha2 = leitor2.readLine();
				//confirindo se n estao vazias e se estao diferentes
				if(linha1 != null && linha2 != null)
				{
					if(linha1.equals(linha2)== false)
					{
						cont++;
						
					}
				}
				
			}
			//falando se sao iguais
			if(cont > 0) 
			{
				System.out.println("Não são iguais");
			}
			else if(linha1 == null && linha2 == null)
			{
				System.out.println("Em um dos arquivos a primeira linha esta vazia");
			}
			else
			{
				System.out.println("São iguais");
			}
			
			leitor1.close();
			leitor2.close();
		}
		catch(IOException ioex)
		{
			System.out.println("Erro - arquivo de entrada inexistente");
		}
		
		teclado.close();

	}

}
