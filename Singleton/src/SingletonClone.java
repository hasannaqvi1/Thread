public class SingletonClone implements Cloneable{

    static volatile SingletonClone instance;

    private SingletonClone(){
        if(instance!=null){
            throw new IllegalStateException("Instance is already created");
        }
    }
    static SingletonClone getInstance(){
        if(instance==null){
            synchronized (SingletonClone.class){
                if(instance == null){
                    instance = new SingletonClone();
                }
            }
        }
        return instance;
    }
//
//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        throw new CloneNotSupportedException("Cloning of this Singleton is not allowed.");
//    }

    public static void main(String[] args) {
        try {
            SingletonClone instanceOne = SingletonClone.getInstance();
            SingletonClone instanceTwo = (SingletonClone) instanceOne.clone(); // Attempting to clone

            System.out.println("Instance One HashCode: " + instanceOne.hashCode());
            System.out.println("Instance Two HashCode: " + instanceTwo.hashCode());
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage()); // This will print "Cloning of this Singleton is not allowed."
        }
    }

}
