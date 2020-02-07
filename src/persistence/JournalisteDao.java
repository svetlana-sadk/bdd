package persistence;

import domain.Journaliste;

import java.sql.*;

public class JournalisteDao {
    public Journaliste readJournalisteById(int id) throws SQLException, NoDataFoundException {
        Journaliste journaliste = new Journaliste();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "");
            PreparedStatement myStmt = myConn.prepareStatement("SELECT * FROM journaliste WHERE idJournaliste=" + id);
            ResultSet rs = myStmt.executeQuery();

            // exception to catch exact case of empty line in database ( we know where it can happen)
            // need to "send info" to class main
            // if/ else can be used for exceptions ( try/catch is made for this case)
            if (rs.next()) {
                journaliste.setId(rs.getInt("idJournaliste"));
                journaliste.setName(rs.getString("Name"));
                //System.out.println(journaliste);
            } else {
                throw new NoDataFoundException("Not data found");
            }
            rs.close();

        // to catch other exceptions (we don't know where they can happen)
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return journaliste;
    }
}
