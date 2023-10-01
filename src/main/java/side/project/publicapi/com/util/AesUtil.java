package side.project.publicapi.com.util;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;

public class AesUtil {
    private static String privateKey_256 = "AES_PRIVATE_KEY_THIS_TEST_32BYTE";
  	public static String aesCBCEncode(String plainText) throws Exception {
		SecretKeySpec secretKey = new SecretKeySpec(privateKey_256.getBytes("UTF-8"), "AES");
		IvParameterSpec IV = new IvParameterSpec(privateKey_256.substring(0,16).getBytes());
		Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
		c.init(Cipher.ENCRYPT_MODE, secretKey, IV);
		byte[] encrpytionByte = c.doFinal(plainText.getBytes("UTF-8"));
		return Hex.encodeHexString(encrpytionByte);
  	}
  	public static String aesCBCDecode(String encodeText) throws Exception {
		SecretKeySpec secretKey = new SecretKeySpec(privateKey_256.getBytes("UTF-8"), "AES");
		IvParameterSpec IV = new IvParameterSpec(privateKey_256.substring(0,16).getBytes());
		Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
		c.init(Cipher.DECRYPT_MODE, secretKey, IV);
		byte[] decodeByte = Hex.decodeHex(encodeText.toCharArray());
		return new String(c.doFinal(decodeByte), "UTF-8");
  	}
}
