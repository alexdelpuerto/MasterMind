package models;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private SecretKey secretKey;
    private List<SecretKey> userCodes;

    public Board() {
        this.userCodes = new ArrayList<>();
    }

    public void generateSecret() {
        this.secretKey = new SecretKey();
        this.secretKey.generateRandomKey();
    }

    public int deadNumber() {
        int deadCounter = 0;
        for (int i = 0; i < SecretKey.NUM_TOKENS; i++) {

            if (this.secretKey.getSecretKey()[i] == this.userCodes.get(this.userCodes.size() - 1).getSecretKey()[i]) {
                deadCounter++;
            }
        }
        return deadCounter;
    }

    public int injuredNumber() {
        int injuredCounter = 0;
        boolean[] checkedUserCodeNodes = new boolean[SecretKey.NUM_TOKENS];
        boolean[] checkedSecretKeyNodes = new boolean[SecretKey.NUM_TOKENS];
        for (int i = 0; i < SecretKey.NUM_TOKENS; i++) {
            for (int j = 0; j < SecretKey.NUM_TOKENS; j++) {
                if (this.secretKey.getSecretKey()[i] == this.userCodes.get(this.userCodes.size() - 1).getSecretKey()[j] && !checkedSecretKeyNodes[i] && !checkedUserCodeNodes[j]) {
                    injuredCounter++;
                    checkedSecretKeyNodes[i] = true;
                    checkedUserCodeNodes[j] = true;
                }
            }
        }
        return injuredCounter;
    }

    public boolean existVictory() {
        if (this.deadNumber() == SecretKey.NUM_TOKENS) {
            return true;
        } else {
            return false;
        }
    }

    public int countAttemps() {
        return userCodes.size();
    }

    public void guess(SecretKey userCode) {
        assert userCode != null;
        this.userCodes.add(userCode);
    }

    public void clear() {
        this.userCodes.clear();
    }
}
