import java.lang.reflect.Array;
import java.util.ArrayList;

public class Park {
    protected ArrayList<Attraction> attractions;

    public class Attraction {
        private String name;
        private double price;
        private int time;

        public Attraction(String name, double price, int time) {
            this.name = name;
            if (price < 0) this.price = 0.0;
            else this.price = price;

            if (time < 0) this.time = 0;
            else if (time > 24) this.time = 24;
            else this.time = time;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPrice(double price) {
            if (price < 0) this.price = 0.0;
            else this.price = price;
        }

        public void setTime(int time) {
            if (time < 0) this.time = 0;
            else if (time > 24) this.time = 24;
            else this.time = time;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public int getTime() {
            return time;
        }
    }

    public Park() {
        attractions = new ArrayList<>();
    }

    public void addAttraction(Attraction attraction) {
        attractions.add(attraction);
    }


    public void setAttractions(ArrayList<Attraction> attractions) {
        this.attractions = attractions;
    }



    public ArrayList<Attraction> getAttractions() {
        return attractions;
    }
}
