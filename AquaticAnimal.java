class AquaticAnimal extends AnimalInZoo implements Animal {
    public AquaticAnimal(String name, String habitat, double foodConsumption) {
        super(name, habitat, foodConsumption);
    }

    @Override
    public void eat(Zookeeper zookeeper, double foodAmount) {
    }

    @Override
    public String getName() {
        return name;
    }
        @Override
    public String getHabitat() {
        return habitat;
    }
}
