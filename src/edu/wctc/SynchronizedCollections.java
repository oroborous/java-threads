package edu.wctc;

import java.util.*;

public class SynchronizedCollections {
    public static void main(String[] args) {
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        Set<String> set = Collections.synchronizedSet(new HashSet<>());
        Map<Integer, String> map = Collections.synchronizedMap(new HashMap<>());

    }
}
