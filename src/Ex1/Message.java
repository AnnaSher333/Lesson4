package Ex1;

public class Message {
    public void pin(){System.out.println("Введите пин-код");}
    public void pinErrorFirst() {
        System.out.println("Некорректный ввод! Каждый символ пин-кода должен быть цифрой от 0 до 9. \nВведите одну цифру.");
    }
    public void pinErrorSecond(){
        System.out.println("Вы 3 раза ввели некорректный pin.\nАккаунт заблокирован.\nПовторный ввод pin возможен через 10 секунд.");}
    public String pinIncorrectEx(){
        return  "Некорректный пин-код!\nПин ДОЛЖЕН состоять из 4 цифр.\nПин НЕ должен сожердать символы и буквы.\nПопробуйте задать пин повторно.";}
    public void serverConnect(){
        System.out.println("Соединение с сервером прошло успешно!");
    }
    public String serverError(){
        return  "Сервер не найден или не отвечает. Перезагрузите терминал.";
    }
    public void lock(int second){
        System.out.println("Блокировка завершится через: " + second + " секунд");
    }
    public void sumMastBe(){
        System.out.println("Сумма должна быть кратна 100 руб.\nВведите сумму кратную 100.");
    }
    public void noMoney(double sum, double balance){
        System.out.println("Ваш баланс: " + balance + "руб. Вы не можете снять " + sum +  "руб. \nВведите сумму меньше.");;
    }
    public String balanceError(){
        return "Недостаточно средств для операции. Проверьте баланс.";
    }
    public void inputError(){
        System.out.println("Вы ввели некорректный символ. Введите, пожалуйста, цифру.");
    }
    public void hello(){
        System.out.println("Добрый день! \nВставье карту. ");
    }
    public void chooseOperation(){
        System.out.println("Выберите номер операции: \n1 - Проверить баланс \n2 - Снять/внести денежные средства");
    }
    public void choosePutOrTake(){
        System.out.println("Выберите номер операции: \n1 - Снять \n2 - Внести");
    }
    public void balance(double sum){
        System.out.println("Ваш баланс: " + sum + " руб.");}
    public void typeOperation(){
        System.out.println("Вы ввели некорректный вид операции, попробуйте еще раз.:");
    }
    public void sumTake(){
        System.out.println("Введите сумму, которую хотите снять со счета: ");
    }
    public void sumPut(){
        System.out.println("Введите сумму, которую хотите внести на счет: ");
    }
    public void balanceAfterTake(double sum){
        System.out.println("Снятие наличных произведено, теперь Ваш баланс сотавляет: " + sum + "руб.");
    }
    public void balanceAfterPut(double sum){
        System.out.println("Пополнение счета произведено, теперь Ваш баланс сотавляет: " + sum + "руб.");
    }

}
