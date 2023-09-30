package side.project.publicapi.mvc.service;

import java.util.List;

import side.project.publicapi.mvc.vo.CultureApiVO;
import side.project.publicapi.mvc.vo.Paging;

public interface CultureApiService {
    
    // pSeqCheck
    int seqCheck(int seq) throws Exception;

    // data insert
    void cultureInsert(CultureApiVO vo) throws Exception;

    List<CultureApiVO> getCultureList(Paging pg) throws Exception;

}
