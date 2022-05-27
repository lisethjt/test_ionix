package utils;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class Cifrado {

	public static String encryptForDES(String plainRut, String key)
			throws InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeySpecException,
			NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		SecureRandom secureRandom = new SecureRandom();
		DESKeySpec keySpec = new DESKeySpec(key.getBytes("UTF-8"));
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey secretKey = keyFactory.generateSecret(keySpec);
		Cipher cipher = Cipher.getInstance("DES");
		cipher.init(Cipher.ENCRYPT_MODE, secretKey, secureRandom);
		String encryptedRut = Base64.getEncoder().encodeToString(cipher.doFinal(plainRut.getBytes("UTF-8")));
		return encryptedRut;
	}
}