package Service;

import Entity.Plant;
import Repository.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PlantService {
//    public Plant getPlantByName(String name) {
//        return new Plant();
//    }
    @Autowired
    PlantRepository plantRepository;
    /**
     *     Create service methods to:
     *          Save a plant
     *          Check if a plant has been delivered
     *          Find a list of plant cheaper than a specified price
     **/
    public Long save(Plant plant) {
        return (Long) plantRepository.save(plant);
    }
    public Boolean delivered(Long id) {
        // return plantRepository.deliveryCompleted(id);
        return plantRepository.existsPlantByIdAndDeliveryCompleted(id, true);
    }
    public List<Plant> findPlantsBelowPrice(BigDecimal price) {
        return plantRepository.findByPriceLessThan(price);
    }
}
