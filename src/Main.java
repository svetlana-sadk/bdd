import domain.Journaliste;
import domain.News;

import persistence.JournalisteDao;
import persistence.NewsDao;
import persistence.NoDataFoundException;


import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, NoDataFoundException {
        /*try{
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
        ndao.readNewsWithTags(1);*/

        NewsDao ndao = new NewsDao();
        News newsById = ndao.readNewsById(32);
        System.out.println(newsById.toString());


        JournalisteDao jDao = new JournalisteDao();
        Journaliste journaliste = jDao.readJournalisteById(1);
        System.out.println(journaliste.toString());
    }
}
