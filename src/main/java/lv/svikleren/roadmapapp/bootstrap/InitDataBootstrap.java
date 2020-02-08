package lv.svikleren.roadmapapp.bootstrap;

import lombok.AllArgsConstructor;
import lv.svikleren.roadmapapp.model.Item;
import lv.svikleren.roadmapapp.repository.ItemRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class InitDataBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private ItemRepository itemRepository;

    private void initData() {

        Item item1 = new Item();
        item1.setName("dators");
        item1.setCount(1);
        item1.setDescription("labais dators");
        item1.setType("notebooks");
        item1.setPrice(100.00f);
        itemRepository.save(item1);

        Item item2 = new Item();
        item2.setName("galds");
        item2.setCount(5);
        item2.setDescription("labais dators");
        item2.setType("notebooks");
        item2.setPrice(50.00f);
        itemRepository.save(item2);

        Item item3 = new Item();
        item3.setName("lampa");
        item3.setCount(3);
        item3.setDescription("labais dators");
        item3.setType("notebooks");
        item3.setPrice(24.76f);
        itemRepository.save(item3);

        Item item4 = new Item();
        item4.setName("kamera");
        item4.setCount(9);
        item4.setDescription("labais dators");
        item4.setType("notebooks");
        item4.setPrice(563.98f);
        itemRepository.save(item4);

    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
