package org.firstinspires.ftc.teamcode.ftc16072.Util;

import java.util.HashMap;

public class BlackBoard {
    /**
     * creates hashmap as a storage method to reference values over various nodes
     */
    private HashMap<String,Object> map = new HashMap<>();

    /**
     * takes a key and a value and adds it to the blackboard as a pair
     * @param key - name
     * @param value
     */
    public void add(String key, Object value){
        map.put(key, value);

    }

    /**
     * gets class of an object and pairs with a key
     * returns a value related to the key that was requested
     * checks to ensure that it never returns a value without a class to go with it (class should be declared where it is called)
     * @param classOrInterface
     * @param key
     * @return
     * @param <T>
     */
    public <T> T get(Class<? extends T> classOrInterface,String key){
        Object value = map.get(key);
        if(value != null){
            if (!classOrInterface.isInstance(value)) {
                return null;
            }
        }
        return (T) value;
    }
}
