package side.project.publicapi.mvc.serviceImpl;

import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import side.project.publicapi.com.util.AESCryptoUtil;
import side.project.publicapi.mvc.dao.LoginDAO;
import side.project.publicapi.mvc.service.LoginService;
import side.project.publicapi.mvc.vo.LoginVO;

@Service
public class LoginServiceImpl implements LoginService {
	
    @Autowired
	private LoginDAO LoginVODao;

	public int loginCheck(LoginVO vo) throws Exception {
		return LoginVODao.loginCheck(vo);
	}

    // data insert
    public void loginInsert(LoginVO vo) throws Exception{
		// 암호화 cipherText 복호화 plainText
		// String plainText = "Hello, MadPlay!";
		// SecretKey key = AESCryptoUtil.getKey();
		// IvParameterSpec ivParameterSpec = AESCryptoUtil.getIv();
		// String specName = "AES/CBC/PKCS5Padding";
		// String encryptedText = AESCryptoUtil.encrypt(specName, key, ivParameterSpec, plainText);
		// String decryptedText = AESCryptoUtil.decrypt(specName, key, ivParameterSpec, encryptedText);

		// cipherText: vzyKxKufZmKdtSUwVKWJYg==
		// plainText: Hello, MadPlay!
		
		vo.setPw(encryption(vo.getPw()));
		LoginVODao.loginInsert(vo);
	}

	@Override
	public String getLoginId(LoginVO vo) throws Exception {
		vo.setPw(encryption(vo.getPw()));
		return LoginVODao.getLoginId(vo);
	}

	private String encryption(String pw) throws Exception{
		String plainText = pw;
		SecretKey key = AESCryptoUtil.getKey();
		IvParameterSpec ivParameterSpec = AESCryptoUtil.getIv();
		String specName = "AES/CBC/PKCS5Padding";
		String encryptedText = AESCryptoUtil.encrypt(specName, key, ivParameterSpec, plainText);
		return encryptedText;
	}
	
}
