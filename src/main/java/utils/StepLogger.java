package utils;

public class StepLogger {
    private static ThreadLocal<com.aventstack.extentreports.ExtentTest> testLog = new ThreadLocal<>();

    public static void setTest(com.aventstack.extentreports.ExtentTest test) {
        testLog.set(test);
    }

    public static void log(String message) {
        testLog.get().info(message);
    }

    public static void fail(String message) {
        testLog.get().fail(message);
    }

    public static void pass(String message) {
        testLog.get().pass(message);
    }
}
