package week2.designpatterns;

abstract class DataEncryptionTemplate {
    public void encryptData(String data) {
        String key = generateKey();
        String encryptedData = encrypt(data, key);
        System.out.println("Encrypted Data: " + encryptedData);
    }

    abstract String generateKey();

    abstract String encrypt(String data, String key);
}

class AESEncryption extends DataEncryptionTemplate {
    @Override
    String generateKey() {
        return "AES Key";
    }

    @Override
    String encrypt(String data, String key) {
        return "AES Encrypted Data";
    }
}

class DESEncryption extends DataEncryptionTemplate {
    @Override
    String generateKey() {
        return "DES Key";
    }

    @Override
    String encrypt(String data, String key) {
        return "DES Encrypted Data";
    }
}