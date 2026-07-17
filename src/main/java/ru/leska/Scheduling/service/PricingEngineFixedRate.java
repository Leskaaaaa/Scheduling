package ru.leska.Scheduling.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.logging.Logger;

@Service
public class PricingEngineFixedRate {
    static final Logger LOGGER = Logger.getLogger(PricingEngineFixedRate.class.getName());

    /**
     * fixedRate - следует использовать, если методы должны вызываться независимо.
     * Async нужен для того, чтобы запускать выполнение метода в другом потоке. Если мы уберем аннотацию, то планировщик
     *      будет ждать выполнение предыдущего метода.
     *
     * initialDelay + fixedRate - вместе эти параметры работают так, что initialDelay выполняет роль отсрочки. То есть
     *      вызов метода начинается не сразу после инициализации контекста.
     */
    @Scheduled(initialDelay = 2000, fixedRate = 2000)
    @Async
    public void refreshPricingParameters() throws InterruptedException {
        LOGGER.info("Fixed Rate: computing price at " + LocalDateTime.now().toEpochSecond(ZoneOffset.UTC));
        Thread.sleep(4000);
    }

}