package databases;

import java.util.*;
import java.util.stream.Collectors;

public class Collections2 {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>(5);

        for (int i = 1; i<= 5; i++)
            arrayList.add(i);

        System.out.println(arrayList);

        arrayList.remove(3);
        System.out.println(arrayList);

       // for (int i =0; i< arrayList.size(); i++)
        //    System.out.print(arrayList.get(i) + " ");
        System.out.println();
        for (int j:arrayList) {
            System.out.println(j);

        }
        System.out.println("beginning of linkedList");

        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.addFirst("J");
        list.addLast("S");
        list.add(2,"M");

        System.out.println(list);

        list.remove("B");
        list.remove(1);
        System.out.println(list);

        list.removeFirst();
        list.removeLast();
        System.out.println(list);

        for (String j:list) {
            System.out.println(j);

        }
        System.out.println("HASHSET");
        HashSet<String> hashSet = new HashSet<>();


        hashSet.add("D");
        hashSet.add("A");
        hashSet.add("B");
        hashSet.add("C");
        hashSet.add("C");

        System.out.println(hashSet);

        System.out.println("contains = "+ hashSet.contains("C"));

        hashSet.remove("A");
        //hashSet.remove(3);
        System.out.println(hashSet);

        for (String cont:hashSet ) {
            System.out.println(cont);

        }
        System.out.println("TREE SET");
        TreeSet<String> treeSet = new TreeSet<>();

        treeSet.add("B");
        treeSet.add("A");
        treeSet.add("C");
        treeSet.add("C");
        treeSet.add("Z");
        treeSet.add("H");
        System.out.println(treeSet);

        treeSet.add("james");
        treeSet.add("africa");
        treeSet.add("allysa");
        System.out.println(treeSet);

        System.out.println("map");
        HashMap<String, Integer> hashMap = new HashMap<>();

hashMap.put("a", 10);
hashMap.put("b",20);
hashMap.put("c",30);
System.out.println(hashMap.size());
System.out.println(hashMap);

if (hashMap.containsKey("a")) {
    Integer a = hashMap.get("a");
    System.out.println("value of ke: " + a);
}
        for (String key:hashMap.keySet()) {
            System.out.println("key :" + key+",value:" + hashMap.get(key));

        }
        for (Map.Entry<String,Integer> entry : hashMap.entrySet()) {
            System.out.println("key : " + entry.getKey() + ",value:-" + entry.getValue());

        }
        TreeMap<Integer,String> treeMap = new TreeMap<>();
        treeMap.put(3,"A");
        treeMap.put(1,"B");
        treeMap.put(2,"C");
        System.out.println(treeMap);

        TreeMap<String,Integer> treeMap1 = new TreeMap<>();

        treeMap1.put("C",10);
        treeMap1.put("A",300);
        treeMap1.put("B",20);
        System.out.println(treeMap1);

        for (String key: treeMap1.keySet()) {
            System.out.println("key:=" + key +",value :=" +treeMap1.get(key));

        }
        for (Map.Entry<Integer,String> entry : treeMap.entrySet()){
            System.out.println("key==" + entry.getKey() + ",value=" + entry.getValue());
        }

        Stack<String> stack = new Stack<>();
        stack.push("Uganda");
        stack.push("Kenya");
        stack.push("Nandi");
        System.out.println("stack : " + stack);

        for (String item : stack) {
            System.out.println(item);

        }

        String poppedElement = stack.pop();
        System.out.println("pooped element : " + poppedElement);

        System.out.println("now the stack is :" + stack);


String top = stack.peek();
System.out.println(top);
System.out.println(stack);

Queue<String> name = new PriorityQueue<>();

name.add("Kenya");
name.add("Angola");
name.add("Uganda");
name.add("Zambia");

System.out.println("original : " + name);

for (String item : name)
    System.out.println(item);

name.remove();
System.out.println("after remove;" + name);


String h = name.peek();
System.out.println("head :" + h);

  h = name.poll();
System.out.println("removed: " + h);
System.out.println(name);

h = name.poll();
System.out.println("removed: " + h);
System.out.println(name);

List<Integer> numberList = new ArrayList<>();
numberList.add(10);
numberList.add(20);
numberList.add(30);
numberList.add(40);

List<Integer> squareList = new ArrayList<>();
for (Integer i : numberList){
    squareList.add(i*i);
}
System.out.println(squareList);

List<Integer> square = numberList.stream().map(x-> x*x).collect(Collectors.toList());
        System.out.println("List of squared numbers: " + square);

        Set<Integer> squareSet = new HashSet<>();
        for (Integer i : numberList){
            squareSet.add(i*i);

        }
        System.out.println(squareSet);

        Set<Integer> squareSets = numberList.stream().map(x -> x*x).collect(Collectors.toSet());
        System.out.println(squareSets);

        List<String> language = new ArrayList<>();
        language.add("java");
        language.add("python ");
        language.add("C");
        language.add("javascript");
        language.add("kotlin");

        List<String> filterResult = new ArrayList<>();
        for (String item : language){
            if (item.startsWith("j"))
                filterResult.add(item);}
        System.out.println(filterResult);

        List<String>  filter = language.stream().filter(s ->s.startsWith("j")).collect(Collectors.toList());
        System.out.println(filter);

        List<String> sortedList = language.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedList);

        numberList.stream().map(x->x*x).forEach(y-> System.out.println(y));


        int sum = numberList.stream().reduce(0,(ans,i) -> ans+1);
        System.out.println(sum);
    }
}
