package app.utils;

import app.model.Personagem;

public class Constants {
    public static final String URL_MEU_BANCO = "jdbc:sqlite:sqlite.db";
    public static final int ID_NULO = -1;
    public static final String TABELA_PERSONAGENS = "personagens";
    public static final String SQL_INSERT_PERSONAGEM = "INSERT INTO "+ TABELA_PERSONAGENS + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);";
    public static final String getInsert(String table, int paramsCount){
        String sqlInsert = "INSERT INTO "+ table + " VALUES (";
        for (int i = 0; i < paramsCount-1; i++) {
            sqlInsert += "?,";
        }
        sqlInsert += "?);";
        return sqlInsert;
    }
    public static final String selectAll(String table){
        return "SELECT * FROM "+table+";";
    }
    public static final String selectId(String table, int id){
        return "SELECT * FROM "+table+" WHERE id="+id+";";
    }
    public static final String updatePersonagemById(String table, Personagem personagem){
        return "UPDATE "+ table + " SET nome=\"" + personagem.nome + "\"," +
                "nome=\"" + personagem.nome + "\"," +
                "raca=\"" + personagem.raca + "\"," +
                "profissao=\"" + personagem.profissao + "\"," +     
                "mana=\"" + personagem.mana + "\"," +
                "ataque=\"" + personagem.ataque + "\"," +
                "ataqueMagico=\"" + personagem.ataqueMagico + "\"," +
                "defesa=\"" + personagem.defesa + "\"," +
                "defesaMagica=\"" + personagem.defesaMagica + "\"," +
                "velocidade=\"" + personagem.velocidade + "\"," +
                "destreza=\"" + personagem.destreza + "\"," +
                "xp=\"" + personagem.xp + "\"," +
                "lvl=\"" + personagem.lvl + "\" WHERE id=" + personagem.id+";";
    }

    public static final String deletePersonagemById(String table, int id){
        return "DELETE FROM "+ table + " WHERE id=" + id+";";
    }
}
