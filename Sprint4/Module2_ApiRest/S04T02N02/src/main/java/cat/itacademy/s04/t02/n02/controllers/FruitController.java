package cat.itacademy.s04.t02.n02.controllers;

import cat.itacademy.s04.t02.n02.model.FruitModel;
import cat.itacademy.s04.t02.n02.service.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fruta")
public class FruitController {

    @Autowired
    private FruitService fruitService;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllFruits(){
        List<FruitModel> fruitList = this.fruitService.getFruits();
        return (!fruitList.isEmpty()) ? ResponseEntity.ok(fruitList) : ResponseEntity.noContent().build();
    }

    @PostMapping("/add")
    public ResponseEntity<?> saveFruit(@RequestBody FruitModel fruit){
        FruitModel fruitObj = this.fruitService.saveFruit(fruit);
        return new ResponseEntity<>(fruitObj, HttpStatus.CREATED);
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<?> getFruitById(@PathVariable Long id){
        FruitModel fruit = fruitService.getFruitById(id);
        return getFruitById(id);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateFruitById(@RequestBody FruitModel request, Long id){
        FruitModel updatedFruit = fruitService.updateFruitById(request, id);
        return ResponseEntity.ok(updatedFruit);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        fruitService.deleteFruitById(id);
        return ResponseEntity.ok().build();
    }
}