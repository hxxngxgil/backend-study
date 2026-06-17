package collection.set.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SetOperationsTest {

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(List.of(1, 2, 3, 4, 5));
        Set<Integer> set2 = new HashSet<>(List.of(3, 4, 5, 6, 7));

        Set<Integer> union = new TreeSet<>();
        union.addAll(set1);
        union.addAll(set2);
        System.out.println("합집합: " + union);

        Set<Integer> intersection = new TreeSet<>(set1);
        intersection.retainAll(set2);
        System.out.println("교집합: " + intersection);

        Set<Integer> difference = new TreeSet<>(set1);
        difference.removeAll(set2);
        System.out.println("차집합: " + difference);
    }
}
