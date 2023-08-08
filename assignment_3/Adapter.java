
class Pizza {
    private final String size;
    private final boolean cheese;
    private final boolean pepperoni;
    private final boolean mushrooms;
    private final boolean onions;
    private final boolean olives;
   

    public Pizza(PizzaBuilder builder) {
        this.size = builder.size;
        this.cheese = builder.cheese;
        this.pepperoni = builder.pepperoni;
        this.mushrooms = builder.mushrooms;
        this.onions = builder.onions;
        this.olives = builder.olives;
    }

    public String getSize() {
        return size;
    }

    public boolean hasCheese() {
        return cheese;
    }

    public boolean hasPepperoni() {
        return pepperoni;
    }

    public boolean hasMushrooms() {
        return mushrooms;
    }

    public boolean hasOnions() {
        return onions;
    }

    public boolean hasOlives() {
        return olives;
    }

    
    @Override
    public String toString() {
        StringBuilder toppings = new StringBuilder();
        if (cheese) toppings.append("Cheese, ");
        if (pepperoni) toppings.append("Pepperoni, ");
        if (mushrooms) toppings.append("Mushrooms, ");
        if (onions) toppings.append("Onions, ");
        if (olives) toppings.append("Olives, ");

        if (!toppings.isEmpty()) {
            toppings.setLength(toppings.length() - 2); // Remove the last comma and space
        }

        return "Size: " + size + ", Toppings: " + toppings.toString();
    }

    public static class PizzaBuilder {
        private final String size;
        private boolean cheese;
        private boolean pepperoni;
        private boolean mushrooms;
        private boolean onions;
        private boolean olives;
        

        public PizzaBuilder(String size) {
            this.size = size;
        }

        public PizzaBuilder addCheese() {
            cheese = true;
            return this;
        }

        public PizzaBuilder addPepperoni() {
            pepperoni = true;
            return this;
        }

        public PizzaBuilder addMushrooms() {
            mushrooms = true;
            return this;
        }

        public PizzaBuilder addOnions() {
            onions = true;
            return this;
        }

        public PizzaBuilder addOlives() {
            olives = true;
            return this;
        }

        

        public Pizza build() {
            return new Pizza(this);
        }
    }

    public static void main(String[] args) {
        // Creating a pizza using the Builder pattern
        Pizza pizza = new PizzaBuilder("large")
                .addCheese()
                .addPepperoni()
                .addOnions()
                .addOlives()
                .build();

        System.out.println("Pizza details:");
        System.out.println(pizza);
    }
}
