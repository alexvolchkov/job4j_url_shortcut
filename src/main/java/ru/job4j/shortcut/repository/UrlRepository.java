package ru.job4j.shortcut.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.job4j.shortcut.domain.Url;

import javax.transaction.Transactional;
import java.util.Optional;

public interface UrlRepository extends CrudRepository<Url, Integer> {
    Optional<Url> findByUrl(String url);

    Optional<Url> findByCode(String code);

    @Modifying
    @Transactional
    @Query(value = "update Url u set u.countStatistic = u.countStatistic+1 where u.code = :code")
    void incrementCount(@Param("code") String code);
}
