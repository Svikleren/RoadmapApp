package lv.svikleren.roadmapapp.bootstrap;

import lombok.AllArgsConstructor;
import lv.svikleren.roadmapapp.personbuilder.PersonBuilderImpl;
import lv.svikleren.roadmapapp.repository.PersonRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class InitDataBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private PersonRepository personRepository;

    private void initData() {

        personRepository.save(new PersonBuilderImpl()
                .setName("Anna")
                .setSurname("Ozolina")
                .setGroup("friends")
                .setPhoneNumber("12345678")
                .setEmail("aaa@bbb.lv")
                .setComments("comment1")
                .build());

        personRepository.save(new PersonBuilderImpl()
                .setName("Janis")
                .setSurname("Kalnins")
                .setGroup("colleagues")
                .setPhoneNumber("87654321")
                .setEmail("bbb@aaa.lv")
                .setComments("comment2")
                .build());

        personRepository.save(new PersonBuilderImpl()
                .setName("Arvis")
                .setSurname("Kaulins")
                .setGroup("family")
                .setPhoneNumber("12312312")
                .setEmail("ccc@ddd.lv")
                .setComments("comment3")
                .build());
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}