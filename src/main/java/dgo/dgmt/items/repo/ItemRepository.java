package dgo.dgmt.items.repo;

import dgo.dgmt.items.Item;
import io.r2dbc.spi.Connection;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.Row;
import io.r2dbc.spi.RowMetadata;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;


@Service
public class ItemRepository {

    private final DatabaseClient databaseClient;
    private final ConnectionFactory connectionFactory;

    public ItemRepository(DatabaseClient databaseClient, ConnectionFactory connectionFactory) {
        this.databaseClient = databaseClient;
        this.connectionFactory = connectionFactory;
    }

    public Flux<Item> findByName(String name) {
        var query =
                "select * from cypher('items', $$\n" +
                "    MERGE (i:Item { name:" + " \"" + name + "\" })\n" +
                "    RETURN i \n" +
                "$$) as (item agtype);";


        return  this.databaseClient
                .sql(query)
                .fetch()
                .all()
                .map(row -> {
                    return Item.newBuilder().setName((String)row.get("name")).build();
                });

    }

    public Flux<Item> findByBatch(String name){
        var query =
                "select * from cypher('items', $$\n" +
                        "    MERGE (i:Item { name:" + " \"" + name + "\" })\n" +
                        "    RETURN i \n" +
                        "$$) as (item agtype);";

        return Flux.usingWhen(
                connectionFactory.create(),
                connection -> Flux.from(connection.createStatement(query).execute())
                        .flatMap(result -> result.map(this::mapRowToItem)),
                Connection::close
        );
    }

    private Item mapRowToItem(Row row, RowMetadata metadata) {
        return Item.newBuilder()
                .setName(row.get("item", String.class))
                .build();
    }
}
