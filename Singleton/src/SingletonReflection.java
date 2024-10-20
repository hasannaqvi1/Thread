public class SingletonReflection {

    /*Using reflection we can access
    * private constructors therefore singleton design pattner
    * will break here*/
    static volatile SingletonReflection instance;

    private SingletonReflection(){
        if(instance!=null){
            throw new IllegalStateException("Instance already created.");
        }
    }

    static SingletonReflection getInstance(){
        if (instance == null){
            synchronized (SingletonSerializable.class){
                if(instance==null){
                    instance = new SingletonReflection();
                }
            }
        }
        return instance;
    }
}
