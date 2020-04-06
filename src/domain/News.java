package domain;

import java.util.Date;
import java.util.List;

public class News {
    private Integer id;
    private String title;
    private String content;
    private Date DateOfPoste; //LocalDateTime ?
    private List<String> tags;
    //private String journalisteName;
    private Integer journalisteId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDateOfPoste() {
        return DateOfPoste;
    }

    public void setDateOfPoste(Date dateOfPoste) {
        this.DateOfPoste = dateOfPoste;
    }

    public Integer getJournalisteId() {
        return journalisteId;
    }

    public void setJournalisteId(Integer journalisteId) {
        this.journalisteId = journalisteId;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", DateOfPoste='" + DateOfPoste + '\'' +
                ", journalisteId='" + journalisteId + '\'' +
                '}';
    }
}
