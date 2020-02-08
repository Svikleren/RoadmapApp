package lv.svikleren.roadmapapp.repository;

import lv.svikleren.roadmapapp.model.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {
}
