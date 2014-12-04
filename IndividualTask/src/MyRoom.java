/**
 * Created by SU on 04.12.2014.
 */
class MyRoom {
    private int capacity;
    private MyRequisition myRequisition;
    private String typeOfRoom;// = {"lux","econom", "standart"};

    MyRoom() {
    }

    public MyRoom(int capacity, String typeOfRoom) {
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

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
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

