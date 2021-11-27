/** Transactions class  -- to store all the transaction details  */

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.io.IOException;

public class Transaction {

    private String resNum;      //reservation number;
    private String name;        //name of the client
    private LocalDate checkIn;     //check in time;
    private String hotelTypes;        //type of hotel
    private String roomType;    //TYpe of room;
    private boolean ap;           //true for advanced pay,false for  standard pay
    private double totalCost;      //total cost

    /** create a constructor of the transaction class */
    public Transaction(){}
    
    public Transaction(String resNum, String name, LocalDate checkIn, String hotelTypes, String roomType, boolean ap, double totalCost) {
        this.resNum = resNum;
        this.name = name;
        this.checkIn = checkIn;
        this.hotelTypes = hotelTypes;
        this.roomType = roomType;
        this.ap = ap;
        this.totalCost = totalCost;
    }
    

    /** Create a csv file and write all the transaction data to it */
    public void writeToCsv() throws IOException {

        try {
            File file = new File("Transaction.csv");
            deleteFile(file);
            FileWriter fw = new FileWriter(file);



            fw.append("Reservation Number, Name,CheckIn Date,HotelType,RoomType,advancedPurchased,totalCost\n");

            fw.append(this.resNum);
            fw.append(',');
            fw.append(this.name);
            fw.append(',');
            fw.append(this.checkIn.toString());
            fw.append(',');
            fw.append(hotelTypes);
            fw.append(',');
            fw.append(roomType);
            fw.append(',');
            fw.append(String.valueOf(ap));
            fw.append(',');
            fw.append(String.valueOf(totalCost));

            fw.close();


        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }
    }


    /** remove content of all transactions detail */
    public void removeContent() throws IOException{
        FileWriter fw = new FileWriter("Transaction.csv",false);

        fw.append("Reservation Number, Name,CheckIn Date,HotelType,RoomType,advancedPurchased,totalCost\n");
        fw.append("");

        fw.close();

        }



    public boolean deleteFile(File file) throws IOException {
        if (file != null) {
            if (file.isFile()) {
                file.delete();
            }
        }
        return false;
    }



}
