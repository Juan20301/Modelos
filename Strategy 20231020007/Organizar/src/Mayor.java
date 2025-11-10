import java.util.ArrayList;
public class Mayor extends Ordenar {
    @Override
    public void ordenar(ArrayList<Persona> personas) {
        int n = personas.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (personas.get(j).getCedula() < personas.get(j + 1).getCedula()) {
                    Persona temp = personas.get(j);
                    personas.set(j, personas.get(j + 1));
                    personas.set(j + 1, temp);
                }
            }
        }
    }

}
