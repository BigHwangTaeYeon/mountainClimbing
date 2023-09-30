package side.project.publicapi.com.Elasticsearch.provider;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import side.project.publicapi.mvc.vo.CultureApiVO;

@Service
public interface CultureApiRepository {
    
    Flux<CultureApiVO> findAll();
    Flux<CultureApiVO> findByTitle(String title);
    Flux<CultureApiVO> matchPhraseQueryByTitle(String title);
    Mono<CultureApiVO> findById(String id);
    
}
