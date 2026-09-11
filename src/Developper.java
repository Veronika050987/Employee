class Developper extends Employee{
    public Developper(String name, double baseSalary){
        super(name, baseSalary);
    }
    @Override
    public double calculatePay(){
        return getSalary() + 15000;
    }
}
