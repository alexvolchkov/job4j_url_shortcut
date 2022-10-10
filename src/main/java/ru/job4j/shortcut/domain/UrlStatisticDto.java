package ru.job4j.shortcut.domain;

public class UrlStatisticDto {
    private String url;
    private long total;

    public static UrlStatisticDto of(String url, long total) {
        UrlStatisticDto urlStatisticDao = new UrlStatisticDto();
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
