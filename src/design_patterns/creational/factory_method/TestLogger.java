package design_patterns.creational.factory_method;

public class TestLogger {
    public static void main(String[] args) {
        LoggerFactory loggerFactory=(LoggerFactory)XMLUtil.getBean();
        Logger logger=loggerFactory.createLogger();
        logger.writeLog();
    }

}

interface Logger{
    public void writeLog();
}

interface LoggerFactory{
    public Logger createLogger();
    public Logger createLogger(String args);
    public Logger createLogger(Object obj);
}

class DatabaseLogger implements Logger{
    @Override
    public void writeLog() {
        System.out.println("Writing log to DB");
    }
}

class FileLogger implements Logger{
    @Override
    public void writeLog() {
        System.out.println("Writing log to File");
    }
}

class DatabaseLoggerFactory implements LoggerFactory{
    @Override
    public Logger createLogger() {
        return new DatabaseLogger();
    }

    @Override
    public Logger createLogger(String args) {
        return null;
    }

    @Override
    public Logger createLogger(Object obj) {
        return null;
    }
}
class FileLoggerFactory implements LoggerFactory{
    @Override
    public Logger createLogger() {
        return new FileLogger();
    }

    @Override
    public Logger createLogger(String args) {
        return null;
    }

    @Override
    public Logger createLogger(Object obj) {
        return null;
    }
}