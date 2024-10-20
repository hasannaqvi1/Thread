
public class Singleton {
    static volatile Singleton instance;

    private Singleton(){}

    static Singleton getInstance(){
        if(instance ==  null){
            synchronized(Singleton.class){
                if(instance == null){
                  instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        Singleton s3 = new Singleton();
        System.out.println(s3.hashCode());
        System.out.println(s1.hashCode());

        if(s1==s2){
            System.out.println("Equals");
        }
    }
}