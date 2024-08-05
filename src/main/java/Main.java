import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Add addition = (a, b) -> a + b;
        System.out.println(addition.add(10, 20));
        Subt subtract = (a, b) -> a - b;
        System.out.println(subtract.subt(52, 17));
        Multi multiply = (a, b) -> a * b;
        System.out.println(multiply.multi(3, 40));
        Div division = (a, b) -> a / b;
        System.out.println(division.div(30, 10));
        System.out.println("-----------------");

        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(10);
        list.add(7);
        list.add(12);
        list.add(3);
        list.add(52);
        list.add(3);
        list.add(3);
        System.out.println(list);

        Predicate<Integer> isThree = num -> num == 3;
        List<Integer> allThrees = list.stream()
                .filter(isThree)
                .collect(Collectors.toList());
        System.out.println(allThrees);
        System.out.println("-----------------");

        Function<List<Integer>, List<Integer>> addFive = nums ->
            nums.stream().map(n -> n + 5).collect(Collectors.toList());
        List<Integer> allFive = addFive.apply(list);
        System.out.println(allFive);
        System.out.println("------------------------");

        Consumer<Integer> newNum = num -> list.add(num);
        newNum.accept(5);
        System.out.println(list);
        System.out.println("------------------------");

        Supplier<Double> randomNum = () -> (10 * Math.random());
        System.out.println(randomNum.get());
        System.out.println("------------------------");



    }

}

@FunctionalInterface
interface Add {
    double add(double a, double b);
}
@FunctionalInterface
interface Subt {
    double subt(double a, double b);
}
@FunctionalInterface
interface Multi {
    double multi(double a, double b);
}
@FunctionalInterface
interface Div {
    double div(double a, double b);
}

