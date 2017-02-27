package model;

import java.util.Random;

public class Missao {
	private String operacao;
	private int numeroAlvo;
	Random gerador;


	public Missao() {
		gerador = new Random();

	}

	public void gerarMissao(){

		int a= gerador.nextInt(10);
		int b= gerador.nextInt(10);

		switch (gerador.nextInt(4)){
		case 0 :{
			operacao="+";
			numeroAlvo = a+b;

		}break;
		case 1 :{
			operacao="-";
			if(a>b){
				numeroAlvo = a-b;
			}else{numeroAlvo = b-a;}


		}break;
		case 2 :{
			operacao="*";
			numeroAlvo = a*b;

		}break;
		case 3 :{
			operacao="/";
			if(a==0){a+=1;}
			if(b==0){b+=1;}
			if(a>b){
				numeroAlvo = a/b;
			}else{numeroAlvo = b/a;}
		}break;
		}
	}

	public boolean checarMissao(Personagem personagem){
		switch(operacao){
		case "+" :{
			if(( personagem.getAcerto1()+personagem.getAcerto2())==numeroAlvo){
				return true;
			}else{return false;}

		}
		case "-" :{

			if(( personagem.getAcerto1()-personagem.getAcerto2())==numeroAlvo){
				return true;
			}else{return false;}

		}
		case "*" :{

			if(( personagem.getAcerto1()*personagem.getAcerto2())==numeroAlvo){
				return true;
			}else{return false;}

		}
		case "/" :{

			if(( personagem.getAcerto1()/personagem.getAcerto2())==numeroAlvo){
				return true;
			}else{return false;}
		}
		}
		return true;
	}

	public String getOperacao() {
		return operacao;
	}

	public int getNumeroAlvo() {
		return numeroAlvo;
	}


}
