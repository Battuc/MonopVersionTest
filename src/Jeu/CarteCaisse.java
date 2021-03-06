package Jeu;

public class CarteCaisse extends Carte {
    private CarteCaisseEnum action;
        
    public CarteCaisse(Monopoly monopoly, CarteCaisseEnum action){
        super(monopoly);
        setAction(action);
    }
    
    public CarteCaisseEnum getAction(){
        return action;
    }
    private void setAction(CarteCaisseEnum action){
        this.action = action;
    }
    
    public void actionAEffectuer (){
        Joueur joueur = this.getMonopoly().getJoueurCourant();
        CarteCaisseEnum action = this.getAction();
        this.getMonopoly().getInter().afficherActionCarteCaisse(action);
        switch(action){
            case libere_prison:
                break;
            case payez_amende:
                payezAmende(joueur);
                break;
            case payez_note_medecin:
                payezNoteMedecin(joueur);
                break;
            case payez_hopital:
                payezHopital(joueur);
                break;
            case payez_assurance:
                payezAssurance(joueur);
                break;
            case recevez_anniversaire:
                recevezAnniversaire(joueur);
                break;
            case recevez_erreur_banque:
                recevezErreurBanque(joueur);
                break;
            case recevez_contributions:
                recevezContributions(joueur);
                break;
            case recevez_heritage:
                recevezHeritage(joueur);
                break;
            case recevez_vente_stock:
                recevezVenteStock(joueur);
                break;
            case recevez_interet_emprunt:
                recevezInteretEmprunt(joueur);
                break;
            case recevez_revenu_annuel:
                recevezRevenuAnnuel(joueur);
                break;
            case recevez_prix_beaute:
                recevezPrixBeaute(joueur);
                break;
            case allez_prison:
                allezPrison(joueur);
                break;
            case reculez_belleville:
                reculezBelleville(joueur);
                break;
            case avancez_depart:
                avancezDepart(joueur);
                break;
            default:
        }
    }
    public void payezAmende(Joueur joueur){
        joueur.removeCash(10);
    }
    public void payezNoteMedecin(Joueur joueur){
        joueur.removeCash(50);
    }
    public void payezHopital(Joueur joueur){
        joueur.removeCash(100);
    }
    public void payezAssurance(Joueur joueur){
        joueur.removeCash(50);
    }
    public void recevezAnniversaire(Joueur joueur){
        for (Joueur jou : this.getMonopoly().getJoueurs()){
            if (jou!= joueur){jou.payer(joueur, 10);}
        }
    }
    public void recevezErreurBanque(Joueur joueur){
        joueur.addCash(200);
    }
    public void recevezContributions(Joueur joueur){
        joueur.addCash(20);
    }
    public void recevezHeritage(Joueur joueur){
        joueur.addCash(100);
    }
    public void recevezVenteStock(Joueur joueur){
        joueur.addCash(50);
    }
    public void recevezInteretEmprunt(Joueur joueur){
        joueur.addCash(25);
    }
    public void recevezRevenuAnnuel(Joueur joueur){
        joueur.addCash(100);
    }
    public void recevezPrixBeaute(Joueur joueur){
        joueur.addCash(10);
    }
    public void allezPrison(Joueur joueur){
        joueur.allerPrison();
    }
    public void reculezBelleville(Joueur joueur){
        joueur.setPositionCourante(this.getMonopoly().getCarreau(2));
        getMonopoly().getCarreau(2).action(joueur);
    }
    public void avancezDepart(Joueur joueur){
        joueur.avancerViaCarte(1);
        getMonopoly().getCarreau(1).action(joueur);
    }
}