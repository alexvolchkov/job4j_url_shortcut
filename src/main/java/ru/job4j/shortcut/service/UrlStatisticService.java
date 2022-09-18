package ru.job4j.shortcut.service;

import org.springframework.stereotype.Service;
import ru.job4j.shortcut.domain.UrlStatistic;
import ru.job4j.shortcut.domain.UrlStatisticDao;
import ru.job4j.shortcut.repository.UrlStatisticRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UrlStatisticService {
    private final UrlStatisticRepository urlStatistic;

    public UrlStatisticService(UrlStatisticRepository urlStatistic) {
        this.urlStatistic = urlStatistic;
    }

    public List<UrlStatisticDao> statistic() {
        List<UrlStatistic> urls = new ArrayList<>();
        urlStatistic.findAll().forEach(urls::add);
        List<UrlStatisticDao> rsl = new ArrayList<>();
        rsl.add(UrlStatisticDao.of("URL", 0));
        Map<String, Long> map =  urls.stream()
                .collect(Collectors.groupingBy(UrlStatistic::getUrl, Collectors.counting()));
        for (String s : map.keySet()) {
            rsl.add(UrlStatisticDao.of(s, map.get(s)));
        }
        return rsl;
    }

    public void save(UrlStatistic url) {
        urlStatistic.save(url);
    }
}
