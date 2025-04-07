/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tracklist_premium;

import form.Tela;
import file.Data;
import file.Hora;

/**
 *
 * @author josue
 */
public class TrackList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.print("\f\f TrackList -- ");
        System.out.print("Alterado ");
        System.out.print(new Data("07/04/2025").DataLinha(false));
        System.out.print(" às ");
        System.out.println(new Hora("11:27").getNodeHora(false));
        System.out.println();
        
        new Tela().Enter(true);
        
    }
    
}
