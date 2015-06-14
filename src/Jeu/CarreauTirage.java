package Jeu;


import Jeu.CarreauAction;
import java.util.Scanner;

public class CarreauTirage extends CarreauAction {
    
    public CarreauTirage(int numero, String nomCarreau, Monopoly monopoly) {
        super(numero, nomCarreau, monopoly);
    }
    
    @Override
    public void action(Joueur j){
        System.out.println("Veuillez saisir le numéro de la carte souhaitée :");
        Scanner sc = new Scanner(System.in);
        int res;
        if ("Caisse de Communauté".equals(this.getNomCarreau())){
            res = sc.nextInt();
            if (CarteCaisseEnum.values()[res] == CarteCaisseEnum.libere_prison){
                    this.getMonopoly().getJoueurCourant().setCarteCaisseLibere(true);
                    CarteCaisse caisse = new CarteCaisse(getMonopoly(),CarteCaisseEnum.libere_prison);
                    caisse.actionAEffectuer();
                }
            else {
                for (CarteCaisse caisse : getMonopoly().getCartesCaisse()){
                    if (CarteCaisseEnum.values()[res] == caisse.getAction()){
                        caisse.actionAEffectuer();
                    }
                }
            }
        }
        else {
            res = sc.nextInt();
            if (CarteChanceEnum.values()[res] == CarteChanceEnum.libere_prison){
                    this.getMonopoly().getJoueurCourant().setCarteChanceLibere(true);
                }
            else {
                for (CarteChance chance : getMonopoly().getCartesChance()){
                    if (CarteChanceEnum.values()[res] == chance.getAction()){
                        chance.actionAEffectuer();
                    }
                }
            }
        }
    }
}