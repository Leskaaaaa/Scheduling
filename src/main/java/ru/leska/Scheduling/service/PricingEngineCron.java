package ru.leska.Scheduling.service;

import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.logging.Logger;

@Service
public class PricingEngineCron {

    static final Logger LOGGER = Logger.getLogger(PricingEngineCron.class.getName());

    /**
     * cron - планировщик запускает задачу в определенное время
     *  ┌───────────── second (0-59)
     *  │ ┌───────────── minute (0 - 59)
     *  │ │ ┌───────────── hour (0 - 23)
     *  │ │ │ ┌───────────── day of the month (1 - 31)
     *  │ │ │ │ ┌───────────── month (1 - 12) (or JAN-DEC)
     *  │ │ │ │ │ ┌───────────── day of the week (0 - 7)
     *  │ │ │ │ │ │          (or MON-SUN -- 0 or 7 is Sunday)
     *  │ │ │ │ │ │
     *  * * * * * *
     *
     * SchedulerLock - используется в случае, если у нас есть несколько сервисов, которые должны выполнять задачи
     *      по расписанию
     */
    @Scheduled(cron = "${interval-in-cron}")
    @SchedulerLock(name = "mySchedulerTask")
    public void computePrice() {
        LOGGER.info("computing price at " + LocalDateTime.now().toEpochSecond(ZoneOffset.UTC));
    }

}
