package br.uel.principal;

import java.util.Locale;
import java.util.Scanner;

public class Application {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		input.useLocale(Locale.ENGLISH);
		
		Agencia agencia = new Agencia();
		System.out.println("Insira o id da agencia: ");
		Integer idAgencia = input.nextInt();
		agencia.setId(idAgencia);
		
		Integer tipo = 1;
		
		int contFila = 0;
		
		while(tipo != 0) {
			System.out.println("\nInsira 1 para entrar na fila, 2 para desistir da fila,3 para atender um cliente,\n4 para buscar posição na fila, 5 para imprimir a fila ou 0 para encerrar o programa ");
			tipo = input.nextInt();
			
			if(tipo == 1) {
				agencia.insertClient();
		        
			}else if(tipo == 2) {
				agencia.giveUp();
				
			}else if(tipo == 3) {
				contFila = agencia.serveClient(contFila);
				
			}else if(tipo == 4) {			
				agencia.getPosic();
				
			}else if(tipo == 5) {
				agencia.printLine();
			}
		}
		
		input.close();
		}
	}
