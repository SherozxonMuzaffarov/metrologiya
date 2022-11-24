package uzvagontamir.ModelDto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class TransportModelDto {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String rusumi;

    @NotNull
    private String nomeri;

    @NotNull
    private int yili;

    private String texMuddati;

    private String gazMuddati;

    private String sugurta;

    @NotNull
    private String yoqilgiTuri;

    @NotNull
    private String depoNomi;

    @NotNull
    private String holati;

    private String izoh;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRusumi() {
        return rusumi;
    }

    public void setRusumi(String rusumi) {
        this.rusumi = rusumi;
    }

    public int getYili() {
        return yili;
    }

    public void setYili(int yili) {
        this.yili = yili;
    }

    public String getNomeri() {
        return nomeri;
    }

    public void setNomeri(String nomeri) {
        this.nomeri = nomeri;
    }

    public String getHolati() {
        return holati;
    }

    public void setHolati(String holati) {
        this.holati = holati;
    }

    public String getYoqilgiTuri() {
        return yoqilgiTuri;
    }

    public void setYoqilgiTuri(String yoqilgiTuri) {
        this.yoqilgiTuri = yoqilgiTuri;
    }

    public String getDepoNomi() {
        return depoNomi;
    }

    public void setDepoNomi(String depoNomi) {
        this.depoNomi = depoNomi;
    }

    public String getIzoh() {
        return izoh;
    }

    public void setIzoh(String izoh) {
        this.izoh = izoh;
    }

    public String getTexMuddati() {
        return texMuddati;
    }

    public void setTexMuddati(String texMuddati) {
        this.texMuddati = texMuddati;
    }

    public String getGazMuddati() {
        return gazMuddati;
    }

    public void setGazMuddati(String gazMuddati) {
        this.gazMuddati = gazMuddati;
    }

    public String getSugurta() {
        return sugurta;
    }

    public void setSugurta(String sugurta) {
        this.sugurta = sugurta;
    }
}
