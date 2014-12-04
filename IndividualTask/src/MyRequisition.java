/**
 * Created by SU on 03.12.2014.
 */
public class MyRequisition implements Runnable{
    private String name;
    private int amountOfPeople;
    private long milliseconds;
    private MyHotel myHotel;
    private String typeOfRoom;

    public MyRequisition(String name, int amountOfPeople, long milliseconds, MyHotel myHotel, String typeOfRoom) {
        this.name = name;
        this.amountOfPeople = amountOfPeople;
        this.milliseconds = milliseconds;
        this.myHotel = myHotel;
        this.typeOfRoom = typeOfRoom;
    }

    @Override
    public String toString() {
        return "MyRequisition : " +
                "name='" + name + '\'' +
                ", amountOfPeople=" + amountOfPeople +
                ", milliseconds=" + milliseconds +
                ", typeOfRoom=" + typeOfRoom +
                '.';
    }
    public String getTypeOfRoom() {
        return typeOfRoom;
    }

    public void setTypeOfRoom(String typeOfRoom) {
        this.typeOfRoom = typeOfRoom;
    }
    public MyRequisition() {
    }

    public MyHotel getMyHotel() {
        return myHotel;
    }

    public void setMyHotel(MyHotel myHotel) {
        this.myHotel = myHotel;
    }

    public long getMilliseconds() {
        return milliseconds;
    }

    public void setMilliseconds(long milliseconds) {
        this.milliseconds = milliseconds;
    }

    public int getAmountOfPeople() {
        return amountOfPeople;
    }

    public void setAmountOfPeople(int amountOfPeople) {
        this.amountOfPeople = amountOfPeople;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyRequisition that = (MyRequisition) o;

        if (amountOfPeople != that.amountOfPeople) return false;
        if (milliseconds != that.milliseconds) return false;
        if (myHotel != null ? !myHotel.equals(that.myHotel) : that.myHotel != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (typeOfRoom != null ? !typeOfRoom.equals(that.typeOfRoom) : that.typeOfRoom != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + amountOfPeople;
        result = 31 * result + (int) (milliseconds ^ (milliseconds >>> 32));
        result = 31 * result + (myHotel != null ? myHotel.hashCode() : 0);
        result = 31 * result + (typeOfRoom != null ? typeOfRoom.hashCode() : 0);
        return result;
    }



    @Override
    public void run() {
        try {
            while (true) {
                if (myHotel.settlement(this)) {
                    Thread.sleep(milliseconds);
                    myHotel.eviction(this);
                    synchronized (typeOfRoom) {
                        typeOfRoom.notify();
                    }
                    break;
                } else {
                    synchronized (typeOfRoom) {
                        typeOfRoom.wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
