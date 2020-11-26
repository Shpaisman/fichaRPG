package app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import app.model.Personagem;
import app.utils.Constants;

public class PersonagensDAO {
    private Connection connection;
    private static PersonagensDAO instance = null;
    public static PersonagensDAO getInstance(){
        if(instance == null)
            instance = new PersonagensDAO(Constants.URL_MEU_BANCO);
        return instance;
    }
    

    private PersonagensDAO(String myConnection) {
        try {
            connection = DriverManager.getConnection(myConnection);
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
            connection = null;
        }
    }

    public boolean insertPersonagem(Personagem personagem) {
        PreparedStatement comandoSQL;
        try {
            comandoSQL = connection.prepareStatement(Constants.getInsert(Constants.TABELA_PERSONAGENS, 13));
            comandoSQL.setString(2, personagem.nome);
            comandoSQL.setString(3, personagem.raca);
            comandoSQL.setString(4, personagem.profissao);
            comandoSQL.setInt(5, personagem.mana);
            comandoSQL.setInt(6, personagem.ataque);
            comandoSQL.setInt(7, personagem.ataqueMagico);
            comandoSQL.setInt(8, personagem.defesa);
            comandoSQL.setInt(9, personagem.defesaMagica);
            comandoSQL.setInt(10, personagem.velocidade);
            comandoSQL.setInt(11, personagem.destreza);
            comandoSQL.setInt(12, personagem.xp);
            comandoSQL.setInt(13, personagem.lvl);
            comandoSQL.setNull(1, Types.INTEGER);
            comandoSQL.executeUpdate();
            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (NullPointerException e) {
            e.printStackTrace();
            return false;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<Personagem> getAllPersonagens() {
        List<Personagem> personagensList = new ArrayList<>();
        try {
            Statement comandoSql = connection.createStatement();
            ResultSet rs = comandoSql.executeQuery(Constants.selectAll(Constants.TABELA_PERSONAGENS));
            while (rs.next()) {
                Personagem personagem = new Personagem(rs.getString("nome"), rs.getString("raca"),
                        rs.getString("profissao"), rs.getInt("mana"), rs.getInt("ataque"), rs.getInt("ataqueMagico"),
                        rs.getInt("defesa"), rs.getInt("defesaMagica"), rs.getInt("velocidade"), rs.getInt("destreza"),
                        rs.getInt("xp"), rs.getInt("lvl"));
                        
                personagem.id = rs.getInt("id");
                personagensList.add(personagem);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return personagensList;

    }

    public Personagem getPersonagem(int id){
        Personagem personagem = null;
        try {
            Statement comandoSql = connection.createStatement();
            ResultSet rs = comandoSql.executeQuery(Constants.selectId(Constants.TABELA_PERSONAGENS, id));
            while(rs.next()){
                personagem = new Personagem(rs.getString("nome"), rs.getString("raca"),
                rs.getString("profissao"), rs.getInt("mana"), rs.getInt("ataque"), rs.getInt("ataqueMagico"),
                rs.getInt("defesa"), rs.getInt("defesaMagica"), rs.getInt("velocidade"), rs.getInt("destreza"),
                rs.getInt("xp"), rs.getInt("lvl")
                );
                personagem.id = rs.getInt("id");
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return personagem;
    }

    public boolean updatePersonagemById(Personagem personagem){
        try {
            Statement comandoSql = connection.createStatement();
            comandoSql.executeUpdate(Constants.updatePersonagemById(Constants.TABELA_PERSONAGENS, personagem));
            connection.commit();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public boolean deletePersonagemById(int id){
        try {
            Statement comandoSql = connection.createStatement();
            comandoSql.executeUpdate(Constants.deletePersonagemById(Constants.TABELA_PERSONAGENS, id));
            connection.commit();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    

}
