public class TICKTACKTOE extends SPIEL
{
    //TODO: Initialisiere ein zweidimensionales Array namens spielfeld zur Verwaltung von ganzen Zahlen.
    //Diese geben die Belegung des Spielfeldes an.
    //0 steht für ein leeres Feld, 1 steht für Spieler_X und 2 steht für Spieler_O.
    int[][] spielfeld;

    //TODO: Initialisiere ein ganzzahliges Attribut aktueller_spieler. Es soll anzeigen, welcher Spieler gerade am Zug ist.
    int aktueller_spieler;

    public TICKTACKTOE()
    {
        //1 Bildschirmmeter entspricht 30 Pixel.
        super( 450 , 450, true );

        this.setzeHintergrundgrafik("spielfeld.png");
        
        //TODO: Initialisiere das Array spielfeld 3 x 3.
        spielfeld = new int[3][3];
        
        //TODO: Initialisiere das Attribut aktueller_spieler mit dem Wert 1.
        aktueller_spieler = 1;

        //TODO: Initialisiere alle Elemente des Arrays spielfeld mit dem Wert 0. Alle Felder sind zu Beginn leer.

        for (int i = 0; i < spielfeld.length; i++)
        {
            for (int j = 0; j < spielfeld.length; j++)
            {
                spielfeld[i][j] = 0;
            }
        }
        zeigeKoordinatensystem(true);
    }
    
    //TODO: Schreibe eine Methode zum Wechseln des Spielers. Beim Aufruf der Methode soll das Attribut aktueller_spieler von 1 auf 2 wechseln und umgekehrt.
    /**
     * Methode SpielerWechseln sorgt dafür, dass die Spieler sich abwechseln und ändert das Attribut aktueller_spieler geeignet.
     *
     */
    public void SpielerWechseln()
    {
        if (aktueller_spieler == 1)
        {
            this.aktueller_spieler = 2;
        }
        else if (aktueller_spieler == 2)
        {
            aktueller_spieler = 1;
        }
    }
    
    
    
    //TODO: Schreibe eine Methode FeldMarkieren(...) zum Markieren der Felder. Wenn das mit x und y ausgewählte Feld leer ist, soll es mit der übergebenen
    //spielerNummer besetzt werden. Zudem soll, je nach spielerNummer (1 oder 2) an passender Stelle ein X oder O gezeichnet werden. Verwende hierzu die Klasse FIGUR.
    /**
     * Methode FeldMarkieren
     *
     * @param x Ein Parameter der die x-Koordinate der Spielmatrix beschreibt. 0 ist links, 1 ist mittig, 2 ist rechts.
     * @param y Ein Parameter der die y-Koordinate der Spielmatrix beschreibt. 0 ist oben, 1 ist mittig, 2 ist unten.
     * @param spielerNummer Ein Parameter, der die Spielernummer übergibt, der gerade am Zug ist (1 oder 2).
     */
    public void FeldMarkieren(int x, int y, int spielerNummer)
    {
        FIGUR Figure;
        if(spielerNummer == 1)
        {
            Figure = new FIGUR("x.png");
        }
        else
        {
            Figure = new FIGUR("o.png");
        }
        Figure.setzeMittelpunkt(x, y);


    }
    
    //TODO: Überschreibe die Methode klickReagieren(...). Je nachdem in welchen Bereich der aktuelle Spieler klickt, soll die Methode FeldMarkieren(...)
    // mit passenden Werten aufgerufen und anschließend ein Spielerwechsel durchgeführt werden.
    /**
     * Methode klickReagieren wird stets ausgelöst, wenn man mit der Maus in das Fenster klickt.
     *
     * @param x Ein Parameter der die x-Koordinate der Mausposition beim Klicken in Bildschirmmetern übergibt.
     * @param y Ein Parameter der die y-Koordinate der Mausposition beim Klicken in Bildschirmmetern übergibt.
     */
    @Override
    public void klickReagieren( double x , double y )
    {
        /*
          erst rechts mitte, oben, unten, dann in der mitte die mitte, oben, unten, dann links mitte, oben, unten
         */
        if(x >= 2.5 && y < 2.5 && y > -2.5 && spielfeld[2][1] == 0)
        {
            FeldMarkieren(5,0, this.aktueller_spieler);
            SpielerWechseln();
            spielfeld[2][1] = this.aktueller_spieler;
        } else if (x >= 2.5 && y >= 2.5 && spielfeld[2][0] == 0) {
            FeldMarkieren(5,5, this.aktueller_spieler);
            SpielerWechseln();
            spielfeld[2][0] = this.aktueller_spieler;
        } else if (x >= 2.5 && y <= -2.5 && spielfeld[2][2] == 0) {
            FeldMarkieren(5,-5, this.aktueller_spieler);
            SpielerWechseln();
            spielfeld[2][2] = this.aktueller_spieler;
        } else if (x >= -2.5 && x < 2.5 && y < 2.5 && y > -2.5 && spielfeld[1][1] == 0) {
            FeldMarkieren(0,0, this.aktueller_spieler);
            SpielerWechseln();
            spielfeld[1][1] = this.aktueller_spieler;
        } else if (x >= -2.5 && x < 2.5 && y >= 2.5 && spielfeld[1][0] == 0) {
            FeldMarkieren(0,5, this.aktueller_spieler);
            SpielerWechseln();
            spielfeld[1][0] = this.aktueller_spieler;
        } else if (x >= -2.5 && x < 2.5 && y <= -2.5 && spielfeld[1][2] == 0) {
            FeldMarkieren(0,-5, this.aktueller_spieler);
            SpielerWechseln();
            spielfeld[1][2] = this.aktueller_spieler;
        } else if (x < -2.5 && y < 2.5 && y > -2.5 && spielfeld[0][1] == 0) {
            FeldMarkieren(-5,0, this.aktueller_spieler);
            SpielerWechseln();
            spielfeld[0][1] = this.aktueller_spieler;
        } else if (x < -2.5 && y >= 2.5 && spielfeld[0][0] == 0) {
            FeldMarkieren(-5, 5, this.aktueller_spieler);
            SpielerWechseln();
            spielfeld[0][0] = this.aktueller_spieler;
        } else if (x < -2.5 && y <= -2.5 && spielfeld[0][2] == 0) {
            FeldMarkieren(-5, -5, this.aktueller_spieler);
            SpielerWechseln();
            spielfeld[0][2] = this.aktueller_spieler;
        }
    }
}
