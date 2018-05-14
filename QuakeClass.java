package com.example.guswng.quakeport;

import java.util.ArrayList;

public class QuakeClass extends ArrayList<QuakeClass> {

        private String mMag;
        private String mLocation;
        private String mTimeInMilliseconds;

        public String getmMag() {
            return mMag;
        }

        public String getmLocation() {
            return mLocation;
        }

        public String getmTimeInMilliseconds() {
            return mTimeInMilliseconds;
        }

        public QuakeClass(String mag, String loc, String time){
            mMag = mag;
            mLocation = loc;
            mTimeInMilliseconds = time;
        }

    }


