package ru.job4j.shortcut.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.shortcut.domain.UrlStatistic;

public interface UrlStatisticRepository extends CrudRepository<UrlStatistic, Integer> {

}
