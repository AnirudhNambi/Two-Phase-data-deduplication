package pack;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;

import sun.misc.BASE64Encoder;

public class encryption 
{
	public String encrypt(String text,SecretKey secretkey)
	{
		String plainData=null,cipherText=null;
		try
		{
			plainData=text;

			Cipher aesCipher = Cipher.getInstance("AES");//getting AES instance
			aesCipher.init(Cipher.ENCRYPT_MODE,secretkey);//initiating ciper encryption using secretkey

			byte[] byteDataToEncrypt = plainData.getBytes();
			byte[] byteCipherText = aesCipher.doFinal(byteDataToEncrypt);//encrypting data 

			cipherText = new BASE64Encoder().encode(byteCipherText);//converting encrypted data to string 
		}
		catch(Exception e)
		{
			System.out.println(e);	
		}
		return cipherText;
	}
}



