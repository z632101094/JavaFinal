package com.example.javafinal.dao;

import com.example.javafinal.bean.CalendarEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.TemporalType;
import java.util.*;

@Repository(value = "CalendarDao")
public class CalendarDao {
    public boolean scheduleTime(CalendarEntity calendarEntity) {
        boolean result = true;

        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();

        session.save(calendarEntity);

        session.getTransaction().commit();
        session.close();
        sf.close();

        return result;
    }

    public boolean unscheduleTime(CalendarEntity calendarEntity) {
        boolean result = false;

        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();

        Query q = session.createQuery("from CalendarEntity where date = :currentTime ");
        q.setParameter("currentTime",calendarEntity.getDate(), TemporalType.DATE);
        q.getResultList();
        if (q.list().size() > 0) {
            CalendarEntity retrieveCalendar = (CalendarEntity) q.list().get(0);
            if (retrieveCalendar.getName().equals(calendarEntity.getName())) {
                if (retrieveCalendar.getPassword().equals(calendarEntity.getPassword())) {
                    session.remove(retrieveCalendar);
                    result = true;
                }
            }
        }

        session.getTransaction().commit();
        session.close();
        sf.close();

        return result;
    }


    public boolean checkDuplicate(CalendarEntity calendarEntity) {
        boolean result = false;

        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();

        Query q = session.createQuery("from CalendarEntity where date = :currentTime ");
        q.setParameter("currentTime",calendarEntity.getDate(), TemporalType.DATE);
        q.getResultList();
        if (q.list().size() > 0) result = true;

        session.getTransaction().commit();
        session.close();
        sf.close();

        return result;
    }


    public List<CalendarEntity> getAllSchedule() {

        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();

        Query q = session.createQuery("from CalendarEntity");

        q.getResultList();
        List<CalendarEntity> result  = q.list();


        session.getTransaction().commit();
        session.close();
        sf.close();

        return result;
    }
}
