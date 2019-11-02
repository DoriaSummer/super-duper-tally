package tally.ui;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class UITest {

    public static void main(String[] args) throws InvalidKeySpecException, NoSuchAlgorithmException {
        TallySystem.Show();
        //TallySystem.GetInstance().gotoOperationPanel();
    }
}
