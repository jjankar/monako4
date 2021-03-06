package com.monaco.Database;

import com.monaco.Entities.City;
import lv.javaguru.java2.database.DBException;

import java.util.List;

/**
 * Created by maksimspuskels on 01/11/15.
 */

public interface CityDAOInterface {
    City getCityByID(Integer id) throws DBException;
    Integer getIDByCityName(String cityName) throws DBException;
}