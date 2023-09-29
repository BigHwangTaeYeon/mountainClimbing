package side.project.publicapi.service;

import java.util.ArrayList;
import java.util.List;

import side.project.publicapi.vo.CultureApiVO;

public interface CultureApiService {
    
    // pSeqCheck
    int seqCheck(int seq) throws Exception;

    // data insert
    void cultureInsert(CultureApiVO vo) throws Exception;

    List<CultureApiVO> getCultureList() throws Exception;

}
