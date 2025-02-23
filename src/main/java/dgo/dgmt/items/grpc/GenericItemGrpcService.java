package dgo.dgmt.items.grpc;


import dgo.dgmt.items.*;
import dgo.dgmt.items.ageutils.AgtypeWrapper;
import dgo.dgmt.items.graph.ItemMapper;
import dgo.dgmt.items.graph.ObjectMapperUtil;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Service;


@Service
public class GenericItemGrpcService extends ItemsServiceGrpc.ItemsServiceImplBase {


    ItemMapper itemMapper;

    ObjectMapperUtil objectMapperUtils;

    public GenericItemGrpcService(ItemMapper itemMapper, ObjectMapperUtil objectMapperUtils) {
        this.itemMapper = itemMapper;
        this.objectMapperUtils = objectMapperUtils;
    }

    @Override
    public void getItems(GetItemsRequest request,
                         StreamObserver<Item> responseObserver) {

        itemMapper.findByName(AgtypeWrapper.from(request.getNameQuery()))
                .doOnNext(itemData -> {

            Item item = Item.newBuilder()
                  .build();
            responseObserver.onNext(item);

        }).doOnTerminate(responseObserver::onCompleted)
                .subscribe();


        //super.getItems(request, responseObserver);
    }

    @Override
    public void getAll(AllItemsRequest request,
                       StreamObserver<Item> responseObserver) {
        itemMapper.findAll()
                .doOnNext(itemData -> {

                            Item item = Item.newBuilder()
                                    .build();

                            responseObserver.onNext(item);
                })
                .doOnTerminate(responseObserver::onCompleted)
                .doOnError(responseObserver::onError)
                .subscribe();

    }
}
