package other.bean;

import java.util.Comparator;

/**
 * @Auther: Yonggang Shi
 * @Date: 2020/04/13 16:54
 * @Description:
 */
public class Person implements Comparator<Person> {

    private String name;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    private Integer age ;

    @Override
    public int compare(Person o1, Person o2) {
        return 0;
    }
}
