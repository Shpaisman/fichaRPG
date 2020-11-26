package app.model;

import app.utils.Constants;

public class Personagem {

	public int id;
	public String nome;
	public String raca;
	public String profissao;
	public int mana;
	public int ataque;
	public int ataqueMagico;
	public int defesa;
	public int defesaMagica;
	public int velocidade;
	public int destreza;
	public int xp;
	public int lvl;

	public Personagem(String nome, String raca, String profissao, int mana, int ataque, int ataqueMagico,
			int defesa, int defesaMagica, int velocidade, int destreza, int xp, int lvl) {
		this.id = Constants.ID_NULO;
		this.nome = nome;
		this.raca = raca;
		this.profissao = profissao;
		this.mana = mana;
		this.ataque = ataque;
		this.ataqueMagico = ataqueMagico;
		this.defesa = defesa;
		this.defesaMagica = defesaMagica;
		this.velocidade = velocidade;
		this.destreza = destreza;
		this.xp = xp;
		this.lvl = lvl;
	}

}