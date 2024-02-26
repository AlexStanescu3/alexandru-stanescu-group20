package OOP_Asignement_II;

public class Apple {
    static class IPhoneX extends SmartPhone {
        public IPhoneX() {
            super(7, "blue", "carbon fiber");
        }

        @Override
        public String toString() {
            return "IPhoneX: " + super.toString();
        }
    }

    static class IPhone15 extends SmartPhone {
        public IPhone15() {
            super(8, "white", "metal");
        }

        @Override
        public String toString() {
            return "IPhone15: " + super.toString();
        }
    }
}
