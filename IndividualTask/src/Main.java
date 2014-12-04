import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by SU on 04.12.2014.
 */
public class Main {
    public static List<MyRoom> createMyRooms(){
        ArrayList<MyRoom> myRooms = new ArrayList<MyRoom>();
        myRooms.add(new MyRoom(3,"Lux"));
        myRooms.add(new MyRoom(2,"Lux"));
        myRooms.add(new MyRoom(2,"Lux"));
        myRooms.add(new MyRoom(1,"Lux"));
        myRooms.add(new MyRoom(1,"Standart"));
        myRooms.add(new MyRoom(3,"Standard"));
        myRooms.add(new MyRoom(3,"Standart"));
        myRooms.add(new MyRoom(3,"Econom"));
        myRooms.add(new MyRoom(2,"Econom"));
        myRooms.add(new MyRoom(1,"Econom"));
        return myRooms;
    }

    public static void main(String[] args) throws InterruptedException {
        MyHotel hotel = new MyHotel(createMyRooms());
        new Thread(new MyRequisition("1",3,50,hotel, "Lux")).start();
        new Thread(new MyRequisition("2",1,30,hotel, "Lux")).start();
        new Thread(new MyRequisition("5",5,80,hotel, "Econom")).start();
        TimeUnit.MILLISECONDS.sleep(20);
        new Thread(new MyRequisition("6",4,150,hotel, "Econom")).start();
        new Thread(new MyRequisition("12",3,60,hotel, "Lux")).start();
        new Thread(new MyRequisition("9",3,90,hotel, "Econom")).start();
        new Thread(new MyRequisition("13",4,300,hotel, "Econom")).start();
        TimeUnit.MILLISECONDS.sleep(20);
        new Thread(new MyRequisition("8",2,250,hotel, "Econom")).start();
        new Thread(new MyRequisition("3",3,60,hotel, "Econom")).start();
        new Thread(new MyRequisition("4",2,100,hotel, "Standart")).start();
        TimeUnit.MILLISECONDS.sleep(20);
        new Thread(new MyRequisition("7",5,200,hotel, "Standart")).start();
        new Thread(new MyRequisition("10",3,40,hotel, "Standart")).start();
        new Thread(new MyRequisition("11",1,250,hotel, "Standart")).start();
    }
}
