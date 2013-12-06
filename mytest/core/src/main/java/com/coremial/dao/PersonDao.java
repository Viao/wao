package com.coremial.dao;

import com.coremial.model.Person;
import org.appfuse.dao.GenericDao;
import java.util.List;

public interface PersonDao extends GenericDao<Person, Long> {
    public List<Person> findByLastName(String lastName);
    public List<Person> findById(long id);
}

