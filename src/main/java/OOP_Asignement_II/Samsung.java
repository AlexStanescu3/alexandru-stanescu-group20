package OOP_Asignement_II;

public class Samsung {
    static class GalaxyS20 extends SmartPhone {

        public GalaxyS20() {
            super(11, "black", "plastic");
        }

        @Override
        public String toString() {
            return "GalaxyS20: " + super.toString();
        }
    }

    static class Note20 extends SmartPhone {
        public Note20()
        {
            super(8, "pink", "metal");
        }

        @Override
        public String toString() {
            return "Note20: " + super.toString();
        }
    }

}
