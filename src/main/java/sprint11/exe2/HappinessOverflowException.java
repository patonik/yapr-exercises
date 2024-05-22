package sprint11.exe2;

public class HappinessOverflowException extends RuntimeException {
    private Integer happinessLevel;

    public HappinessOverflowException(Integer happinessLevel) {
        this.happinessLevel = happinessLevel;
    }

    public Integer getHappinessLevel() {
        return happinessLevel;
    }
}
