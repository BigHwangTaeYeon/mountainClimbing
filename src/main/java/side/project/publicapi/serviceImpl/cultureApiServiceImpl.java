package side.project.publicapi.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import side.project.publicapi.dao.CultureApiDAO;
import side.project.publicapi.service.CultureApiService;
import side.project.publicapi.vo.CultureApiVO;

@Service
public class CultureApiServiceImpl implements CultureApiService {
	
    @Autowired
	private CultureApiDAO cultuerDao;

    // pSeqCheck
	public int seqCheck(int seq) throws Exception{
		return cultuerDao.seqCheck(seq);
	}

    // data insert
    public void cultureInsert(CultureApiVO vo) throws Exception{
		cultuerDao.cutureInsert(vo);
	}

}
