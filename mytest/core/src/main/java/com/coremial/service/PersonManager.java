package com.coremial.service;

import com.coremial.model.Person;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: coremail
 * Date: 13-12-3
 * Time: 下午4:33
 * To change this template use File | Settings | File Templates.
 */
public interface PersonManager {
    public List<Person> findByLastName(String lastName);
}
