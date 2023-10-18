public enum MonthsNames {
    January("Январь"), Febrary("Февраль"), March("Март");
    private String name;
    MonthsNames(String name){
        this.name = name;
    }
    public String getName(){ return name;}
}
