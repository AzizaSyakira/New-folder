class AnimalInZoo {
    protected String name;
    protected String habitat;
    protected double foodConsumption;

    public AnimalInZoo(String name, String habitat, double foodConsumption) {
        this.name = name;
        this.habitat = habitat;
        this.foodConsumption = foodConsumption;
    }

    public double calculateFoodConsumption(int days) {
        return foodConsumption * days;
    }

    public String getFoodName() {
        return "Generic Animal Food";
    }
}

