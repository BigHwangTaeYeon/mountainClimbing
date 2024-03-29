package side.project.publicapi.mvc.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;
import side.project.publicapi.mvc.vo.LoginVO;
import side.project.publicapi.mvc.vo.User;

import java.util.Optional;

@Repository("loginDAO")
public class LoginDAO {

    @Autowired
	private SqlSessionTemplate sqlSession;
	
	public Optional<User> save(User user) {
		return sqlSession.selectOne("loginDAO.loginInsert", user);
	}

	public Optional<User> findByEmailAndOauthType(User user) {
		return sqlSession.selectOne("loginDAO.findByEmailAndOauthType", user);
	}

	public User getLoginInfo(String id) {
		return sqlSession.selectOne("loginDAO.loginCheck", id);
	}

	public int loginCheck(LoginVO vo) throws Exception{
		Object result = sqlSession.selectOne("loginDAO.loginCheck", vo);
		if(ObjectUtils.isEmpty(result))
			return 0;
		else
			return 1;
	}

	public void loginInsert(LoginVO vo) throws Exception{
		sqlSession.insert("loginDAO.loginInsert", vo);
	}

	public String getLoginId(LoginVO vo) throws Exception{
		LoginVO getId = sqlSession.selectOne("loginDAO.loginCheck", vo);
		return getId.getId();
	}

	public LoginVO getLoginInfo(LoginVO vo) throws Exception{
		return sqlSession.selectOne("loginDAO.loginCheck", vo);
	}

	public User selectUserById(String loginId) throws Exception{
		return sqlSession.selectOne("loginDAO.selectUserById", loginId);
	}

}
