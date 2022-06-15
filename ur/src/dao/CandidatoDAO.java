package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Candidato;


/**
 *
 * @author Israel
 */
public class CandidatoDAO extends ExecuteSQL{
    public CandidatoDAO(Connection con){
        super(con);
    }
    
    public String salvar(Candidato candidato){
        
        String sql = "INSERT INTO CANDIDATO VALUES(?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);            
            ps.setInt(1, candidato.getTFnumber());
            ps.setString(2, candidato.getTFName());
            if(ps.executeUpdate() > 0){
                return "Candidato Inserido com sucesso";
            }else{
                return "Erro ao Inserir";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
    
}
