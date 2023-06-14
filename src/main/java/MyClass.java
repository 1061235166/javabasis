import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

public class MyClass {

    public void out(){
        System.out.println("myClass out");
    }

    public static void main(String[] args) {

    }
}

class MyclassInstrumentation implements ClassFileTransformer {

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {



        return new byte[0];
    }
}