import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Stud {

    String name;
    int age;

    public Stud(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args) {
        Stud s4 = new Stud("Kishan", 12);
        Stud s5 = new Stud("Raman", 13);
        Stud s3 = new Stud("Vinay", 15);

        List<Stud> list = new ArrayList<>();
        list.add(s4);
        list.add(s5);
        list.add(s3);

        List<String> names = Arrays.asList("alice","Aliceee","Aliiii", "Bob", "Charlie", "David");

//        List<String> ll = names.stream().filter(s->s.length()>5).filter(s->s.startWith('A'))
//                .map(s-> s.charAt(0).toUpperCase())
//                .collect(Collectors.toList());

        List<String> lll3 =names.stream().filter(s->s.length()>5)
                .filter(s->s.startsWith("A"))

                .map(s->s.substring(0).toUpperCase())
                .collect(Collectors.toList());

        //s->s+""

        System.out.println(lll3);

    }
}
