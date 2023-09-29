package side.project.publicapi.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import side.project.publicapi.dao.CultureApiDAO;
import side.project.publicapi.service.CultureApiService;
import side.project.publicapi.vo.CultureApiVO;
import side.project.publicapi.vo.Paging;

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
	 
	public List<CultureApiVO> getCultureList(Paging pg) throws Exception{
		return cultuerDao.getCultureList(pg);
	}

}
