import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by SU on 03.12.2014.
 */
public class MyHotel {
    private List<MyRoom> myRooms;
    private int diferencesOfRooms;
    private MyRoom nearestRoom1;
    private MyRoom nearestRoom2;
    private List<MyRequisition> myRequisitions;

    public MyHotel() {
    }

    public MyHotel(List<MyRoom> myRooms) {
        this.myRooms = myRooms;
        myRequisitions = new ArrayList<MyRequisition>();
    }

    public int counterOfFreeRooms(String type) {
        int count = 0;
        for (MyRoom myRoom : myRooms) {
            if (myRoom.getTypeOfRoom().equals(type) && myRoom.getMyRequisition() == null) {
                count += myRoom.getCapacity();
            }
        }
        return count;
    }

    public List<MyRoom> freeRooms(MyRequisition myRequisition) {
        List<MyRoom> freeRooms = new ArrayList<MyRoom>();
        int freeBed = 0;
        int myRequisitionAmount = myRequisition.getAmountOfPeople();
        for (MyRoom myRoom : myRooms) {
            if (myRoom.getTypeOfRoom().equals(myRequisition.getTypeOfRoom()) && myRoom.getMyRequisition() == null) {
                if (myRoom.getCapacity() == myRequisitionAmount) {
                    return Arrays.asList(myRoom);
                }
                freeRooms.add(myRoom);
                freeBed += myRoom.getCapacity();
            }
        }
        nearestRoom1 = null;
        nearestRoom2 = null;
        diferencesOfRooms = 1000;
        for (MyRoom room1 : freeRooms) {
            for (MyRoom room2 : freeRooms) {
                if (room1.equals(room2)) {
                    continue;
                }
                int room1Capacity = room1.getCapacity();
                int room2Capacity = room2.getCapacity();
                if (room1Capacity + room2Capacity == myRequisitionAmount) {
                    return Arrays.asList(room1, room2);
                }
            }
        }
        if (nearestRoom1 != null) {
            if (nearestRoom2 != null) {
                return Arrays.asList(nearestRoom1, nearestRoom2);
            }
            return Arrays.asList(nearestRoom1);
        }
        return freeBed >= myRequisition.getAmountOfPeople() ? freeRooms : null;
    }

    @Override
    public String toString() {
        return "MyHotel{" +
                "myRooms=" + myRooms +
                ", diferencesOfRooms=" + diferencesOfRooms +
                ", nearestRoom1=" + nearestRoom1 +
                ", nearestRoom2=" + nearestRoom2 +
                ", myRequisitions=" + myRequisitions +
                '}';
    }

    public synchronized void eviction(MyRequisition myRequisition) {
        System.out.println("Eviction " + myRequisition);
        System.out.println("Now : " + new Date(System.currentTimeMillis()));
        for (MyRoom myRoom : myRooms) {
            if (myRequisition.equals(myRoom.getMyRequisition())) {
                myRoom.setMyRequisition(null);
            }
        }
        System.out.println("Amount of available beds for type " + myRequisition.getTypeOfRoom()+ ": " + counterOfFreeRooms(myRequisition.getTypeOfRoom()) + '\n');
        myRequisitions.remove(myRequisition);
        System.out.println();
    }

    public synchronized boolean settlement(MyRequisition myRequisition) {
        System.out.println("Settlement " + myRequisition.getName());
        List<MyRoom> freeRooms = freeRooms(myRequisition);
        if (freeRooms != null) {
            System.out.println("Settlement " + myRequisition);
            for (MyRoom room : freeRooms) {
                room.setMyRequisition(myRequisition);
                System.out.println("In room are " + room.getCapacity() + " beds.");
            }
            System.out.println("________________\n\n");
            return myRequisitions.add(myRequisition);
        } else {
            System.out.println("Can't settle " + myRequisition.getName() + " in room " + myRequisition.getTypeOfRoom()
                    + ". They need: " + myRequisition.getAmountOfPeople() + " beds. But available: " + counterOfFreeRooms(myRequisition.getTypeOfRoom()));
            System.out.println("________________\n\n");
            return false;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyHotel myHotel = (MyHotel) o;

        if (diferencesOfRooms != myHotel.diferencesOfRooms) return false;
        if (myRequisitions != null ? !myRequisitions.equals(myHotel.myRequisitions) : myHotel.myRequisitions != null)
            return false;
        if (myRooms != null ? !myRooms.equals(myHotel.myRooms) : myHotel.myRooms != null) return false;
        if (nearestRoom1 != null ? !nearestRoom1.equals(myHotel.nearestRoom1) : myHotel.nearestRoom1 != null)
            return false;
        if (nearestRoom2 != null ? !nearestRoom2.equals(myHotel.nearestRoom2) : myHotel.nearestRoom2 != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = myRooms != null ? myRooms.hashCode() : 0;
        result = 31 * result + diferencesOfRooms;
        result = 31 * result + (nearestRoom1 != null ? nearestRoom1.hashCode() : 0);
        result = 31 * result + (nearestRoom2 != null ? nearestRoom2.hashCode() : 0);
        result = 31 * result + (myRequisitions != null ? myRequisitions.hashCode() : 0);
        return result;
    }
}

