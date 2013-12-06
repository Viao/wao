package com.coremial.dao;

import com.coremial.model.Person;
import org.appfuse.dao.BaseDaoTestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import java.util.List;
import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class PersonDaoTest extends BaseDaoTestCase{
    @Autowired
    private PersonDao personDao;

    @Test(expected = DataAccessException.class)
    public void testAddAndRemovePerson() throws Exception {
        Person person = new Person();
        person.setFirstName("Country");
        person.setLastName("Bry");

        person = personDao.save(person);
        flush();

        person = personDao.get(person.getId());

        assertEquals("Country", person.getFirstName());
        assertNotNull(person.getId());

        log.debug("removing person...");

        personDao.remove(person.getId());
        flush();

        // should throw DataAccessException
        personDao.get(person.getId());
    }

    @Test
    public void testFindByLastName(){
        List<Person> people = personDao.findByLastName("Raible");
        assertTrue(people.size() > 0);
    }

    @Test
    public void testFindById(){
        List<Person> people = personDao.findById(1);
        assertTrue(people.size() > 0);
    }

}
