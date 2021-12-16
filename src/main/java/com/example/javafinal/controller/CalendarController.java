package com.example.javafinal.controller;

import com.example.javafinal.bean.CalendarEntity;
import com.example.javafinal.response.ApiResult;
import com.example.javafinal.service.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "calendar")
public class CalendarController {
    @Autowired
    private CalendarService calendarService;

    @RequestMapping(value = "schedule", method = RequestMethod.POST)
    public ApiResult scheduleTime(@RequestBody CalendarEntity calendar) {
        //CalendarEntity calendar = new CalendarEntity(date,name,password);
        ApiResult apiResult = new ApiResult();
        if (!calendarService.scheduleTime(calendar)) {
            apiResult.setSuccess(false);
            apiResult.setCode(-1);
            apiResult.setMessage("Schedule fail, this date is already scheduled");
            return apiResult;
        }
        apiResult.setSuccess(true);
        apiResult.setCode(0);
        apiResult.setMessage("Schedule successfully");
        return apiResult;
    }

    @RequestMapping(value = "unschedule", method = RequestMethod.POST)
    public ApiResult unscheduleTime(@RequestBody CalendarEntity calendar) {
        ApiResult apiResult = new ApiResult();
        if (!calendarService.unscheduleTime(calendar)) {
            apiResult.setSuccess(false);
            apiResult.setCode(-1);
            apiResult.setMessage("Unschedule fail");
            return apiResult;
        }
        apiResult.setSuccess(true);
        apiResult.setCode(0);
        apiResult.setMessage("Unschedule successfully");
        return apiResult;
    }

    @RequestMapping(value = "getSchedule", method = RequestMethod.GET)
    public ApiResult getAllSchedule() {
        ApiResult apiResult = new ApiResult();
        apiResult.setData(calendarService.getAllSchedule());
        apiResult.setSuccess(true);
        apiResult.setCode(0);
        apiResult.setMessage("Retrieve success");
        System.out.println(apiResult.getData());
        return apiResult;
    }




}
