/*interface Beverage {
    String getDescription();
    double getCost();
}

class Espresso implements Beverage {
    public String getDescription() {
        return "Эспрессо";
    }

    public double getCost() {
        return 2.0;
    }
}

class Tea implements Beverage {
    public String getDescription() {
        return "Чай";
    }

    public double getCost() {
        return 1.5;
    }
}

class Latte implements Beverage {
    public String getDescription() {
        return "Латте";
    }

    public double getCost() {
        return 3.0;
    }
}

abstract class BeverageDecorator implements Beverage {
    protected Beverage beverage;

    public BeverageDecorator(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription();
    }

    public double getCost() {
        return beverage.getCost();
    }
}

class Milk extends BeverageDecorator {
    public Milk(Beverage beverage) {
        super(beverage);
    }

    public String getDescription() {
        return beverage.getDescription() + ", Молоко";
    }

    public double getCost() {
        return beverage.getCost() + 0.5;
    }
}

class Sugar extends BeverageDecorator {
    public Sugar(Beverage beverage) {
        super(beverage);
    }

    public String getDescription() {
        return beverage.getDescription() + ", Сахар";
    }

    public double getCost() {
        return beverage.getCost() + 0.2;
    }
}

class WhippedCream extends BeverageDecorator {
    public WhippedCream(Beverage beverage) {
        super(beverage);
    }

    public String getDescription() {
        return beverage.getDescription() + ", Взбитые сливки";
    }

    public double getCost() {
        return beverage.getCost() + 0.7;
    }
}

public class Modul {
    public static void main(String[] args) {
        Beverage order = new Espresso();
        order = new Milk(order);
        order = new Sugar(order);
        order = new WhippedCream(order);

        System.out.println("Описание заказа: " + order.getDescription());
        System.out.println("Общая стоимость: $" + (int) order.getCost());
    }
}*/


//2
interface IPaymentProcessor {
    void processPayment(double amount);
}
class PayPalPaymentProcessor implements IPaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Обработка платежа через PayPal: " + amount);
    }
}
class StripePaymentService {
    public void makeTransaction(double totalAmount) {
        System.out.println("Обработка платежа через Stripe: " + totalAmount);
    }
}

class StripePaymentAdapter implements IPaymentProcessor {
    private StripePaymentService stripeService;

    public StripePaymentAdapter(StripePaymentService stripeService) {
        this.stripeService = stripeService;
    }

    @Override
    public void processPayment(double amount) {
        stripeService.makeTransaction(amount);
    }
}

public class Modul {
    public static void main(String[] args) {
        // Использование PayPal
        IPaymentProcessor paypalProcessor = new PayPalPaymentProcessor();
        paypalProcessor.processPayment(100.0);

        // Использование Stripe через адаптер
        StripePaymentService stripeService = new StripePaymentService();
        IPaymentProcessor stripeAdapter = new StripePaymentAdapter(stripeService);
        stripeAdapter.processPayment(200.0);
    }
}


