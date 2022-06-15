package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Eleitor;


/**
 *
 * @author Israel
 */
public class EleitorDAO extends ExecuteSQL{
    public EleitorDAO(Connection con){
        super(con);
    }
    
    public String salvar(Eleitor eleitor){
        
        String sql = "INSERT INTO ELEITOR VALUES(?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);            
            ps.setInt(1, eleitor.getCpf());
            ps.setString(2, eleitor.getNome());
            if(ps.executeUpdate() > 0){
                return "Eleitor Inserido com sucesso";
            }else{
                return "Erro ao Inserir";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
    
}
