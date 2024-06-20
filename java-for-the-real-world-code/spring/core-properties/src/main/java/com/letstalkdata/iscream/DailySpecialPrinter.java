package com.letstalkdata.iscream;

import com.letstalkdata.iscream.service.DailySpecialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DailySpecialPrinter {

    private DailySpecialService dailySpecialService;

    @Autowired
    public DailySpecialPrinter(DailySpecialService dailySpecialService) {
        this.dailySpecialService = dailySpecialService;
    }

    public void printSpecials() {
        List<String> dailySpecials = dailySpecialService.getSpecials();

        System.out.println("Today's specials are:");
        dailySpecials.forEach(s -> System.out.println(" - " + s));
    }
}
