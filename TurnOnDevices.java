public class TurnOnDevices{
    
    public static void main(String args[]){

        turnOnDevice(new Lamp());
        turnOnDevice(new Computer());
        turnOnDevice(CoffeMakerAdapter); //Obviamente se debe crear previamente el objeto CoffeMaker y pasarselo al constructor del adaptador
    }

    //Implementacion de la clase Connectable
    public interface Connectable {
        void turnOn();
        void turnOff();
        boolean isOn();
    }

    //Implementacion de la clase CoffeMaker
    public class CoffeMaker {
        private boolean off = true;
    
        public void on() {
            off = false;
        }
    
        public void off() {
            off = true;
        }
    
        public boolean isOff() {
            return off;
        }
    }

    //Se crea el adaptador para poder usar CoffeMaker como parte de la interfaz Connectable
    public class CoffeMakerAdapter implements Connectable {
        private CoffeMaker coffeMaker;
    
        public CoffeMakerAdapter(CoffeMaker coffeMaker) {
            this.coffeMaker = coffeMaker;
        }
    
        @Override
        public void turnOn() {
            coffeMaker.on();
        }
    
        @Override
        public void turnOff() {
            coffeMaker.off();
        }
    
        @Override
        public boolean isOn() {
            return coffeMaker.isOff();//Como estan invertidos, no sabia que colocar asi que asumo que solo quieren el estado actual.
        }
    }

    private static void turOnDevice(Connectable device){
        device.turnOn();
        System.out.println(device.isOn());
    }
}
