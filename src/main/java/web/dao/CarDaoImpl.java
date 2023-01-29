package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {

    @Override
    public List<Car> getSomeNumberOfCars(List<Car> cars, int numberOfCars) {
        Collections.shuffle(cars);
        List<Car> newCarList = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            newCarList.add(cars.get(i));
        }
        return newCarList;
    }
}
