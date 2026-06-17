package collection.set.test;

import java.util.HashSet;
import java.util.Set;

public class RetangleTest {

    public static void main(String[] args) {
        Set<Rectangle> rectanleSet = new HashSet<>();
        rectanleSet.add(new Rectangle(10, 10));
        rectanleSet.add(new Rectangle(20, 20));
        rectanleSet.add(new Rectangle(20, 20)); //중복

        for (Rectangle rectangle : rectanleSet) {
            System.out.println("rectangle = " + rectangle);
        }
    }
}
