public class App {
    public static void main(String[] args) throws Exception {
        DirectorTienda director = new DirectorTienda();
        director.setBuilderTienda(new TiendaBarrioBuilder());
        director.getTienda();
    }
}
