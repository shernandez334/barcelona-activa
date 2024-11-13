package cat.itacademy.s04.t02.n01.service;

import cat.itacademy.s04.t02.n01.exception.NoFruitFoundException;
import cat.itacademy.s04.t02.n01.model.FruitModel;
import cat.itacademy.s04.t02.n01.repository.FruitRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class FruitService {
    private static final Logger LOGGER = LoggerFactory.getLogger(FruitService.class);

    @Autowired
    FruitRepository fruitRepository;

    public ArrayList<FruitModel> getFruits(){
        return (ArrayList<FruitModel>) fruitRepository.findAll();
    }

    public FruitModel saveFruit(FruitModel fruit){
        return fruitRepository.save(fruit);
    }

    public FruitModel getFruitById(Long id){
        return fruitRepository.findById(id)
                .orElseThrow(() -> new NoFruitFoundException("No Fruit Found by the ID: " + id));
    }

    public FruitModel updateFruitById(FruitModel request, Long id){
        FruitModel fruit = fruitRepository.findById(id)
                .orElseThrow(() ->new NoFruitFoundException("No Fruit Found by the ID: " + id));
        fruit.setName(request.getName());
        return fruit;
    }

    public void deleteFruitById(Long id){
        if (fruitRepository.existsById(id)) {
            fruitRepository.deleteById(id);
        } else {
            throw new NoFruitFoundException("Fruit not found with ID: " + id);
        }
    }
}