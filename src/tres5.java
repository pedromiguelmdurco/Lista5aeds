import java.io.*;
import java.util.Scanner;

public class tres5 {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		String nomea,linha;
		File arq;
		//coletando o caminho do arquivo
		System.out.println("Digite o caminho do arquivo que você queira copiar: ");
		nomea = teclado.nextLine();
		
		try
		{
			arq = new File(nomea);
			FileWriter copia = new FileWriter("copia.txt");
			FileReader ler = new FileReader(arq);
			BufferedReader leitor = new BufferedReader(ler);
			linha = leitor.readLine();
			//lendo a proxima linha
			while(linha != null)
			{
				copia.write(linha+ "\n");
				linha = leitor.readLine();
				//passando para outro arquivo e trocando de linha
			}
			
			System.out.println("Copiado com sucesso");// mostrando para o usuario q terminou
			leitor.close();
			copia.close();
		}
		catch(IOException ioex)
		{
			System.out.println("Erro - arquivo de entrada inexistente");
		}
		
		teclado.close();
	}

}
