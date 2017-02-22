package model;

import java.util.Random;

public class Missao {
	String Operacao;
	int numeroAlvo;
	

	Random gerador;
	public Missao() {
		gerador = new Random();

	}
	
	public void gerarMissao(){
		
		int a= gerador.nextInt(10);
		int b= gerador.nextInt(10);
		
		
		
	}
//	public void gerarNumeroAlvo(){
//		
//		
//		
//		
//	}
	
}
