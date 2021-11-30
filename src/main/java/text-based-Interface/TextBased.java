import java.io.*;
import java.time.LocalDate;
import java.util.*;

import static java.time.LocalDate.parse;


public class TextBased {
    public Scanner scan;
    private ArrayList<String> hotels = new ArrayList<String>();
    int noOfRoom;
    int occupancy;
    String roomType = "";
    String hotelType = "";
    LocalDate checkInDate;
    LocalDate checkOutDate;
    Boolean ap = false;


    /**
     * Constructs an HotelReservationMenu object.
     */
    public TextBased() {
        scan = new Scanner(System.in);
    }


    /**
     * Runs the system.
     */
    /*
    public void run() throws IOException {
        boolean begin = true;

        //add hotel types:
        hotels.add("5-star");
        hotels.add("4-star");
        hotels.add("3-star");


        while (begin) {
            System.out.println("---------------------------------------------------");
            System.out.println("******* Welcome to Hotel Reservation System *******");
            System.out.println("---------------------------------------------------");
            System.out.println("Login:  C)ustomer  |  S)taff  |  M)anager  |  Q)uit");
            System.out.print("ENTER --> ");
            String input = scan.nextLine().toUpperCase();

            if (input.equals("Q")) {
                break;

            }

            if (input.equals("C")) {
                System.out.println("Do you want to make a 1)Reservation or 2)Cancellation?");
                int input2 = scan.nextInt();

                if (input2 == 1) {
                    System.out.println("Choose a Type of Hotel you want to stay");
                    System.out.println("5)-star | 4)-star | 3)-star");

                    int input3 = scan.nextInt();
                    System.out.println("Choose a room type");

                    if (input3 == 5) {
                        hotelType = "5-star hotel";
                        System.out.println("1)Deluxe Double | 2)Deluxe Twin | 3) Deluxe Single | 4)Deluxe Family");

                    } else if (input3 == 4) {
                        hotelType = "4-star hotel";
                        System.out.println("1)Executive Double | 2)Executive Twin | 3) Executive Single");

                    } else if (input3 == 3) {
                        hotelType = "3-star hotel";
                        System.out.println("1)Classic Double | 2)Classic Twin | 3) Classic Single");

                    }


                    //5 star hotel:
                    if (input3 == 5) {

                        int in4 = scan.nextInt();

                        if (in4 == 1) {
                            roomType = "Deluxe Double";
                        } else if (in4 == 2) {
                            roomType = "Deluxe Twin";
                        } else if (in4 == 3) {
                            roomType = "Deluxe Single";
                        } else if (in4 == 4) {
                            roomType = "Deluxe Family";
                        }
                        int in5;
                        int in6;

                        if (in4 != 4) {
                            System.out.println("Note: Maximum of 2 people allow in this type of room.");
                            System.out.println("Enter how many rooms you want to book?");
                            in5 = scan.nextInt();
                            noOfRoom = in5;
                            System.out.println("Enter how many people want to stay in the hotel");
                            in6 = scan.nextInt();
                            occupancy = in6;

                            if (noOfRoom * 2 < occupancy) {
                                System.out.println("The amount of people you entered exceed the occupancy of the amount of room you required.");
                                System.out.println("Note: Maximum of 2 people allow in this type of room.");
                                System.out.println("Enter how many rooms you want to book?");
                                in5 = scan.nextInt();
                                noOfRoom = in5;
                                System.out.println("Enter how many people want to stay in the hotel");
                                in6 = scan.nextInt();
                                occupancy = in6;
                            }

                        } else {
                            System.out.println("Note: Maximum of 3 people allow in this type of room.");
                            System.out.println("Enter how many rooms you want to book?");
                            in5 = scan.nextInt();
                            noOfRoom = in5;
                            System.out.println("Enter how many people want to stay in the hotel");
                            in6 = scan.nextInt();
                            occupancy = in6;

                            if (noOfRoom * 3 < occupancy) {
                                System.out.println("The amount of people you entered exceed the occupancy of the amount of room you required.");
                                System.out.println("Note: Maximum of 2 people allow in this type of room.");
                                System.out.println("Enter how many rooms you want to book?");
                                in5 = scan.nextInt();
                                noOfRoom = in5;
                                System.out.println("Enter how many people want to stay in the hotel");
                                in6 = scan.nextInt();
                                occupancy = in6;
                            }
                        }


                    } else if (input3 == 4 || input3 == 3) {

                        int in7 = scan.nextInt();

                        if (input3 == 4 && in7 == 1) {
                            roomType = "Executive Double";
                            System.out.println("Note: Maximum of 2 people allow in this type of room.");
                        } else if (input3 == 4 && in7 == 2) {
                            roomType = "Executive Twin";
                            System.out.println("Note: Maximum of 2 people allow in this type of room.");
                        } else if (input3 == 4 && in7 == 3) {
                            roomType = "Executive Single";
                            System.out.println("Note: Maximum of 1 people allow in this type of room.");
                        } else if (input3 == 3 && in7 == 1) {
                            roomType = "Classic Double";
                            System.out.println("Note: Maximum of 2 people allow in this type of room.");
                        } else if (input3 == 3 && in7 == 2) {
                            roomType = "Classic Twin";
                            System.out.println("Note: Maximum of 2 people allow in this type of room.");
                        } else if (input3 == 3 && in7 == 3) {
                            roomType = "Classic Single";
                            System.out.println("Note: Maximum of 1 people allow in this type of room.");
                        }

                        int in5, in6;
                        System.out.println("Enter how many rooms you want to book?");
                        in5 = scan.nextInt();
                        noOfRoom = in5;
                        System.out.println("Enter how many people want to stay in the hotel");
                        in6 = scan.nextInt();
                        occupancy = in6;

                        if (in7 == 1 || in7 == 2) {
                            if (noOfRoom * 2 < occupancy) {
                                System.out.println("The amount of people you entered exceed the occupancy of the amount of room you required.");
                                System.out.println("Note: Maximum of 2 people allow in this type of room.");
                                System.out.println("Enter how many rooms you want to book?");
                                in5 = scan.nextInt();
                                noOfRoom = in5;
                                System.out.println("Enter how many people want to stay in the hotel");
                                in6 = scan.nextInt();
                                occupancy = in6;
                            }


                        } else if (in7 == 3) {
                            if (noOfRoom < occupancy) {
                                System.out.println("The amount of people you entered exceed the occupancy of the amount of room you required.");
                                System.out.println("Note: Maximum of 1 people allow in this type of room.");
                                System.out.println("Enter how many rooms you want to book?");
                                in5 = scan.nextInt();
                                noOfRoom = in5;
                                System.out.println("Enter how many people want to stay in the hotel");
                                in6 = scan.nextInt();
                                occupancy = in6;
                            }
                        }
                    }


                    System.out.println("A 5% off applied to an advanced purchase.");
                    System.out.println("Would you like to pay in advance? [Y/N]");

                    String ad = scan.next().toUpperCase();


                    if (ad.equals("Y")) {
                        ap = true;

                    } else if (ad.equals("N")) {
                        ap = false;
                    }


                    System.out.println("What is your name?");
                    String in8 = scan.next();
                    String name = in8;

                    System.out.println("What is your email?");
                    String in9 = scan.next();
                    String email = in9;

                    System.out.println("Check in date: (yyyy-mm-dd)");
                    String date1 = scan.next();


                    checkInDate = LocalDate.parse(date1);


                    System.out.println("Check out date: (yyyy-mm-dd)");

                    checkOutDate = LocalDate.parse(scan.next());

                    System.out.println("");


                    Booking user = new Booking(email, name, checkInDate, checkOutDate, ap, roomType, noOfRoom);

                    user.insertNewRow(new File("booking.csv"));

                    System.out.println("******Thank you for using Hotel Reservation System!******");
                    System.out.println();
                    break;

                } else {//make a cancellation

                    System.out.println("Please enter your name");
                    String in10 = scan.next();

                    Booking.deleteRow(new File("booking.csv"), in10);
                    System.out.println("******Cancellation successful! Thank you for using our system!******");
                }

//staff mode============================================================================================================
            } else if (input.equals("S")) {
                System.out.println("This is Staff mode: ****************************************************");
                System.out.println("M)make a resrvation | C)ancellation  |  CH)eck date for customer |  Q)uit");

                String in1 = scan.nextLine().toUpperCase();
                if (in1.equals("Q")) {
                    break;
                }

                if (in1.equals("M")) {
                    boolean ap = false;

                    System.out.println("Please enter the following detail:");
                    System.out.println("Email:");
                    String email1 = scan.nextLine();
                    System.out.println("Name:");
                    String name1 = scan.nextLine();
                    System.out.println("A)dvanced purchase or S)tandard purchase");
                    String in2 = scan.next().toUpperCase();
                    if (in2.equals("A")) {
                        ap = true;
                    } else {
                        ap = false;
                    }

                    System.out.println("Choose a Type of Hotel you want to stay");
                    System.out.println("5)-star | 4)-star | 3)-star");

                    int input3 = scan.nextInt();
                    System.out.println("Choose a room type");

                    if (input3 == 5) {
                        hotelType = "5-star hotel";
                        System.out.println("1)Deluxe Double | 2)Deluxe Twin | 3) Deluxe Single | 4)Deluxe Family");

                    } else if (input3 == 4) {
                        hotelType = "4-star hotel";
                        System.out.println("1)Executive Double | 2)Executive Twin | 3) Executive Single");

                    } else if (input3 == 3) {
                        hotelType = "3-star hotel";
                        System.out.println("1)Classic Double | 2)Classic Twin | 3) Classic Single");

                    }


                    //5 star hotel:
                    if (input3 == 5) {

                        int in4 = scan.nextInt();

                        if (in4 == 1) {
                            roomType = "Deluxe Double";
                        } else if (in4 == 2) {
                            roomType = "Deluxe Twin";
                        } else if (in4 == 3) {
                            roomType = "Deluxe Single";
                        } else if (in4 == 4) {
                            roomType = "Deluxe Family";
                        }
                        int in5;
                        int in6;

                        if (in4 != 4) {
                            System.out.println("Note: Maximum of 2 people allow in this type of room.");
                            System.out.println("Enter how many rooms you want to book?");
                            in5 = scan.nextInt();
                            noOfRoom = in5;
                            System.out.println("Enter how many people want to stay in the hotel");
                            in6 = scan.nextInt();
                            occupancy = in6;

                            if (noOfRoom * 2 < occupancy) {
                                System.out.println("The amount of people you entered exceed the occupancy of the amount of room you required.");
                                System.out.println("Note: Maximum of 2 people allow in this type of room.");
                                System.out.println("Enter how many rooms you want to book?");
                                in5 = scan.nextInt();
                                noOfRoom = in5;
                                System.out.println("Enter how many people want to stay in the hotel");
                                in6 = scan.nextInt();
                                occupancy = in6;
                            }

                        } else {
                            System.out.println("Note: Maximum of 3 people allow in this type of room.");
                            System.out.println("Enter how many rooms you want to book?");
                            in5 = scan.nextInt();
                            noOfRoom = in5;
                            System.out.println("Enter how many people want to stay in the hotel");
                            in6 = scan.nextInt();
                            occupancy = in6;

                            if (noOfRoom * 3 < occupancy) {
                                System.out.println("The amount of people you entered exceed the occupancy of the amount of room you required.");
                                System.out.println("Note: Maximum of 2 people allow in this type of room.");
                                System.out.println("Enter how many rooms you want to book?");
                                in5 = scan.nextInt();
                                noOfRoom = in5;
                                System.out.println("Enter how many people want to stay in the hotel");
                                in6 = scan.nextInt();
                                occupancy = in6;
                            }
                        }


                    } else if (input3 == 4 || input3 == 3) {

                        int in7 = scan.nextInt();

                        if (input3 == 4 && in7 == 1) {
                            roomType = "Executive Double";
                            System.out.println("Note: Maximum of 2 people allow in this type of room.");
                        } else if (input3 == 4 && in7 == 2) {
                            roomType = "Executive Twin";
                            System.out.println("Note: Maximum of 2 people allow in this type of room.");
                        } else if (input3 == 4 && in7 == 3) {
                            roomType = "Executive Single";
                            System.out.println("Note: Maximum of 1 people allow in this type of room.");
                        } else if (input3 == 3 && in7 == 1) {
                            roomType = "Classic Double";
                            System.out.println("Note: Maximum of 2 people allow in this type of room.");
                        } else if (input3 == 3 && in7 == 2) {
                            roomType = "Classic Twin";
                            System.out.println("Note: Maximum of 2 people allow in this type of room.");
                        } else if (input3 == 3 && in7 == 3) {
                            roomType = "Classic Single";
                            System.out.println("Note: Maximum of 1 people allow in this type of room.");
                        }

                        int in5, in6;
                        System.out.println("Enter how many rooms you want to book?");
                        in5 = scan.nextInt();
                        noOfRoom = in5;
                        System.out.println("Enter how many people want to stay in the hotel");
                        in6 = scan.nextInt();
                        occupancy = in6;

                        if (in7 == 1 || in7 == 2) {
                            if (noOfRoom * 2 < occupancy) {
                                System.out.println("The amount of people you entered exceed the occupancy of the amount of room you required.");
                                System.out.println("Note: Maximum of 2 people allow in this type of room.");
                                System.out.println("Enter how many rooms you want to book?");
                                in5 = scan.nextInt();
                                noOfRoom = in5;
                                System.out.println("Enter how many people want to stay in the hotel");
                                in6 = scan.nextInt();
                                occupancy = in6;
                            }


                        } else if (in7 == 3) {
                            if (noOfRoom < occupancy) {
                                System.out.println("The amount of people you entered exceed the occupancy of the amount of room you required.");
                                System.out.println("Note: Maximum of 1 people allow in this type of room.");
                                System.out.println("Enter how many rooms you want to book?");
                                in5 = scan.nextInt();
                                noOfRoom = in5;
                                System.out.println("Enter how many people want to stay in the hotel");
                                in6 = scan.nextInt();
                                occupancy = in6;
                            }
                        }
                    }
                    System.out.println("Check in date: (yyyy-mm-dd)");
                    String date1 = scan.next();
                    checkInDate = LocalDate.parse(date1);
                    System.out.println("Check out date: (yyyy-mm-dd)");
                    checkOutDate = LocalDate.parse(scan.next());

                    System.out.println("");

                    Booking user = new Booking(email1, name1, checkInDate, checkOutDate, ap, roomType, noOfRoom);

                    user.insertNewRow(new File("booking.csv"));

                    System.out.println("******Thank you for using Hotel Reservation System!******");
                    System.out.println();

                    //make a cancellation=====================================================================================================
                } else if (in1.equals("C")) {

                    System.out.println("Please enter your name");
                    String in10 = scan.next();

                    Booking.deleteRow(new File("booking.csv"), in10);
                    System.out.println("******Cancellation successful! Thank you for using our system!******");
                    System.out.println();

                } else if (in1.equals("CH")) {
                    System.out.println("Please enter your name: ");
                    String in11 = scan.nextLine();
                    System.out.println("Result: ");
                    Booking.checkIn(new File("booking.csv"), in11);


                }
                //manager mode:============================================================================
            } else if (input.equals("M")) {
                System.out.println("This is Manager mode: ***********************************************************");
                System.out.println("M)make a reservation | C)ancellation  | B)ooking log | A)nalysis csv file | Q)uit");

                String in1 = scan.nextLine().toUpperCase();
                if (in1.equals("Q")) {
                    break;
                }

                if (in1.equals("M")) {
                    boolean ap = false;

                    System.out.println("Please enter the following detail:");
                    System.out.println("Email:");
                    String email1 = scan.nextLine();
                    System.out.println("Name:");
                    String name1 = scan.nextLine();
                    System.out.println("Check in date (yyyy-mm-dd) format");
                    LocalDate checkIn = parse(scan.nextLine());
                    System.out.println("Check out date (yyyy-mm-dd) format");
                    LocalDate checkOut = parse(scan.nextLine());

                    System.out.println("A)dvanced purchase or S)tandard purchase");
                    String in2 = scan.nextLine().toUpperCase();
                    if (in2.equals("A")) {
                        ap = true;
                    } else {
                        ap = false;
                    }

                    System.out.println("Choose a Type of Hotel you want to stay");
                    System.out.println("5)-star | 4)-star | 3)-star");

                    int input3 = scan.nextInt();
                    System.out.println("Choose a room type");

                    if (input3 == 5) {
                        hotelType = "5-star hotel";
                        System.out.println("1)Deluxe Double | 2)Deluxe Twin | 3) Deluxe Single | 4)Deluxe Family");

                    } else if (input3 == 4) {
                        hotelType = "4-star hotel";
                        System.out.println("1)Executive Double | 2)Executive Twin | 3) Executive Single");

                    } else if (input3 == 3) {
                        hotelType = "3-star hotel";
                        System.out.println("1)Classic Double | 2)Classic Twin | 3) Classic Single");

                    }


                    //5 star hotel:
                    if (input3 == 5) {

                        int in4 = scan.nextInt();

                        if (in4 == 1) {
                            roomType = "Deluxe Double";
                        } else if (in4 == 2) {
                            roomType = "Deluxe Twin";
                        } else if (in4 == 3) {
                            roomType = "Deluxe Single";
                        } else if (in4 == 4) {
                            roomType = "Deluxe Family";
                        }
                        int in5;
                        int in6;

                        if (in4 != 4) {
                            System.out.println("Note: Maximum of 2 people allow in this type of room.");
                            System.out.println("Enter how many rooms you want to book?");
                            in5 = scan.nextInt();
                            noOfRoom = in5;
                            System.out.println("Enter how many people want to stay in the hotel");
                            in6 = scan.nextInt();
                            occupancy = in6;

                            if (noOfRoom * 2 < occupancy) {
                                System.out.println("The amount of people you entered exceed the occupancy of the amount of room you required.");
                                System.out.println("Note: Maximum of 2 people allow in this type of room.");
                                System.out.println("Enter how many rooms you want to book?");
                                in5 = scan.nextInt();
                                noOfRoom = in5;
                                System.out.println("Enter how many people want to stay in the hotel");
                                in6 = scan.nextInt();
                                occupancy = in6;
                            }

                        } else {
                            System.out.println("Note: Maximum of 3 people allow in this type of room.");
                            System.out.println("Enter how many rooms you want to book?");
                            in5 = scan.nextInt();
                            noOfRoom = in5;
                            System.out.println("Enter how many people want to stay in the hotel");
                            in6 = scan.nextInt();
                            occupancy = in6;

                            if (noOfRoom * 3 < occupancy) {
                                System.out.println("The amount of people you entered exceed the occupancy of the amount of room you required.");
                                System.out.println("Note: Maximum of 2 people allow in this type of room.");
                                System.out.println("Enter how many rooms you want to book?");
                                in5 = scan.nextInt();
                                noOfRoom = in5;
                                System.out.println("Enter how many people want to stay in the hotel");
                                in6 = scan.nextInt();
                                occupancy = in6;
                            }
                        }


                    } else if (input3 == 4 || input3 == 3) {

                        int in7 = scan.nextInt();

                        if (input3 == 4 && in7 == 1) {
                            roomType = "Executive Double";
                            System.out.println("Note: Maximum of 2 people allow in this type of room.");
                        } else if (input3 == 4 && in7 == 2) {
                            roomType = "Executive Twin";
                            System.out.println("Note: Maximum of 2 people allow in this type of room.");
                        } else if (input3 == 4 && in7 == 3) {
                            roomType = "Executive Single";
                            System.out.println("Note: Maximum of 1 people allow in this type of room.");
                        } else if (input3 == 3 && in7 == 1) {
                            roomType = "Classic Double";
                            System.out.println("Note: Maximum of 2 people allow in this type of room.");
                        } else if (input3 == 3 && in7 == 2) {
                            roomType = "Classic Twin";
                            System.out.println("Note: Maximum of 2 people allow in this type of room.");
                        } else if (input3 == 3 && in7 == 3) {
                            roomType = "Classic Single";
                            System.out.println("Note: Maximum of 1 people allow in this type of room.");
                        }

                        int in5, in6;
                        System.out.println("Enter how many rooms you want to book?");
                        in5 = scan.nextInt();
                        noOfRoom = in5;
                        System.out.println("Enter how many people want to stay in the hotel");
                        in6 = scan.nextInt();
                        occupancy = in6;

                        if (in7 == 1 || in7 == 2) {
                            if (noOfRoom * 2 < occupancy) {
                                System.out.println("The amount of people you entered exceed the occupancy of the amount of room you required.");
                                System.out.println("Note: Maximum of 2 people allow in this type of room.");
                                System.out.println("Enter how many rooms you want to book?");
                                in5 = scan.nextInt();
                                noOfRoom = in5;
                                System.out.println("Enter how many people want to stay in the hotel");
                                in6 = scan.nextInt();
                                occupancy = in6;
                            }


                        } else if (in7 == 3) {
                            if (noOfRoom < occupancy) {
                                System.out.println("The amount of people you entered exceed the occupancy of the amount of room you required.");
                                System.out.println("Note: Maximum of 1 people allow in this type of room.");
                                System.out.println("Enter how many rooms you want to book?");
                                in5 = scan.nextInt();
                                noOfRoom = in5;
                                System.out.println("Enter how many people want to stay in the hotel");
                                in6 = scan.nextInt();
                                occupancy = in6;
                            }
                        }
                    }

                    Booking user = new Booking(email1, name1, checkIn, checkOut, ap, roomType, noOfRoom);

                    user.insertNewRow(new File("booking.csv"));

                    System.out.println("******Thank you for using Hotel Reservation System!******");
                    System.out.println();


                } else if (in1.equals("C")) {
                    System.out.println("Please enter your name: ");
                    String in10 = scan.nextLine();

                    Booking.deleteRow(new File("booking.csv"), in10);
                    System.out.println("******Cancellation successful! Thank you for using our system!******");
                    System.out.println();

                    //booking log allows to open a reservation detail
                } else if (in1.equals("B")) {
                    System.out.println("-- This is a reservation file: -- ");
                    Scanner scanner = new Scanner(new File("booking.csv"));

                    while (scanner.hasNext()) {
                        System.out.println(scanner.next() + ",");

                    }

                    scanner.close();
                    System.out.println("End of the file.");
                } else if (in1.equals("A")) {
                    System.out.println("This is a analysis file");
                }


            }
        }
    }
    */
}





