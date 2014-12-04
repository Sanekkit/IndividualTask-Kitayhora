/**
 * Created by SU on 03.12.2014.
 */
public class MyRoom {
    private Integer capacity;
    private MyRequisition myRequisition;
    private String typeOfRoom;// = {"lux","econom", "standart"};
    public MyRoom(Integer capacity, String typeOfRoom) {
        this.capacity = capacity;
        this.typeOfRoom = typeOfRoom;
    }
    public String getTypeOfRoom() {
        return typeOfRoom;
    }
    public void setTypeOfRoom(String typeOfRoom) {
        this.typeOfRoom = typeOfRoom;
    }
    public MyRequisition getMyRequisition() {
        return myRequisition;
    }

    public void setMyRequisition(MyRequisition myRequisition) {
        this.myRequisition = myRequisition;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }


    @Override
    public String toString() {
        return "MyRoom " +
                "capacity=" + capacity +
                ", myRequisition=" + myRequisition +
                ", typeOfRoom='" + typeOfRoom + '\'' +
                '.';
    }

}
