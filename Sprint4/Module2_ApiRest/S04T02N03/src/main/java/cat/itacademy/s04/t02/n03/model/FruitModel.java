package cat.itacademy.s04.t02.n03.model;

import jakarta.persistence.*;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "fruit")
public class FruitModel {

    @Id
    private ObjectId id;

    private String name;
    private double kgAmount;

    public double getKgAmount() {
        return kgAmount;
    }

    public String getName() {
        return name;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setKgAmount(double kgAmount) {
        this.kgAmount = kgAmount;
    }
}