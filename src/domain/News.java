package domain;

import java.util.List;

public class News {
    private int id;
    private String title;
    private String content;
    private String dateDuPoste;
    private List<String> tags;
    private String reporterName;

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

    public String getDateDuPoste() {
        return dateDuPoste;
    }

    public void setDateDuPoste(String dateDuPoste) {
        this.dateDuPoste = dateDuPoste;
    }

    public String getReporterName() {
        return reporterName;
    }

    public void setReporterName(String reporterName) {
        this.reporterName = reporterName;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", dateDuPoste='" + dateDuPoste + '\'' +
                ", reporterName='" + reporterName + '\'' +
                '}';
    }
}
