package side.project.publicapi.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import side.project.publicapi.vo.CultureApiVO;

@Repository("cultureApiDAO")
public class CultureApiDAO {

    @Autowired
	private SqlSessionTemplate sqlSession;

    // pSeqCheck
	public int seqCheck(int p_seq) throws Exception{
		if(ObjectUtils.isEmpty((int)sqlSession.selectOne("cultureApiDAO.seqCheck", p_seq)))
			return 0;
		else
			return 1;
	}

	public void cutureInsert(CultureApiVO vo) throws Exception{
		sqlSession.insert("cultureApiDAO.cutureInsert", vo);
	}

	public List<CultureApiVO> getCultureList() throws Exception{
		return sqlSession.selectList("cultureApiDAO.getCultureList");
	}

}
