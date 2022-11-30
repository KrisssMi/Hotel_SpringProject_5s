package com.example.by.minevich.services;

import java.util.List;
import java.util.Optional;

public interface GeneralService<T> {
    void delete(int id);
    Optional<T> getById(int id);
    void editItem(T item);
    void add(T item);
    int getCountRows();
    int getCountRows(String search);
    List<T> getAll();
    List<T> getPaginated(int min, int max);
    List<T> getPaginated(int min, int max, String search);
}
