package br.uel.principal;

public class Cliente {
	private String nome;
	private String servico;
	private Integer horas;
	private Integer minutos;
	private Integer idade;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getServico() {
		return servico;
	}
	
	public void setServico(String servico) {
		this.servico = servico;
	}
	
	public Integer getHoras() {
		return horas;
	}
	
	public void setHoras(Integer horas) {
		this.horas = horas;
	}
	
	public Integer getMinutos() {
		return minutos;
	}
	
	public void setMinutos(Integer minutos) {
		this.minutos = minutos;
	}
	
	public Integer getIdade() {
		return idade;
	}
	
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	
}
