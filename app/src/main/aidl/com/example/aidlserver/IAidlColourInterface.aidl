package com.example.aidlserver;

// Declare any non-default types here with import statements
parcelable DummyUser;
interface IAidlColourInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    /*void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);*/
            int getColour();

            String getMessage();

            DummyUser transformation(in DummyUser dummyUser);
}