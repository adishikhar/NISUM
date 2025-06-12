package Q23;




class Ticket {

    int availableTicket = 5;

    public synchronized  void book (String name, int reqTicket ){

        if (reqTicket <= availableTicket){
System.out.println(reqTicket + " Tickets alloted to " + name);
availableTicket= availableTicket- reqTicket;
        }else{
            System.out.println("Ticket Booked");
        }
    }
}

public class booking{
    public static void main(String[] args){

        Ticket obj = new Ticket();
        

        Thread t1 = new Thread(() -> obj.book("Aditya", 3));
        Thread t2 = new Thread(() -> obj.book("Richa", 2));
        Thread t3 = new Thread(() -> obj.book("Mishra", 3));

        t1.start();
        t2.start();
        t3.start();
        
    }


}