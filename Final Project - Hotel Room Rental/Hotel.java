 

public class Hotel
{
    private String name;
    private RoomType[] roomTypes;
    private Extra snacks, beverages, membership, beds;
    private Extra[] extrasAvailable;
    
    public Hotel(String name, RoomType[] roomTypes)
    {
        this.name = name;
        this.roomTypes = roomTypes;
        this.snacks = new Extra("Snacks", 25);
        this.beverages = new Extra("Beverages", 40);
        this.membership = new Extra("Membership", 120);
        this.beds = new Extra("Beds", 20);
        Extra[] extrasAvailable = {this.snacks, this.beverages, this.membership, this.beds};
        this.extrasAvailable = extrasAvailable;
    }
    
    public RoomType[] getRoomTypes()
    {
        return this.roomTypes;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public Extra getSnacks()
    {
        return this.snacks;
    }
    
    public Extra getBeverages()
    {
        return this.beverages;
    }

    public Extra getMembership()
    {
        return this.membership;
    }

    public Extra getBeds()
    {
        return this.beds;
    }

    
    public Extra[] getAvailableExtras()
    {
        return this.extrasAvailable;
    }
    
    
}
