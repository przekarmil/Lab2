package pl.lublin.wsei.java.cwiczenia;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Infografika {
    private String tytul = "";
    private String adresStrony = "";
    private String adresGrafiki = "";
    private String szerokosc = "";
    private String wysokosc = "";
    private String adresMiniaturki = "";

    public Infografika(String tekst){

        Pattern pat = Pattern.compile("<title><!\\[CDATA\\[(.*)\\]\\]");
        Matcher m = pat.matcher(tekst);
        if (m.find())
            tytul = m.group(1);

        pat = Pattern.compile("<link>(.*)</link>");
        m = pat.matcher(tekst);
        if (m.find())
            adresStrony = m.group(1);

        pat = Pattern.compile("<media:content url=\"(.*)\" type");
        m = pat.matcher(tekst);
        if (m.find())
            adresGrafiki = m.group(1);

        pat = Pattern.compile("<media:thumbnail url=\"(.*)/>");
        m = pat.matcher(tekst);
        if (m.find())
            adresMiniaturki = m.group(1);

        pat = Pattern.compile("width=\"(.*)\" height");
        m = pat.matcher(tekst);
        if (m.find())
            szerokosc = m.group(1);

        pat = Pattern.compile("height=\"(.*)\">");
        m = pat.matcher(tekst);
        if (m.find())
            wysokosc = m.group(1);

    }

    public final void print(){
        System.out.println("tytul: "
                + this.tytul + "\nadres strony: "
                + this.adresStrony + "\nadres grafiki: "
                + this.adresGrafiki + "\nadres miniaturki: "
                + this.adresMiniaturki + "\nrozmiary: "
                + this.szerokosc+"x"+this.wysokosc);
    }

}
