package ru.job4j.shortcut.domain;

public class UrlStatisticDao {
    private String url;
    private long total;

    public static UrlStatisticDao of(String url, long total) {
        UrlStatisticDao urlStatisticDao = new UrlStatisticDao();
        urlStatisticDao.url = url;
        urlStatisticDao.total = total;
        return urlStatisticDao;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
