package side.project.publicapi.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import side.project.publicapi.vo.CultureApiVO;

@Repository("cultureApiDAO")
public class CultureApiDAO {

    @Autowired
	private SqlSessionTemplate sqlSession;

    // pSeqCheck
	public int seqCheck(String seq) throws Exception{
		// return sqlSession.selectOne("cultureApiDAO.seqCheck", seq);
		if(sqlSession.selectOne("cultureApiDAO.seqCheck", seq) != null)
			return 1;
		else
			return 0;
	}

	public void cutureInsert(CultureApiVO vo) throws Exception{
		sqlSession.insert("cultureApiDAO.cutureInsert", vo);
	}

}
