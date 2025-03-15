package com.example.pizza.beans;

public class Pizza {
     protected static int id=0;
     private String nom;
     private String nbringredients;
     private int photo;
     private float duree;

     private String detailsIngred;
     private String description;
     private String preparation;

     public Pizza(String nom, String nbringredients, int photo, float duree, String detailsIngred, String description, String preparation) {
          this.nom = nom;
          this.nbringredients = nbringredients;
          this.photo = photo;
          this.duree = duree;
          this.detailsIngred = detailsIngred;
          this.description = description;
          this.preparation = preparation;
     }

     public Pizza() {
          id++;
     }

     public static int getId() {
          return id;
     }

     public static void setId(int id) {
          Pizza.id = id;
     }

     public String getNom() {
          return nom;
     }

     public void setNom(String nom) {
          this.nom = nom;
     }

     public String getNbringredients() {
          return nbringredients;
     }

     public void setNbringredients(String nbringredients) {
          this.nbringredients = nbringredients;
     }

     public int getPhoto() {
          return photo;
     }

     public void setPhoto(int photo) {
          this.photo = photo;
     }

     public float getDuree() {
          return duree;
     }

     public void setDuree(float duree) {
          this.duree = duree;
     }

     public String getDetailsIngred() {
          return detailsIngred;
     }

     public void setDetailsIngred(String detailsIngred) {
          this.detailsIngred = detailsIngred;
     }

     public String getDescription() {
          return description;
     }

     public void setDescription(String description) {
          this.description = description;
     }

     public String getPreparation() {
          return preparation;
     }

     public void setPreparation(String preparation) {
          this.preparation = preparation;
     }

     @Override
     public String toString() {
          return "Pizza{" +
                  "nom='" + nom + '\'' +
                  ", nbringredients='" + nbringredients + '\'' +
                  ", photo=" + photo +
                  ", duree=" + duree +
                  ", detailsIngred='" + detailsIngred + '\'' +
                  ", description='" + description + '\'' +
                  ", preparation='" + preparation + '\'' +
                  '}';
     }
}
