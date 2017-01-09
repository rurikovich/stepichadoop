package javaBaseCourse.task5_4;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Objects;

/**
 * Created by rurik on 09.01.2017.
 */
public class AnimalDeserializer {

    public static Animal[] deserializeAnimalArray(byte[] data) {

        ByteArrayInputStream bis = new ByteArrayInputStream(data);
        try (ObjectInputStream oiStream = new ObjectInputStream(bis);) {
            int size = oiStream.readInt();
            Animal[] animals=new Animal[size];
            for (int i = 0; i < size; i++) {
                animals[i]=(Animal)oiStream.readObject();
            }
            return animals;
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }



    }

}
