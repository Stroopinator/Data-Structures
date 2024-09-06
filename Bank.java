public class  Bank {
    private String name;
    private double balance;

    public Bank(String _name, double _money){
        balance = _money;
        name = _name;
    }

    public void add(double dollars){
        balance += dollars;
    }

    public void withdraw(double dollars){
        balance -= dollars;
    }
    public double getBalance(){
        return balance;
    }
    public String getName(){
        return name;
    }

    public String toString(){
        return "Owner: " + name + " \n $" + balance;
    }
}
