/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.core.utils;

import java.security.Key;
import java.security.spec.KeySpec;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.eclipse.rcptt.util.Base64;
import org.eclipse.rcptt.util.StringUtils;

public class Cryptography {
	private static final byte[] IV_PARAMETER_SPEC = new byte[]{1,2,3,4,5,6,7,8,1,2,3,4,5,6,7,8};
	private static final byte[] SALT = new byte[]{0, 0, 0, 0, 0, 0, 0, 0};
	private static final String CIPHER_MODE = "AES/CBC/PKCS5Padding";
	private static final String PROPERTY = "org.eclipse.rcptt.cryptoKey";
	private Key key;

	public Cryptography(Key key) {
		this.key = key;
		if (key == null)
			throw new NullPointerException();
	}

	public String decrypt(String input) {
		try {
			Cipher cipher = Cipher.getInstance(CIPHER_MODE);
			cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(IV_PARAMETER_SPEC));
			return new String(cipher.doFinal(Base64
					.decode(input)), "UTF-8");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public String encrypt(String input) {
		try {
			Cipher cipher = Cipher.getInstance(CIPHER_MODE);
			cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(IV_PARAMETER_SPEC));
			return Base64.encode(cipher.doFinal(input
					.getBytes("UTF-8")));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	static public final Cryptography INSTANCE = new Cryptography(
			getConfiguredKey());

	private static Key getConfiguredKey() {
		String keyString = System.getProperty(PROPERTY);
		if (StringUtils.isEmpty(keyString)) 
			keyString = "gjdlm7JIO.UOLNE/EOL<FPUWX MI<KMG2TYIL";
		try {
			SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
			KeySpec spec = new PBEKeySpec(keyString.toCharArray(), SALT, 256, 128);
			byte[] encoded = factory.generateSecret(spec).getEncoded(); 
			assert encoded.length*8 == 128;
			Key rv = new SecretKeySpec(encoded, "AES");
			//Testing key
			Cipher cipher = Cipher.getInstance(CIPHER_MODE);
			cipher.init(Cipher.DECRYPT_MODE, rv, new IvParameterSpec(IV_PARAMETER_SPEC));
			return rv;
		} catch (Exception e) {
			throw new RuntimeException("Cryptography key failure.", e);
		}

	}
}
