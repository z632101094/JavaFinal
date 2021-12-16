package com.example.javafinal.service;

import com.example.javafinal.bean.CalendarEntity;
import com.example.javafinal.dao.CalendarDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CalendarService {
    @Resource
    private CalendarDao calendarDao;

    public boolean scheduleTime(CalendarEntity calendarEntity) {
        if (checkDuplicate(calendarEntity)) return false;
        return calendarDao.scheduleTime(calendarEntity);
    }

    public boolean checkDuplicate(CalendarEntity calendarEntity) {
        return calendarDao.checkDuplicate(calendarEntity);
    }

    public List<CalendarEntity> getAllSchedule() {
        return calendarDao.getAllSchedule();
    }

    public boolean unscheduleTime(CalendarEntity calendarEntity) {
        return calendarDao.unscheduleTime(calendarEntity);
    }

}
