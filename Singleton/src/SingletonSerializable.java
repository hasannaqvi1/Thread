public class SingletonSerializable {
    /*Serializable can berak the singletono pattern as at
     the of deserialization, a new instance is create
    even if the constructor is private because private
    constructor is bypassed*/

    /*This can be resolve using readResolve method*/

     volatile SingletonSerializable instance;

    private SingletonSerializable(){

    }
     SingletonSerializable getInstance(){
        if(instance==null){
            synchronized (SingletonSerializable.class){
                if(instance==null){
                    instance = new SingletonSerializable();
                }
            }
        }
        return instance;
    }
/*Java always checks if the readResolve method is present'
 at the time of deserializationi and
* if it is present then same method is returned*/
    private Object readResolve(){
        return instance;
    }

    public static void main(String[] args) {
    }
}
