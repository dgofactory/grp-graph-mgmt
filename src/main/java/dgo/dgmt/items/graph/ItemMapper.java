package dgo.dgmt.items.graph;

import dgo.dgmt.items.Item;
import dgo.dgmt.items.ageutils.AgtypeWrapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Mapper
public interface ItemMapper {
    Flux<ItemGraph> findByName(@Param("name") AgtypeWrapper<String> name);
    Flux<ItemGraph> findAll();
    Mono<ItemGraph> createItem(@Param("item") Item item);
}
