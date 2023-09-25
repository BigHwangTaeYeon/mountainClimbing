
@Repository("cultureApiDAO")
public class cultureApiDAO {

    @Autowired
	private SqlSessionTemplate sqlSession;

    // pSeqCheck
	public int seqCheck(String seq) throws Exception{
		return sqlSession.selectOne("cultureApiDAO.seqCheck", seq);
	}

	public void cutureInsert(cultureApiVO vo) throws Exception{
		sqlSession.insert("cultureApiDAO.cutureInsert", vo);
	}

}
