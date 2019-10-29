package tally.auth;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.security.*;

public class PhysicalKeyVerification {
    public static final String AUTH = "SUPERDUPER";
    private static PublicKey publicKey;
    private static String physicalKeyFile;

    public static void setPhysicalKey(String file) {
        physicalKeyFile = file;
    }

    // This is a simulation of an off-line private key generating process.
    // The signature will be written onto a physical USB key for the delegates to access the tally system.
    public static void genKeyPair() {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("DSA");
            keyPairGenerator.initialize(2048);
            KeyPair pair = keyPairGenerator.generateKeyPair();

            // write to physical key
            PrivateKey privateKey = pair.getPrivate();
            Signature signature = Signature.getInstance("SHA256withDSA");
            signature.initSign(privateKey);
            signature.update(AUTH.getBytes());
            byte[] physicalKey = signature.sign();

            FileOutputStream fos = new FileOutputStream(physicalKeyFile);
            fos.write(physicalKey);

            // public key
            publicKey = pair.getPublic();
        } catch (NoSuchAlgorithmException | InvalidKeyException | SignatureException | IOException e) {
            e.printStackTrace();
        }
    }

    // This is a simulation of an on-line signature verification process.
    // The signature comes from a physical USB key.
    public static boolean verifySignature() {
        try {
            File sigFile = new File(physicalKeyFile);
            byte[] physicalKey = Files.readAllBytes(sigFile.toPath());

            Signature signature = Signature.getInstance("SHA256withDSA");
            signature.initVerify(publicKey);
            signature.update(AUTH.getBytes());
            return signature.verify(physicalKey);

        } catch (IOException | NoSuchAlgorithmException | InvalidKeyException | SignatureException e) {
            e.printStackTrace();
        }
        return false;
    }
}
