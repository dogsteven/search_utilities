package com.foxsteven.search_utilities.searching;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.search.Hit;
import com.foxsteven.search_utilities.entity_loader.abstractions.StringIdentifiable;
import com.foxsteven.search_utilities.entity_loader.abstractions.StringIdentifiableEntityLoader;

import java.io.IOException;
import java.util.List;

public class ElasticsearchSearchingTemplate {
    private final ElasticsearchClient elasticsearchClient;

    private final StringIdentifiableEntityLoader entityLoader;

    public ElasticsearchSearchingTemplate(ElasticsearchClient elasticsearchClient,
                                          StringIdentifiableEntityLoader entityLoader) {
        this.elasticsearchClient = elasticsearchClient;
        this.entityLoader = entityLoader;
    }

    public <T extends StringIdentifiable> List<T> search(SearchRequest request, Class<T> entityClass) throws IOException {
        final var response = elasticsearchClient.search(request);

        final var identifiers = response.hits()
                .hits()
                .stream()
                .map(Hit::id)
                .toList();

        return entityLoader.load(identifiers, entityClass);
    }
}
