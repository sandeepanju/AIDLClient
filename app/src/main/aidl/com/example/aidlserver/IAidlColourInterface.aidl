package com.example.aidlserver;

// Declare any non-default types here with import statements
parcelable DummyUser;
interface IAidlColourInterface {
            int getColour();

            String getMessage();

            DummyUser transformation(in DummyUser dummyUser);
}