package UnitTestProject;

public class CargoPlane{
    private int fuel;
    //an int representing the ammount of fuel in liters on the plane
    //fuel cannot be negative
    private int boxes;
    //an int representing the # of boxes onboard the plane
    //boxes cannot be negative


    //defualt constructor for a Cargo plane with all values set to 0
    public CargoPlane(){
        fuel = 0;
        boxes = 0;

    }
    /*
     * takes user inpuyt and creates a cargo plane object with those variables.
     */
    public CargoPlane(int _fuel, int _numberOfBoxes){
        fuel = _fuel;
        boxes = _numberOfBoxes;
    }
    /*
     * adds the number of fuel units desired to the planes fuel tank
     */
    public void refuel(int addedFuel){
        fuel += addedFuel;
    }
    /*
     * not sure if thsi is a real word but removes the desired ammount of fuel form the planes fuel tank fuel cannot be negative;
     */
    public void deFule(int removedFuel){
            fuel -= removedFuel;

    }
        /*
         * addes desired number of boxes to cargo planes bay.
         */
        public void addBoxes(int newBoxes){
            boxes += newBoxes;
        }
        /*
         * removes the desired number of boxes
         */
        public void removeBoxes(int numberOfBoxes){
                boxes -= numberOfBoxes;
  
        }
        
        /**
         * 
         * @return
         */
        public int getBoxes(){
            return boxes;
        }
        /*
         * returns the ammount of fuel
         */
        public int getFuel(){
            return fuel;
        }
    public boolean isValid(){
        if (boxes >= 0 && fuel >= 0){
            return true;
        } else {
            return false;
        }
    }
}

    
