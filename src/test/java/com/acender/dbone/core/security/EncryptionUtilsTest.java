package com.acender.dbone.core.security;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for EncryptionUtils.
 */
class EncryptionUtilsTest {

    @Test
    void testEncryptionAndDecryption() throws Exception {
        String originalPassword = "mySecretPass123";
        String encrypted = EncryptionUtils.encrypt(originalPassword);
        String decrypted = EncryptionUtils.decrypt(encrypted);

        assertNotNull(encrypted);
        assertNotEquals(originalPassword, encrypted); // Ensure encryption is not plaintext
        assertEquals(originalPassword, decrypted); // Ensure correct decryption
    }

    @Test
    void testEncryptionConsistency() throws Exception {
        String password = "testPassword";
        String encrypted1 = EncryptionUtils.encrypt(password);
        String encrypted2 = EncryptionUtils.encrypt(password);

        assertEquals(encrypted1, encrypted2); // Encryption should be deterministic
    }

    @Test
    void testDecryptionWithInvalidData() {
        assertThrows(Exception.class, () -> EncryptionUtils.decrypt("invalidEncryptedData"));
    }
}