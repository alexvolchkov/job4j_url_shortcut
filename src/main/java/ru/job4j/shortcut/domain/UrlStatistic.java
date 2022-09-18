package ru.job4j.shortcut.domain;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "url_statistic")
public class UrlStatistic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String url;
    private Timestamp date = new Timestamp(System.currentTimeMillis());

    public static UrlStatistic of(String url) {
        UrlStatistic urlStatistic = new UrlStatistic();
        urlStatistic.url = url;
        return urlStatistic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}
