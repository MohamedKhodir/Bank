import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Objects;


public class bankAm {
    String numberOfAcc ;
    BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    String checkdigits () throws IOException {

        int three=0;


        while (!(three==3)){
            System.out.println("enter 3 digits");
        numberOfAcc= br.readLine();
            three=numberOfAcc.length();
            System.out.println(numberOfAcc +" "+ three);

        }
        return numberOfAcc;
    }
    void FoindAcc() throws MalformedURLException {
        try
        {
            URL url = new URL("https://ewib.nbp.pl/plewibnra?dokNazwa=plewibnra.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line= reader.readLine();
            while (line  != null ) {
                 line= reader.readLine();
                String[] seatData = line.split(" ");

                String seatID = seatData[0];
                String seatbank = seatData[1];
                String seatbakname = seatData[2];
                String seatbakname1 = seatData[3];
//                System.out.println(seatID);
//                System.out.println(seatbakname);
                boolean whichh;
                whichh= Objects.equals(seatID,numberOfAcc);
                if (whichh) System.out.println(seatbakname +seatbakname1);

            }
        }
        catch (IOException e) {
            e.printStackTrace();


    }}
}
