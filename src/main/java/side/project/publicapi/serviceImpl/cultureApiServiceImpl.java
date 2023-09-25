@service
public class cultureApiServiceImpl implements cultureApiService {
    
    // pSeqCheck
	public int seqCheck(String seq) throws Exception{
		return cultureApiDAO.seqCheck(seq);
	}

    // data insert
    public void cutureInsert(cultureApiVO vo) throws Exception{
		cultureApiDAO.cutureInsert(vo);
	}

}
