import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        LinkedListMap<String,Integer> map = new LinkedListMap<>();
        ArrayList<String> arrayList = new ArrayList<>();
        FileOperation.readFile("Map/pride-and-prejudice.txt",arrayList);
        System.out.println("Pride and Prejudice:");
        System.out.println("Total words:"+arrayList.size());
        for (String word:arrayList) {
            if (!map.contains(word)){
                map.add(word,1);
            }else {
                map.set(word,map.get(word)+1);
            }
        }
        System.out.println("Total different words:"+map.getSize());
        System.out.println("pride:"+map.get("pride"));
        System.out.println("prejudice:"+map.get("prejudice"));
        System.out.println("argument:"+map.get("argument"));
    }
}
