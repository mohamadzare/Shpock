package com.example.shpock.Models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class shipsTest {
    ships sh = new ships();

    @Test
    void getId() {
        sh.setId(1);
       assertEquals(1,sh.getId());
    }

    @Test
    void setId() {
        fail();
    }

    @Test
    void getPrice() {

        sh.setPrice(20);
        assertEquals(20,sh.getPrice());
    }

    @Test
    void setPrice() {
        fail();
    }

    @Test
    void getTitle() {

        sh.setTitle("Hi");
        assertEquals("Hi",sh.getTitle());
    }

    @Test
    void setTitle() {
        fail();
    }

    @Test
    void getDescription() {

        sh.setDescription("Test");
        assertEquals("Test",sh.getDescription());

    }

    @Test
    void setDescription() {
        fail();
    }

    @Test
    void getImage() {
        sh.setImage("http://images.bit-tech.net/content_images/2008/01/pirates_of_the_burning_sea/p.jpg");
        assertEquals("http://images.bit-tech.net/content_images/2008/01/pirates_of_the_burning_sea/p.jpg",sh.getImage());
    }

    @Test
    void setImage() {
        fail();
    }

    @Test
    void getGreeting_type() {
        sh.setGreeting_type("YO");
        assertEquals("YO",sh.getGreeting_type());

    }

    @Test
    void setGreeting_type() {
        fail();
    }
}