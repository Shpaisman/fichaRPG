package app.main;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import app.dao.PersonagensDAO;
import app.model.Personagem;

public class Main {
    private PersonagensDAO personagensDAO;
    private List<Personagem> personagensList;

    public Main() {
        personagensList = new ArrayList<>();
    }

    static Scanner sc = new Scanner(System.in);

    public void run() {
        do {
            menu();
            int opt = sc.nextInt();
            int id;
            Personagem resultPersonagem;
            switch (opt) {
                case 1:
                    String nome, raca, profissao;
                    int mana, ataque, ataqueMagico, defesa, defesaMagica, velocidade, destreza, xp, lvl;
                    System.out.println("Informe: ");
                    System.out.println("Nome: ");
                    nome = sc.next();
                    System.out.println("Raça: ");
                    raca = sc.next();
                    System.out.println("Profissão: ");
                    profissao = sc.next();
                    System.out.println("Mana: ");
                    mana = sc.nextInt();
                    System.out.println("Ataque: ");
                    ataque = sc.nextInt();
                    System.out.println("Ataque Magico: ");
                    ataqueMagico = sc.nextInt();
                    System.out.println("Defesa: ");
                    defesa = sc.nextInt();
                    System.out.println("Defesa Magica: ");
                    defesaMagica = sc.nextInt();
                    System.out.println("Velocidade: ");
                    velocidade = sc.nextInt();
                    System.out.println("Destreza: ");
                    destreza = sc.nextInt();
                    System.out.println("Experciência: ");
                    xp = sc.nextInt();
                    System.out.println("Level: ");
                    lvl = sc.nextInt();

                    Personagem personagem = new Personagem(nome, raca, profissao, mana, ataque, ataqueMagico, defesa,
                            defesaMagica, velocidade, destreza, xp, lvl);

                    PersonagensDAO.getInstance().insertPersonagem(personagem);
                    break;
                case 2:

                    System.out.println("Informe o ID:");
                    id = sc.nextInt();
                    resultPersonagem = PersonagensDAO.getInstance().getPersonagem(id);
                    if (resultPersonagem == null)
                        System.out.println("Usuario nao cadastrado");
                    else {
                        System.out.println("ID: " + resultPersonagem.id);
                        System.out.println("Nome: " + resultPersonagem.nome);
                        System.out.println("Raça: " + resultPersonagem.raca);
                        System.out.println("Profissão: " + resultPersonagem.profissao);
                        System.out.println("Mana: " + resultPersonagem.mana);
                        System.out.println("Ataque: " + resultPersonagem.ataque);
                        System.out.println("Ataque Magico: " + resultPersonagem.ataqueMagico);
                        System.out.println("Defesa: " + resultPersonagem.defesa);
                        System.out.println("Defesa Magica: " + resultPersonagem.defesaMagica);
                        System.out.println("Velocidade: " + resultPersonagem.velocidade);
                        System.out.println("Destreza: " + resultPersonagem.destreza);
                        System.out.println("Experciência: " + resultPersonagem.xp);
                        System.out.println("Level: " + resultPersonagem.lvl);

                        System.out.println("Qual campo atualizar:");

                        System.out.println("1 - Nome");
                        System.out.println("2 - raca");
                        System.out.println("3 - profissao");
                        System.out.println("4 - mana");
                        System.out.println("5 - ataque");
                        System.out.println("6 - ataque magico");
                        System.out.println("7 - defesa");
                        System.out.println("8 - defesa magica");
                        System.out.println("9 - velocidade");
                        System.out.println("10 - destreza");
                        System.out.println("11 - xp");
                        System.out.println("12 - lvl");

                        opt = sc.nextInt();

                        System.out.println("Novo Valor:");
                        String temp = sc.next();

                        switch (opt) {

                            case 1:
                                resultPersonagem.nome = temp;
                                break;

                            case 2:
                                resultPersonagem.raca = temp;
                                break;
                            case 3:
                                resultPersonagem.profissao = temp;
                                break;
                            case 4:
                                resultPersonagem.mana = Integer.parseInt(temp);
                                break;
                            case 5:
                                resultPersonagem.ataque = Integer.parseInt(temp);
                                break;
                            case 6:
                                resultPersonagem.ataqueMagico = Integer.parseInt(temp);
                                break;
                            case 7:
                                resultPersonagem.defesa = Integer.parseInt(temp);
                                break;
                            case 8:
                                resultPersonagem.defesaMagica = Integer.parseInt(temp);
                                break;
                            case 9:
                                resultPersonagem.velocidade = Integer.parseInt(temp);
                                break;
                            case 10:
                                resultPersonagem.destreza = Integer.parseInt(temp);
                                break;
                            case 11:
                                resultPersonagem.xp = Integer.parseInt(temp);
                                break;
                            case 12:
                                resultPersonagem.lvl = Integer.parseInt(temp);
                                break;

                        }
                        PersonagensDAO.getInstance().updatePersonagemById(resultPersonagem);
                    }

                    break;

                case 3:
                    personagensList = PersonagensDAO.getInstance().getAllPersonagens();
                    for (Personagem p : personagensList) {
                        System.out.println("ID: " + p.id);
                        System.out.println("Nome: " + p.nome);
                        System.out.println("Raça: " + p.raca);
                        System.out.println("Profissão: " + p.profissao);
                        System.out.println("Mana: " + p.mana);
                        System.out.println("Ataque: " + p.ataque);
                        System.out.println("Ataque Magico: " + p.ataqueMagico);
                        System.out.println("Defesa: " + p.defesa);
                        System.out.println("Defesa Magica: " + p.defesaMagica);
                        System.out.println("Velocidade: " + p.velocidade);
                        System.out.println("Destreza: " + p.destreza);
                        System.out.println("Experciência: " + p.xp);
                        System.out.println("Level: " + p.lvl);
                        System.out.println("");

                    }
                    break;
                case 4:
                    System.out.println("Id para deletar:");
                    id = sc.nextInt();
                    PersonagensDAO.getInstance().deletePersonagemById(id);
                    break;
                    
                default:
                    break;
            }
        } while (true);

    }

    public void menu() {
        System.out.println("1. Criar personagem");
        System.out.println("2. Alterar personagem existente");
        System.out.println("3. Consultar os personagens existentes");
        System.out.println("4. Deletar personagem");
    }

}
