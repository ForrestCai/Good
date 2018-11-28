package test;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.spi.LoggerContextListener;
import ch.qos.logback.core.Context;
import ch.qos.logback.core.spi.ContextAwareBase;
import ch.qos.logback.core.spi.LifeCycle;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class LoggerStartupListener extends ContextAwareBase implements LoggerContextListener, LifeCycle {
    private static final String DEFAULT_LOG_FILE = "MYAPP";
    private boolean started = false;

    @Override
    public void start() {
        if (started) return;
        InetAddress ia = null;
        try {
            ia = InetAddress.getLocalHost();
            String host = ia.getHostName();//获取计算机主机名
            context.putProperty("APP_NAME", host);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        started = true;
    }

    @Override
    public void stop() {

    }

    @Override
    public boolean isStarted() {
        return started;
    }

    @Override
    public boolean isResetResistant() {
        return true;
    }

    @Override
    public void onStart(LoggerContext context) {
    }

    @Override
    public void onReset(LoggerContext context) {
    }

    @Override
    public void onStop(LoggerContext context) {
    }

    @Override
    public void onLevelChange(Logger logger, Level level) {
    }
}