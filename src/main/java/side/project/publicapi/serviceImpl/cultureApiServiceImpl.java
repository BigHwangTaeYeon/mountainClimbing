package side.project.publicapi.serviceImpl;

import org.springframework.stereotype.Service;

import side.project.publicapi.dao.CultureApiDAO;
import side.project.publicapi.service.CultureApiService;
import side.project.publicapi.vo.CultureApiVO;

@Service
public class CultureApiServiceImpl implements CultureApiService {
    
    // pSeqCheck
	public int seqCheck(String seq) throws Exception{
		return CultureApiDAO.seqCheck(seq);
	}

    // data insert
    public void cultureInsert(CultureApiVO vo) throws Exception{
		CultureApiDAO.cutureInsert(vo);
	}

}
