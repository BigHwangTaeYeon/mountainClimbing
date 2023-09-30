package side.project.publicapi.mvc.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import side.project.publicapi.mvc.vo.CultureApiVO;
import side.project.publicapi.mvc.vo.Paging;

@Repository("cultureApiDAO")
public class CultureApiDAO {

    @Autowired
	private SqlSessionTemplate sqlSession;

    // pSeqCheck
	public int seqCheck(int p_seq) throws Exception{
		Object result = sqlSession.selectOne("cultureApiDAO.seqCheck", p_seq);
		if(ObjectUtils.isEmpty(result))
			return 0;
		else
			return 1;
	}

	public void cutureInsert(CultureApiVO vo) throws Exception{
		sqlSession.insert("cultureApiDAO.cutureInsert", vo);
	}

	public List<CultureApiVO> getCultureList(Paging pg) throws Exception{
		return sqlSession.selectList("cultureApiDAO.getCultureList", pg);
	}

}
