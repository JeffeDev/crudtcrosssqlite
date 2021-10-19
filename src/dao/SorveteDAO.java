package dao;

import domain.Sorvete;
import litebase.PreparedStatement;
import totalcross.sql.SQLException;
import util.DataBaseManager;

public class SorveteDAO {
	public boolean insertSorvete(Sorvete sorvete) throws SQLException, java.sql.SQLException{
		PreparedStatement ps = (PreparedStatement) 
				DataBaseManager.getConnection().prepareStatement("INSERT INTO SORVETES VALUES(?,?,?)");
		ps.setString(1, sorvete.sabor);
		ps.setDouble(2, sorvete.valor);
		ps.setDouble(3, sorvete.estoque);
		
		int inserted = ps.executeUpdate();
		ps.close();
		return inserted > 0 ? true : false;
	}
}
		
		