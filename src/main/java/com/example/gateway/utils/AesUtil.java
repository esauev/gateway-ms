package com.example.gateway.utils;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Component;

@Component
public class AesUtil {
	
	private static final String ALGORITHM = "AES";
	
    private static final String TRANSFORMATION = "AES/ECB/PKCS5Padding";
    
    public String encrypt(String data, String secretKey) throws Exception {
    	
    	Key key = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), ALGORITHM);
    	Cipher cipher = Cipher.getInstance(TRANSFORMATION);
    	cipher.init(Cipher.ENCRYPT_MODE, key);
    	byte[] encryptedBytes = cipher.doFinal(data.getBytes(StandardCharsets.UTF_8));
    	
//    	String encrypt = 
//    	System.out.println(encrypt);
    	
    	return Base64.getEncoder().encodeToString(encryptedBytes);
    }
    
    public String decrypt(String encryptedData, String secretKey) throws Exception {
    	
    	Key key = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), ALGORITHM);
    	Cipher cipher = Cipher.getInstance(TRANSFORMATION);
    	cipher.init(Cipher.DECRYPT_MODE, key);
    	byte[] decryptdBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
    	
    	return new String(decryptdBytes);
    }

}
