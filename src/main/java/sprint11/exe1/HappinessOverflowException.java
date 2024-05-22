package sprint11.exe1;

// добавьте необходимые поля, методы и наследование
public class HappinessOverflowException extends RuntimeException{
    private int happinessLevel;

    public HappinessOverflowException(String message, int hp) {
        super(message);
        happinessLevel = hp;
    }

    public int getHappinessLevel() {
        return happinessLevel;
    }

    public void setHappinessLevel(int happinessLevel) {
        this.happinessLevel = happinessLevel;
    }
}
