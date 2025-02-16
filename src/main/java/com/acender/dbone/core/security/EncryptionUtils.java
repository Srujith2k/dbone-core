package com.acender.dbone.core.security;

import com.acender.dbone.core.utils.ConfigUtils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

/**
 * Utility class for encrypting and decrypting database credentials.
 */
public class EncryptionUtils {

    private static final String ALGORITHM = "AES";
    private static final String ENV_KEY = "DB_ENCRYPTION_KEY";  // Environment variable key
    private static final byte[] SECRET_KEY = getSecretKey();  // Fetch from environment

    /**
     * Retrieves the encryption key from environment variables or falls back to a default.
     * @return The encryption key as a byte array.
     */
    private static byte[] getSecretKey() {
        String key = ConfigUtils.getEnv(ENV_KEY, "DefaultSecretKey123"); // Default fallback (must be 16 bytes)

        if ("DefaultSecretKey123".equals(key)) {
            System.err.println("WARNING: Using the default encryption key! Set 'DB_ENCRYPTION_KEY' for security.");
        }

        return key.getBytes();
    }

    /**
     * Encrypts a given string using AES.
     * @param plainText The text to encrypt.
     * @return Encrypted string.
     * @throws Exception If encryption fails.
     */
    public static String encrypt(String plainText) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        SecretKey key = new SecretKeySpec(SECRET_KEY, ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    /**
     * Decrypts an encrypted string using AES.
     * @param encryptedText The text to decrypt.
     * @return Decrypted string.
     * @throws Exception If decryption fails.
     */
    public static String decrypt(String encryptedText) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        SecretKey key = new SecretKeySpec(SECRET_KEY, ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
        return new String(decryptedBytes);
    }
}
