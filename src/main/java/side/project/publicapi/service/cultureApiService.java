package side.project.publicapi.service;

import side.project.publicapi.vo.CultureApiVO;

public interface CultureApiService {
    
    // pSeqCheck
    int seqCheck(String seq) throws Exception;

    // data insert
    void cultureInsert(CultureApiVO vo) throws Exception;

}
