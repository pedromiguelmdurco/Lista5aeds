import java.io.*;
import java.util.Scanner;

public class quatro5 {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		String palavra,nomea,linha;
		String[] palavras;
		File arq;
		int cont = 0, cont2 = 0;
		//coletando o caminho do arquivo e a palavra q quer conferir
		System.out.println("Digite o caminho do arquivo: ");
		nomea = teclado.nextLine();
		
		System.out.println("Digite agora a palavra q procura: ");
		palavra	= teclado.nextLine();
		
		try
		{
			// recomendo usar o arquivo quatro.txt
			arq = new File(nomea);
			FileReader ler = new FileReader(arq);
			BufferedReader leitor = new BufferedReader(ler);
			linha = leitor.readLine();
			//vendo se a linha n esta vazia
			while(linha != null)
			{
				//criando um vetor q armazenas as palavras toda vez q tiver um espaço
				palavras = linha.split(" ");
				for(int a = 0; a < palavras.length;a++)
				{
					//passando pelo o vetor e conferindo se a palavras sao iguais
					if(palavras[a].equals(palavra))
					{
						cont++;
					}
				}
				//vendo quantas linhas tem no arquivo
				cont2++;
				linha = leitor.readLine();
			}
			//mostrando para o usuario
			System.out.println("A palavra repitiu :"+cont);
			System.out.println("Tem "+cont2+" linhas no arquivo");
			
			leitor.close();
		}
		catch(IOException ioex)
		{
			System.out.println("Erro - arquivo de entrada inexistente");
		}
		
		teclado.close();
	}

}
