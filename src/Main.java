import domain.Journaliste;
import domain.News;
import domain.Tag;
import persistence.JournalisteDao;
import persistence.NewsDao;
import persistence.NoDataFoundException;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        /*try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root", "");
            PreparedStatement  myStmt = myConn.prepareStatement();
            String sql = "select * from News";
            ResultSet rs = myStmt.executeQuery(sql);

            if (rs.next()) {
                // there is at least one result. Let's read the content
                var title = rs.getString("Titre");
                var idReporter = rs.getInt("idJournaliste");
                System.out.println(title + " et id jounaliste "+idReporter);
            } {
                System.exit(-1);
                // There is no results
            }

            System.out.println("-- News --");
            while (rs.next()){
               System.out.println("titre :"+rs.getString("titre"));
               System.out.println("contenu :"+rs.getString("contenu"));
            }

            //
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }*/
        try{
            JournalisteDao jdao = new JournalisteDao();
            var journaliste = jdao.readJournalisteById(1);
            System.out.println(journaliste);
        }catch (NoDataFoundException | SQLException e ){
            e.printStackTrace();
            System.exit(-1);
        }

        NewsDao ndao = new NewsDao();
        var listNews = ndao.readNewsByJournalistName("autor1");
        for (News n : listNews) {
            System.out.println(n);
        }
        Tag tag = new Tag();
        var listTags = ndao.getTagsByIdNews(1);
        for (Tag t : listTags){
            System.out.println(t);
        }
        ndao.readNewsWithTags(1);
    }
}
