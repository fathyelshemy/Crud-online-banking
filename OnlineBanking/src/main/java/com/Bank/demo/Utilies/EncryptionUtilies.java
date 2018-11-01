package com.Bank.demo.Utilies;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

@Component
public class EncryptionUtilies {
	
	public String getSHA_512EncryptedPassword(String password) {
		String encryptedPassword=DigestUtils.sha512Hex(password);
		return encryptedPassword;
	}

}
