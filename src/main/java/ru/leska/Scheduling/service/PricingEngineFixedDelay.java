package ru.leska.Scheduling.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.logging.Logger;

@Service
public class PricingEngineFixedDelay {

    static final Logger LOGGER = Logger.getLogger(PricingEngineFixedDelay.class.getName());

    private Double price;

    private Double getPrice() {
        return price;
    }

    // fixedDelay используем когда нужно, чтобы метод выполнялся последовательно. Сейчас метод выполняется последовательно
    // каждые 2 секунды, но Thread.sleep(4000) заставляет планировщика ждать, пока метод не выполнится до конца.
    @Scheduled(fixedDelay = 2000)
    public void computePrice() throws InterruptedException {
        LOGGER.info("computing price at " + LocalDateTime.now().toEpochSecond(ZoneOffset.UTC));

        Thread.sleep(4000);
    }

}
