import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectionExample {

    public static void main(String[] args) {
        try {
            SingletonReflection instanceOne = SingletonReflection.getInstance();

            // Using reflection to break the Singleton
            Constructor<SingletonReflection> constructor = SingletonReflection.class.getDeclaredConstructor();
            constructor.setAccessible(true); // Bypass the private constructor

            // Attempt to create another instance using reflection
            SingletonReflection instanceTwo = constructor.newInstance();

            System.out.println("Instance One HashCode: " + instanceOne.hashCode());
            System.out.println("Instance Two HashCode: " + instanceTwo.hashCode());

        } catch (NoSuchMethodException e) {
            System.out.println("No such method: " + e.getMessage());
        } catch (InstantiationException e) {
            System.out.println("Instantiation exception: " + e.getMessage());
        } catch (IllegalAccessException e) {
            System.out.println("Illegal access: " + e.getMessage());
        } catch (InvocationTargetException e) {
            System.out.println("Invocation target exception: " + e.getMessage());
            // Extracting the actual cause of the exception
            System.out.println("Cause: " + e.getCause());
        }
    }
}