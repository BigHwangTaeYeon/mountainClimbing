package side.project.publicapi.service;

import java.util.List;

import side.project.publicapi.vo.CultureApiVO;
import side.project.publicapi.vo.Paging;

public interface CultureApiService {
    
    // pSeqCheck
    int seqCheck(int seq) throws Exception;

    // data insert
    void cultureInsert(CultureApiVO vo) throws Exception;

    List<CultureApiVO> getCultureList(Paging pg) throws Exception;

}
