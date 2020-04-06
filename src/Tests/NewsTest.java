package Tests;

import domain.News;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import persistence.NewsDao;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class NewsTest {

    @Test
    public void readNewsByIdTest1() throws SQLException {
        NewsDao monDao = new NewsDao();
        News newsLue  = monDao.readNewsById(1);
        assertNotNull(newsLue);
        assertEquals(2, newsLue.getId());
    }

    @Test
    public void readNewsByIdTest2() throws SQLException {
        NewsDao monDao = new NewsDao();
        News newsLue  = monDao.readNewsById(2);
        assertNotNull(newsLue);
        assertNotEquals(3, newsLue.getId());
    }
}
