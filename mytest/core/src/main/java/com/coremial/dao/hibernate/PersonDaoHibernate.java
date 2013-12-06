package com.coremial.dao.hibernate;

import com.coremial.dao.PersonDao;
import com.coremial.model.Person;
import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("personDao")
public class PersonDaoHibernate extends GenericDaoHibernate<Person, Long> implements PersonDao {

    public PersonDaoHibernate() {
        super(Person.class);
    }

    public List<Person> findByLastName(String lastName) {
        return getSession().createCriteria(Person.class).add(Restrictions.eq("lastName", lastName)).list();
    }

    @Override
    public List<Person> findById(long id) {
        return getSession().createCriteria(Person.class).add(Restrictions.eq("id",id)).list();
    }


}