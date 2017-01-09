package javaBaseCourse.task5_4;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by rurik on 09.01.2017.
 */
class Animal implements Serializable {
    private final String name;

    public Animal(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Animal) {
            return Objects.equals(name, ((Animal) obj).name);
        }
        return false;
    }
}
