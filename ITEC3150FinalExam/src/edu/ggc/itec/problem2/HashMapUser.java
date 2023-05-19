package edu.ggc.itec.problem2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;


public class HashMapUser {

    public static void main(String[] args) {
        // create instance
        String keys[] = {"Riker", "Raffi", "Jean-Luc", "Deanna", "Geordi", "Q", "Locutus", "Beverly", "Seven"};
        ArrayList <UUID> uuids = new ArrayList<>();
        uuids.add(UUID.fromString("ad2526b1-9e83-454f-bbb4-446b68022e93"));
        uuids.add(UUID.fromString("02004051-016b-4a6c-9140-534967effc11"));
        uuids.add(UUID.fromString("d0a06005-b592-4750-bdfe-f7dc2d38d544"));
        uuids.add(UUID.fromString("c1d4afe2-8dd0-425d-90bb-8a0244ed5774"));
        uuids.add(UUID.fromString("1469f88d-33ba-4e5f-afe0-a8dfd3bfeaa1"));
        uuids.add(UUID.fromString("6f8c8e52-5d94-4a3a-96e0-912fc77aeec8"));
        uuids.add(UUID.fromString("e1f73186-1b64-4621-988b-6cb38df7fc62"));
        uuids.add(UUID.fromString("9cfb98d0-cce8-41fd-bb40-0fcb66e2f5ac"));
        uuids.add(UUID.fromString("02004051-016b-4a6c-9140-534967effc7c"));


        // TODO Create a HashMap (may use java library version)
        // keys should be the key and the value should
        // be the UUID as described in the program statement
        HashMap<String, UUID> hashMap = new HashMap<>();
        for (int i = 0; i < keys.length; i++)
            hashMap.put(keys[i], uuids.get(i));

        // TODO Then print the contents of the Map, using an iterator or for loop.
        System.out.println("Hash Map User");
        for (String i : hashMap.keySet()) {
            System.out.println("Key: " + i + ", Value: " + hashMap.get(i));
        }
        System.out.println("Map contains " + hashMap.size() + " entries.");

    }

}
