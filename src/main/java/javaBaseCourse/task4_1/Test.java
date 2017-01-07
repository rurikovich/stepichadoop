package javaBaseCourse.task4_1;

/**
 * Created by User on 07.01.2017.
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName());
        anotherMethod();
    }

    private static void anotherMethod() {
        System.out.println(getCallerClassAndMethodName());
    }

    public static String getCallerClassAndMethodName() {
        try {
            throw new Exception();
        } catch (Exception e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            if (stackTrace.length > 2) {
                StackTraceElement firstSTE = stackTrace[2];
                String methodName = firstSTE.getMethodName();

                return firstSTE.getClassName() + "#" + methodName;
            }
            return null;
        }
    }
}
