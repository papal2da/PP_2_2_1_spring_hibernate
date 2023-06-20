package hiber.model;

import org.hibernate.annotations.GeneratorType;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

//    2. Создайте сущность Car с полями String model и int series, на которую будет ссылаться User с помощью связи one-to-one.
//3. Добавьте этот класс в настройки hibernate.
@Entity
@Table(name = "car")
public class Car {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String model;
    @Column
    private int series;
    @OneToOne(mappedBy = "car"
            , cascade = CascadeType.ALL)
    private User user;

    public User getUser() {
        return user;
    }

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public Car() {

    }

    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }
    @Override
    public String toString() {
        return "{" +
                "model='" + model + '\'' +
                ", series=" + series +
                '}';
    }

}
