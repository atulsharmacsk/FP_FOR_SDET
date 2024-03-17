import java.util.function.Function;

@FunctionalInterface
public interface FI {
    void doSomething();

    default void doSomethingElse() {
        System.out.println("doing something else");
    }
}

class TestLambdaExpression {
    public static void main(String[] args) {
        FI fi = () -> System.out.println("doing something using lambda expression");
        fi.doSomething();
    }
}

class Demo implements FI {

    @Override
    public void doSomething() {
        System.out.println("doing something using method reference");
    }
}

class testMethodReference {
    public static void main(String[] args) {
        Demo demo = new Demo();
        FI fi = demo::doSomething;
        fi.doSomething();
    }
}

class DemoFunctionType {
    public static void main(String[] args) {
        Function<String, Integer> evalStringLength = String::length;
        System.out.println(evalStringLength.apply("testString"));

        Function<Integer, Integer> evalDoubleOfIntegers = i -> i * i;
        System.out.println(evalDoubleOfIntegers.apply(5));
    }
}