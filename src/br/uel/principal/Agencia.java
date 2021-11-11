package br.uel.principal;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Agencia {
	private Integer id;
	private ArrayList<Cliente> comum = new ArrayList<Cliente>();
	private ArrayList<Cliente> preferencial = new ArrayList<Cliente>();
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public ArrayList<Cliente> getComum() {
		return comum;
	}
	
	public void setComum(ArrayList<Cliente> comum) {
		this.comum = comum;
	}
	
	public ArrayList<Cliente> getPreferencial() {
		return preferencial;
	}
	
	public void setPreferencial(ArrayList<Cliente> preferencial) {
		this.preferencial = preferencial;
	}
	
	public void insertClient() {
		String name;
		Integer hour;
		Integer minutes;
		Integer age;
		String service;
		
		Scanner input = new Scanner(System.in);
		
		Cliente cliente = new Cliente();
		
		System.out.println("\nInsira o nome do cliente");
		name = input.next();
		System.out.println("\nInsira a idade do cliente");
		age = input.nextInt();
		System.out.println("\nInsira o serviço do cliente");
		service = input.next();
		LocalDateTime now = LocalDateTime.now();
		hour = now.getHour();
		minutes = now.getMinute();
        
		//create a new client with the passed parameters 
        cliente.setNome(name);
        cliente.setServico(service);
        cliente.setHoras(hour);
        cliente.setMinutos(minutes);
        cliente.setIdade(age);
        
        
        //if the client is younger than 65, goes to an preferred line, else, goes to an normal line
        if(age < 65) {
        	this.comum.add(cliente);
        }else {
        	this.preferencial.add(cliente);
        }
        
	}
	
	public void giveUp() {
		String name;
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("\nInsira o nome do cliente");
		name = input.next();
		int comparador = 0;
		
		//search the client first at the normal line
		for(Cliente clienteComum : this.comum) {					
			if(clienteComum.getNome().equals(name)) {
				this.comum.remove(clienteComum);
				comparador = 1;
				break;
			}
		}
		
		//then search the client at the preferred line
		if(comparador == 0) {
			for(Cliente clientePreferencial : this.preferencial) {

				if(clientePreferencial.getNome().equals(name)) {
					this.preferencial.remove(clientePreferencial);
					comparador = 1;
					break;
				}
			}
		}
		
		if(comparador == 0) 
			System.out.println("\nNão existe cliente com esse nome");
		else 
			System.out.println("\nCliente desistiu da fila");
	}
	
	public Integer serveClient(Integer contFila) {
		//serve a customer in the preferred line if the sequence of the already served clients
		//was no more than a single client of that same line
		//else serve a customer in the normal line
		//if the lines don't have any customers, no one is served
		if(contFila < 2 && this.preferencial.size() > 0) {
			this.preferencial.remove(0);
			System.out.println("\nCliente atendido");
			contFila++;
		}else if(this.comum.size() > 0) {
			this.comum.remove(0);
			System.out.println("\nCliente atendido");
			contFila = 0;
		}else {
			System.out.println("\nAmbas as filas estão vazias");
		}
		return contFila;
	}
	
	public void getPosic() {
		String name;
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("\nInsira o nome do cliente");
		name = input.next();
		
		int comparador = 0;
		int contador = 0;
		
		//search the client first at the normal line than at the preferred
		//show your position in the queue (index + 1)
		for(Cliente cliente : this.comum) {
			contador++;
			if(cliente.getNome().equals(name)) {
				System.out.printf("\nPosição do cliente na fila comum: %d\n", contador);
				comparador = 1;
				break;
			}
		}
		
		contador = 0;
		
		if(comparador == 0) {
			for(Cliente cliente : this.preferencial) {
				contador++;
				if(cliente.getNome().equals(name)) {
					System.out.printf("\nPosição do cliente na fila preferencial: %d\n", contador);
					comparador = 1;
					break;
				}
			}
		}
		
		if(comparador == 0) 
			System.out.println("\nNão existe cliente com esse nome");
		
	}
	
	public void printLine() {
		int contador = 0;
		
		//print the lines, first the normal and than the preferred, with the name of
		//the client and your current position on the line
		if(this.comum.size() > 0) {
			System.out.println("\nFila comum:\n");
			for(Cliente clienteComum : this.comum) {
				contador++;
				System.out.printf("Cliente %s posição na fila %d\n",clienteComum.getNome(), contador);
			}
			System.out.println(" ");
		}else
			System.out.println("\nFila comum vazia");
		
		contador = 0;
		
		if(this.preferencial.size() > 0) {
			System.out.println("\nFila preferencial:\n");
			for(Cliente clientePreferencial : this.preferencial) {
				contador++;
				System.out.printf("Cliente %s posição na fila %d\n",clientePreferencial.getNome(), contador);
			}
			System.out.println(" ");
		}else
			System.out.println("\nFila preferencial vazia");
		
	}
	
}
