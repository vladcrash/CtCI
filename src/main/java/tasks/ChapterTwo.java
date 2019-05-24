package main.java.tasks;

import main.java.CtCILibrary.LinkedListNode;

import java.util.*;

/**
 * {7 / 8)
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


    /* ------------------------------------------------------------------------------------------------------------- */
    // 2.4
    // 25.04.2019

    public static LinkedListNode partition(LinkedListNode head, int p) {
        LinkedListNode first = head;
        if (head == null)
            return null;
        LinkedListNode previous = head;
        head = head.next;
        while (head != null) {
            if (head.data < p) {
                previous.next = head.next;
                head.next = first;
                first = head;
                head = previous.next;
            } else {
                previous = head;
                head = head.next;
            }
        }

        return first;
    }

    /* ------------------------------------------------------------------------------------------------------------- */
    // 2.5
    // 20.05.2019

    public static List<LinkedListNode> sumLists(LinkedListNode first, LinkedListNode second) {
        List<LinkedListNode> result = new LinkedList();
        if (first == null || second == null) {
            return result;
        }

        boolean addOne = false;
        while (first != null && second != null) {
            int value = first.data + second.data;
            if (addOne) {
                value++;
                addOne = false;
            }
            if (value >= 10)
                addOne = true;
            result.add(new LinkedListNode(value % 10));
            first = first.next;
            second = second.next;
        }

        finishList(first, result);
        finishList(second, result);

        return result;
    }

    private static void finishList(LinkedListNode head, List<LinkedListNode> result) {
        while (head != null) {
            result.add(new LinkedListNode(head.data));
            head = head.next;
        }
    }

    /* ------------------------------------------------------------------------------------------------------------- */
    // 2.5 Follow up
    // 21.05.2019

    public static List<LinkedListNode> sumListsFollowUp(LinkedListNode first, LinkedListNode second) {
        List<LinkedListNode> result = new LinkedList();
        if (first == null || second == null) {
            return result;
        }
        LinkedListNode shortList;
        LinkedListNode longList;

        int firstLength = calculateLength(first);
        int secondLength = calculateLength(second);
        int skipLength;
        if (firstLength >= secondLength) {
            shortList = second;
            longList = first;
            skipLength = firstLength - secondLength;
        } else {
            shortList = first;
            longList = second;
            skipLength = secondLength - firstLength;
        }

        LinkedListNode previous = new LinkedListNode();
        for (int i = 0; i < skipLength; i++) {
            result.add(longList);
            previous = longList;
            longList = longList.next;
        }

        while (shortList != null && longList != null) {
            int value = shortList.data + longList.data;
            if (value >= 10)
                previous.data++;
            previous = new LinkedListNode(value % 10);
            result.add(previous);
            shortList = shortList.next;
            longList = longList.next;
        }

        return result;
    }

    private static int calculateLength(LinkedListNode head) {
        LinkedListNode temp = head;
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    /* ------------------------------------------------------------------------------------------------------------- */
    // 2.6 Palindrome
    // 23.05.2019

    public static boolean isPalindrome(LinkedListNode head) {
        LinkedListNode tail = head;
        int length = 0;

        while (tail != null) {
            length++;
            if (tail.next == null) break;
            tail = tail.next;
        }

        for (int i = 0; i < length / 2; i++) {
            if (head.data != tail.data)
                return false;
            head = head.next;
            tail = tail.prev;
        }

        return true;
    }

    /* ------------------------------------------------------------------------------------------------------------- */
    // 2.7 Palindrome
    // 24.05.2019

    public static LinkedListNode isIntersected(LinkedListNode first, LinkedListNode second) {
        Set<LinkedListNode> set = new HashSet<>();
        fill(first, set);
        return find(second, set);
    }

    private static void fill(LinkedListNode first, Set<LinkedListNode> set) {
        while (first != null) {
            set.add(first);
            first = first.next;
        }
    }

    private static LinkedListNode find(LinkedListNode second, Set<LinkedListNode> set) {
        while (second != null) {
            if (set.contains(second))
                return second;
            second = second.next;
        }
        return null;
    }
}
