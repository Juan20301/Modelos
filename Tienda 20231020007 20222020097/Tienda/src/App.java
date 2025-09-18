public class App {
    
    public static void main(String[] args) throws Exception {
        Director director = new Director();
        director.setBuilder(new TiendaBarrioBuilder());
        director.getTienda();
    }
}
