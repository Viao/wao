package com.coremial.service.impl;

/**
 * Created with IntelliJ IDEA.
 * User: coremail
 * Date: 13-12-3
 * Time: 下午4:33
 * To change this template use File | Settings | File Templates.
 */

import com.coremial.dao.PersonDao;
import com.coremial.model.Person;
import com.coremial.service.PersonManager;
import org.appfuse.service.impl.GenericManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("personManager")
public class PersonManagerImpl extends GenericManagerImpl<Person, Long> implements PersonManager {

    PersonDao personDao;

    @Autowired
    public PersonManagerImpl(PersonDao personDao) {
        super(personDao);
        this.personDao = personDao;
    }

    public List<Person> findByLastName(String lastName) {
        return personDao.findByLastName(lastName);
    }
}