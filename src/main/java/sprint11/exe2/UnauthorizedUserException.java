package sprint11.exe2;

public class UnauthorizedUserException extends RuntimeException {
    // реализуйте исключение: добавьте наследование, поля user и owner, конструктор и геттеры
    private String user;
    private String owner;

    public UnauthorizedUserException(String user, String owner) {
        super();
        this.owner = owner;
        this.user = user;
    }

    public String getUser() {
        return user;
    }

    public String getOwner() {
        return owner;
    }
}
