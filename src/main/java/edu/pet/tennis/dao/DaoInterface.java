package edu.pet.tennis.dao;

import java.util.List;
import java.util.Optional;

public interface DaoInterface<T> {
    Optional<T> findById(Integer id);
    void save(T entity);
    void update(T entity);
    void delete(T entity);
    List<T> findAll();
}
