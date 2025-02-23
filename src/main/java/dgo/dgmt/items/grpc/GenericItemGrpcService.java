package dgo.dgmt.items.service;


import dgo.dgmt.items.*;
import dgo.dgmt.items.ageutils.AgtypeWrapper;
import dgo.dgmt.items.mappers.ItemMapper;
import dgo.dgmt.items.mappers.ObjectMapperUtil;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Service;


@Service
public class ItemsServiceImpl extends ItemsServiceGrpc.ItemsServiceImplBase {


    ItemMapper itemMapper;

    ObjectMapperUtil objectMapperUtils;

    public ItemsServiceImpl(ItemMapper itemMapper, ObjectMapperUtil objectMapperUtils) {
        this.itemMapper = itemMapper;
        this.objectMapperUtils = objectMapperUtils;
    }

    @Override
    public void getItems(GetItemsRequest request,
                         StreamObserver<Item> responseObserver) {

        itemMapper.findByName(AgtypeWrapper.from(request.getNameQuery()))
                .doOnNext(itemData -> {

            Item item = Item.newBuilder()
                    .setName(itemData.getProperties())
                    .setDescription(itemData.getProperties())
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
                                    .setId(String.valueOf(itemData.getId()))
                                    .setName(itemData.getProperties().getName())
                                    .setDescription(itemData.getProperties().getBrand())
                                    .build();

                            responseObserver.onNext(item);
                })
                .doOnTerminate(responseObserver::onCompleted)
                .doOnError(responseObserver::onError)
                .subscribe();

    }
}
