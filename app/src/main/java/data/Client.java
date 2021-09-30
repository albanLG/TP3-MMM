package data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "client_table")
public class Client {
     @PrimaryKey(autoGenerate = true)
     public int uid;

     @ColumnInfo(name = "prenom")
     private String prenom;

     @ColumnInfo(name = "nom")
     private String nom;

     @ColumnInfo(name = "birthday")
     private String birthday;

     @ColumnInfo(name = "villeNaissance")
     private String villeNaissance;

     @ColumnInfo(name = "departement")
     private String departement;

     public Client(String prenom, String nom, String birthday, String villeNaissance, String departement) {
          this.prenom = prenom;
          this.nom = nom;
          this.birthday = birthday;
          this.villeNaissance = villeNaissance;
          this.departement = departement;
     }


     public String getPrenom() {
          return prenom;
     }

     public void setPrenom(String prenom) {
          this.prenom = prenom;
     }

     public String getNom() {
          return nom;
     }

     public void setNom(String nom) {
          this.nom = nom;
     }

     public String getBirthday() {
          return birthday;
     }

     public void setBirthday(String birthday) {
          this.birthday = birthday;
     }

     public String getVilleNaissance() {
          return villeNaissance;
     }

     public void setVilleNaissance(String villeNaissance) {
          this.villeNaissance = villeNaissance;
     }

     public String getDepartement() {
          return departement;
     }

     public void setDepartement(String departement) {
          this.departement = departement;
     }
}
