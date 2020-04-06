package persistence;

import domain.Journaliste;

import java.sql.*;

public class JournalisteDao {
    private Journaliste journaliste;

    private Connection myConn =  ConnectionBD.getConnection();;
    private Statement myStmt = myConn.createStatement();
    private ResultSet rs = null;
    private String sql1 = "SELECT * FROM journaliste";

    public JournalisteDao() throws SQLException {
    }

    public Journaliste readJournalisteById(int id) {
        try {
            rs = myStmt.executeQuery(sql1);
            if (rs.next()) {
                journaliste = new Journaliste();
                journaliste.setId(rs.getInt("idJournaliste"));
                journaliste.setName(rs.getString("Name"));
            } else {
                throw new NoDataFoundException("Not data found");
            }
            rs.close();
        } catch (SQLException | NoDataFoundException e) {
            e.printStackTrace();
        }
        return journaliste;
    }
}
