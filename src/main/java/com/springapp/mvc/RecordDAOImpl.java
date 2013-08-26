package com.springapp.mvc;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;


/**
 * Created with IntelliJ IDEA.
 * User: saveln
 * Date: 8/22/13
 * Time: 3:23 PM
 * To change this template use File | Settings | File Templates.
 */

@Repository( "RecordDao" )
public class RecordDAOImpl extends HibernateDaoSupport implements RecordDAO {

    @Override
    public void addRecord(Record record) {
        getHibernateTemplate().saveOrUpdate(record);
    }

    @Override
    public List getRecords() {
        return getHibernateTemplate().find("FROM Record");
    }

    @Override
    public void shutdown()
    {
        getHibernateTemplate().getSessionFactory().openSession().createSQLQuery( "SHUTDOWN" ).executeUpdate();
    }

    @Autowired
    public void init( SessionFactory sessionFactory )
    {
        setSessionFactory( sessionFactory );
    }
}
