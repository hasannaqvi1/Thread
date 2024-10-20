public class Example1 {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        SingletonSerializable s3 = new SingletonSerializable();



        System.out.println(s1==s2);
    }
}
