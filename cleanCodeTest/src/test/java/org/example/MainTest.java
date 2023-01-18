package org.example;

import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.core.ConsoleAppender;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    public void testLogCreate() {
        Logger logger = Logger.getLogger("MyLogger");
        logger.info("hello");
    }

    @Test
    public void testLogCreateWithConsoleAppender() {
        Logger logger = Logger.getLogger("MyLogger");
        ConsoleAppender appender = new ConsoleAppender();
        // logger.addAppender(appender);  해당 메서드를 더 이상 지원하지 않는다고 한다.
        logger.info("hello");
    }

    @Test
    public void testLogCreateWithConsoleAppenderAndPatternLayout() {
        Logger logger = Logger.getLogger("MyLogger");
        // 아래 주석 코드가 오류가 난다..
//        logger.removeAllApenders();
//        logger.addAppender(new ConsoleAppender(
//                new PatternLayout("%p %t %m%n"),
//                ConsoleAppender.SYSTEM_OUT)
//        );
        logger.info("hello");
    }
}