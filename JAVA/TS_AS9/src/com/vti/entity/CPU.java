package com.vti.entity;

public class CPU {
    private float price;

    public CPU(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public class Processor {
        private int coreAmount;
        private String menufacturer;

        public float getCache() {
            return 4.3f;
        }
    }

    public class Ram {
        private float memory;
        private String menufacturer;

        public float getClockSpeed() {
            return 5.5f;
        }
    }
}
