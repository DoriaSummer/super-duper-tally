package tally.auth;

import java.io.FileOutputStream;
import java.io.IOException;
import java.security.*;

public class PhysicalKeyVerification {
    public static final String AUTH = "SUPERDUPER";
    private static PrivateKey privateKey, publicKey;
    private static String keyFile;

    public static void setPhysicalKey(String file) {
        keyFile = file;
    }

    public static void genKeyPair() throws NoSuchAlgorithmException, InvalidKeyException, SignatureException, IOException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("DSA");
        keyPairGenerator.initialize(2048);
        KeyPair pair = keyPairGenerator.generateKeyPair();

        // write to physical key
        privateKey = pair.getPrivate();
        Signature signature = Signature.getInstance("SHA256withDSA");
        signature.initSign(privateKey);
        signature.update(AUTH.getBytes());
        byte[] physicalKey = signature.sign();

        FileOutputStream fos = new FileOutputStream(keyFile);
        fos.write(physicalKey);
    }
}
