import java.io.*;
import java.util.Scanner;

public class dois5 {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		String nomea;
		File arq;
		int cont = 0;
		//coletando o caminho do arquivo
		System.out.println("Digite o caminho do arquivo: ");
		nomea = teclado.nextLine();
		
		try
		{
			arq = new File(nomea);
			Scanner ler = new Scanner(arq);
			//scaneando o arquivo
			//vendo se a proxima linha esta vazia
			while(ler.hasNextLine() && ler != null)
			{
				ler.nextLine();
				cont++;
				//contando quantas linhas tem
			}
			System.out.println("Número de linha do arquivo é: "+cont);//mostrando quantas tem
			ler.close();
		}
		catch(IOException ioex)
		{
			System.out.println("Erro - arquivo de entrada inexistente");
		}
		
		teclado.close();
	}

}
