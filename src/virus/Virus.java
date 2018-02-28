package virus;

public class Virus {
    protected Virus name; 

    protected int incubationTime; 
    protected int contagiousTime; 
    protected int recoverTime; 
    
    
    protected double infect_Rate; 
    protected double dead_Rate;
    public double getInfectedRate() { return infect_Rate; }

    public double getDeadRate() { return dead_Rate; }
    

}
