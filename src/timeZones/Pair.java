package timeZones;

public class Pair<Name, TimeToAdd> {
    private Name name;
    private TimeToAdd timeToAdd;

    public Pair(Name n, TimeToAdd t){
        this.name = n;
        this.timeToAdd = t;
    }

    public Name getName(){ return name; }
    public TimeToAdd getTimeToAdd(){ return timeToAdd; }

    public String toString(){
        return (String)name;
    }
}
