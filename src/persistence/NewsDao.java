package persistence;
import domain.News;

import java.sql.*;

public class NewsDao {
    private News news;

    private Connection myConn =  ConnectionBD.getConnection();;
    private Statement myStmt = myConn.createStatement();;
    private ResultSet rs = null;
    private String sql1 = "SELECT * FROM news";

    public NewsDao() throws SQLException {
    }

    public News readNewsById(int id) {
        try {
            rs = myStmt.executeQuery(sql1);
            if (rs.next()) {
                news = new News();
                news.setId(rs.getInt("idNews"));
                news.setTitle(rs.getString("Title"));
                news.setContent(rs.getString("Content"));
                news.setDateOfPoste(rs.getDate("DateOfPoste"));
                news.setJournalisteId(rs.getInt("idJournaliste"));
            } else {
                throw new NoDataFoundException("Not data found");
            }
            rs.close();
        } catch (SQLException | NoDataFoundException e) {
            e.printStackTrace();
        }
        return news;
    }

    // Inserting data in database
    public News createNews() {
        return  news;
    }

}
