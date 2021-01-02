public class Date implements MyDate{
    private int year, month, day;
    
    public Date(){//default date to 1/1/1900
        year = 1900;
        month = 1;
        day = 1;
    }
    
    public Date(int year, int month, int day){
        if (isValidDay(year, month, day)){
            this.year = year;
            this.month = month;
            this.day = day;
        }
        else{
            this.year = -1;
            this.month = -1;
            this.day = -1;
        }
    }
    
    private static boolean isValidMonth(int month){
        if (month >= 1 && month <=12){
            return true;
        }
        else{
            return false;
        }
    }
    
    private static boolean isValidDay(int year, int month, int day){
        if (!isValidMonth(month))
        {
            return false;
        }
        if ((month == 1 || month == 3 || month == 5 || month == 7 ||
             month == 8 || month == 10 || month == 12) && day>=1 && day<=31){
            return true;
        }
        else if ((month == 4 || month == 6 || month == 9 || month == 11) &&
            day >= 1 && day <= 30){
            return true;
        }
        else if (month == 2){//February
            if((day>=1 && day<=28) || (day == 29 && isLeapYear(year))){
                return true;
            }
            return false;
        }
        return false;
    }
    
    private static boolean isLeapYear(int year){
        return (year >= 1752 && year % 4 == 0 && 
                (year % 100 != 0 || year % 400 == 0));
    }
    
    public int getYear(){
        return year;
    }
    
    public void setYear(int y){
        year = y;
    }
    
    public int getMonth(){
        return month;
    }
    public int getDay(){
        return day;
    }
    
    public boolean equals(MyDate d){
        if(this.year  == d.getYear()  &&
           this.month == d.getMonth() &&
           this.day   == d.getDay()){
            return true;
        }
        return false;
    }
    
    public int compare(MyDate d){
        if(this.equals(d)){
            return 0;
        }
        else if(this.year > d.getYear()){
            return 1;
        }
        else if(this.year < d.getYear()){
            return -1;
        }
        else if(this.month > d.getYear()){
            return 1;
        }
        else if(this.month < d.getYear()){
            return -1;
        }
        else if(this.day < d.getDay()){
            return 1;
        }
        return -1;
    }
    
    public String toString(){
        return year + "-" + month + "-" + day;
    }
}