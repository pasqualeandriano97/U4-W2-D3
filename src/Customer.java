import java.util.Random;

public class Customer {
    private Long id;
    private String name;

    private Integer tier;

    Random random = new Random();
    public Customer(String name, Integer tier) {
        this.id = random.nextLong(1, 1000000000000000000L);
        this.name = name;        this.tier = tier;

    }

    public Integer getTier() {
        return tier;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", tier=" + tier +
                '}';
    }
}
