package sprint11.exe2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/dogs")
public class DogsInteractionController {
    // добавьте поле owner
    private String owner;
    private int happiness = 0;

    // добавьте эндпоинт POST /owner с параметром newOwner
    // метод должен называться setOwner
    @PostMapping("/owner")
    public Map<String, String> setOwner(@RequestParam final String newOwner) {
        if (newOwner==null){
            throw new IncorrectParameterException("Параметр newOwner равен null.");
        }
        owner = newOwner;
        return Map.of("owner", newOwner);
    }
    @GetMapping("/converse")
    public Map<String, String> converse() {
        checkHappiness();
        happiness += 2;
        return Map.of("talk", "Гав!");
    }

    @GetMapping("/happiness")
    public Map<String, Integer> happiness() {
        return Map.of("happiness", happiness);
    }

    @PutMapping("/pet")
    public Map<String, String> pet(
        @RequestParam(required = false) final Integer count,
        @RequestParam final String user
    ) {
        // добавьте необходимые проверки
        if (owner == null) {
            throw new IncorrectParameterException("Необходимо установить параметр owner.");
        }
        if (!owner.equals(user)) {
            throw new UnauthorizedUserException(user, owner);
        }
        if (count == null) {
            throw new IncorrectParameterException("Параметр count равен null.");
        }
        if (count <= 0) {
            throw new IncorrectParameterException("Параметр count имеет отрицательное значение.");
        }

        checkHappiness();

        happiness += count;
        return Map.of("action", "Вильнул хвостом. ".repeat(count));
    }

    private void checkHappiness() {
        if (happiness > 10) {
            throw new HappinessOverflowException(happiness);
        }
    }
}
