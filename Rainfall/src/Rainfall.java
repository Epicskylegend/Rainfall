public class RainFall {
    private double[] rainFallData;
    public RainFall(double[] rainFallData) {
        this.rainFallData = rainFallData;
    }
    // calculates total rain fall for the year
    public double totalRainFall(){
        double totalRainFall = 0;
        for(double amt : rainFallData)
            totalRainFall+=amt;
        return totalRainFall;
    }
    // calculates average monthly rain fall
    public double averageRainFall(){
        return totalRainFall()/12;
    }
    //finds out the month which has most rain fall
    public int monthWithMostRainFall(){
        double maxRainFall = 0;
        int month = 1;
        for(int i=0; i<12; i++)
        {
            // this condition will take first month which has most rain fall
            // if you want to return the last month which has most rain fall
            // then consider >= in condition
            // i.e. if Jan has 10.99 inches and Dec has 10.99 inches and max = 10.99
            // then this method will return Jan
            if(rainFallData[i] > maxRainFall) {
                maxRainFall = rainFallData[i];
                month = i;
            }
        }
        return month+1; // month contains 0 based index hence returning month+1
    }
    //finds out the month which has least rain fall
    public int monthWithLeastRainFall(){
        double minRainFall = Double.MAX_VALUE;
        int month = 1;
        for(int i=0; i<12; i++)
        {
            // this condition will take first month which has least rain fall
            // if you want to return the last month which has least rain fall
            // then consider <= in condition
            // i.e. if Jan has 0  inches and Dec has 0  inches and min = 0
            // then this method will return Jan
            if(rainFallData[i] < minRainFall) {
                minRainFall = rainFallData[i];
                month = i;
            }
        }
        return month+1;
    }
    //month is from 1-12
    public double rainFallInMonth(int month){
        // throw new RuntimeException("invalid input"); exception can be thrown for invalid input
        return rainFallData[month-1];
    }
    public String monthName(int month){
        switch (month)
        {
            case 1: return "January";
            case 2: return "February";
            case 3: return "March";
            case 4: return "April";
            case 5: return "May";
            case 6: return "June";
            case 7: return "July";
            case 8: return "August";
            case 9: return "September";
            case 10: return "October";
            case 11: return "November";
            case 12: return "December";
            default: return "Invalid input";
        }
    }
    // if rainfall is more than avg then increment count and add the month name and rainfall in that month into data
    // and finally print the value of count and complete data with month name and rainfall if count>0
    // String.format() is used to format the number upto required decimal points. Here %.2f means to consider 2 places after decimal
    public void monthsWithRainFallMoreThanAvg()
    {
        int count=0;
        double avg = averageRainFall();
        StringBuilder data = new StringBuilder("");
        for(int i=0;i<12;i++)
        {
            if(rainFallData[i]>avg){
                count++;
                data.append(monthName(i+1)).append("\t\t\t").append(String.format("%.2f",rainFallInMonth(i+1))).append("\n");
            }
        }
        System.out.println("There are "+count+" months whose rainfall are higher than average:");
        if(count>0)
        {
            System.out.println("Month\t\t\t"+"RainFall");
            System.out.println(data);
        }
    }
}
