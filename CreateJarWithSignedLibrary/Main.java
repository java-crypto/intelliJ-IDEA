import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.Provider;
import java.security.Security;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World - Build Jar with signed Library");
        Security.addProvider(new BouncyCastleProvider());
        Provider provider = Security.getProvider("BC");
        System.out.println("Die vorhandene BC-Version ist: " + provider.getInfo());
    }
}
