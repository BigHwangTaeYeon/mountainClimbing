package side.project.publicapi.mvc.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import side.project.publicapi.mvc.vo.LoginVO;

@Repository("loginDAO")
public class LoginDAO {

    @Autowired
	private SqlSessionTemplate sqlSession;

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

}
