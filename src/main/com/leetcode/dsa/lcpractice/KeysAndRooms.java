package main.com.leetcode.dsa.lcpractice;

/*There are n rooms labeled from 0 to n - 1 and all the rooms are locked except
for room 0. Your goal is to visit all the rooms. However, you cannot enter a locked
room without having its key. When you visit a room, you may find a set of distinct keys in it.
Each key has a number on it, denoting which room it unlocks, and you can take all of them
with you to unlock the other rooms. Given an array rooms where rooms[i] is the set of keys that you can
obtain if you visited room i, return true if you can visit all the rooms, or false otherwise.

https://leetcode.com/problems/keys-and-rooms/
*/

import java.util.*;
import java.util.stream.Collectors;

public class KeysAndRooms {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if(rooms.isEmpty())
            return false;

        boolean canVisitAll = false;
        List<Integer> roomKeysAvailable = new ArrayList<>();
        Set<Integer> visitedRooms = new HashSet<>();
        int currentKey;
        roomKeysAvailable.add(0);
        visitedRooms.add(0);

        while(! roomKeysAvailable.isEmpty()){
            currentKey = roomKeysAvailable.remove(0);
            for(int key : rooms.get(currentKey)){
                if(! visitedRooms.contains(key)) {
                    roomKeysAvailable.add(key);
                    visitedRooms.add(key);
                }
            }
        }

        canVisitAll = visitedRooms.size() == rooms.size();
        return canVisitAll;
    }

    public static void main(String[] args) {
        KeysAndRooms obj = new KeysAndRooms();

        List<List<Integer>> rooms = new ArrayList<>();
        List<Integer> room0 = new ArrayList<>();
        room0.add(1);
        room0.add(3);
        List<Integer> room1 = new ArrayList<>();
        room1.add(3);
        room1.add(0);
        room1.add(1);
        List<Integer> room2 = new ArrayList<>();
        room2.add(2);
        List<Integer> room3 = new ArrayList<>();
        room2.add(0);
        rooms.add(room0);
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);

        System.out.println(obj.canVisitAllRooms(rooms));
    }

}
