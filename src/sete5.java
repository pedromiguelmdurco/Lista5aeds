import java.io.*;
import java.util.Scanner;

public class sete5 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		Eletro[] elet = new Eletro[15];
		String nomea, nomelj="",nomea2, linha;
		String[] pala;
		int tel=0, conta = 0;
		double preco=0, total = 0, media2;
		double[] media = new double[elet.length];
		File arq, arq2;
		
		try
		{//coletando o caminho do arquivo e saida
			System.out.println("Digite o caminho do arquivo: ");
			nomea = teclado.nextLine();
			
			System.out.println("Digite o caminho do arquivo das me: ");
			nomea2 = teclado.nextLine();
			
			arq = new File(nomea);
			arq2 = new File(nomea2);
			FileReader ler = new FileReader(arq);
			BufferedReader leitor = new BufferedReader(ler);
			linha = leitor.readLine();
			// lendo os arquivos
			FileWriter saida = new FileWriter(arq2);
			//Recomendo usar o cinco.txt como entrada e cinco2.txt como saida
			while(linha != null)
			{
				pala = linha.split(",");// fazendo a mesma coisa q na primeira mas em vez de ser espaço é ,
				for(int c = 0; c < pala.length; c++)//separando cada parte do vetor no lugar expecifico
				{
					if(c == 2)
					{
						preco = Double.parseDouble(pala[c]);
					}
					else if(c == 0)
					{
						nomelj = pala[c];
					}
					else if(c == 1)
					{
						tel = Integer.parseInt(pala[c]);
					}
					
				}
				//criando o objeto com os valores
				Eletro ricardo = new Eletro(nomelj, tel, preco);
				elet[conta] = ricardo;//armazenando o objeto no vetor
				
				
				media[conta] = preco;// guardando precos
				conta++;// trocar parte do vetor elet e media
				linha = leitor.readLine();
			}
			
			// pegando o total
			for(int vet = 0; vet < media.length;vet++)
			{
				total += media[vet];
			}
			
			media2 = total/media.length;// calculando a media
			
			saida.write("A média é:"+media2+"\n");// mostrando no arquivo a media
			
			for(int d = 0; d <elet.length;d++)//percorrendo o vetor com os objetos e vendo quais precos estao abaixo da media e imprimindo no arquivo
			{
				elet[d].mostrar();
				if(elet[d].getPreco() < media2)
				{
					saida.write(elet[d].getNomelj()+" esta abaixo da media com o preço de R$: "+elet[d].getPreco()+" e o telefone é: "+elet[d].getTel()+"\n");
				}
			}
			System.out.println("Gravada a média no arquivo");// mostrando pro usuario que ja arquivou
			leitor.close();
			saida.close();
		}
		catch(IOException ioex)
		{
			System.out.println("Erro - arquivo de entrada inexistente");
		}
		
		teclado.close();

	}

}
class Eletro
{
	String nomelj;
	int tel;
	double preco;
	
	public Eletro(String nomelj, int tel, double preco) {
		super();
		this.nomelj = nomelj;
		this.tel = tel;
		this.preco = preco;
	}
	
	public String getNomelj() {
		return nomelj;
	}
	public void setNomelj(String nomelj) {
		this.nomelj = nomelj;
	}
	
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public void mostrar() {// mostrando para o usuario todas as alternativas no arquivo
		System.out.println("O nome é "+getNomelj());
		System.out.println("O telefone é "+getTel());
		System.out.println("O preço é : "+getPreco());
		System.out.println("");
	}
}
