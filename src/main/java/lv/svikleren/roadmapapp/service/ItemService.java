package lv.svikleren.roadmapapp.service;

import lombok.extern.slf4j.Slf4j;
import lv.svikleren.roadmapapp.model.Item;
import lv.svikleren.roadmapapp.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public void addItem(Item item){
        itemRepository.save(item);
        log.info("Item"+item.getName()+" added");
    }

    public void editItem(Long id){
        Optional<Item> item = itemRepository.findById(id);
    }

    public void deleteItem(){}
}
