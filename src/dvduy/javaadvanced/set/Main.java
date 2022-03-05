package dvduy.javaadvanced.set;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();
        Set<String> linkedHashSet = new LinkedHashSet<>();
        Set<String> treeSet = new TreeSet<>();

        hashSet.add("Java");
        hashSet.add("Spring");
        hashSet.add("Javascript");
        System.out.println("size hashSet" + hashSet.size());
        for (String element : hashSet){
            System.out.println(element);
        }
    }
}
