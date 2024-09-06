package Mountains;

public class Mountain {
    private String country;
    private String name;
    private double latitude;
    private double longitude;
    private double elevation;
    private String units;
    private String errorMessages;
    private boolean hasError = false;
    private int numberOfErrors;
    private String failedPrintStream;

    /*
     * basic constructor calls upon parse methods to try and catch errors in the syntax of the mountain data
     */
    public Mountain(String line){
        String[] record = line.split("\t");
        recordIsValid(record);
        if(!hasError){
            country = record[0];
            //System.out.println(country);
            name = record[2];
            //System.out.println(name);
            latitude = parseLat(record[3]);
            //System.out.println(latitude);
            longitude = parseLong(record[4]);
           // System.out.println(longitude);
            checkLatAndLong();
            elevation = parseElevation(record[5]);
            //System.out.println(elevation +"");
            //System.out.println(errorMessages);
            //System.out.println(numberOfErrors + "");
            units = parseUnits(record[5]);
        }
        if(hasError){
            failedPrintStream = line;
        }

    }

public void recordIsValid(String[] record){
    try { String l = record[5];
    } catch (Exception ArrayIndexOutOfBounds) {
        hasError = true;
        errorMessages += "record is not valid";
        numberOfErrors++;
    }
}
    public double parseLat(String Lat){
        try {
            latitude = Double.parseDouble(Lat);
        } catch (Exception NumberFormatException) {
            hasError = true;
            errorMessages += "failed parseLat ";
            numberOfErrors++;
            return 0.0;
        }
    return Double.parseDouble(Lat);
        
    }

    public double parseLong(String Long){
        try {
            longitude = Double.parseDouble(Long);
        } catch (Exception NumberFormatException) {
            hasError = true;
            errorMessages += "failed parseLong ";
            numberOfErrors++;
            return 0.0;
        }
        return Double.parseDouble(Long);
    }

    /**
     * returns the elevation of the mountain
     * @param rawHeight
     * @return
     */
    public double parseElevation(String rawHeight){
    if(rawHeight.contains("m")){
     rawHeight = rawHeight.substring(0,rawHeight.indexOf("m")-1);

    } 
    if(rawHeight.contains("ft")){
     rawHeight = rawHeight.substring(0,rawHeight.indexOf("ft")-2);
    }

    try{
        elevation = Double.parseDouble(rawHeight);
        } catch(Exception e){
            hasError = true;
            errorMessages += "failed parseElevation ";
            numberOfErrors++;
            return -1;
        }
      return Double.parseDouble(rawHeight);

    }
    public void checkLatAndLong(){
        if(latitude > 90.0 || latitude < -90.0){
            hasError = true;
            numberOfErrors++;
            errorMessages += "Latitude is off the earth";
        }
        if(longitude > 180 || longitude < -180){
            hasError = true;
            numberOfErrors++;
            errorMessages += "Longitude is off the earth";
        }
    }
    public String parseUnits(String rawHeight){
        if(rawHeight.contains("m")){
            return "m";
       
           } 
           if(rawHeight.contains("ft")){
            return "ft";
           }
           return "m";
    }
    /*
     * lots of getter methods for the various objects data
     */
    public String getName(){
        return name;
    }
    public double getElevation(){
        return elevation;
    }
    public String getUnits(){
        return units;
    }
    public double getLat(){
        return latitude;
    }
    public double getLong(){
        return longitude;
    }
    public boolean getHasError(){
        return hasError;
    }
    public int getNumberOfErrors(){
        return numberOfErrors;
    }
    public String getErrorMessages(){
        return errorMessages;
    }
    public String getCountry(){
        return country;
    }
    public String getFailedStream(){
        return failedPrintStream;
    }
}
