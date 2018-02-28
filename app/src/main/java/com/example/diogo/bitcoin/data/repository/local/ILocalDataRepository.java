package com.example.diogo.bitcoin.data.repository.local;

import java.util.List;

/**
 * Created by Diogo on 2/27/2018.
 */

public interface ILocalDataRepository<T> {

    List<T> getAll();

    long insert(List<T> charts);

    int deleteAll();

}