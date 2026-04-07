class Hillstations {
    void famousfood() {
        System.out.println("Famous food of hill station");
    }

    void famousfor() {
        System.out.println("Famous for features of hill station");
    }
}

class Shimla extends Hillstations {
    @Override
    void famousfood() {
        System.out.println("Shimla Famous Food: Siddu");
    }

    @Override
    void famousfor() {
        System.out.println("Shimla Famous For: Snowfall and Colonial Architecture");
    }
}

class Mussoorie extends Hillstations {
    @Override
    void famousfood() {
        System.out.println("Mussoorie Famous Food: Hot Chocolate");
    }

    @Override
    void famousfor() {
        System.out.println("Mussoorie Famous For: Hills and Waterfalls");
    }
}

class Mahabaleshwar extends Hillstations {
    @Override
    void famousfood() {
        System.out.println("Mahabaleshwar Famous Food: Strawberries and Cream");
    }

    @Override
    void famousfor() {
        System.out.println("Mahabaleshwar Famous For: Scenic Viewpoints");
    }
}

public class lab3_2 {
    public static void main(String[] args) {

        Hillstations h;

        // Shimla
        h = new Shimla();
        h.famousfood();
        h.famousfor();

        System.out.println();

        // Mussoorie
        h = new Mussoorie();
        h.famousfood();
        h.famousfor();

        System.out.println();

        // Mahabaleshwar
        h = new Mahabaleshwar();
        h.famousfood();
        h.famousfor();
    }
}