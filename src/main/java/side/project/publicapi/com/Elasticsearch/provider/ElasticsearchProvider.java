package side.project.publicapi.com.Elasticsearch.provider;

import java.io.IOException;

import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import side.project.publicapi.mvc.vo.CultureApiVO;

@Component
public class ElasticsearchProvider implements CultureApiRepository {

    private final RestHighLevelClient restHighLevelClient;

    public ElasticsearchProvider(RestHighLevelClient restHighLevelClient) {
        this.restHighLevelClient = restHighLevelClient;
    }

    @Override
    public Flux<CultureApiVO> findAll() {

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        //searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        searchSourceBuilder.query(QueryBuilders.typeQuery("CultureApiVO"));

        return getCultureFlux(searchSourceBuilder);
    }

    @Override
    public Flux<CultureApiVO> findByTitle(String title) {
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.termQuery("title", title));

        return getCultureFlux(searchSourceBuilder);
    }

    @Override
    public Flux<CultureApiVO> matchPhraseQueryByTitle(String title) {

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        //searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        searchSourceBuilder.query(QueryBuilders.matchPhraseQuery("title", title));

        return getCultureFlux(searchSourceBuilder);
    }

    private Flux<CultureApiVO> getCultureFlux(SearchSourceBuilder searchSourceBuilder) {
        SearchRequest searchRequest = new SearchRequest("p_seq"); //index
        searchRequest.source(searchSourceBuilder);

        return Flux.<CultureApiVO>create(sink -> {
            ActionListener<SearchResponse> actionListener = new ActionListener<SearchResponse>() {
                @Override
                public void onResponse(SearchResponse searchResponse) {

                    for(SearchHit hit : searchResponse.getHits()) {
                        ObjectMapper objectMapper = new ObjectMapper();

                        try {
                            CultureApiVO Culture = objectMapper.readValue(hit.getSourceAsString(), CultureApiVO.class);
                            sink.next(Culture);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    sink.complete();
                }

                @Override
                public void onFailure(Exception e) {
                }
            };
            restHighLevelClient.searchAsync(searchRequest, RequestOptions.DEFAULT, actionListener);
        });
    }

    @Override
    public Mono<CultureApiVO> findById(String id) {
        GetRequest getRequest = new GetRequest(
                "p_seq",
                "CultureApiVO", id
                );
        return null;
    }

}