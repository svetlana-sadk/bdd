package persistence;
import domain.Journaliste;
import domain.News;
import domain.Tag;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NewsDao {
    public List<News> readNewsById(int id) {
        List<News> listNews = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "");
            PreparedStatement myStmt = myConn.prepareStatement(
                    "SELECT news.idNews, news.Titre, news.Contenu, news.DateDuPoste, journaliste.Name FROM news INNER JOIN journaliste ON news.idJournaliste=journaliste.idJournaliste");
            ResultSet rs = myStmt.executeQuery();

            while (rs.next()) {
                News news = new News();
                news.setId(rs.getInt("idNews"));
                news.setTitle(rs.getString("Titre"));
                news.setContent(rs.getString("Contenu"));
                news.setDateDuPoste(rs.getString("DateDuPoste"));
                news.setReporterName(rs.getString("Name"));
                listNews.add(news);
            }

            rs.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return listNews;
    }
    public List<News> readNewsByJournalistName(String name) {
        List<News> listNews = new ArrayList<>();
        Journaliste journaliste = new Journaliste();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "");
            PreparedStatement myStmt = myConn.prepareStatement(
                    "SELECT news.idNews, news.Titre, news.Contenu, news.DateDuPoste, journaliste.Name FROM news INNER JOIN journaliste ON news.idJournaliste=journaliste.idJournaliste");
            ResultSet rs = myStmt.executeQuery();

            while (rs.next()) {
                News news = new News();
                news.setId(rs.getInt("idNews"));
                news.setTitle(rs.getString("Titre"));
                news.setContent(rs.getString("Contenu"));
                news.setDateDuPoste(rs.getString("DateDuPoste"));
                news.setReporterName(rs.getString("Name"));
                listNews.add(news);
            }

            rs.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return listNews;
    }

    public List<Tag> getTagsByIdNews(int id ){
        List<Tag> listTags = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "");
            PreparedStatement myStmt = myConn.prepareStatement(
                    "SELECT distinct tag.Name FROM news JOIN tagNews ON tagNews.id_News=" + id + " JOIN tag ON tag.idTag=tagNews.id_Tag");
            ResultSet rs = myStmt.executeQuery();
            while(rs.next()){
                Tag tag = new Tag();
                tag.setName(rs.getString("Name"));
                listTags.add(tag);
            }
            rs.close();
            }
        catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
        }
        return listTags;
    }

    public void readNewsWithTags(int id){
        readNewsById(id);
        getTagsByIdNews(id);
    }
}
