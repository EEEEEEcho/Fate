package com.thinkInJava.chapter17;

public class AssociativeArray<K,V> {
    private Object[][] pairs;
    private int index;
    public AssociativeArray(int length){
        pairs = new Object[length][2];
    }
    public void put(K key,V value){
        if (index >= pairs.length) throw new ArrayIndexOutOfBoundsException();
        pairs[index ++] = new Object[]{key,value};
    }

    @SuppressWarnings("unchecked")
    public V get(K key){
        for (int i = 0; i < index; i++) {
            if (pairs[i][0].equals(key)){
                return (V) pairs[i][1];
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < index; i++) {
            stringBuilder.append(pairs[i][0].toString());
            stringBuilder.append(" : ");
            stringBuilder.append(pairs[i][1].toString());
            if (i < index - 1){
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        AssociativeArray<String, String> associativeArray = new AssociativeArray<String, String>(6);
        associativeArray.put("sky","blue");
        associativeArray.put("grass","green");
        associativeArray.put("ocean","dancing");
        associativeArray.put("tree","tall");
        associativeArray.put("earth","brown");
        associativeArray.put("sun","warm");
        try {
            associativeArray.put("extra","object");
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Too many object");
        }
        System.out.println(associativeArray);
        System.out.println(associativeArray.get("tree"));
    }
}
