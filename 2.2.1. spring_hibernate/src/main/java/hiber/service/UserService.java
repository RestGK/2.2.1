package hiber.service;

import hiber.model.Car;
import hiber.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
    void add(User user);

    @Transactional
    void add(User user, Car car);

    List<User> listUsers();

    List<Car> listCars();

    @Transactional
    List<User> userByCar(String model, int series);

    boolean getUserByCar(String model, int series);
}
