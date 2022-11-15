 

public class HotelRental
{
    public static RoomType singleRoom, doubleRoom, deluxeRoom, studioRoom, suiteRoom;
    public static Hotel hotel1, hotel2, hotel3, hotel4;
    
    public static void initHotelRental()
    {
        initRoomTypes();
        initHotels();
    }

    
    public static void initHotels()
    {
        // Hotel 1
        RoomType[] hotel1RoomTypes = {doubleRoom, studioRoom, suiteRoom};
        hotel1 = new Hotel("Hotel 1", hotel1RoomTypes);
        // Set Prices
        // Double
        hotel1RoomTypes[0].setPrice(85);
        // Studio
        hotel1RoomTypes[1].setPrice(170);
        // Suite
        hotel1RoomTypes[2].setPrice(230);
        
        
        // Hotel 2
        RoomType[] hotel2RoomTypes = {singleRoom, doubleRoom, deluxeRoom, studioRoom, suiteRoom};
        hotel2 = new Hotel("Hotel 2", hotel2RoomTypes);
        // Set Prices
        // Single
        hotel2RoomTypes[0].setPrice(60);
        // Double
        hotel2RoomTypes[1].setPrice(80);
        // Deluxe
        hotel2RoomTypes[2].setPrice(130);
        // Studio
        hotel2RoomTypes[3].setPrice(160);
        // Suite
        hotel2RoomTypes[4].setPrice(210);
        
        
        // Hotel 3
        RoomType[] hotel3RoomTypes = {singleRoom, deluxeRoom, studioRoom};
        hotel3 = new Hotel("Hotel 3", hotel3RoomTypes);
        // Set Prices
        // Single
        hotel3RoomTypes[0].setPrice(55);
        // Deluxe
        hotel3RoomTypes[1].setPrice(125);
        // Studio
        hotel3RoomTypes[2].setPrice(165);

        
        RoomType[] hotel4RoomTypes = {doubleRoom, deluxeRoom, studioRoom, suiteRoom};
        hotel4 = new Hotel("Hotel 4", hotel4RoomTypes);
                // Set Prices
        // Double
        hotel4RoomTypes[0].setPrice(90);
        // Deluxe
        hotel4RoomTypes[1].setPrice(145);
        // Studio
        hotel4RoomTypes[2].setPrice(170);
        // Suite
        hotel4RoomTypes[3].setPrice(220);

        
        
    }
    
    public static Hotel[] getHotels()
    {
        Hotel[] hotels = {hotel1, hotel2, hotel3, hotel4};
        
        return hotels;
    }
    
    public static void initRoomTypes()
    {
        String[] singleServices = {"Single Bed", 
                                   "Air Conditioner",
                                   "Refrigerator", 
                                   "Shower",
                                   "Toilet",
                                   "Breakfast",
                                   "Toiletries",
                                   "Coffee Set",
                                   "Television"
                                  };
                            
        singleRoom = new RoomType("Single", singleServices);
        
        String[] doubleServices = {"Double Bed", 
                                   "Air Conditioner",
                                   "Refrigerator", 
                                   "Shower",
                                   "Toilet",
                                   "Bathtub",
                                   "Breakfast",
                                   "Toiletries",
                                   "Coffee Set",
                                   "Television",
                                   "Table Set",
                                  };
        doubleRoom = new RoomType("Double", doubleServices);
        
        String[] deluxeServices = {"King Bed", 
                                   "Air Conditioner",
                                   "Refrigerator", 
                                   "Shower",
                                   "Toilet",
                                   "Bathtub",
                                   "Breakfast",
                                   "Toiletries",
                                   "Coffee Set",
                                   "Coffee Maker",
                                   "Tea Set",
                                   "Tea Maker",
                                   "Smart TV",
                                   "Table Set",
                                   "Fiber Internet",
                                   "Living Area"
                                  };
        
        deluxeRoom = new RoomType("Deluxe", deluxeServices);
        
        String[] studioServices = {"King Bed", 
                                   "Air Conditioner",
                                   "Refrigerator", 
                                   "Shower",
                                   "Toilet",
                                   "Bathtub",
                                   "Breakfast",
                                   "Toiletries",
                                   "Kitchen",
                                   "Coffee Set",
                                   "Coffee Maker",
                                   "Tea Set",
                                   "Tea Maker",
                                   "Smart TV",
                                   "Table Set",
                                   "Fiber Internet",
                                   "Living Area",
                                   "Desktop Computer",
                                   "Speakers",
                                   "Jacuzzi"

                                  };
    
        studioRoom = new RoomType("Studio", studioServices);
        
        String[] suiteServices = {"King Bed", 
                                   "Air Conditioner",
                                   "Refrigerator", 
                                   "Shower",
                                   "Toilet",
                                   "Bathtub",
                                   "Breakfast",
                                   "Dinner",
                                   "Toiletries",
                                   "Kitchen",
                                   "Coffee Set",
                                   "Coffee Maker",
                                   "Tea Set",
                                   "Tea Maker",
                                   "Smart TV",
                                   "Table Set",
                                   "Fiber Internet",
                                   "Living Area",
                                   "Desktop Computer",
                                   "Speakers",
                                   "Jacuzzi",
                                   "Private Pool",
                                  };
        
        suiteRoom = new RoomType("Suite", suiteServices);
        
        
    }

}
