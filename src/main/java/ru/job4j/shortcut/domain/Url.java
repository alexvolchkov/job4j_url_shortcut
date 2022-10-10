package ru.job4j.shortcut.domain;

import javax.persistence.*;

@Entity
public class Url {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String url;
    private String code;
    @Column(name = "count_statistic")
    private int countStatistic;

    public int getCountStatistic() {
        return countStatistic;
    }

    public void setCountStatistic(int countStatistic) {
        this.countStatistic = countStatistic;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

}
