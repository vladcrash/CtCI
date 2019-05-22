package main.java.tasks;

import main.java.CtCILibrary.LinkedListNode;

import java.util.*;

/**
 * {3 / 8)
 * <p>
 * Created by Влад on 20.01.2019.
 */
public class ChapterTwo {
    /* ------------------------------------------------------------------------------------------------------------- */
    // 2.1
    // 10.01.2019

    public static void removeDuplicates(List<String> list) {
        Map<String, String> map = new HashMap<>();
        Iterator<String> iter = list.iterator();
        List<String> temp = new ArrayList<>();
        while (iter.hasNext()) {
            String next = iter.next();
            String v = map.get(next);
            if (v != null) {
                temp.add(next);
            } else {
                map.put(next, next);
            }
        }
        for (String s : temp)
            list.remove(s);
    }

    /* ------------------------------------------------------------------------------------------------------------- */
    // 2.1 Follow up
    // 16.01.2019

    public static void removeDuplicatesFollowUp(List<String> list) {
        boolean shouldSkip = true;
        Iterator<String> iter = list.iterator();
        while (iter.hasNext()) {
            String outer = iter.next();
            Iterator<String> innerIter = list.iterator();
            while (innerIter.hasNext()) {
                String inner = innerIter.next();
                if (outer.equals(inner))
                    if (!shouldSkip)
                        innerIter.remove();
                    else {
                        skip(innerIter);
                        shouldSkip = false;
                    }
            }
            shouldSkip = true;
        }
    }

    private static void skip(Iterator<String> iter) {
        if (iter.hasNext())
            iter.next();
    }

    /* ------------------------------------------------------------------------------------------------------------- */
    // 2.2

    /* ------------------------------------------------------------------------------------------------------------- */
    // 2.3
    // 17.04.2019

    public static void deleteMiddleNode(LinkedListNode node) {
        if (node == null || node.next == null)
            return;

        LinkedListNode next = node.next;
        node.data = next.data;
        node.next = next.next;
    }
}
