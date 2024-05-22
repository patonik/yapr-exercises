package sprint11.exe2;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

    // во всех обработчиках замените формат ответа на ErrorResponse
    // добавьте коды ошибок

    @ExceptionHandler
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorResponse handleHappinessOverflow(final HappinessOverflowException e) {
        return new ErrorResponse("Осторожно, вы так избалуете питомца!", e.getHappinessLevel().toString());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleIncorrectParameter(final IncorrectParameterException e) {
        return new ErrorResponse("Ошибка с входным параметром.", "Текущий уровень счастья: " + e.getMessage());
    }

    // реализуйте обработчик UnauthorizedUserException
    @ExceptionHandler
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorResponse handleUnauthorizedUser(final UnauthorizedUserException e) {
        return new ErrorResponse("Питомец даёт себя гладить только хозяину.",
            "Владелец - " + e.getOwner() + ", а пытается погладить " + e.getUser() + ".");
    }
}
