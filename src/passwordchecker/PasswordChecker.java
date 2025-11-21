package passwordchecker;

public class PasswordChecker {

    private Integer minLength;
    private Integer maxRepeats;

    public void setMinLength(int minLength) {
        if (minLength < 0) {
            throw new IllegalArgumentException("Минимальная длина не может быть отрицательной");
        }
        this.minLength = minLength;
    }

    public void setMaxRepeats(int maxRepeats) {
        if (maxRepeats <= 0) {
            throw new IllegalArgumentException("Максимальное количество повторений должно быть > 0");
        }
        this.maxRepeats = maxRepeats;
    }

    public boolean verify(String password) {

        if (minLength == null || maxRepeats == null) {
            throw new IllegalStateException("Настройки чекера не установлены!");
        }


        if (password.length() < minLength) {
            return false;
        }


        int repeatCount = 1;
        for (int i = 1; i < password.length(); i++) {
            if (password.charAt(i) == password.charAt(i - 1)) {
                repeatCount++;
                if (repeatCount > maxRepeats) {
                    return false;
                }
            } else {
                repeatCount = 1;
            }
        }

        return true;
    }
}
