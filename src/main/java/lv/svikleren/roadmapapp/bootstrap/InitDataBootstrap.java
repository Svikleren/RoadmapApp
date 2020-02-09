package lv.svikleren.roadmapapp.bootstrap;

import lombok.AllArgsConstructor;
import lv.svikleren.roadmapapp.model.Person;
import lv.svikleren.roadmapapp.repository.PersonRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class InitDataBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private PersonRepository personRepository;

    private void initData() {

        Person person1 = new Person();
        person1.setName("Anna");
        person1.setSurname("Ozolina");
        person1.setGroup("friends");
        person1.setPhoneNumber("12345678");
        person1.setEmail("aaa@bbb.lv");
        person1.setComments("comment1");
        personRepository.save(person1);

        Person person2 = new Person();
        person2.setName("Janis");
        person2.setSurname("Kalnins");
        person2.setGroup("colleagues");
        person2.setPhoneNumber("87654321");
        person2.setEmail("bbb@aaa.lv");
        person2.setComments("comment2");
        personRepository.save(person2);

        Person person3 = new Person();
        person3.setName("Arvis");
        person3.setSurname("Kaulins");
        person3.setGroup("family");
        person3.setPhoneNumber("12312312");
        person3.setEmail("ccc@ddd.lv");
        person3.setComments("comment3");
        personRepository.save(person3);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}